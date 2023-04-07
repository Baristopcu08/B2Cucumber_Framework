package pageObjects;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static driver.Driver.getDriver;

public class AccountPage {

    public AccountPage() {
        PageFactory.initElements(getDriver(),this);
    }


}
