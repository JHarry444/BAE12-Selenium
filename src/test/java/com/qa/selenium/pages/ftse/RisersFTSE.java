package com.qa.selenium.pages.ftse;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RisersFTSE {

	@FindBy(css = "#ls-row-IAG-L > td.name-col.align-left > a")
	private WebElement topRiser;

	public String getTopRiser() {
		return this.topRiser.getText();
	}
}
