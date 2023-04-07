package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static driver.Driver.getDriver;

public class SearchProduct {

    public SearchProduct() {
        PageFactory.initElements(getDriver(),this);
    }


    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement searhBox;

    @FindBy(xpath = "//i[@class='fa fa-search']")
    public WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class,\"product-layout product\")]")
    public List<WebElement> searchProductList;
}
