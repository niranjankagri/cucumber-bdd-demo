package StepDefination;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberStpDef {

	@Given("Open the browser window")
	public void open_the_browser_window() {
		DriverManager.start();
	}

	@When("Enter the url of website")
	public void enter_the_url_of_website() {
		driver().get(Config.get("practiceSiteUrl"));
	}

	@Then("Click on signin button")
	public void click_on_signin_button() {
		driver().findElement(By.linkText("Form Authentication")).click();
	}

	@When("Enter Username")
	public void enter_username() {
		driver().findElement(By.id("username")).sendKeys(Config.get("practiceUser"));
	}

	@When("Enter Password")
	public void enter_password() {
		driver().findElement(By.id("password")).sendKeys(Config.get("practicePassword"));
	}

	@Then("Click on Submit")
	public void click_on_submit() {
		driver().findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Then("The secure area is shown")
	public void the_secure_area_is_shown() {
		String message = driver().findElement(By.id("flash")).getText();
		assertTrue("Unexpected message: " + message, message.contains("You logged into a secure area!"));
		assertTrue("Not on the secure page: " + driver().getCurrentUrl(), driver().getCurrentUrl().endsWith("/secure"));
	}

	private WebDriver driver() {
		return DriverManager.getDriver();
	}
}
