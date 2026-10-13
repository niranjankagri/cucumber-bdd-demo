package StepDefination;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Steps of cucumber.feature: sign in on the-internet.herokuapp.com, a public practice
 * site whose login page publishes its own test user (tomsmith / SuperSecretPassword!).
 * URL and login come from config.properties. (Until 2026 this scenario signed in to
 * amazon.in, which blocks automated logins.)
 */
public class CucumberStpDef {

	/** Starts the browser from config.properties; the @After hook closes it. */
	@Given("Open the browser window")
	public void open_the_browser_window() {
		DriverManager.start();
	}

	/** Opens the practice site's home page (practiceSiteUrl). */
	@When("Enter the url of website")
	public void enter_the_url_of_website() {
		driver().get(Config.get("practiceSiteUrl"));
	}

	/** Opens the login page through its link on the home page. */
	@Then("Click on signin button")
	public void click_on_signin_button() {
		DriverManager.waitFor(By.linkText("Form Authentication")).click();
	}

	/** Types the test user (practiceUser). */
	@When("Enter Username")
	public void enter_username() {
		DriverManager.waitFor(By.id("username")).sendKeys(Config.get("practiceUser"));
	}

	/** Types the test password (practicePassword). */
	@When("Enter Password")
	public void enter_password() {
		DriverManager.waitFor(By.id("password")).sendKeys(Config.get("practicePassword"));
	}

	/** Submits the login form. */
	@Then("Click on Submit")
	public void click_on_submit() {
		DriverManager.waitFor(By.cssSelector("button[type='submit']")).click();
	}

	/** The login worked: success message shown and the browser is on /secure. */
	@Then("The secure area is shown")
	public void the_secure_area_is_shown() {
		String message = DriverManager.waitFor(By.id("flash")).getText();
		assertTrue("Unexpected message: " + message, message.contains("You logged into a secure area!"));
		assertTrue("Not on the secure page: " + driver().getCurrentUrl(), driver().getCurrentUrl().endsWith("/secure"));
	}

	// The browser of the running scenario, shared with the other step classes
	private WebDriver driver() {
		return DriverManager.getDriver();
	}
}
