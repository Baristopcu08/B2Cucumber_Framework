package runners;


import ReuseableClass.BaseClass;
import driver.Browsers;
import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

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

    @BeforeTest
    @Parameters("browser")
    public  void beforeTest( @Optional String browser){
        Driver.getDriver(Browsers.valueOf(browser));

    }
}

