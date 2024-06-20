package com.example.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloVerificationPage {

	WebDriver driver;

	public TrelloVerificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "mfa-promote-dismiss")
	private WebElement skipVerification;

	public WebElement getSkipOpt() {
		return skipVerification;
	}

}
