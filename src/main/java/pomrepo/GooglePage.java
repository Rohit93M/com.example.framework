package pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutility.WebDriverUtility;

public class GooglePage {
	WebDriver driver;
	WebDriverUtility webdriverUtils = new WebDriverUtility();

	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	private WebElement searchTF;
	
	@FindBy(name = "btnK")
	private WebElement searchButton;

	public void search(String text) {
		searchTF.sendKeys(text);
	}
	
	public void clickBtn() {
		webdriverUtils.waitTillElementToBeClickable(driver, searchButton);
		searchButton.submit();
	}
}

//  public SearchResultsPage searchFor(String text) {
//    q.sendKeys(text);
//    q.submit();
//    new WebDriverWait(driver, Duration.ofSeconds(8)).until(visibilityOfElementLocated(By.cssSelector("[data-testid='result']")));
//    return PageFactory.initElements(driver, SearchResultsPage.class);
//  }
