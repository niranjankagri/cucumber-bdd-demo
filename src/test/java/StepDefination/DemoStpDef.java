package StepDefination;

import org.opentest4j.TestAbortedException;

import io.cucumber.java.en.Given;

/**
 * Step used only by ReportDemo.feature, to show a skipped scenario in the report.
 */
public class DemoStpDef {

	/**
	 * On the JUnit Platform, a TestAbortedException marks the scenario as skipped
	 * (not failed); its message is the reason shown in the report.
	 */
	@Given("this scenario is skipped on purpose")
	public void this_scenario_is_skipped_on_purpose() {
		throw new TestAbortedException("Skipped on purpose to show a skipped scenario in the report");
	}
}
