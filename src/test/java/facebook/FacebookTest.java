package facebook;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericutility.BaseClass;
import pomrepo.FacebookLoginPage;
import pomrepo.FacebookSignUpPage;
import pomrepo.FbForgotPwdPage;

public class FacebookTest extends BaseClass {

	@Test(priority = 1, groups = { "smoke","functional" })
	public void writeAScriptToEnterDataAndLoginIntoFacebookLoginPage() {

		try {

			FacebookLoginPage loginPage = new FacebookLoginPage(driver);

			driver.get(fileUtils.getPropertyKeyValue("url"));	
			
			webdriverUtils.waitForATitle(driver, "Facebook – log in or sign up");
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, "Facebook – log in or sign up");

			/*
			 * CAUTION : For successful running you have to enter valid credentials for login
			 * The credentials given in property file for login won't work
			 * But they will work for sign up as shown in the next test method		
			 */
			
			Assert.assertTrue(loginPage.getUsernameTF().isDisplayed(), "Username textfield is not displayed");
			loginPage.getUsernameTF().sendKeys(fileUtils.getPropertyKeyValue("username"));
			
			Assert.assertTrue(loginPage.getPasswordTF().isDisplayed(), "Password textfield is not displayed");
			loginPage.getPasswordTF().sendKeys(fileUtils.getPropertyKeyValue("password"));
			
			Assert.assertTrue(loginPage.getSubmitButton().isEnabled(), "Submit button is not enabled");
			loginPage.getSubmitButton().submit();

			webdriverUtils.waitForTitleContains(driver, "Facebook");
			actualTitle = driver.getTitle();
			Assert.assertTrue(actualTitle.contains("Facebook"), "Page title is incorrect");
			
			//Handling notification pop up on home page using Robot class from java.awt package
			
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			Assert.fail("Test failed due to exception: " + e.getMessage());
			// e.printStackTrace();
		}
	}
	
	
	@Test(priority = 0, groups = { "smoke", "functional" }, invocationCount = 2)
	public void checkWhetherTheUserIsAbleToRegisterInFacebookSignUpPage() {
		
        //Use property file.
		
		try {

			FacebookSignUpPage signUpPage = new FacebookSignUpPage(driver);

			driver.get(fileUtils.getPropertyKeyValue("signup_url"));

			webdriverUtils.waitForATitle(driver, fileUtils.getPropertyKeyValue("title"));
			Assert.assertEquals(driver.getTitle(), fileUtils.getPropertyKeyValue("title"));

			signUpPage.setFirstName(fileUtils.getPropertyKeyValue("firstName"));
			signUpPage.setLastName(fileUtils.getPropertyKeyValue("lastName"));

			signUpPage.setMobileOrEmail(fileUtils.getPropertyKeyValue("username"));	
			webdriverUtils.waitTillElementToBeVisible(driver, signUpPage.getMobileOrEmailConfirmInput());
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
			FacebookLoginPage loginPage = new FacebookLoginPage(driver);

			driver.get(fileUtils.getPropertyKeyValue("url"));

			webdriverUtils.waitForATitle(driver, "Facebook – log in or sign up");
			Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");

			actions.sendKeys(driver.switchTo().activeElement())
			.sendKeys("wrong_email@gmail.com")
			.sendKeys(Keys.TAB)
			.sendKeys("wrongpassword")
			.sendKeys(Keys.ENTER)
			.build()
			.perform();

			Assert.assertTrue(loginPage.getErrorMessage().isDisplayed(),
					"Error message isn't displayed; log in happened unexpectely");

		} catch (Exception e) {
			// e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

	}

	@Test(priority = 3, groups = "functional")
	public void writeAScriptToLoginWithEmptyCredentialsInFacebookLoginPage() {

		try {

			Actions actions = new Actions(driver);

			FacebookLoginPage loginPage = new FacebookLoginPage(driver);

			driver.get(fileUtils.getPropertyKeyValue("url"));

			webdriverUtils.waitForATitle(driver, "Facebook – log in or sign up");
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
	
	@Test(priority = 3, groups = "functional")
	public void scriptToPerformASetOfActions() {
		
	    /* Below line sends some text to field by converting it to upper case, then
		   double click the text so that it will select all, then do right click */
		
		try {
			
			FacebookLoginPage loginPage = new FacebookLoginPage(driver);

			driver.get(fileUtils.getPropertyKeyValue("url"));
			
			webdriverUtils.waitForATitle(driver, "Facebook – log in or sign up");
			Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");

			Actions actions = new Actions(driver);

			actions.moveToElement(loginPage.getUsernameTF())
			.click()
			.keyDown(loginPage.getUsernameTF(), Keys.SHIFT)
			.sendKeys("Rohit")
			.keyUp(loginPage.getUsernameTF(), Keys.SHIFT)
			.doubleClick(loginPage.getUsernameTF())
			.contextClick(loginPage.getUsernameTF())
			.build()
			.perform();
			
		}

		catch (Exception e) {
			//e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}

	@Test(priority = 2, groups = "functional", enabled = false)
	public void WriteAScriptToTestForgotPassword() {
		
		/*
		 * CAUTION : For successful running you have to enter valid credentials for login. 
		 * The credentials taken to login from property file won't work		
		 */

		try {

			Actions actions = new Actions(driver);
			new FbForgotPwdPage(driver);
			new FacebookLoginPage(driver);

			driver.get(fileUtils.getPropertyKeyValue("forgotpwd_url"));

			String pageTitle = driver.getTitle();
			Assert.assertTrue(pageTitle.contains("Forgotten Password | Can't Log In"), "Page title is incorrect");
			
			actions.sendKeys(driver.switchTo().activeElement(), fileUtils.getPropertyKeyValue("username"))
					.sendKeys(Keys.ENTER).perform();

			pageTitle = driver.getTitle();
			Assert.assertTrue(pageTitle.contains("Log in to"), "Page title is incorrect");

			actions.sendKeys(driver.switchTo().activeElement()).sendKeys(fileUtils.getPropertyKeyValue("password"))
					.sendKeys(Keys.ENTER).perform();

		} catch (Exception e) {
			// e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
		
	}
	
	

}
