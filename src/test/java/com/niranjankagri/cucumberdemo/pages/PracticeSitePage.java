package com.niranjankagri.cucumberdemo.pages;

import org.openqa.selenium.By;

import com.niranjankagri.cucumberdemo.utils.Config;
import com.niranjankagri.cucumberdemo.utils.DriverManager;

/**
 * Page object of the practice site the-internet.herokuapp.com: its home page, the
 * "Form Authentication" login page and the secure area behind it.
 *
 * Holds the locators and page actions; the step definitions (CucumberStpDef) only call
 * these methods and keep the assertions. Every lookup waits until the element is
 * visible (DriverManager.waitFor), so a slow page does not fail a step.
 */
public class PracticeSitePage {

	// Locators
	private static final By LOGIN_LINK = By.linkText("Form Authentication");
	private static final By USERNAME = By.id("username");
	private static final By PASSWORD = By.id("password");
	private static final By SUBMIT = By.cssSelector("button[type='submit']");
	// Message box shown after a login attempt (success or error)
	private static final By FLASH = By.id("flash");

	/** Opens the home page (practiceSiteUrl from config.properties). */
	public void open() {
		DriverManager.getDriver().get(Config.get("practiceSiteUrl"));
	}

	/** Opens the login page through its link on the home page. */
	public void openLoginPage() {
		DriverManager.waitFor(LOGIN_LINK).click();
	}

	/**
	 * @param username user name to type into the login form
	 */
	public void enterUsername(String username) {
		DriverManager.waitFor(USERNAME).sendKeys(username);
	}

	/**
	 * @param password password to type into the login form
	 */
	public void enterPassword(String password) {
		DriverManager.waitFor(PASSWORD).sendKeys(password);
	}

	/** Submits the login form. */
	public void submit() {
		DriverManager.waitFor(SUBMIT).click();
	}

	/**
	 * @return String the text of the message box after a login attempt
	 */
	public String flashMessage() {
		return DriverManager.waitFor(FLASH).getText();
	}

	/**
	 * @return String the URL the browser shows now (/secure after a successful login)
	 */
	public String currentUrl() {
		return DriverManager.getDriver().getCurrentUrl();
	}
}
