package trelloapp_test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericutility.BaseClass;
import genericutility.ListenersImplementation;
import pomrepo.TrelloBoardsPage;
import pomrepo.TrelloLoginPage;
import pomrepo.TrelloLogoutPage;
import pomrepo.TrelloTopicPage;
import pomrepo.TrelloWelcomePage;

@Listeners(ListenersImplementation.class)
public class TrelloAppTest extends BaseClass {

	@Test
	public void checkWhetherTheEndUserIsAbleToCreateAndDeleteTheBoard() throws IOException {

		try {

			TrelloWelcomePage welcomePage = new TrelloWelcomePage(driver);
			TrelloLoginPage loginPage = new TrelloLoginPage(driver);
			TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
			TrelloTopicPage topicPage = new TrelloTopicPage(driver);
			TrelloLogoutPage logoutPage = new TrelloLogoutPage(driver);

			webdriverUtils.waitForATitle(driver, "Manage Your Team’s Projects From Anywhere | Trello");
			Assert.assertEquals(driver.getTitle(), "Manage Your Team’s Projects From Anywhere | Trello",
					"Welcome page title does not match");

			webdriverUtils.waitTillElementToBeClickable(driver, welcomePage.getLoginLink());
			welcomePage.getLoginLink().click();

			webdriverUtils.waitForATitle(driver, "Log in to continue - Log in with Atlassian account");
			Assert.assertEquals(driver.getTitle(), "Log in to continue - Log in with Atlassian account",
					"Login page title does not match");

			webdriverUtils.waitTillElementToBeVisible(driver, loginPage.getUsernameTextField());
			loginPage.getUsernameTextField().sendKeys(fileUtils.getPropertyKeyValue("email"));

			webdriverUtils.waitTillElementToBeClickable(driver, loginPage.getContinueButton());
			loginPage.getContinueButton().click();

			webdriverUtils.waitTillElementToBeVisible(driver, loginPage.getPasswordTextField());
			loginPage.getPasswordTextField().sendKeys(fileUtils.getPropertyKeyValue("password"));

			webdriverUtils.waitTillElementToBeClickable(driver, loginPage.getLoginButton());
			loginPage.getLoginButton().click();

			webdriverUtils.waitForATitle(driver, "Boards | Trello");
			Assert.assertEquals(driver.getTitle(), "Boards | Trello", "Homepage page title does not match");

			webdriverUtils.waitTillElementToBeClickable(driver, boardsPage.getCreateNewBoardOption());
			boardsPage.getCreateNewBoardOption().click();

			webdriverUtils.waitTillElementToBeVisible(driver, boardsPage.getBoardTitleTextField());
			boardsPage.getBoardTitleTextField().sendKeys("Selenium");
			Assert.assertTrue(boardsPage.getCreateOption().isEnabled(), "Create Option is disabled");

			webdriverUtils.waitTillElementToBeClickable(driver, boardsPage.getCreateOption());
			boardsPage.getCreateOption().click();

			webdriverUtils.waitForATitle(driver, "Selenium | Trello");
			Assert.assertEquals(driver.getTitle(), "Selenium | Trello", "Topic page title does not match");

			webdriverUtils.waitTillElementToBeClickable(driver, topicPage.getThreeDots());
			topicPage.getThreeDots().click();

			webdriverUtils.waitTillElementToBeClickable(driver, topicPage.getCloseBoardOption());
			topicPage.getCloseBoardOption().click();

			webdriverUtils.waitTillElementToBeClickable(driver, topicPage.getCloseOption());
			topicPage.getCloseOption().click();

			webdriverUtils.waitTillElementToBeClickable(driver, topicPage.getPermanentlyDeleteBoardOpt());
			topicPage.getPermanentlyDeleteBoardOpt().click();

			webdriverUtils.waitTillElementToBeClickable(driver, topicPage.getDeleteOption());
			topicPage.getDeleteOption().click();

			webdriverUtils.waitForATitle(driver, "Boards | Trello");
			Assert.assertEquals(driver.getTitle(), "Boards | Trello", "Boards page title does not match");

			webdriverUtils.waitTillElementToBeClickable(driver, boardsPage.getMenuIcon());
			boardsPage.getMenuIcon().click();

			webdriverUtils.waitTillElementToBeClickable(driver, boardsPage.getLogoutLink());
			boardsPage.getLogoutLink().click();

			webdriverUtils.waitForATitle(driver, "Log out of your Atlassian account - Log in with Atlassian account");
			Assert.assertEquals(driver.getTitle(), "Log out of your Atlassian account - Log in with Atlassian account",
					" Logout page title does not match");

			webdriverUtils.waitTillElementToBeClickable(driver, logoutPage.getLogoutButton());
			logoutPage.getLogoutButton().click();

			webdriverUtils.waitForATitle(driver, "Manage Your Team’s Projects From Anywhere | Trello");
			Assert.assertEquals(driver.getTitle(), "Manage Your Team’s Projects From Anywhere | Trello",
					"Welcome page title does not match");

		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void writeAScriptToCheckClickHoldAndReleaseFunctionalityWithCardsAndListsInTrelloBoardsPage() {

		try {

			WebElement loginLink = driver.findElement(By.xpath("//a[text()='Log in']"));
			loginLink.click();
			Actions actions = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

			// V&V Login page ->
			wait.until(ExpectedConditions.titleIs("Log in to continue - Log in with Atlassian account"));
			String loginPageActualTitle = driver.getTitle();
			String loginPageExpectedTitle = "Log in to continue - Log in with Atlassian account";
			if (loginPageActualTitle.equals(loginPageExpectedTitle)) {
				WebElement emailTextField = driver.findElement(By.id("username"));
				emailTextField.sendKeys("rohit93m@gmail.com");
				WebElement continueButton = driver.findElement(By.xpath("//span[text()='Continue']"));
				continueButton.submit();
				WebElement passwordTextField = driver.findElement(By.id("password"));
				passwordTextField.sendKeys("Rohit@1993");
				WebElement loginButton = driver.findElement(By.xpath("//span[text()='Log in']"));
				loginButton.submit();

				// V&V Trello Boards Page ->
				wait.until(ExpectedConditions.titleIs("Boards | Trello"));
				String actualBoardsPageTitle = driver.getTitle();
				String expectedBoardsPageTitle = "Boards | Trello";
				if (actualBoardsPageTitle.equals(expectedBoardsPageTitle)) {
					System.out.println("Actual Title of Trello Boards Page is same as Expected Title");
					WebElement createNewBoardOption = driver.findElement(By.xpath("//span[text()='Create new board']"));
					createNewBoardOption.click();
					WebElement boardTitleTextField = driver.findElement(By.xpath("//input[@type='text']"));
					boardTitleTextField.sendKeys("Selenium");
					WebElement createOption = driver.findElement(By.xpath("//button[text()='Create']"));
					wait.until(ExpectedConditions.elementToBeClickable(createOption));
					if (createOption.isEnabled()) {
						createOption.click();
						System.out.println("createButton is enabled");

						// V&V Chosen Title Page ->
						wait.until(ExpectedConditions.titleIs("Selenium | Trello"));
						String actualChosenTitle = driver.getTitle();
						String expectedChosenTitle = "Selenium | Trello";
						if (actualChosenTitle.equals(expectedChosenTitle)) {
							System.out.println("actualChosenTitle is same as expectedChosenTitle");

							// Creating Subject Data ->
							driver.findElement(By.xpath("(//textarea[@data-testid='list-name-textarea'])[1]"))
									.sendKeys("Topics");
							driver.findElement(By.xpath("//button[@type='submit']")).submit();
							driver.findElement(By.xpath("(//textarea[@data-testid='list-name-textarea'])[2]"))
									.sendKeys("Manual");
							driver.findElement(By.xpath("//button[@type='submit']")).submit();
							driver.findElement(By.xpath("(//textarea[@data-testid='list-name-textarea'])[3]"))
									.sendKeys("SQL");
							driver.findElement(By.xpath("//button[@type='submit']")).submit();
							driver.findElement(By.xpath("(//textarea[@data-testid='list-name-textarea'])[4]"))
									.sendKeys("Java");
							driver.findElement(By.xpath("//button[@type='submit']")).submit();
							driver.findElement(By.xpath("//span[@data-testid='CloseIcon']")).click();

							// Entering Topics Data ->
							driver.findElement(By.xpath("//button[text()='Add a card']")).click();
							driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']"))
									.sendKeys("Test Cases");
							driver.findElement(By.xpath("//button[text()='Add card']")).click();
							driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']"))
									.sendKeys("Agile Methodology");
							driver.findElement(By.xpath("//button[text()='Add card']")).click();
							driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']"))
									.sendKeys("Joins");
							driver.findElement(By.xpath("//button[text()='Add card']")).click();
							driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']"))
									.sendKeys("Normalization");
							driver.findElement(By.xpath("//button[text()='Add card']")).click();
							driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']"))
									.sendKeys("OOPS");
							driver.findElement(By.xpath("//button[text()='Add card']")).click();
							driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']"))
									.sendKeys("Collection");
							driver.findElement(By.xpath("//button[text()='Add card']")).click();
							driver.findElement(By.xpath("//span[@data-testid='CloseIcon']")).click();

							// Click And Hold Action ->
							WebElement testCaseTopic = driver.findElement(By.xpath("//a[text()='Test Cases']"));
							WebElement agileTopic = driver.findElement(By.xpath("//a[text()='Agile Methodology']"));
							WebElement manualTextField = driver.findElement(By.xpath("//h2[text()='Manual']"));
							actions.clickAndHold(testCaseTopic).release(manualTextField).perform();
							actions.clickAndHold(agileTopic).release(manualTextField).perform();

							WebElement joinsTopic = driver.findElement(By.xpath("//a[text()='Joins']"));
							WebElement normalizationTopic = driver.findElement(By.xpath("//a[text()='Normalization']"));
							WebElement sqlTextField = driver.findElement(By.xpath("//h2[text()='SQL']"));
							actions.clickAndHold(joinsTopic).release(sqlTextField).perform();
							actions.clickAndHold(normalizationTopic).release(sqlTextField).perform();

							WebElement oopsTopic = driver.findElement(By.xpath("//a[text()='OOPS']"));
							WebElement stringTopic = driver.findElement(By.xpath("//a[text()='Collection']"));
							WebElement javaTextField = driver.findElement(By.xpath("//h2[text()='Java']"));
							actions.clickAndHold(oopsTopic).release(javaTextField).perform();
							actions.clickAndHold(stringTopic).release(javaTextField).perform();
							System.out.println("Click and Hold Successfully Performed");

							// Clicking On Menu Icon and Logout Link ->
							driver.findElement(By.xpath("//div[@data-testid='header-member-menu-avatar']//span"))
									.click();
							WebElement logoutLink = driver.findElement(By.xpath("//span[text()='Log out']"));
							actions.moveToElement(logoutLink).click().perform();

							// V&V Logout page and Logging out ->
							wait.until(ExpectedConditions
									.titleIs("Log out of your Atlassian account - Log in with Atlassian account"));
							String logoutPageActualTitle = driver.getTitle();
							String logoutPageExpectedTitle = "Log out of your Atlassian account - Log in with Atlassian account";
							if (actualBoardsPageTitle.equals(expectedBoardsPageTitle)) {
								WebElement logoutButton = driver.findElement(By.xpath("//button[@type='submit']"));
								logoutButton.submit();

								// V&V Trello HomePage ->
								wait.until(ExpectedConditions
										.titleIs("Manage Your Team’s Projects From Anywhere | Trello"));
								String actualHomepageTitle = driver.getTitle();
								String expectedHomepageTitle = "Manage Your Team’s Projects From Anywhere | Trello";
								if (actualHomepageTitle.equals(expectedHomepageTitle)) {
									System.out.println("Scenario sucessfully executed");
								} else {
									System.out.println("Scenario execution failed");
								}
							} else {
								System.out
										.println("logoutPageActualTitle is not matching with logoutPageExpectedTitle");
							}
						} else {
							System.out.println("actualChosenTitle is not matching with expectedChosenTitle");
						}
					} else {
						System.out.println("createButton is disabled");
					}
				} else {
					System.out.println("actualBoardsPageTitle is not matching with expectedBoardsPageTitle");
				}
			} else {
				System.out.println("loginPageActualTitle is not matching with loginPageExpectedTitle");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
