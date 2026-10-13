package StepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExampleStpDef {

	@Given("Open browser window")
	public void open_the_browser_window() {
		DriverManager.start();
	}

	@When("Enter url of website")
	public void enter_the_url_of_website() {
		driver().get(Config.get("sauceDemoUrl"));
	}

	@When("User enter (.*) and (.*)$")
	public void login_page(String uname, String pwd) {
		driver().findElement(By.id("user-name")).sendKeys(uname);
		driver().findElement(By.id("password")).sendKeys(pwd);
	}

	@Then("click on login button")
	public void click_on_login_button() {
		driver().findElement(By.id("login-button")).click();
	}

	@Then("the page shows {string}")
	public void the_page_shows(String expected) {
		WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(Long.parseLong(Config.get("waitSeconds"))));
		try {
			wait.until(d -> d.findElement(By.tagName("body")).getText().contains(expected));
		} catch (TimeoutException e) {
			throw new AssertionError("Expected the page to show \"" + expected + "\" but it shows:\n"
					+ driver().findElement(By.tagName("body")).getText());
		}
	}

	private WebDriver driver() {
		return DriverManager.getDriver();
	}
}
