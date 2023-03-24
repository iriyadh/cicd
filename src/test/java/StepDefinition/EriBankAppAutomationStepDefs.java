package StepDefinition;

import Core.Helper;
import POM.EriBankWebElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;

public class EriBankAppAutomationStepDefs {
    DesiredCapabilities dc = new DesiredCapabilities();
    public static AndroidDriver driver;
    //Helper helper = new Helper();

    @Given("app apk is there")
    public void appApkIsThere() throws InterruptedException, MalformedURLException {
        Helper helper = new Helper();
        driver = helper.apkLaunch();
        //helper.apkLaunch();
    }


    @When("user enters {string}and {string}")
    public void userEntersUsernameAndPass(String username, String password) throws InterruptedException {
        EriBankWebElement eri = new EriBankWebElement(driver);
        eri.inputField(username, password);

    }

    @Then("user will navigate to home screen")
    public void userWillNavigateToHomeScreen() {
        System.out.println("test");
    }
}


