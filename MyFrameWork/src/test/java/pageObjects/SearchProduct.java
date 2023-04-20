package pageObjects;

import ReuseableClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readers.textFile.ReaderTextFiles;

import java.io.IOException;
import java.util.List;

import static driver.Driver.getDriver;

public class SearchProduct extends BaseClass {

    public SearchProduct() {
        PageFactory.initElements(getDriver(), this);
    }


    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement searhBox;

    @FindBy(xpath = "//i[@class='fa fa-search']")
    public WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class,\"product-layout product\")]")
    public List<WebElement> searchProductList;

    @FindBy(xpath = "//a//ancestor::div[@class=\"product-thumb\"]//button[1]")
    public WebElement listOfAllWantedProducts;

    public void serachPruduct(String productText) {
        $(searhBox).sendKeys(productText);
        $( searchButton).click();
    }

    public void addProductsToTheCart() {
        List<WebElement> elementList = $(listOfAllWantedProducts).getElementList();
        for (WebElement webElement : elementList) {
            webElement.click();
            sleep(1000);

        }


    }
    public void saveProductList (String folderName) throws IOException {
        List<WebElement> searcProducts = searchProductList;
        for (WebElement product : searcProducts) {
            String producttext = product.findElement(By.xpath(".//div[contains(@class,\"product-layout product\")]//h4//a")).getText();

            new  ReaderTextFiles().writeToTextFile(producttext);
            System.out.println("methot çalıştııııı");
        }


    }
}
