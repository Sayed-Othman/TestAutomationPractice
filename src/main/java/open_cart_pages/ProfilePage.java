package open_cart_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;

public class ProfilePage {
	WebDriver driver;
	
	
	//Constructor
	
	public ProfilePage (WebDriver driver) {
		this.driver = driver;
	}
	
	//Elements Locator 
	private By YourStoreTextMessage = By.xpath("//a[contains(.,'Your Store')]");
	
	
	//Actions 
	
	
    public String GetYourStoreTextMessage () {
    	 return  ElementActions.getText(driver, YourStoreTextMessage);
    }

}
