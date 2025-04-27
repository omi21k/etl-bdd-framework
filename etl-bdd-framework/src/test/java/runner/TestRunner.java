package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDef"},
    plugin = {"pretty", "html:target/cucumber-reports"},
    monochrome = true,
    tags = "@smoketest",
    publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {}