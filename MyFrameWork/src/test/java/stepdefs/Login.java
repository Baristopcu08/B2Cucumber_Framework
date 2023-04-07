package stepdefs;

import ReuseableClass.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.ForgottenPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import readers.property.PropertyReader;

import java.util.List;
import java.util.Map;

import static ReuseableClass._Conditions.visibilty;
import static readers.property.PropertyReader.propertyReader;

public class Login extends BaseClass {

    HomePage hp=new HomePage();
    LoginPage lp=new LoginPage();

    @Given("user on homepage")
    public void userOnHomepage() {
        open(PropertyReader.read().get("url"));
    }

    @When("user clicks My Account Link")
    public void userClicksMyAccountLink() {
        hp.myAccount.click();

    }

    @And("user clicks Login Link")
    public void userClicksLoginLink() {
        wait.until(ExpectedConditions.visibilityOf(hp.loginLink)).click();

    }

    @Then("Login page should be visible")
    public void loginPageShouldBeVisible() {
        wait.until(ExpectedConditions.urlContains("login"));
    }

    @When("user fill the login form with the following datas")
    public void userFillTheLoginFormWithTheFollowingDatas(DataTable table) {
        Map<String, String> userInfo = table.asMap();

        $(lp.username).sendKeys(userInfo.get("username")).
        $(lp.password).sendKeys(userInfo.get("password"));

    }

    @And("user clicks Login button")
    public void userClicksLoginButton() {
       lp.loginButton.click();
    }

    @Then("login should be successfull")
    public void loginShouldBeSuccessfull() {
        wait.until(ExpectedConditions.urlContains("account"));
    }

    @And("Account page should be visible")
    public void accountPageShouldBeVisible() {

    }

    @Then("Warning message with the text {string} should be displayed")
    public void warningMessageWithTheTextShouldBeDisplayed(String warningText) {
        $(hp.warningMessage).waitFor(visibilty,null);

    }

    @When("Don't enter anything into the E-Mail Address field")
    public void donTEnterAnythingIntoTheEMailAddressField() {
        $(lp.username).sendKeys("");

    }

    @And("Don't enter anything into the Password field")
    public void donTEnterAnythingIntoThePasswordField() {
        $(lp.password).sendKeys("");
    }

    @When("user fill the E-Mail Address form with the following datas with  Press Tab keyboard")
    public void userFillTheEMailAddressFormWithTheFollowingDatasWithPressTabKeyboard(DataTable table) {
        Map<String, String> userInfo = table.asMap();
        String username = userInfo.get("username");
        moveWithTab(username,lp.username);

    }

    @And("user fill the Password form with the following datas with  Press Tab keyboard")
    public void userFillThePasswordFormWithTheFollowingDatasWithPressTabKeyboard(DataTable table) {
        Map<String, String> userInfo = table.asMap();
        String password = userInfo.get("password");
        moveWithTab(password,lp.password);
    }



    private void moveWithTab(String userInfo, WebElement targetElement) {
        boolean temp=true;
        while (temp){
            new Actions(driver).sendKeys(Keys.TAB).build().perform();
            if (driver.switchTo().activeElement().equals(targetElement)) {
                lp.username.sendKeys(userInfo);
                temp=false;
            }
        }
    }

    @And("user click on Forgotten Password link")
    public void userClickOnForgottenPasswordLink() {
        $(lp.forgottenPassword).click();
    }

    @Then("user should be taken to Login page and Forgotten Password link should be displayed in the page")
    public void userShouldBeTakenToLoginPageAndForgottenPasswordLinkShouldBeDisplayedInThePage() {
        WebElement forgottenPasswordLink = new ForgottenPasswordPage().forgottenPasswordLink;
        $(forgottenPasswordLink).waitFor(visibilty,null);

    }

    @And("user should be taken to Forgotten Password page")
    public void userShouldBeTakenToForgottenPasswordPage() {
        wait.until(ExpectedConditions.urlContains("forgotten"));
    }

    @And("Click on Browser back button")
    public void clickOnBrowserBackButton() {
        driver.navigate().back();
    }

    @Then("User should not logged out")
    public void userShouldNotLoggedOut() {
        loginShouldBeSuccessfull();
    }
}
