package com.niranjankagri.cucumberdemo.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import com.niranjankagri.cucumberdemo.utils.DriverManager;

/**
 * Cucumber hooks, found through the runners' glue (this package is part of it).
 */
public class Hooks {

	/**
	 * Runs after every scenario, passed or failed: attaches a screenshot to the report
	 * when the scenario failed, then closes the browser.
	 */
	@After
	public void afterScenario(Scenario scenario) {
		WebDriver driver = DriverManager.getDriver();
		if (driver != null && scenario.isFailed()) {
			byte[] png = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(png, "image/png", scenario.getName());
		}
		DriverManager.quit();
	}
}
