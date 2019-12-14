package framework.tests;

import framework.bases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NopCommerceTest extends BaseTest {

    @Test(dataProvider = "itemsToSearch")
    public void searchingProduct(String itemToSearch){
        extentTest = extentReports.createTest("Searching Product");
        searchedProductsPage = navigationBarPage.searchingSpecificItem(itemToSearch);

        Assert.assertTrue(searchedProductsPage.containProduct(itemToSearch));
    }

    @Test
    public void addingToWishlist(){
        extentTest = extentReports.createTest("Adding to Wishlist.");
        searchedProductsPage = navigationBarPage.searchingItems("HTC One");
        searchedProductsPage.addingAllItemsToWishlist();
        searchedProductsPage.goingToWishListPage();



    }

    @DataProvider(name = "itemsToSearch")
    public Object[][] listItem() {
        return new Object[][] {
                {"HTC One M8 Android"},
                {"HTC One Mini Blue"},
                {"Nokia Lumia 1020"},
        };
    }

}
