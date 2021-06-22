package guiTests;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import open_cart_pages.Confirmation_Page;
import open_cart_pages.Home_Page;
import open_cart_pages.Registration_Page;

public class Rgistration {
	private WebDriver driver ; 
	private  Home_Page homePage;
	private  Confirmation_Page confirmationPage;
	private  Registration_Page  registrationPage;
	private JSONFileManager RegFileReader;
	String email ="sayed"+ new Date().getTime() +"@gmail.com";

	@Test(description = "Registration With valid Data")
	@Description("When the user enters valid data on the sign up form and click continue, Then the user navigates to confirmation Page")
	@Epic("Web GUI")
	public void UserRegistration() {
		homePage.NavigateToRegistrationPage();
		registrationPage.UserRegistration(RegFileReader.getTestData("firstName"),RegFileReader.getTestData("lastName"),
				email,RegFileReader.getTestData("phone"),RegFileReader.getTestData("password"));

		//Validation
		Assertions.assertEquals("Your Account Has Been Created!",
				confirmationPage.GetConfirmationMessege());
	}
	
	
	@BeforeClass
	public void BeforeClass() {
		RegFileReader = new JSONFileManager(System.getProperty("testDataFolderPath")+"Registration.json");
	}

	@BeforeMethod
	public void beforeMethod () {
		WebDriver driver = DriverFactory.getDriver();
		BrowserActions.navigateToURL(driver, "https://demo.opencart.com/");
		homePage = new Home_Page(driver) ;
		confirmationPage = new Confirmation_Page(driver);
		registrationPage = new Registration_Page (driver);	 
	}

	@AfterMethod
	public void afterMethod() {
		BrowserActions.closeCurrentWindow(driver);
	}




}