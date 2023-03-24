package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

public class WebRunner {

    @CucumberOptions(tags ="@test1", features = {
            "src/test/resources/Features/addcustomer.feature",
            "src/test/resources/Features/openAccount.feature"},
            glue = {"WebStepDefs"},
            monochrome = true,
            dryRun = false,
            plugin = {
                    "pretty",
                    "html:build/reports/feature.html"   //Report
            })
    @Test
    public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    }
}
