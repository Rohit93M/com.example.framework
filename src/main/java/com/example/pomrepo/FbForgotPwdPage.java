package com.example.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FbForgotPwdPage {
	WebDriver driver;

	public FbForgotPwdPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	@FindBy(id = "identify_email")
	private WebElement emailOrPhoneField;

	@FindBy(name = "did_submit")
	private WebElement searchButton;

	// Getters for elements
	public WebElement getEmailOrPhoneField() {
		return emailOrPhoneField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
}
