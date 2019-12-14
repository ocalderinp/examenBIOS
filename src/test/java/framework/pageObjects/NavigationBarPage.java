package framework.pageObjects;

import framework.bases.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationBarPage extends BasePage {

    @FindBy(id = "small-searchterms")
    WebElement searchBar;

    @FindBy(className = "search-box-button")
    WebElement searchButton;

    //Constructor
    public NavigationBarPage(WebDriver driver){
        super(driver);
    }

    public SearchedProductsPage searchingSpecificItem(String itemToSearch){
        searchBar.sendKeys(itemToSearch);
        searchButton.click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2 a"), itemToSearch));
        return new SearchedProductsPage(driver);
    }

    public SearchedProductsPage searchingItems(String itemName){
        searchBar.sendKeys(itemName);
        searchButton.click();
        return new SearchedProductsPage(driver);
    }


}
