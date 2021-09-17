package com.qa.selenium.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingTest {

	private RemoteWebDriver driver;

	private WebDriverWait wait;

	@BeforeEach
	void setup() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.wait = new WebDriverWait(driver, 5);
	}

	@Test
	void seeMyVest() {
		this.driver.get("http://automationpractice.com/index.php");

		WebElement dressLink = this.driver.findElementByCssSelector(
				"#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > h5 > a");
		dressLink.click();
		WebElement dressTitle = this.driver
				.findElementByCssSelector("#center_column > div > div > div.pb-center-column.col-xs-12.col-sm-4 > h1");

		assertEquals("Faded Short Sleeve T-shirts", dressTitle.getText());
	}

	@Test
	void buyMyVest() {
		this.driver.get("http://automationpractice.com/index.php");

		WebElement dressLink = this.driver.findElementByCssSelector(
				"#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > h5 > a");
		dressLink.click();

		WebElement addToCart = this.driver.findElementByCssSelector("#add_to_cart > button");
		addToCart.click();

		WebElement proceedToCart = this.driver.findElementByCssSelector(
				"#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");
		this.wait.until(ExpectedConditions.elementToBeClickable(proceedToCart));
		proceedToCart.click();

		WebElement proceedToSignIn = this.driver.findElementByCssSelector(
				"#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium");
		proceedToSignIn.click();

		WebElement email = this.driver.findElementById("email");
		email.sendKeys("J@H.com");

		WebElement passwd = this.driver.findElementById("passwd");
		passwd.sendKeys("password");

		WebElement signIn = this.driver.findElementById("SubmitLogin");
		signIn.click();

		WebElement proceedToShipping = this.driver.findElementByCssSelector("#center_column > form > p > button");
		proceedToShipping.click();

		WebElement terms = this.driver.findElementById("cgv");
		terms.click();

		WebElement proceedToPayment = this.driver.findElementByCssSelector("#form > p > button");
		proceedToPayment.click();

		WebElement selectPayment = this.driver
				.findElementByCssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a");
		selectPayment.click();

		WebElement confirm = this.driver.findElementByCssSelector("#cart_navigation > button");
		confirm.click();

		WebElement result = this.driver.findElementByCssSelector("#center_column > div > p");
		assertEquals("Your order on My Store is complete.", result.getText());
	}
}
