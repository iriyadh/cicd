package WebStepDefs;

import Core.BrowserClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AddStepDefs extends BrowserClass {

    WebDriver driver;

    BrowserClass BC = new BrowserClass();

    @Given("user in add customer page")
    public void userInAddCustomerPage() {

        BC.firefox("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/addCust");
    }

    @When("user enter {string} and {string} and {string}")
    public void userEnterFirstnameAndLastnameAndPostcode(String firstname, String lastname, String postcode) throws InterruptedException {

        BC.addCus(firstname, lastname, postcode);

    }

    @And("click addcustomer button")
    public void clickAddcustomerButton() throws InterruptedException {

        BC.clickButt();
    }

    @Then("click ok")
    public void clickOk() throws InterruptedException {

        BC.alertt();

    }
}

