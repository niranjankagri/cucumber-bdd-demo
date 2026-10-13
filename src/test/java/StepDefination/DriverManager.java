package StepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Holds the browser of the running scenario, so every step class uses the same one.
 * Started by the "Open (the) browser window" steps, closed by Hooks after each scenario.
 */
public final class DriverManager {

	// One browser per thread, so scenarios could later run in parallel
	private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

	// Only static access
	private DriverManager() {
	}

	/**
	 * Starts the browser named in config.properties (browser, headless).
	 *
	 * @return WebDriver the started browser
	 */
	public static WebDriver start() {
		boolean headless = Boolean.parseBoolean(Config.get("headless"));
		WebDriver driver = create(Config.get("browser"), headless);
		// A headless window already has its size; maximize() would shrink it
		if (!headless) {
			driver.manage().window().maximize();
		}
		DRIVER.set(driver);
		return driver;
	}

	/**
	 * Selenium Manager downloads the matching driver, so only the browser has to be installed.
	 *
	 * @param browser  chrome, firefox or edge
	 * @param headless true to run without a window, at 1920x1080
	 */
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

	/**
	 * @return WebDriver the browser of this scenario, or null before "Open browser window"
	 */
	public static WebDriver getDriver() {
		return DRIVER.get();
	}

	/**
	 * Waits until the element is visible (up to waitSeconds from config.properties) and
	 * returns it. Steps use this instead of findElement, so a slow page does not fail them.
	 *
	 * @param locator the element
	 * @return WebElement the visible element
	 */
	public static WebElement waitFor(By locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Long.parseLong(Config.get("waitSeconds"))));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/** Closes the browser, if one is open. */
	public static void quit() {
		WebDriver driver = DRIVER.get();
		if (driver != null) {
			driver.quit();
			DRIVER.remove();
		}
	}
}
