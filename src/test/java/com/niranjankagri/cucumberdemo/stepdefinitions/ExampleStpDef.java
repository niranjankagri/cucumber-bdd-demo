package com.niranjankagri.cucumberdemo.stepdefinitions;

import org.openqa.selenium.TimeoutException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.niranjankagri.cucumberdemo.pages.SauceDemoLoginPage;
import com.niranjankagri.cucumberdemo.utils.DriverManager;

/**
 * Steps of features/Example.feature: the Sauce Demo login, run once per row of its
 * Examples table (four demo users, each with the result the page must show).
 * Locators and page actions are in {@link SauceDemoLoginPage}.
 */
public class ExampleStpDef {

	// Page object of the Sauce Demo login; it uses the browser of the running scenario
	private final SauceDemoLoginPage loginPage = new SauceDemoLoginPage();

	/** Starts the browser from config.properties; the @After hook closes it. */
	@Given("Open browser window")
	public void open_the_browser_window() {
		DriverManager.start();
	}

	/** Opens the Sauce Demo login page. */
	@When("Enter url of website")
	public void enter_the_url_of_website() {
		loginPage.open();
	}

	/**
	 * Types user name and password from the Examples row. Regular expression step
	 * (it ends with $), so the two (.*) groups become the parameters.
	 */
	@When("User enter (.*) and (.*)$")
	public void login_page(String uname, String pwd) {
		loginPage.enterCredentials(uname, pwd);
	}

	/** Submits the login form. */
	@Then("click on login button")
	public void click_on_login_button() {
		loginPage.clickLogin();
	}

	/**
	 * Checks that the page shows the expected text: "Products" after a successful login,
	 * the error message for a refused user.
	 */
	@Then("the page shows {string}")
	public void the_page_shows(String expected) {
		try {
			loginPage.waitForText(expected);
		} catch (TimeoutException e) {
			// Report what the page shows instead, so the failure explains itself
			throw new AssertionError("Expected the page to show \"" + expected + "\" but it shows:\n"
					+ loginPage.pageText());
		}
	}
}
