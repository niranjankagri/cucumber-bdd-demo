package StepDefination;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

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
