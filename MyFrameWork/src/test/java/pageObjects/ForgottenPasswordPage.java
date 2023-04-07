package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static driver.Driver.getDriver;

public class ForgottenPasswordPage {

    public ForgottenPasswordPage() {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "(//a[contains(.,'Forgotten Password')])[1]")
    public WebElement forgottenPasswordLink;
}
