package com.ect.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SearchPage {
    WebDriver driver;
    // Constructor to initialize the WebDriver and PageFactory
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // WebElements identified using @FindBy
    @FindBy(xpath="//*[@id=\"container\"]/div/div/nav/ol/li[1]/a") WebElement hometxt;
    @FindBy(id = "fm_search") WebElement srchProduct;
    @FindBy(linkText ="Search") WebElement searchbtn; // Corrected typo in variable name (was "serachbtn")
    @FindBy(xpath = "//*[@id='container']/div/div[1]/div[2]/div/div/p/a")WebElement productClick;
    @FindBy(xpath = "//*[@id='navbarText']/ul/li[3]/a") WebElement addCart;
    @FindBy(xpath = "//*[@id='cart']/div/a") WebElement checkout;
    // Method to search for a product and perform actions
    public void searchProduct() {
        // Navigate to Home
        hometxt.click(); 
        // Enter product name
        srchProduct.sendKeys("Android TV");       
        // Click on the search button
        searchbtn.click();
        // Click on the product
        productClick.click();
        // Add to cart
        addCart.click();     
        // Proceed to checkout
        checkout.click();
    }
}
