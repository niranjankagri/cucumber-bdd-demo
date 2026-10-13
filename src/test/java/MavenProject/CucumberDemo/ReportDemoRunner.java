package MavenProject.CucumberDemo;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/MavenProject/CucumberDemo/ReportDemo.feature"}, glue = {"StepDefination"},
		plugin = {"pretty", "html:target/cucumber-reports/report-demo.html", "json:target/cucumber-reports/report-demo.json"},
		monochrome = true
		)
public class ReportDemoRunner {
}
