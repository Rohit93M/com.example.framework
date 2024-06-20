package com.example.framework.facebook;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.example.genericutility.BaseClass;
import com.example.pomrepo.FacebookLoginPage;
import com.example.pomrepo.FacebookSignUpPage;
import com.example.pomrepo.FbForgotPwdPage;

public class FacebookTest extends BaseClass {

	@Test(priority = 1, groups = { "smoke","functional" })
	public void writeAScriptToEnterDataAndLoginIntoFacebookLoginPage() {

		try {

			FacebookLoginPage loginPage = new FacebookLoginPage(driver);

			driver.get(fileUtils.getPropertyKeyValue("url"));	
			
			webdriverUtils.waitForATitle(driver, "Facebook – log in or sign up");
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, "Facebook – log in or sign up");
			
			Assert.assertTrue(loginPage.getUsernameTF().isDisplayed(), "Username textfield is not displayed");
			loginPage.getUsernameTF().sendKeys(fileUtils.getPropertyKeyValue("username"));
			
			Assert.assertTrue(loginPage.getPasswordTF().isDisplayed(), "Password textfield is not displayed");
			loginPage.getPasswordTF().sendKeys(fileUtils.getPropertyKeyValue("password"));
			
			Assert.assertTrue(loginPage.getSubmitButton().isEnabled(), "Submit button is not enabled");
			loginPage.getSubmitButton().submit();

			webdriverUtils.waitForTitleContains(driver, "Facebook");
			actualTitle = driver.getTitle();
			Assert.assertTrue(actualTitle.contains("Facebook"), "Page title is incorrect");
			
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			Assert.fail("Test failed due to exception: " + e.getMessage());
			 e.printStackTrace();
		}
	}
	
	
	@Test(priority = 0, groups = { "smoke", "functional" }, invocationCount = 2)
	public void checkWhetherTheUserIsAbleToRegisterInFacebookSignUpPage() {
//		Use property file
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			FacebookSignUpPage signUpPage = new FacebookSignUpPage(driver);

			driver.get(fileUtils.getPropertyKeyValue("signup_url"));

			wait.until(ExpectedConditions.titleIs(fileUtils.getPropertyKeyValue("title")));
			Assert.assertEquals(driver.getTitle(), fileUtils.getPropertyKeyValue("title"));

			signUpPage.setFirstName(fileUtils.getPropertyKeyValue("firstName"));
			signUpPage.setLastName(fileUtils.getPropertyKeyValue("lastName"));

			signUpPage.setMobileOrEmail(fileUtils.getPropertyKeyValue("username"));
			wait.until(ExpectedConditions.visibilityOf(signUpPage.getMobileOrEmailConfirmInput()));
			signUpPage.setMobileOrEmailConfirmInput(fileUtils.getPropertyKeyValue("username"));
			signUpPage.setPassword(fileUtils.getPropertyKeyValue("password"));

			signUpPage.setBirthDay(fileUtils.getPropertyKeyValue("birthDay"));
			signUpPage.setBirthMonth(fileUtils.getPropertyKeyValue("birthMonth"));
			signUpPage.setBirthYear(fileUtils.getPropertyKeyValue("birthYear"));

			signUpPage.setGender(fileUtils.getPropertyKeyValue("gender"));
			signUpPage.clickSignUp();

			Assert.assertNotNull(driver.getTitle(), "URL is null after sign up");
			Reporter.log(driver.getTitle());

		} catch (Exception e) {
			Assert.fail("Test failed due to exception: " + e.getMessage());
			// e.printStackTrace();
		}
	}

	@Test(priority = 4, groups = "functional")
	public void scriptForFacebookLoginWithInvalidData() {

		try {

			Actions actions = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			FacebookLoginPage loginPage = new FacebookLoginPage(driver);

			driver.get("https://www.facebook.com/");

			wait.until(ExpectedConditions.titleIs("Facebook – log in or sign up"));
			Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");

			actions.sendKeys(driver.switchTo().activeElement()).sendKeys("wrong_email@gmail.com").sendKeys(Keys.TAB)
					.sendKeys("wrongpassword").sendKeys(Keys.ENTER).perform();

			Assert.assertTrue(loginPage.getErrorMessage().isDisplayed(),
					"Error message isn't displayed; log in happened unexpectely");

		} catch (Exception e) {
			// e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

	}

	@Test(priority = 3, groups = "functional")
	public void writeAScriptToLoginWithEmptyCredentialsInFacebookLoginPage() throws InterruptedException {

		try {

			Actions actions = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			FacebookLoginPage loginPage = new FacebookLoginPage(driver);

			driver.get("https://www.facebook.com/");

			wait.until(ExpectedConditions.titleIs("Facebook – log in or sign up"));
			Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");

			actions.click(loginPage.getSubmitButton()).perform();

			// Script to capture error text and color of error text
			String errorMsgText = loginPage.getErrorMessage().getText();
			System.out.println("errorMsgText= " + errorMsgText);

			String colorOfErrorMsg = loginPage.getErrorMessage().getCssValue("color");
			System.out.println("colorOfErrorMsg= " + colorOfErrorMsg);

			String hexadecimalValue = Color.fromString(colorOfErrorMsg).asHex();
			System.out.println("hexadecimalValue= " + hexadecimalValue);

		} catch (Exception e) {
			// e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}

	@Test(priority = 2, groups = "functional", enabled = false)
	public void WriteAScriptToTestForgotPassword() {

		try {

			Actions actions = new Actions(driver);
			new FbForgotPwdPage(driver);
			new FacebookLoginPage(driver);

			driver.get("https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0");

			String pageTitle = driver.getTitle();
			Assert.assertTrue(pageTitle.contains("Forgotten Password | Can't Log In"), "Page title is incorrect");

			actions.sendKeys(driver.switchTo().activeElement(), fileUtils.getPropertyKeyValue("username"))
					.sendKeys(Keys.ENTER).perform();

			String PageTitle = driver.getTitle();
			Assert.assertTrue(PageTitle.contains("Log in to"), "Page title is incorrect");

			actions.sendKeys(driver.switchTo().activeElement()).sendKeys(fileUtils.getPropertyKeyValue("password"))
					.sendKeys(Keys.ENTER).perform();

		} catch (Exception e) {
			// e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}

}
