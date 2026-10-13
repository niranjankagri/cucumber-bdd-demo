package MavenProject.CucumberDemo;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/test/java/MavenProject.CucumberDemo/Example.feature"}, glue = {"StepDefination"}
		)


public class ExampleRunner {

}
