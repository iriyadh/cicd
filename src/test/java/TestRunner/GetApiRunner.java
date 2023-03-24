package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

public class GetApiRunner {

    @CucumberOptions(tags ="@smoke", features = {"src/test/resources/Features/getApi.feature"},
            glue = {"StepDefinition"},
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

