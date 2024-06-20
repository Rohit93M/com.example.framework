package com.example.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbLoginConfirmPage {

	WebDriver driver;

	public FbLoginConfirmPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(@href,'https://www.facebook.com/recover')]")
	private WebElement forgottenPwdLink;

	public WebElement getForgottenPwdLink() {
		return forgottenPwdLink;
	}
}
