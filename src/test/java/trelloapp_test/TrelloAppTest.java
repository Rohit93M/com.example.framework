package trelloapp_test;

import java.io.IOException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.interactions.Actions;
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
	            Assert.assertEquals(driver.getTitle(), "Boards | Trello", "Boards page title does not match");

	            webdriverUtils.waitTillElementToBeClickable(driver, boardsPage.getCreateNewBoardOption());
	            boardsPage.getCreateNewBoardOption().click();

	            webdriverUtils.waitTillElementToBeVisible(driver, boardsPage.getBoardTitleTextField());
	            boardsPage.getBoardTitleTextField().sendKeys("Selenium");
	            Assert.assertTrue(boardsPage.getCreateOption().isEnabled(), "Create Option is disabled");

	            webdriverUtils.waitTillElementToBeClickable(driver, boardsPage.getCreateOption());
	            boardsPage.getCreateOption().click();

	            webdriverUtils.waitForATitle(driver, "Selenium | Trello");
	            Assert.assertEquals(driver.getTitle(), "Selenium | Trello", "Topic page title does not match");

	         // Creating lists
	            webdriverUtils.waitTillElementToBeVisible(driver, topicPage.getListNameTextarea1());
	            topicPage.getListNameTextarea1().sendKeys("Topics");
	            topicPage.getSubmitButton().click();

	            webdriverUtils.waitTillElementToBeVisible(driver, topicPage.getListNameTextarea2());
	            topicPage.getListNameTextarea2().sendKeys("Manual");
	            topicPage.getSubmitButton().click();

	            webdriverUtils.waitTillElementToBeVisible(driver, topicPage.getListNameTextarea3());
	            topicPage.getListNameTextarea3().sendKeys("SQL");
	            topicPage.getSubmitButton().click();

	            webdriverUtils.waitTillElementToBeVisible(driver, topicPage.getListNameTextarea4());
	            topicPage.getListNameTextarea4().sendKeys("Java");
	            topicPage.getSubmitButton().click();

	            webdriverUtils.waitTillElementToBeClickable(driver, topicPage.getCloseIcon());
	            topicPage.getCloseIcon().click();

	            // Adding cards
	            webdriverUtils.waitTillElementToBeClickable(driver, topicPage.getAddCardButton());
	            topicPage.getAddCardButton().click();

	            webdriverUtils.waitTillElementToBeVisible(driver, topicPage.getCardTitleTextarea());
	            topicPage.getCardTitleTextarea().sendKeys("Test Cases");
	            topicPage.getAddCardSubmitButton().click();

	            topicPage.getAddCardButton().click();
	            topicPage.getCardTitleTextarea().sendKeys("Agile Methodology");
	            topicPage.getAddCardSubmitButton().click();

	            topicPage.getAddCardButton().click();
	            topicPage.getCardTitleTextarea().sendKeys("Joins");
	            topicPage.getAddCardSubmitButton().click();

	            topicPage.getAddCardButton().click();
	            topicPage.getCardTitleTextarea().sendKeys("Normalization");
	            topicPage.getAddCardSubmitButton().click();

	            topicPage.getAddCardButton().click();
	            topicPage.getCardTitleTextarea().sendKeys("OOPS");
	            topicPage.getAddCardSubmitButton().click();

	            topicPage.getAddCardButton().click();
	            topicPage.getCardTitleTextarea().sendKeys("Collection");
	            topicPage.getAddCardSubmitButton().click();

	            webdriverUtils.waitTillElementToBeClickable(driver, topicPage.getCloseIcon());
	            topicPage.getCloseIcon().click();

	            // Perform click and hold actions
	            Actions actions = new Actions(driver);

	            webdriverUtils.waitTillElementToBeClickable(driver, topicPage.getTestCaseTopic());
	            webdriverUtils.waitTillElementToBeClickable(driver, topicPage.getManualTextField());
	            actions.clickAndHold(topicPage.getTestCaseTopic()).moveToElement(topicPage.getManualTextField()).release().perform();

	            webdriverUtils.waitTillElementToBeClickable(driver, topicPage.getAgileTopic());
	            actions.clickAndHold(topicPage.getAgileTopic()).moveToElement(topicPage.getManualTextField()).release().perform();

	            webdriverUtils.waitTillElementToBeClickable(driver, topicPage.getJoinsTopic());
	            webdriverUtils.waitTillElementToBeClickable(driver, topicPage.getSqlTextField());
	            actions.clickAndHold(topicPage.getJoinsTopic()).moveToElement(topicPage.getSqlTextField()).release().perform();

	            webdriverUtils.waitTillElementToBeClickable(driver, topicPage.getNormalizationTopic());
	            actions.clickAndHold(topicPage.getNormalizationTopic()).moveToElement(topicPage.getSqlTextField()).release().perform();

	            webdriverUtils.waitTillElementToBeClickable(driver, topicPage.getOopsTopic());
	            webdriverUtils.waitTillElementToBeClickable(driver, topicPage.getJavaTextField());
	            actions.clickAndHold(topicPage.getOopsTopic()).moveToElement(topicPage.getJavaTextField()).release().perform();

	            webdriverUtils.waitTillElementToBeClickable(driver, topicPage.getCollectionTopic());
	            actions.clickAndHold(topicPage.getCollectionTopic()).moveToElement(topicPage.getJavaTextField()).release().perform();

	            System.out.println("Click and Hold Successfully Performed");

	            // Log out
	            webdriverUtils.waitTillElementToBeClickable(driver, boardsPage.getMenuIcon());
	            boardsPage.getMenuIcon().click();

	            webdriverUtils.waitTillElementToBeClickable(driver, boardsPage.getLogoutLink());
	            boardsPage.getLogoutLink().click();

	            webdriverUtils.waitForATitle(driver, "Log out of your Atlassian account - Log in with Atlassian account");
	            Assert.assertEquals(driver.getTitle(), "Log out of your Atlassian account - Log in with Atlassian account",
	                    "Logout page title does not match");

	            webdriverUtils.waitTillElementToBeClickable(driver, logoutPage.getLogoutButton());
	            logoutPage.getLogoutButton().click();

	            webdriverUtils.waitForATitle(driver, "Manage Your Team’s Projects From Anywhere | Trello");
	            Assert.assertEquals(driver.getTitle(), "Manage Your Team’s Projects From Anywhere | Trello",
	                    "Welcome page title does not match");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
