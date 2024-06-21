package sampleform;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericutility.BaseClass;
import genericutility.ListenersImplementation;
import pomrepo.SampleWebForm;

@Listeners(ListenersImplementation.class)
public class WebFormTest extends BaseClass {

	@Test
	public void checkWhetherUserIsAbleToFillTheForm() {
		
		try {
		
			SampleWebForm swf = new SampleWebForm(driver);

			driver.get("C:\\Users\\ROHIT M\\OneDrive\\Desktop\\sel\\web form.html");
			
			/*
			 * IMPORTANT: you need to copy the web form.html present in the src/test/resources folder to your local machine
			 */

			webdriverUtils.waitForATitle(driver, "JavaScript Form Validation using a sample registration form");
			Assert.assertEquals(driver.getTitle(), "JavaScript Form Validation using a sample registration form",
					"Welcome page title does not match");

			webdriverUtils.waitTillElementToBeVisible(driver, swf.getUserID());
			swf.getUserID().sendKeys(excelUtils.readTheStringData("Sheet1", 2, 3));
			
			webdriverUtils.waitTillElementToBeVisible(driver, swf.getPassword());
			swf.getPassword().sendKeys(excelUtils.readTheStringData("Sheet1", 10, 3));
			
			webdriverUtils.waitTillElementToBeVisible(driver, swf.getName());
			swf.getName().sendKeys(excelUtils.readTheStringData("Sheet1", 19, 3));
			
			webdriverUtils.waitTillElementToBeVisible(driver, swf.getAddress());
			swf.getAddress().sendKeys(excelUtils.readTheStringData("Sheet1", 26, 3));
			
			webdriverUtils.waitTillElementToBeVisible(driver, swf.getCountry());
			Select countrySelect = new Select(swf.getCountry());
			countrySelect.selectByIndex(2);
			
			webdriverUtils.waitTillElementToBeVisible(driver, swf.getZipCode());
			swf.getZipCode().sendKeys("" + excelUtils.readTheLongNumericData("Sheet1", 36, 3));
			
			webdriverUtils.waitTillElementToBeVisible(driver, swf.getEmail());
			swf.getEmail().sendKeys(excelUtils.readTheStringData("Sheet1", 45, 3));
			
			webdriverUtils.waitTillElementToBeClickable(driver, swf.getSex());
			swf.getSex().click();
			
			webdriverUtils.waitTillElementToBeClickable(driver, swf.getLanguage());
			swf.getLanguage().click();
			
			webdriverUtils.waitTillElementToBeVisible(driver, swf.getAbout());
			swf.getAbout().sendKeys("Form details have been filled");
			
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(swf.getLanguage().isSelected(), "The language checkbox is not selected.");
			
			webdriverUtils.waitTillElementToBeClickable(driver, swf.getSubmit());
			swf.getSubmit().submit();

			webdriverUtils.waitForAlertPopup(driver);
			driver.switchTo().alert().accept();

		} catch (Exception e) {
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}
}
