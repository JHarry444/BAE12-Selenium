package com.qa.selenium.pages.ftse;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeFTSE {

	public static String URL = "https://www.hl.co.uk/shares/stock-market-summary/ftse-100";

	@FindBy(id = "acceptCookieButton")
	private WebElement cookies;

	@FindBy(css = "#view-constituents > ul > li:nth-child(2) > a")
	private WebElement risers;

	@FindBy(css = "#view-constituents > ul > li:nth-child(3) > a")
	private WebElement fallers;

	public void acceptCookies() {
		this.cookies.click();
	}

	public void goToRisers() {
		this.risers.click();
	}

	public void goToFallers() {
		this.fallers.click();
	}
}
