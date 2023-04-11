package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = {"src/test/resources/features/MVT-T59.feature"},
        glue = {"stepdefs"},
        dryRun = false,
        plugin = { "pretty",
                "json:test-output/cucumber-reports/cucumber.json",
                "html:test-output/cucumber-reports/cucumberreport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class BDDRunner extends AbstractTestNGCucumberTests {



}

