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

public class Registration_API {
	@Test(description = "Registration With valid parameters")
	@Description("Performing the Registration API using valid parameters on the post request and asserting the respone code")
	@Epic("Web API")
	public void TestUserRegistration_API() {
		List<List<Object>> FormParamter = Arrays.asList(
				Arrays.asList("customer_group_id","1"),
				Arrays.asList("firstname","sayed"),
				Arrays.asList("lastname","ali"),
				Arrays.asList("email","sayed897@test.com"),
				Arrays.asList("telephone","123456"),
				Arrays.asList("password","123456"),
				Arrays.asList("confirm","123456"),
				Arrays.asList("newsletter","0"),
				Arrays.asList("agree:","1")
				);

		RestActions apiObject =   DriverFactory.getAPIDriver("https://demo.opencart.com/");
		Response response = apiObject.buildNewRequest("index.php?route=account/register", RequestType.POST)
				.setParameters(FormParamter,RestActions.ParametersType.FORM)
				.setContentType(ContentType.URLENC)
				.performRequest();

		//Validation
		int StatusCodeValue =  response.statusCode();
		Assertions.assertEquals("200", StatusCodeValue);
	}
}
