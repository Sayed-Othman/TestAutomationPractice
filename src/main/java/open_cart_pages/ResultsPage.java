package open_cart_pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.shaft.gui.element.ElementActions;

public class ResultsPage {
	WebDriver driver;

	//Constructor 
	public ResultsPage (WebDriver driver) {
		this.driver = driver;
	}

	//Actions
	public String getSearchResultText(int resultID) {
		return ElementActions.getText(driver, By.xpath
				("//*[@id=\"content\"]/div[3]/div["+resultID+"]/div/div[2]/div[1]/h4/a"));
	}

}
