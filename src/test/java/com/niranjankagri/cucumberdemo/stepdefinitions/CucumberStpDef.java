package com.niranjankagri.cucumberdemo.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.niranjankagri.cucumberdemo.pages.PracticeSitePage;
import com.niranjankagri.cucumberdemo.utils.Config;
import com.niranjankagri.cucumberdemo.utils.DriverManager;

/**
 * Steps of features/cucumber.feature: sign in on the-internet.herokuapp.com, a public
 * practice site whose login page publishes its own test user. URL and login come from
 * config.properties; locators and page actions are in {@link PracticeSitePage}.
 * (Until 2026 this scenario signed in to amazon.in, which blocks automated logins.)
 */
public class CucumberStpDef {

	// Page object of the practice site; it uses the browser of the running scenario
	private final PracticeSitePage practiceSite = new PracticeSitePage();

	/** Starts the browser from config.properties; the @After hook closes it. */
	@Given("Open the browser window")
	public void open_the_browser_window() {
		DriverManager.start();
	}

	/** Opens the practice site's home page. */
	@When("Enter the url of website")
	public void enter_the_url_of_website() {
		practiceSite.open();
	}

	/** Opens the login page through its link on the home page. */
	@Then("Click on signin button")
	public void click_on_signin_button() {
		practiceSite.openLoginPage();
	}

	/** Types the test user (practiceUser from config.properties). */
	@When("Enter Username")
	public void enter_username() {
		practiceSite.enterUsername(Config.get("practiceUser"));
	}

	/** Types the test password (practicePassword from config.properties). */
	@When("Enter Password")
	public void enter_password() {
		practiceSite.enterPassword(Config.get("practicePassword"));
	}

	/** Submits the login form. */
	@Then("Click on Submit")
	public void click_on_submit() {
		practiceSite.submit();
	}

	/** The login worked: success message shown and the browser is on /secure. */
	@Then("The secure area is shown")
	public void the_secure_area_is_shown() {
		String message = practiceSite.flashMessage();
		assertTrue(message.contains("You logged into a secure area!"), "Unexpected message: " + message);
		assertTrue(practiceSite.currentUrl().endsWith("/secure"), "Not on the secure page: " + practiceSite.currentUrl());
	}
}
