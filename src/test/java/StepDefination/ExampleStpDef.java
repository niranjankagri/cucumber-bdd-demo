package StepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Steps of Example.feature: the Sauce Demo login, run once per row of its Examples
 * table (four demo users, each with the result the page must show).
 */
public class ExampleStpDef {

	/** Starts the browser from config.properties; the @After hook closes it. */
	@Given("Open browser window")
	public void open_the_browser_window() {
		DriverManager.start();
	}

	/** Opens the Sauce Demo login page (sauceDemoUrl). */
	@When("Enter url of website")
	public void enter_the_url_of_website() {
		driver().get(Config.get("sauceDemoUrl"));
	}

	/**
	 * Types user name and password from the Examples row. Regular expression step
	 * (it ends with $), so the two (.*) groups become the parameters.
	 */
	@When("User enter (.*) and (.*)$")
	public void login_page(String uname, String pwd) {
		driver().findElement(By.id("user-name")).sendKeys(uname);
		driver().findElement(By.id("password")).sendKeys(pwd);
	}

	/** Submits the login form. */
	@Then("click on login button")
	public void click_on_login_button() {
		driver().findElement(By.id("login-button")).click();
	}

	/**
	 * Waits until the page contains the expected text: "Products" after a successful
	 * login, the error message for a refused user. performance_glitch_user is slow on
	 * purpose, hence the wait (waitSeconds from config.properties).
	 */
	@Then("the page shows {string}")
	public void the_page_shows(String expected) {
		WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(Long.parseLong(Config.get("waitSeconds"))));
		try {
			wait.until(d -> d.findElement(By.tagName("body")).getText().contains(expected));
		} catch (TimeoutException e) {
			// Report what the page shows instead, so the failure explains itself
			throw new AssertionError("Expected the page to show \"" + expected + "\" but it shows:\n"
					+ driver().findElement(By.tagName("body")).getText());
		}
	}

	// The browser of the running scenario, shared with the other step classes
	private WebDriver driver() {
		return DriverManager.getDriver();
	}
}
