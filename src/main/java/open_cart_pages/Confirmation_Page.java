package open_cart_pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.shaft.gui.element.ElementActions;

public class Confirmation_Page {
	private WebDriver  driver ; 

	// Constructor
	public Confirmation_Page (WebDriver driver) {
		this.driver = driver;
	}

	// Elements Locators 
	private By ConfirmationMessege = By.xpath("//div/h1[contains(.,'Your Account Has Been Created!')]");

	//Actions 
	public String  GetConfirmationMessege () {
		return ElementActions.getText(driver, ConfirmationMessege);
	}

	public By GetConfirmationMessegeLocator () {
		return ConfirmationMessege;
	}
}
