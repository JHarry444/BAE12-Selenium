package com.qa.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// page object model -
public class DemoQaPage {

	public static final String URL = "https://demoqa.com/text-box";

	@FindBy(id = "userName")
	private WebElement nameField;

	@FindBy(id = "userEmail")
	private WebElement emailField;

	@FindBy(id = "currentAddress")
	private WebElement currentAddress;

	@FindBy(id = "permanentAddress")
	private WebElement permAddress;

	@FindBy(id = "close-fixedban")
	private WebElement closeAd;

	@FindBy(id = "submit")
	private WebElement submit;

	public void submitForm(String name, String email, String address) {
		nameField.sendKeys(name);
		emailField.sendKeys(email);
		currentAddress.sendKeys(address);
		permAddress.sendKeys(address);
		closeAd.click();
		submit.click();
	}

	@FindBy(id = "name")
	private WebElement name;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(css = "div#output p#currentAddress")
	private WebElement currAddresssOut;

	@FindBy(css = "div#output p#permanentAddress")
	private WebElement permAddressOut;

	public String getName() {
		return this.name.getText();
	}

	public String getEmail() {
		return this.email.getText();
	}

	public String getCurrentAddress() {
		return this.currAddresssOut.getText();
	}

	public String getPermanentAddress() {
		return this.permAddressOut.getText();
	}

}
