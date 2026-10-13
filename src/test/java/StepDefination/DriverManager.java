package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class DriverManager {

	private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

	private DriverManager() {
	}

	public static WebDriver start() {
		boolean headless = Boolean.parseBoolean(Config.get("headless"));
		WebDriver driver = create(Config.get("browser"), headless);
		if (!headless) {
			driver.manage().window().maximize();
		}
		DRIVER.set(driver);
		return driver;
	}

	private static WebDriver create(String browser, boolean headless) {
		switch (browser.toLowerCase()) {
			case "firefox": {
				FirefoxOptions options = new FirefoxOptions();
				if (headless) {
					options.addArguments("-headless", "--width=1920", "--height=1080");
				}
				return new FirefoxDriver(options);
			}
			case "edge": {
				EdgeOptions options = new EdgeOptions();
				if (headless) {
					options.addArguments("--headless=new", "--window-size=1920,1080");
				}
				return new EdgeDriver(options);
			}
			case "chrome": {
				ChromeOptions options = new ChromeOptions();
				if (headless) {
					options.addArguments("--headless=new", "--window-size=1920,1080");
				}
				return new ChromeDriver(options);
			}
			default:
				throw new IllegalArgumentException("Unknown browser '" + browser + "', expected chrome, firefox or edge");
		}
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
