package pageObjects;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static driver.Driver.getDriver;

public class HomePage {


    public HomePage() {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//span[contains(.,'My Account')]")
    public WebElement myAccount;

    @FindBy(xpath = "(//a[contains(.,'Login')])[1]")
    public WebElement loginLink;

    @FindBy(xpath = "//div[contains(text(),'Warning: No match for E-Mail Address and/or Password.')]")
    public WebElement warningMessage;


    public LoginPage navigateLoginPage(){
        return new  LoginPage();
    }

}
