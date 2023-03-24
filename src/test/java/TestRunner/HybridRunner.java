package TestRunner;
        import io.cucumber.testng.AbstractTestNGCucumberTests;
        import io.cucumber.testng.CucumberOptions;
        import org.testng.annotations.Test;

// tags = "@Web and @AppTest1 and @AppTest2 and (@getApi or @postApi)")

@CucumberOptions(tags = "@Test",
        features =
                {"src/test/resources/Feature"},

        //glue = {"RestAssuredTest", "StepDefinition","TestRunner", "WebStepDefs"},
        glue = {"TestRunner", "WebStepDefs"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/webFeature.html"
        })

@Test
public class HybridRunner extends AbstractTestNGCucumberTests {


}