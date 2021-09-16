package com.qa.selenium.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DemoQaTest {

	private RemoteWebDriver driver;

	@BeforeEach
	void setup() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}

	@Test
	void testTextBox() {
		this.driver.get("https://demoqa.com/text-box");
		final String testName = "JH";
		final String testEmail = "J@H.com";
		final String address = "The cool side of the pillow";

		WebElement nameField = this.driver.findElementById("userName");
		nameField.sendKeys(testName);
		WebElement emailField = this.driver.findElementById("userEmail");
		emailField.sendKeys(testEmail);
		WebElement currAddress = this.driver.findElementById("currentAddress");
		currAddress.sendKeys(address);
		WebElement permAddress = this.driver.findElementById("permanentAddress");
		permAddress.sendKeys(address);
		WebElement closeAd = this.driver.findElementById("close-fixedban");
		closeAd.click();
//		this.driver.executeScript("window.scrollBy(0, 350)", "");
		WebElement submit = this.driver.findElementById("submit");
		submit.click();

		WebElement nameOutput = this.driver.findElementById("name");
		assertEquals("Name:" + testName, nameOutput.getText());

		WebElement emailOutput = this.driver.findElementById("email");
		assertEquals("Email:" + testEmail, emailOutput.getText());

		WebElement currAddressOut = this.driver.findElementByCssSelector("div#output p#currentAddress");
		assertEquals("Current Address :" + address, currAddressOut.getText());

		WebElement permAddressOut = this.driver.findElementByCssSelector("div#output p#permanentAddress");
		assertEquals("Permananet Address :" + address, permAddressOut.getText());

	}
}
