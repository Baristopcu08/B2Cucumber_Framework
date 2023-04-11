package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BDD {
    @Given("^I am on the login page$")
    public void ıAmOnTheLoginPage() {
    }

    @When("^I enter my valid credentials with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void ıEnterMyValidCredentialsWithUsernameAndPassword(String arg0, String arg1) throws Throwable {
        System.out.println(arg0+arg1);
    }

    @And("^I click on the login button$")
    public void ıClickOnTheLoginButton() {
    }

    @Then("^I should be redirected to the home page$")
    public void ıShouldBeRedirectedToTheHomePage() {
    }

    @And("^I should see a welcome message with my name \"([^\"]*)\"$")
    public void ıShouldSeeAWelcomeMessageWithMyName(String arg0) throws Throwable {
        System.out.println(arg0);
    }
}
