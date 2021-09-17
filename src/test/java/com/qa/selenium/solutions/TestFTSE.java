package com.qa.selenium.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.pages.ftse.FallersFTSE;
import com.qa.selenium.pages.ftse.HomeFTSE;
import com.qa.selenium.pages.ftse.RisersFTSE;

public class TestFTSE {

	private RemoteWebDriver driver;

	@BeforeEach
	void setup() {
		ChromeOptions opts = new ChromeOptions();
		opts.setHeadless(true);
		this.driver = new ChromeDriver(opts);
		this.driver.manage().window().maximize();
	}

	@Test
	void testRisers() {
		HomeFTSE home = PageFactory.initElements(driver, HomeFTSE.class);
		this.driver.get(HomeFTSE.URL);
		home.acceptCookies();
		home.goToRisers();

		RisersFTSE risers = PageFactory.initElements(driver, RisersFTSE.class);
		assertEquals("International Consolidated Airlines Group SA", risers.getTopRiser());
	}

	@Test
	void testFallers() {
		HomeFTSE home = PageFactory.initElements(driver, HomeFTSE.class);
		this.driver.get(HomeFTSE.URL);
		home.acceptCookies();
		home.goToFallers();

		FallersFTSE fallers = PageFactory.initElements(driver, FallersFTSE.class);
		assertEquals("Anglo American", fallers.getTopFaller());
	}

	@AfterEach
	void tearDown() {
		this.driver.close();
	}
}
