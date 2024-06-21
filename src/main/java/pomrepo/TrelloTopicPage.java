package pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloTopicPage {

	WebDriver driver;

	public TrelloTopicPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@aria-label='Show menu']")
	WebElement threeDots;

	@FindBy(xpath = "//a[@class='board-menu-navigation-item-link board-menu-navigation-item-link-v2 js-close-board']")
	WebElement closeBoardOption;

	@FindBy(xpath = "//input[@value='Close']")
	WebElement closeOption;

	@FindBy(xpath = "//button[normalize-space()='Permanently delete board']")
	WebElement permanentlyDeleteBoardOpt;

	@FindBy(xpath = "//button[normalize-space()='Delete']")
	WebElement deleteOption;
	
	@FindBy(xpath = "//p[text()='Boards']")
	WebElement boardsOption;

	@FindBy(xpath = "(//textarea[@data-testid='list-name-textarea'])[1]")
	WebElement listNameTextarea1;

	@FindBy(xpath = "(//textarea[@data-testid='list-name-textarea'])[2]")
	WebElement listNameTextarea2;

	@FindBy(xpath = "(//textarea[@data-testid='list-name-textarea'])[3]")
	WebElement listNameTextarea3;

	@FindBy(xpath = "(//textarea[@data-testid='list-name-textarea'])[4]")
	WebElement listNameTextarea4;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;

	@FindBy(xpath = "//button[text()='Add a card']")
	WebElement addCardButton;

	@FindBy(xpath = "//textarea[@placeholder='Enter a title for this card…']")
	WebElement cardTitleTextarea;

	@FindBy(xpath = "//button[text()='Add card']")
	WebElement addCardSubmitButton;

	@FindBy(xpath = "//span[@data-testid='CloseIcon']")
	WebElement closeIcon;

	@FindBy(xpath = "//a[text()='Test Cases']")
	WebElement testCaseTopic;

	@FindBy(xpath = "//a[text()='Agile Methodology']")
	WebElement agileTopic;

	@FindBy(xpath = "//h2[text()='Manual']")
	WebElement manualTextField;

	@FindBy(xpath = "//a[text()='Joins']")
	WebElement joinsTopic;

	@FindBy(xpath = "//a[text()='Normalization']")
	WebElement normalizationTopic;

	@FindBy(xpath = "//h2[text()='SQL']")
	WebElement sqlTextField;

	@FindBy(xpath = "//a[text()='OOPS']")
	WebElement oopsTopic;

	@FindBy(xpath = "//a[text()='Collection']")
	WebElement collectionTopic;

	@FindBy(xpath = "//h2[text()='Java']")
	WebElement javaTextField;

	public WebElement getThreeDots() {
		return threeDots;
	}

	public WebElement getCloseBoardOption() {
		return closeBoardOption;
	}

	public WebElement getCloseOption() {
		return closeOption;
	}

	public WebElement getPermanentlyDeleteBoardOpt() {
		return permanentlyDeleteBoardOpt;
	}

	public WebElement getDeleteOption() {
		return deleteOption;
	}
	
	public WebElement getBoardsOption() {
		return boardsOption;
	}

	public WebElement getListNameTextarea1() {
		return listNameTextarea1;
	}

	public WebElement getListNameTextarea2() {
		return listNameTextarea2;
	}

	public WebElement getListNameTextarea3() {
		return listNameTextarea3;
	}

	public WebElement getListNameTextarea4() {
		return listNameTextarea4;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getAddCardButton() {
		return addCardButton;
	}

	public WebElement getCardTitleTextarea() {
		return cardTitleTextarea;
	}

	public WebElement getAddCardSubmitButton() {
		return addCardSubmitButton;
	}

	public WebElement getCloseIcon() {
		return closeIcon;
	}

	public WebElement getTestCaseTopic() {
		return testCaseTopic;
	}

	public WebElement getAgileTopic() {
		return agileTopic;
	}

	public WebElement getManualTextField() {
		return manualTextField;
	}

	public WebElement getJoinsTopic() {
		return joinsTopic;
	}

	public WebElement getNormalizationTopic() {
		return normalizationTopic;
	}

	public WebElement getSqlTextField() {
		return sqlTextField;
	}

	public WebElement getOopsTopic() {
		return oopsTopic;
	}

	public WebElement getCollectionTopic() {
		return collectionTopic;
	}

	public WebElement getJavaTextField() {
		return javaTextField;
	}
}
