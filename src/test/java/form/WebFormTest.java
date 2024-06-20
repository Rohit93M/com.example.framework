package form;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericutility.BaseClass;
import genericutility.ListenersImplementation;
import genericutility.WebDriverUtility;
import pomrepo.RegistrationFormExample;

@Listeners(ListenersImplementation.class)
public class WebFormTest extends BaseClass {

	@Test
	public void checkWhetherUserIsAbleToFillTheForm()
			throws InterruptedException, EncryptedDocumentException, IOException {
		
		try {
			
			WebDriverUtility webDriverUtil = new WebDriverUtility();
			RegistrationFormExample regf = new RegistrationFormExample(driver);

			driver.get("C:\\Users\\ROHIT M\\OneDrive\\Desktop\\sel\\web form.html");

			webDriverUtil.waitForATitle(driver, "JavaScript Form Validation using a sample registration form");
			Assert.assertEquals(driver.getTitle(), "JavaScript Form Validation using a sample registration form",
					"Welcome page title does not match");

			webDriverUtil.waitTillElementToBeVisible(driver, regf.getUserID());
			regf.getUserID().sendKeys(excelUtils.readTheStringData("Sheet1", 2, 3));
			
			webDriverUtil.waitTillElementToBeVisible(driver, regf.getPassword());
			regf.getPassword().sendKeys(excelUtils.readTheStringData("Sheet1", 10, 3));
			
			webDriverUtil.waitTillElementToBeVisible(driver, regf.getName());
			regf.getName().sendKeys(excelUtils.readTheStringData("Sheet1", 19, 3));
			
			webDriverUtil.waitTillElementToBeVisible(driver, regf.getAddress());
			regf.getAddress().sendKeys(excelUtils.readTheStringData("Sheet1", 26, 3));
			
			webDriverUtil.waitTillElementToBeVisible(driver, regf.getCountry());
			Select countrySelect = new Select(regf.getCountry());
			countrySelect.selectByIndex(2);
			
			webDriverUtil.waitTillElementToBeVisible(driver, regf.getZipCode());
			regf.getZipCode().sendKeys("" + excelUtils.readTheLongNumericData("Sheet1", 36, 3));
			
			webDriverUtil.waitTillElementToBeVisible(driver, regf.getEmail());
			regf.getEmail().sendKeys(excelUtils.readTheStringData("Sheet1", 45, 3));
			
			webDriverUtil.waitTillElementToBeClickable(driver, regf.getSex());
			regf.getSex().click();
			
			webDriverUtil.waitTillElementToBeClickable(driver, regf.getLanguage());
			regf.getLanguage().click();
			
			webDriverUtil.waitTillElementToBeVisible(driver, regf.getAbout());
			regf.getAbout().sendKeys("Form details have been filled");
			
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(regf.getLanguage().isSelected(), "The language checkbox is not selected.");
			
			webDriverUtil.waitTillElementToBeClickable(driver, regf.getSubmit());
			regf.getSubmit().submit();

			webDriverUtil.waitForAlertPopup(driver);
			driver.switchTo().alert().accept();

		} catch (Exception e) {
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}
}
