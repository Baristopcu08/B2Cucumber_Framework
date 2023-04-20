package pageObjects;

import ReuseableClass.BaseClass;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static driver.Driver.getDriver;

public class LoginPage extends BaseClass {


    public LoginPage() {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='email']")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "(//a[contains(.,'Forgotten Password')])[1]")
    public WebElement forgottenPassword;

    public ForgottenPasswordPage navigateForgottenPasswordPage(){
        return new  ForgottenPasswordPage();
    }

    public void Login(String userName,String passWord){
        $(username).sendKeys(userName);
        $(password).sendKeys(passWord);
        $(loginButton).click();
    }

}
