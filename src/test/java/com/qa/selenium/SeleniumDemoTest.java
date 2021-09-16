package com.qa.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumDemoTest {

	private RemoteWebDriver driver;

	@BeforeEach
	void setup() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
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

	@AfterEach
	void tearDown() {
		this.driver.close();
	}
}
