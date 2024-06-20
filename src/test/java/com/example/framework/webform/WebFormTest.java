package com.example.framework.webform;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.example.genericutility.BaseClass;
import com.example.pomrepo.RegistrationFormExample;

public class WebFormTest extends BaseClass {

	@Test
	public void checkWhetherUserIsAbleToFillTheForm()
			throws InterruptedException, EncryptedDocumentException, IOException {
		
		try {

			driver.get("C:\\Users\\ROHIT M\\OneDrive\\Desktop\\sel\\web form.html");
			Actions actions = new Actions(driver);
			RegistrationFormExample regf = new RegistrationFormExample(driver);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.titleIs("JavaScript Form Validation using a sample registration form"));

			regf.getUserID().sendKeys(excelUtils.readTheStringData("Sheet1", 2, 3));
			regf.getPassword().sendKeys(excelUtils.readTheStringData("Sheet1", 10, 3));
			regf.getName().sendKeys(excelUtils.readTheStringData("Sheet1", 19, 3));
			regf.getAddress().sendKeys(excelUtils.readTheStringData("Sheet1", 26, 3));
			Select countrySelect = new Select(regf.getCountry());
			countrySelect.selectByIndex(2);
			regf.getZipCode().sendKeys("" + excelUtils.readTheLongNumericData("Sheet1", 36, 3));
			regf.getEmail().sendKeys(excelUtils.readTheStringData("Sheet1", 45, 3));
			regf.getSex().click();
			Thread.sleep(2000);
			regf.getLanguage().click();
			regf.getAbout().sendKeys("Form details have been filled");
			
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(regf.getLanguage().isSelected(), "The language checkbox is not selected.");
			
			regf.getSubmit().submit();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();

		} catch (Exception e) {
			// e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}
}
