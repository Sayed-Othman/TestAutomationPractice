package open_cart_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;

public class Registeration_Page {
	
	private WebDriver driver; 
	
	
	// Constructor
	
	public Registeration_Page (WebDriver driver) {
		this.driver = driver ; 
	}
	
	
	
	// Elements Locators
	
	
	private By firstname_TextField = By.id("input-firstname");
	private By lastname_TextField = By.id("input-lastname");
	private By email_TextField = By.id("input-email");
	private By phone_TextField= By.id("input-telephone");
	private By password_TextField = By.id("input-password");
	private By confirmPassword_TextField = By.id("input-confirm");
	private By checkBox = By.name("agree");
	private By continue_Button = By.xpath("//input[@value='Continue']");
	
	
	
	
	//Actions
	
	
	public void UserRegisteration (String firstName, String lastName, String email,String phone, String password) {
		
		
	new	ElementActions(driver)
	    .type(firstname_TextField,firstName)
		.type(lastname_TextField, lastName)
		.type(email_TextField , email)
	    .type(phone_TextField , phone)
		.type(password_TextField , password)
		.type(confirmPassword_TextField , password)
		.click(checkBox)	
		.click(continue_Button);
		
		
		
	}
	
	
	
	
	
}
