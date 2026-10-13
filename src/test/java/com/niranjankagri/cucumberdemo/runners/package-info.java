/**
 * Runners: one JUnit Platform suite per feature file.
 *
 * Each class selects a feature from src/test/resources/features
 * (@SelectClasspathResource), runs it with the Cucumber engine and sets the glue
 * (stepdefinitions + hooks) and the report plugins. Surefire runs every *Runner class
 * except ReportDemoRunner, which fails and skips on purpose.
 *
 * Flow: runner -> feature -> stepdefinitions -> pages -> utils (browser, config).
 */
package com.niranjankagri.cucumberdemo.runners;
