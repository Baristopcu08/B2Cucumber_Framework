package pageObjects;

import ReuseableClass.BaseClass;
import ReuseableClass.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.MessageFormat;
import java.util.List;

import static driver.Driver.getDriver;
import static ReuseableClass.Element.$;

public class ProductShowPage extends BaseClass {

    public ProductShowPage() {
        PageFactory.initElements(getDriver(),this);
    }


    @FindBy(xpath = "(//i[@class='fa fa-heart'])[2]")
    public WebElement addtoWishListButton;

    @FindBy(xpath = "//div[contains(@class,\"alert alert-success\") and contains(text(),\"Success\")]")
    public WebElement isAddtoWishList;

    @FindBy(xpath = "(//i[@class='fa fa-heart'])[1]")
    public WebElement addtoCardButton;

    String addtoCardByProductName="//a[text()=\"{0}\"]//ancestor::div[@class=\"product-thumb\"]//button[1]";


    public void addCartProduct(String text){
        new SearchProduct().serachPruduct(text);
        List<WebElement> elements = driver.findElements(By.xpath(MessageFormat.format(addtoCardByProductName, text)));
        if (elements.size()<=0) {
            return;
        }
        $(driver.findElement(By.xpath(MessageFormat.format(addtoCardByProductName, text)))).click();
    }
    public void isAddtoWishList(String text){
        wait.until(ExpectedConditions.visibilityOf(isAddtoWishList));
    }

    public void isAddtoCard(){
        wait.until(ExpectedConditions.visibilityOf(isAddtoWishList));
    }
}
