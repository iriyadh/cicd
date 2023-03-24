package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

public class PostApiRunner {

    @CucumberOptions(tags ="@smoke", features = {"src/test/resources/Features/userPostApi.feature"},
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

