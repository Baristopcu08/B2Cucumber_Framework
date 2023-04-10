package stepdefs;

import ReuseableClass.BaseClass;
import ReuseableClass._Conditions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.HomePage;

import java.text.MessageFormat;
import java.util.List;
import java.util.Random;

import static ReuseableClass._Conditions.visibilty;

public class Featured extends BaseClass {
    HomePage hp=new HomePage();

    @And("Click on Add to Wish List option on a product that is displayed in the Featured section")
    public void clickOnAddToWishListOptionOnAProductThatIsDisplayedInTheFeaturedSection() {
        $(hp.linkYourStore).click();
        List<WebElement> elementList = $(hp.featuredProducts).scrollIntoView(true).getElementList();
        int productsize = elementList.size();
        int productAccont = new Random().nextInt(productsize);
        String featuredList = hp.featuredList;
        $(By.xpath(MessageFormat.format(featuredList,productAccont))).click();

    }

    @Then("Click on the {string} link in the displayed success message")
    public void clickOnTheWishListLinkInTheDisplayedSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(hp.isAddtoWishList));
    }
}
