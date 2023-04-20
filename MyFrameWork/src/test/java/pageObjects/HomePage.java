package pageObjects;

import ReuseableClass.BaseClass;
import ReuseableClass._Conditions;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static driver.Driver.getDriver;

public class HomePage extends BaseClass {


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

    @FindBy(xpath = "//span[contains(.,'Shopping Cart')]")
    public WebElement linkShoppingCart;

    @FindBy(xpath = "//button[@data-original-title=\"Remove\"]")
    public List<WebElement> shoppingCardDeleteButton;

    @FindBy(xpath = "//a[contains(.,'Continue')]")
    public WebElement buttonContinue;


   public String featuredList="//div[@class=\"row\"]//div[contains(@class,\"product-layout\")][\"{0}\"]//button[2]";

   public By featuredProducts= By.xpath("//div[@class=\"row\"]//div[contains(@class,\"product-layout\")]");

    public LoginPage navigateLoginPage(){
        return new  LoginPage();
    }


    public void cleanCard(){
        $(linkShoppingCart).click().waitFor(_Conditions.urlContains,"checkout");
        List<WebElement> elementList = shoppingCardDeleteButton;

        if (elementList.size()>0) {
            for (int i = 0; i < elementList.size(); i++) {
                elementList = shoppingCardDeleteButton;
                elementList.get(0).click();
            }
        }


    }

    public void cardShouldBeEmty(){
        WebElement element=buttonContinue;
        $(element).waitFor(_Conditions.visibilty,null);
    }

}
