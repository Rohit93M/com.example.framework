package pomrepo;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//button[normalize-space()='Add a list']")
    WebElement addListButton;

    @FindBy(xpath = "//textarea[@placeholder='Enter list title…']")
    WebElement listTitleTextField;

    @FindBy(xpath = "//input[@value='Add list']")
    WebElement saveListButton;

    @FindBy(xpath = "//button[normalize-space()='Add a card']")
    WebElement addCardButton;

    @FindBy(xpath = "//textarea[@placeholder='Enter a title for this card…']")
    WebElement cardTitleTextField;

    @FindBy(xpath = "//input[@value='Add card']")
    WebElement saveCardButton;

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

    public WebElement getAddListButton() {
        return addListButton;
    }

    public WebElement getListTitleTextField() {
        return listTitleTextField;
    }

    public WebElement getSaveListButton() {
        return saveListButton;
    }

    public WebElement getAddCardButton(String listName) {
        return driver.findElement(By.xpath("//h2[text()='" + listName + "']/following-sibling::div//span[text()='Add a card']"));
    }

    public WebElement getCardTitleTextField() {
        return cardTitleTextField;
    }

    public WebElement getSaveCardButton() {
        return saveCardButton;
    }

    public WebElement getCard(String cardTitle) {
        return driver.findElement(By.xpath("//span[text()='" + cardTitle + "']"));
    }

    public WebElement getList(String listName) {
        return driver.findElement(By.xpath("//h2[text()='" + listName + "']"));
    }

    public void addCardToList(String listName, String cardTitle) {
        getAddCardButton(listName).click();
        getCardTitleTextField().sendKeys(cardTitle);
        getSaveCardButton().click();
    }
}
