package MavenProject.CucumberDemo;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/test/java/MavenProject/CucumberDemo/Example.feature"}, glue = {"StepDefination"},
		plugin = {"pretty", "html:target/cucumber-reports/sauce-demo-login.html", "json:target/cucumber-reports/sauce-demo-login.json"},
		monochrome = true
		)


public class ExampleRunner {

}
