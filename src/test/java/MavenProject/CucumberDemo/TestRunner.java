package MavenProject.CucumberDemo;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * JUnit 4 runner for cucumber.feature (practice-site login).
 * glue = the package with the step definitions and hooks (StepDefination).
 * Report: target/cucumber-reports/practice-site-login.html (and .json); "pretty" prints each step.
 * Run alone: mvn test -Dtest=TestRunner
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/test/java/MavenProject/CucumberDemo/cucumber.feature"}, glue = {"StepDefination"},
		plugin = {"pretty", "html:target/cucumber-reports/practice-site-login.html", "json:target/cucumber-reports/practice-site-login.json"},
		monochrome = true
		)

public class TestRunner {
}
