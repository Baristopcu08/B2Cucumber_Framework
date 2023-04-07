package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static driver.Driver.getDriver;

public class ProductShowPage {

    public ProductShowPage() {
        PageFactory.initElements(getDriver(),this);
    }


    @FindBy(xpath = "(//i[@class='fa fa-heart'])[2]")
    public WebElement addtoWishListButton;

    @FindBy(xpath = "//div[contains(@class,\"alert alert-success\") and contains(text(),\"Success\")]")
    public WebElement isAddtoWishList;
}
