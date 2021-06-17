package open_cart_test_practice_first;


import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.ElementAttributeType;

import io.qameta.allure.Description;
import open_cart_pages.Confirmation_Page;
import open_cart_pages.Home_Page;
import open_cart_pages.Registeration_Page;



public class Rgisteration {
	
	private WebDriver driver ; 
	 private  Home_Page homePage;
	 private  Confirmation_Page confirmationPage;
	 private  Registeration_Page  registerationPage;
	  String email = "sayed" + new Date().getTime() + "@gmail.com";
	

	
	
	
	  @Test(description = " SignUp With valid Data")
	  @Description("When the User Enters the valid data on the sign up form and click continue Then he navigates to confirmatio Page ")
	  public void UserRegisteration() {
		  
		  
		  
		  homePage.NavigateToRegisterationPage();
		  
		  
		  registerationPage.UserRegisteration
		                ("Sayed", "Othman", email, "123456", "sa123456");
		  
		  
		  //Validation
		  Assertions.assertEquals("Your Account Has Been Created!",
				  confirmationPage.GetConfirmationMessege());
		  
		  
		  

	  }
	  
	  
	  
	@BeforeMethod
	public void beforeMethod () {
		WebDriver driver = DriverFactory.getDriver();
		BrowserActions.navigateToURL(driver, "https://demo.opencart.com/");
		
		 homePage = new Home_Page(driver) ;
		 confirmationPage = new Confirmation_Page(driver);
		 registerationPage = new Registeration_Page (driver);	 
		 
	}
	
	
	@AfterMethod
	public void afterMethod() {
		BrowserActions.closeCurrentWindow(driver);
	}
	
	
	

}