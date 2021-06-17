package open_cart_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;

public class LoginPage {
	
	private WebDriver driver ;
	
	//constructor 
	
	public LoginPage (WebDriver driver) {
		this.driver =driver;	
	}
	
	
	//Elements Locators 
	
	private By LoginEmailAdressInputFiield =  By.id("input-email");
	private By LoginPasswordInputField     = By.id("input-password");
	private By LoginButton                 = By.xpath("//input[@value='Login']");
	
	
	//Actions 
	public void  UserLogin (String loginEmailAdress, String loginPassword) {
		
		new	ElementActions(driver)
		.type(LoginEmailAdressInputFiield, loginEmailAdress)
		.type(LoginPasswordInputField , loginPassword)
		.click( LoginButton);
		
		
	}
	

}
