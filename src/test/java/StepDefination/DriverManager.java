package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class DriverManager {

	private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

	private DriverManager() {
	}

	public static WebDriver start() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		DRIVER.set(driver);
		return driver;
	}

	public static WebDriver getDriver() {
		return DRIVER.get();
	}

	public static void quit() {
		WebDriver driver = DRIVER.get();
		if (driver != null) {
			driver.quit();
			DRIVER.remove();
		}
	}
}
