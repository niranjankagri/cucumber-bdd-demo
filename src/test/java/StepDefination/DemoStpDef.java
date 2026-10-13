package StepDefination;

import org.junit.AssumptionViolatedException;

import io.cucumber.java.en.Given;

/**
 * Step used only by ReportDemo.feature, to show a skipped scenario in the report.
 */
public class DemoStpDef {

	/**
	 * With the JUnit 4 runner, an AssumptionViolatedException marks the scenario as
	 * skipped (not failed); its message is the reason shown in the report.
	 */
	@Given("this scenario is skipped on purpose")
	public void this_scenario_is_skipped_on_purpose() {
		throw new AssumptionViolatedException("Skipped on purpose to show a skipped scenario in the report");
	}
}
