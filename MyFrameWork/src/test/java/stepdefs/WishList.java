package stepdefs;

import ReuseableClass.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.ProductShowPage;
import pageObjects.SearchProduct;

import java.util.List;

public class WishList extends BaseClass {
    SearchProduct searchPage=new SearchProduct();
    ProductShowPage showPage=new ProductShowPage();


    @When("Enter any existing Product name into the Search text box field")
    public void enterAnyExistingProductNameIntoTheSearchTextBoxField(DataTable dataTable) {

        List<String> strings = dataTable.asList();

        searchPage.searhBox.sendKeys(strings.get(0));
    }

    @And("Click on the button having search icon")
    public void clickOnTheButtonHavingSearchIcon() {

        searchPage.searchButton.click();
    }

    @And("Click on the Product displayed in the Search results")
    public void clickOnTheProductDisplayedInTheSearchResults() {

        searchPage.searchProductList.get(0).click();

    }

    @And("Click on Add to Wish List option on a product that is displayed in the Related Products section of displayed Product Display page")
    public void clickOnAddToWishListOptionOnAProductThatIsDisplayedInTheRelatedProductsSectionOfDisplayedProductDisplayPage() {

    showPage=new ProductShowPage();
    showPage.addtoWishListButton.click();

    }

    @Then("Click on the wish list! link in the displayed success message")
    public void clickOnTheWishListLinkInTheDisplayedSuccessMessage() {

        wait.until(ExpectedConditions.visibilityOf(showPage.isAddtoWishList));
    }
}
