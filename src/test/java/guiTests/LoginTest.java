package guiTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.validation.Assertions;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import open_cart_pages.Home_Page;
import open_cart_pages.LoginPage;
import open_cart_pages.ProfilePage;

public class LoginTest {
	WebDriver driver;
	LoginPage loginPage;
	ProfilePage profilePage;
	Home_Page homePage ;

	@Test(description = " SignIn With valid Data")
	@Description("When the User Enters valid data on the sign IN form and click continue Then he navigates to ProfilePage ")
	@Epic("Web GUI")
	public void TestUserLogin() {
		homePage.NavigateToLoginPage();
		loginPage.UserLogin("sayed50@gmail.com", "123456");

		//Validations
		Assertions.assertEquals("Your Store",profilePage.GetYourStoreTextMessage());
	}

	@BeforeMethod
	public void beforeMethod() {
		WebDriver driver = DriverFactory.getDriver();
		BrowserActions.navigateToURL(driver, "https://demo.opencart.com/");
		loginPage = new LoginPage(driver);
		profilePage = new ProfilePage(driver);
		homePage = new Home_Page(driver);
	}

	@AfterMethod
	public void afterMethod() {
		BrowserActions.closeCurrentWindow(driver);
	}
}
