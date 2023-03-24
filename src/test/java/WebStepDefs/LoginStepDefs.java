package WebStepDefs;
import Core.BrowserClass;

import Core.BrowserClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;  //Given
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;  // When

public class LoginStepDefs extends BrowserClass{

    BrowserClass bclass = new BrowserClass();
    @Given("user in login page")
    public void userInLoginPage() {

        //  bclass.mainn();
    }

    @When("user enter {string}and {string}")
    public void userEnterPasswordAndUsername() {

    }

    @And("click button")
    public void clickButton() {

    }

    @Then("user will navigate to dashboard button")
    public void userWillNavigateToDashboardButton() {
    }
}

