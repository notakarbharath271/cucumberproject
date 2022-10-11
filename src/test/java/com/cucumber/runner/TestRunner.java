package com.cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
					features = "src/test/resources/features",
					glue = "com.cucumber.stepdefinations",
					dryRun = false,
					monochrome = true,
					plugin = {"rerun:target/failed_Scenario.txt"}
					
				)

public class TestRunner {

}
