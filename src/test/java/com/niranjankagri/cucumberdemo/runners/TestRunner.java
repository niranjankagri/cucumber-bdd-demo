package com.niranjankagri.cucumberdemo.runners;

import static io.cucumber.junit.platform.engine.Constants.ANSI_COLORS_DISABLED_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

/**
 * JUnit Platform suite for cucumber.feature (practice-site login).
 * The Cucumber engine runs the feature file from src/test/resources/features, with the step definitions and
 * hooks from the glue packages (stepdefinitions, hooks).
 * Report: target/cucumber-reports/practice-site-login.html (and .json); "pretty" prints each step.
 * Run alone: mvn test -Dtest=TestRunner
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/cucumber.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.niranjankagri.cucumberdemo.stepdefinitions, com.niranjankagri.cucumberdemo.hooks")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
		value = "pretty, html:target/cucumber-reports/practice-site-login.html, json:target/cucumber-reports/practice-site-login.json")
@ConfigurationParameter(key = ANSI_COLORS_DISABLED_PROPERTY_NAME, value = "true")
public class TestRunner {
}
