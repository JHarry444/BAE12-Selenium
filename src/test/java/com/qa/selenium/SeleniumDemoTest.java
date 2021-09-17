package com.qa.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.selenium.pages.DemoQaPage;

class SeleniumDemoTest {

	private RemoteWebDriver driver;

	private WebDriverWait wait;

	@BeforeEach
	void setup() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
//		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		whenever it tries to find an element - keep trying for 5 secs
		this.wait = new WebDriverWait(driver, 5);
	}

	@Test
	void demoTest() {
		this.driver.get("https://www.bbc.co.uk/search");

		WebElement searchBar = this.driver.findElementByCssSelector("#search-input");
		searchBar.sendKeys("Turtles");
//		searchBar.sendKeys(Keys.ENTER);
		WebElement searchButton = this.driver
				.findElementByCssSelector("#main-content > div:nth-child(1) > form > div > div > div > button");
		searchButton.click();

		WebElement searchResult = this.driver.findElementByCssSelector(
				"#main-content > div:nth-child(1) > div.ssrcss-1v7bxtk-StyledContainer.enjd40x0 > div > div > ul > li:nth-child(1) > div > div > div.ssrcss-som5se-PromoContent.e1f5wbog7 > div.ssrcss-1cbga70-Stack.e1y4nx260 > a > span > p > span");

		assertEquals("Andy's Aquatic Adventures: Series 1: Andy and the Hawksbill Turtles", searchResult.getText());
//		searchResult.getAttribute("value");
//		get text works on pretty much everything EXCEPT inputs for those use the example above as reference
	}

	@Test
	void testWait() {
		this.driver.get("https://christophperrins.github.io/TestingSite/");

		this.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#quote > h1")));

		WebElement surprise = this.driver.findElementByCssSelector("#quote > h1");

		assertEquals("Surprise!", surprise.getText());
	}

	@Test
	void testTextBoxPOM() {
		final String testName = "JH";
		final String testEmail = "J@H.com";
		final String testAddress = "The cool side of the pillow";

		this.driver.get(DemoQaPage.URL);

		DemoQaPage page = PageFactory.initElements(driver, DemoQaPage.class);

		page.submitForm(testName, testEmail, testAddress);

		assertEquals("Name:" + testName, page.getName());

		assertEquals("Email:" + testEmail, page.getEmail());

		assertEquals("Current Address :" + testAddress, page.getCurrentAddress());

		assertEquals("Permananet Address :" + testAddress, page.getPermanentAddress());

	}

	@AfterEach
	void tearDown() {
		this.driver.close();
	}
}
