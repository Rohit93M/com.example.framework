package com.example.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationFormExample {

	WebDriver driver;

	public RegistrationFormExample(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "userid")
	WebElement userID;

	public WebElement getUserID() {
		return userID;
	}

	@FindBy(name = "passid")
	WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(name = "username")
	WebElement name;

	public WebElement getName() {
		return name;
	}

	@FindBy(name = "address")
	WebElement address;

	public WebElement getAddress() {
		return address;
	}

	@FindBy(name = "country")
	WebElement country;

	public WebElement getCountry() {
		return country;
	}

	@FindBy(name = "zip")
	WebElement zipCode;

	public WebElement getZipCode() {
		return zipCode;
	}

	@FindBy(name = "email")
	WebElement email;

	public WebElement getEmail() {
		return email;
	}

	@FindBy(name = "msex")
	WebElement sex;

	public WebElement getSex() {
		return sex;
	}

	@FindBy(name = "en")
	WebElement language;

	public WebElement getLanguage() {
		return language;
	}

	@FindBy(id = "desc")
	WebElement about;

	public WebElement getAbout() {
		return about;
	}

	@FindBy(name = "submit")
	WebElement submit;

	public WebElement getSubmit() {
		return submit;
	}

}
