package MavenProject.CucumberDemo;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/test/java/MavenProject/CucumberDemo/cucumber.feature"}, glue = {"StepDefination"},
		plugin = {"pretty", "html:target/cucumber-reports/practice-site-login.html", "json:target/cucumber-reports/practice-site-login.json"},
		monochrome = true
		)

public class TestRunner {
}
