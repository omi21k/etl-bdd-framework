package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	publish = false,
    features = "src/test/java/features",
    glue = {"stepDef"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true,
    tags = "@TestRun"
)
public class TestRunner extends AbstractTestNGCucumberTests {}