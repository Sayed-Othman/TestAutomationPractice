package guiTests;
import org.testng.annotations.Test;
import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.AssertionComparisonType;
import com.shaft.validation.Assertions.AssertionType;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import open_cart_pages.Home_Page;
import open_cart_pages.ResultsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class ProductSearch {
	private WebDriver driver;
	private Home_Page homePage;
	private ResultsPage resultPage;
	private JSONFileManager searchFileReader;

	@Test(description = "Searching for products")
	@Description("When the user enters a name of a product he wants to search for, Then the user finds matching results")
	@Epic("Web GUI")
	public void TestSearchForProducts() {
		homePage.SearchForProduct(searchFileReader.getTestData("productSearchQuiery"));
		String searchresulTtext = resultPage.getSearchResultText(1);

		//Validations
		Assertions.assertEquals(searchFileReader.getTestData("productSearchQuiery"),searchresulTtext,
				AssertionComparisonType.CONTAINS, AssertionType.POSITIVE);
	}

	@BeforeClass
	public void BeforeClass() {
		searchFileReader = new JSONFileManager(System.getProperty("testDataFolderPath")+"ProductSearch.json");
	}

	@BeforeMethod
	public void beforeMethod () {
		WebDriver driver = DriverFactory.getDriver();
		BrowserActions.navigateToURL(driver, "https://demo.opencart.com/");
		homePage = new Home_Page(driver) ;
		resultPage = new ResultsPage(driver);
	}

	@AfterMethod
	public void afterMethod() {
		BrowserActions.closeCurrentWindow(driver);
	}

}
