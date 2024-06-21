package pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookSignUpPage {

    WebDriver driver;

    public FacebookSignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "reg_email__")
    private WebElement mobileOrEmailInput;

    public void setMobileOrEmail(String mobileOrEmail) {
        mobileOrEmailInput.sendKeys(mobileOrEmail);
    }

    @FindBy(name = "reg_email_confirmation__")
    private WebElement mobileOrEmailConfirmInput;

    public void setMobileOrEmailConfirmInput(String mobileOrEmail) {
        mobileOrEmailConfirmInput.sendKeys(mobileOrEmail);
    }

    public WebElement getMobileOrEmailConfirmInput() {
        return mobileOrEmailConfirmInput;
    }

    @FindBy(name = "reg_passwd__")
    private WebElement passwordInput;

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    @FindBy(name = "firstname")
    private WebElement firstNameInput;

    public void setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    @FindBy(name = "lastname")
    private WebElement lastNameInput;

    public void setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    @FindBy(name = "birthday_day")
    private WebElement birthDay;

    public void setBirthDay(String day) {
        birthDay.sendKeys(day);
    }

    @FindBy(name = "birthday_month")
    private WebElement birthMonth;

    public void setBirthMonth(String month) {
        birthMonth.sendKeys(month);
    }

    @FindBy(name = "birthday_year")
    private WebElement birthYear;

    public void setBirthYear(String year) {
        birthYear.sendKeys(year);
    }

    @FindBy(xpath = "//label[text()='Female']/following-sibling::input")
    private WebElement femaleRadio;

    @FindBy(xpath = "//label[text()='Male']/following-sibling::input")
    private WebElement maleRadio;

    @FindBy(xpath = "//label[text()='Custom']/following-sibling::input")
    private WebElement customRadio;

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("female")) {
            femaleRadio.click();
        } else if (gender.equalsIgnoreCase("male")) {
            maleRadio.click();
        } else if (gender.equalsIgnoreCase("custom")) {
            customRadio.click();
        }
    }

    @FindBy(name = "websubmit")
    private WebElement signUpButton;

    public void clickSignUp() {
        signUpButton.click();
    }
}
