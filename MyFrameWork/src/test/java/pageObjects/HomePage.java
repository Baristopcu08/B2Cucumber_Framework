package pageObjects;

import driver.Driver;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//div[contains(@class,\"alert alert-success\") and contains(text(),\"Success\")]")
    public WebElement isAddtoWishList;

    @FindBy(xpath = "//a[text()=\"Your Store\"]")
    public WebElement linkYourStore;


   public String featuredList="//div[@class=\"row\"]//div[contains(@class,\"product-layout\")][\"{0}\"]//button[2]";

   public By featuredProducts= By.xpath("//div[@class=\"row\"]//div[contains(@class,\"product-layout\")]");

    public LoginPage navigateLoginPage(){
        return new  LoginPage();
    }

}
