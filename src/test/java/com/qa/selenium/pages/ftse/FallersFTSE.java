package com.qa.selenium.pages.ftse;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FallersFTSE {

	@FindBy(css = "#ls-row-AAL-L > td.name-col.align-left > a")
	private WebElement topFallers;

	public String getTopFaller() {
		return this.topFallers.getText();
	}

}
