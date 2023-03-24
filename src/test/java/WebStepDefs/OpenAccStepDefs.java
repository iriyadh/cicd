package WebStepDefs;

import Core.BrowserClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class OpenAccStepDefs extends BrowserClass {

    WebDriver driver;
    BrowserClass bc = new BrowserClass();
    @Given("user in open account page")
    public void userInOpenAccountPage() {
        bc.firefox("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/addCust");
    }

    @When("user selects {string} and {string}")
    public void userSelectsCustomerAndCurrency(String Customer, String Currency) throws InterruptedException {
        bc.selectCustCurr(Customer, Currency);
    }

    @Then("click process button")
    public void clickProcessButton() {
    }
}
