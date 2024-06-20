package com.example.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardsPage {

	WebDriver driver;

	public TrelloBoardsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Create new board']")
	WebElement createNewBoardOption;

	@FindBy(xpath = "//input[@type='text']")
	WebElement boardTitleTextField;

	@FindBy(xpath = "//button[text()='Create']")
	WebElement createOption;

	@FindBy(xpath = "//div[@data-testid='header-member-menu-avatar']//span")
	WebElement menuIcon;

	@FindBy(xpath = "//span[text()='Log out']")
	WebElement logoutLink;

	public WebElement getCreateNewBoardOption() {
		return createNewBoardOption;
	}

	public WebElement getBoardTitleTextField() {
		return boardTitleTextField;
	}

	public WebElement getCreateOption() {
		return createOption;
	}

	public WebElement getMenuIcon() {
		return menuIcon;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

}
