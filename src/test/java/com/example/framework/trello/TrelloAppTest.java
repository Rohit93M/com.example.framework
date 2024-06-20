package com.example.framework.trello;

import java.io.IOException;

import org.openqa.selenium.ElementNotInteractableException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.genericutility.BaseClass;
import com.example.genericutility.ListenersImplementation;
import com.example.pomrepo.TrelloBoardsPage;
import com.example.pomrepo.TrelloLoginPage;
import com.example.pomrepo.TrelloLogoutPage;
import com.example.pomrepo.TrelloTopicPage;
import com.example.pomrepo.TrelloWelcomePage;

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
            Assert.assertEquals(driver.getTitle(), "Manage Your Team’s Projects From Anywhere | Trello", "Welcome page title does not match");
            
            webdriverUtils.waitTillElementToBeClickable(driver, welcomePage.getLoginLink());
            welcomePage.getLoginLink().click();
            
            webdriverUtils.waitForATitle(driver, "Log in to continue - Log in with Atlassian account");
            Assert.assertEquals(driver.getTitle(), "Log in to continue - Log in with Atlassian account", "Login page title does not match");
            
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
            Assert.assertEquals(driver.getTitle(), "Log out of your Atlassian account - Log in with Atlassian account", " Logout page title does not match");
            
            webdriverUtils.waitTillElementToBeClickable(driver, logoutPage.getLogoutButton());
            logoutPage.getLogoutButton().click();
            
            webdriverUtils.waitForATitle(driver, "Manage Your Team’s Projects From Anywhere | Trello");
            Assert.assertEquals(driver.getTitle(), "Manage Your Team’s Projects From Anywhere | Trello", "Welcome page title does not match");

        } catch (ElementNotInteractableException e) {
            e.printStackTrace();
        }
    }

}
