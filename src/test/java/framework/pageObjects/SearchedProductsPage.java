package framework.pageObjects;

import framework.bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchedProductsPage extends BasePage {

    @FindBy(className = "product-item")
    public List<WebElement> allProducts;

    @FindBy(css = ".details .add-info .buttons input[value='Add to cart']")
    public List<WebElement> allAddWishButtons;

    @FindBy(id = "bar-notification")
    public WebElement notificationBar;

    @FindBy(linkText = "shopping cart")
    public WebElement wishlistLink;


    public SearchedProductsPage(WebDriver driver){
        super(driver);
    }

    public boolean containProduct(String productName){
        boolean aux = false;
        for (WebElement item: allProducts) {
            if (item.getText().contains(productName)){
                aux = true;
            }
        }
        return aux;
    }

    public void addingAllItemsToWishlist(){
        for (WebElement button: allAddWishButtons) {
            wait.until(ExpectedConditions.elementToBeClickable(button));
            button.click();
            wait.until(ExpectedConditions.visibilityOf(notificationBar));
        }
    }

    public WishlistPage goingToWishListPage(){
        wishlistLink.click();

        return new WishlistPage(driver);
    }
}
