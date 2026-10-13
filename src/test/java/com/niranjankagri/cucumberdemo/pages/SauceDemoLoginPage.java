package com.niranjankagri.cucumberdemo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.niranjankagri.cucumberdemo.utils.Config;
import com.niranjankagri.cucumberdemo.utils.DriverManager;

/**
 * Page object of the Sauce Demo login page (saucedemo.com) and what the browser shows
 * after a login attempt.
 *
 * Holds the locators and page actions; the step definitions (ExampleStpDef) only call
 * these methods and keep the assertions.
 */
public class SauceDemoLoginPage {

	// Locators
	private static final By USERNAME = By.id("user-name");
	private static final By PASSWORD = By.id("password");
	private static final By LOGIN_BUTTON = By.id("login-button");
	// The whole page, to check which text it shows after the login
	private static final By BODY = By.tagName("body");

	/** Opens the login page (sauceDemoUrl from config.properties). */
	public void open() {
		DriverManager.getDriver().get(Config.get("sauceDemoUrl"));
	}

	/**
	 * Types a user name and password into the login form.
	 *
	 * @param username a Sauce Demo user, e.g. standard_user
	 * @param password its password
	 */
	public void enterCredentials(String username, String password) {
		DriverManager.waitFor(USERNAME).sendKeys(username);
		DriverManager.waitFor(PASSWORD).sendKeys(password);
	}

	/** Submits the login form. */
	public void clickLogin() {
		DriverManager.waitFor(LOGIN_BUTTON).click();
	}

	/**
	 * Waits until the page contains the text, up to waitSeconds from config.properties
	 * (performance_glitch_user is slow on purpose).
	 *
	 * @param expected text the page must show
	 * @throws org.openqa.selenium.TimeoutException when the text does not appear in time
	 */
	public void waitForText(String expected) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
				Duration.ofSeconds(Long.parseLong(Config.get("waitSeconds"))));
		wait.until(d -> d.findElement(BODY).getText().contains(expected));
	}

	/**
	 * @return String all text the page shows now, for a clear failure message
	 */
	public String pageText() {
		return DriverManager.getDriver().findElement(BODY).getText();
	}
}
