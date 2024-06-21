package pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloWorkspacePage {
	WebDriver driver;

	public TrelloWorkspacePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@title='Selenium']")
	private WebElement createdBoard ;
	
	public WebElement getCreatedBoardName() {
		return createdBoard;
	}
	
}
