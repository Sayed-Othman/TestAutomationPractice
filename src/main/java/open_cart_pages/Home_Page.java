package open_cart_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;

public class Home_Page {
	
	private WebDriver  driver ; 
	
	
	
	 // Constructor
	
	public Home_Page (WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	// Elements Locators 
	
	private By MyAccount_Button = By.xpath("//a[contains(.,'My Account')and @class='dropdown-toggle']");
	private By Register_Button 	= By.xpath("//a[contains(.,'Register')]");
	private By Login_button     = By.xpath("//a[contains(.,'Login')]");
	
	
	//Actions 
	
	
	public void  NavigateToRegisterationPage () {
		
		ElementActions.click(driver, MyAccount_Button);
		ElementActions.click(driver, Register_Button );
		
		
	}
	
	public void  NavigateToLoginPage () {
		
		ElementActions.click(driver, MyAccount_Button);
		ElementActions.click(driver,  Login_button  );
		
	}
	
	
	

	

}
