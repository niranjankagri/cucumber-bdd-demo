package MavenProject.CucumberDemo;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * JUnit 4 runner for Example.feature (Sauce Demo login outline, 4 users).
 * glue = the package with the step definitions and hooks (StepDefination).
 * Report: target/cucumber-reports/sauce-demo-login.html (and .json); "pretty" prints each step.
 * Run alone: mvn test -Dtest=ExampleRunner
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/test/java/MavenProject/CucumberDemo/Example.feature"}, glue = {"StepDefination"},
		plugin = {"pretty", "html:target/cucumber-reports/sauce-demo-login.html", "json:target/cucumber-reports/sauce-demo-login.json"},
		monochrome = true
		)


public class ExampleRunner {

}
