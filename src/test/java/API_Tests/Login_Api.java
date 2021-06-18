package API_Tests;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;
import com.shaft.api.RestActions;
import com.shaft.api.RestActions.RequestType;
import com.shaft.driver.DriverFactory;
import com.shaft.validation.Assertions;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Login_Api{
	@Test(description = "Login With valid parameters")
	@Description("Performing The login API using valid parameters on the post request and asserting the respone code")
	@Epic("Web API")
	public void TestUserLoginn_API() {
		List<List<Object>> LoginParamters = Arrays.asList(
				Arrays.asList("email","sayed897@test.com"),
				Arrays.asList("password","123456"));

		RestActions apiObject =  DriverFactory.getAPIDriver("https://demo.opencart.com/");
		Response response = apiObject.buildNewRequest("index.php?route=account/login",RequestType.POST)
				.setParameters(LoginParamters,RestActions.ParametersType.FORM)
				.setContentType(ContentType.URLENC)
				.performRequest();

		//Validation
		int statusCodeValue = response.statusCode();
		Assertions.assertEquals(200, statusCodeValue);
	}
}

