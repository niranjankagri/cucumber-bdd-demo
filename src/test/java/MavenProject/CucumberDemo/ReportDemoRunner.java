package MavenProject.CucumberDemo;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * JUnit 4 runner for ReportDemo.feature (one failure and one skip ON PURPOSE).
 * glue = the package with the step definitions and hooks (StepDefination).
 * Report: target/cucumber-reports/report-demo.html (and .json); "pretty" prints each step.
 * Run alone: mvn test -Dtest=ReportDemoRunner   (excluded from the normal mvn test)
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/MavenProject/CucumberDemo/ReportDemo.feature"}, glue = {"StepDefination"},
		plugin = {"pretty", "html:target/cucumber-reports/report-demo.html", "json:target/cucumber-reports/report-demo.json"},
		monochrome = true
		)
public class ReportDemoRunner {
}
