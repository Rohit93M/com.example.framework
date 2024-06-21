package pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationFormExample {

    private WebDriver driver;

    public RegistrationFormExample(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "userid")
    private WebElement userID;

    @FindBy(name = "passid")
    private WebElement password;

    @FindBy(name = "username")
    private WebElement name;

    @FindBy(name = "address")
    private WebElement address;

    @FindBy(name = "country")
    private WebElement country;

    @FindBy(name = "zip")
    private WebElement zipCode;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "msex")
    private WebElement sex;

    @FindBy(name = "en")
    private WebElement language;

    @FindBy(id = "desc")
    private WebElement about;

    @FindBy(name = "submit")
    private WebElement submit;

    public WebElement getUserID() {
        return userID;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getZipCode() {
        return zipCode;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getSex() {
        return sex;
    }

    public WebElement getLanguage() {
        return language;
    }

    public WebElement getAbout() {
        return about;
    }

    public WebElement getSubmit() {
        return submit;
    }
}
