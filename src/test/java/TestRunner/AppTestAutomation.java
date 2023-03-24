package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(tags="@test",
        features = {"src/test/resources/Feature/AppTestAutomation.feature",
                "src/test/resources/Feature/EriMakePayment.feature"},

        glue = {"StepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty","html:build/reports/feature.html"
        })
@Test
public class AppTestAutomation extends AbstractTestNGCucumberTests {
}

//"src/test/resources/Feature/EriMakePayment.feature"