package MavenProject.CucumberDemo;

import static io.cucumber.junit.platform.engine.Constants.ANSI_COLORS_DISABLED_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectFile;
import org.junit.platform.suite.api.Suite;

/**
 * JUnit Platform suite for Example.feature (Sauce Demo login outline, 4 users).
 * The Cucumber engine runs the selected feature file, with the step definitions and
 * hooks from the glue package (StepDefination).
 * Report: target/cucumber-reports/sauce-demo-login.html (and .json); "pretty" prints each step.
 * Run alone: mvn test -Dtest=ExampleRunner
 */
@Suite
@IncludeEngines("cucumber")
@SelectFile("src/test/java/MavenProject/CucumberDemo/Example.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "StepDefination")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
		value = "pretty, html:target/cucumber-reports/sauce-demo-login.html, json:target/cucumber-reports/sauce-demo-login.json")
@ConfigurationParameter(key = ANSI_COLORS_DISABLED_PROPERTY_NAME, value = "true")
public class ExampleRunner {
}
