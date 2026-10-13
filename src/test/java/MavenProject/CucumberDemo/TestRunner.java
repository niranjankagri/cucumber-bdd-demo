package MavenProject.CucumberDemo;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/test/java/MavenProject/CucumberDemo/cucumber.feature"}, glue = {"StepDefination"}
		)

public class TestRunner {
}
