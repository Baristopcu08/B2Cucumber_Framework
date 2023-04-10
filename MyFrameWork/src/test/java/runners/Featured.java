package runners;


import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;

@CucumberOptions(

        features = {"src/test/resources/features/FeaturedFunc.feature"},
        glue = {"stepdefs"},
        dryRun = false,
        plugin = {"pretty",
                "json:test-output/cucumber-reports/cucumber.json",
                "html:test-output/cucumber-reports/cucumberreport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class Featured extends AbstractTestNGCucumberTests {

    @AfterTest
    public void after() {
        Driver.quitDriver();
    }

}

