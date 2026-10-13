package MavenProject.CucumberDemo;

import static io.cucumber.junit.platform.engine.Constants.ANSI_COLORS_DISABLED_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

/**
 * JUnit Platform suite for ReportDemo.feature (one failure and one skip on purpose).
 * The Cucumber engine runs the feature file from src/test/resources/features, with the step definitions and
 * hooks from the glue package (StepDefination).
 * Report: target/cucumber-reports/report-demo.html (and .json); "pretty" prints each step.
 * Run alone: mvn test -Dtest=ReportDemoRunner (excluded from the normal mvn test)
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/ReportDemo.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "StepDefination")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
		value = "pretty, html:target/cucumber-reports/report-demo.html, json:target/cucumber-reports/report-demo.json")
@ConfigurationParameter(key = ANSI_COLORS_DISABLED_PROPERTY_NAME, value = "true")
public class ReportDemoRunner {
}
