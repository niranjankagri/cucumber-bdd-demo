package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExampleStpDef {
	
	WebDriver driver;
	
	@Given("Open browser window")
	public void open_the_browser_window(){
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
    
 	driver = new ChromeDriver();
 	
 	driver.manage().window().maximize();
	}

	@When("Enter url of website")
	public void enter_the_url_of_website() {
		driver.get("https://www.saucedemo.com/");
	}

	

	@When("User enter (.*) and (.*)$")
	public void login_page(String uname , String pwd) {
		driver.findElement(By.id("user-name")).sendKeys(uname);
	 	driver.findElement(By.id("password")).sendKeys(pwd);
	}

	
	@Then("click on login button")
	public void click_on_login_button() {
		driver.findElement(By.id("login-button")).click();
		driver.close();
	 	
	}
	
}
