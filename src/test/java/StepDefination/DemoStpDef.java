package StepDefination;

import org.junit.AssumptionViolatedException;

import io.cucumber.java.en.Given;

public class DemoStpDef {

	@Given("this scenario is skipped on purpose")
	public void this_scenario_is_skipped_on_purpose() {
		throw new AssumptionViolatedException("Skipped on purpose to show a skipped scenario in the report");
	}
}
