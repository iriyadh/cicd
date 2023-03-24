package StepDefinition;

import POM.EriBankWebElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static StepDefinition.EriBankAppAutomationStepDefs.driver;

public class EriBankMakePaymentStepDefs {

    EriBankWebElement eri;

    @Given("Click Make Payment Button")
    public void clickMakePaymentButton() throws InterruptedException {
        eri = new EriBankWebElement(driver);
        eri.makePaymentButton();
    }

    @When("User input {string} and {string} and {string}")
    public void userInputPhoneAndNameAndCountry(String Phone,String Name, String Amount) throws InterruptedException {
        eri.makePaymentFields(Phone,Name,Amount);
    }

    @And("click select button")
    public void clickSelectButton() throws InterruptedException {
        eri.clickSelectButton();
    }

    @And("click Send payment button")
    public void clickSendPaymentButton() {
        eri.clickSendPaymentButton();
    }


    @Then("Go to next page")
    public void goToNextPage() {
        System.out.println("Go to the next step");
    }
}
