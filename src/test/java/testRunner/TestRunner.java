package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resource/features",
		glue = {"stepDefinitions", "appHooks"},
		plugin = {"pretty"},
		monochrome = true,
		publish = true
		)

public class TestRunner {

}
