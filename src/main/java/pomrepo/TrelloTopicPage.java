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
    private WebElement threeDots;

    @FindBy(xpath = "//a[@class='board-menu-navigation-item-link board-menu-navigation-item-link-v2 js-close-board']")
    private WebElement closeBoardOption;

    @FindBy(xpath = "//input[@value='Close']")
    private WebElement closeOption;

    @FindBy(xpath = "//button[normalize-space()='Permanently delete board']")
    private WebElement permanentlyDeleteBoardOpt;

    @FindBy(xpath = "//button[normalize-space()='Delete']")
    private WebElement deleteOption;
    
    @FindBy(xpath = "//p[text()='Boards']")
    private WebElement boardsOption;

    @FindBy(xpath = "(//textarea[@data-testid='list-name-textarea'])[1]")
    private WebElement listNameTextarea1;

    @FindBy(xpath = "(//textarea[@data-testid='list-name-textarea'])[2]")
    private WebElement listNameTextarea2;

    @FindBy(xpath = "(//textarea[@data-testid='list-name-textarea'])[3]")
    private WebElement listNameTextarea3;

    @FindBy(xpath = "(//textarea[@data-testid='list-name-textarea'])[4]")
    private WebElement listNameTextarea4;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[text()='Add a card']")
    private WebElement addCardButton;

    @FindBy(xpath = "//textarea[@placeholder='Enter a title for this card…']")
    private WebElement cardTitleTextarea;

    @FindBy(xpath = "//button[text()='Add card']")
    private WebElement addCardSubmitButton;

    @FindBy(xpath = "//span[@data-testid='CloseIcon']")
    private WebElement closeIcon;

    @FindBy(xpath = "//a[text()='Test Cases']")
    private WebElement testCaseTopic;

    @FindBy(xpath = "//a[text()='Agile Methodology']")
    private WebElement agileTopic;

    @FindBy(xpath = "//h2[text()='Manual']")
    private WebElement manualTextField;

    @FindBy(xpath = "//a[text()='Joins']")
    private WebElement joinsTopic;

    @FindBy(xpath = "//a[text()='Normalization']")
    private WebElement normalizationTopic;

    @FindBy(xpath = "//h2[text()='SQL']")
    private WebElement sqlTextField;

    @FindBy(xpath = "//a[text()='OOPS']")
    private WebElement oopsTopic;

    @FindBy(xpath = "//a[text()='Collection']")
    private WebElement collectionTopic;

    @FindBy(xpath = "//h2[text()='Java']")
    private WebElement javaTextField;

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
