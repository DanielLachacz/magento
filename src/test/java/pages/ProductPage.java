package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;

public class ProductPage {


    @FindBy(xpath = "//button[@id='product-addtocart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='action showcart']")
    private WebElement cartButton;

    @FindBy(xpath = "//span[@class='counter qty']")
    private WebElement cartButtonRed;

    @FindBy(xpath = "//strong[@class='product-item-name']//a[contains(@data-bind, 'attr: {href: product_url}, html: product_name')]")
    private WebElement productName;

//    @FindBy(xpath = "product-price-1130")
//    private WebElement productPrice;

    @FindBy(xpath = "//div[@class='amount price-container']//span[contains(@class,'price')]")
    private WebElement totalProductPrice;

    @FindBy(xpath = "//div[@class=('control')]//input[@value='1']")
    private WebElement qtyInput;

    @FindBy(xpath = "//span[@class=('count')]")
    private WebElement itemsCount;

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage addProductToCart(String size, String color) {
        By xpathSize = By.xpath("//div[text()='"+ size +"']");
        By xpathColor = By.xpath("//div[@option-label='"+ color +"']");
        SeleniumHelper.waitForClickable(xpathSize, driver);
        driver.findElement(xpathSize).click();
        SeleniumHelper.waitForClickable(xpathColor, driver);
        driver.findElement(xpathColor).click();
        addToCartButton.click();
        return this;
    }

    public ProductPage setQuantity(String qty) {
        qtyInput.clear();
        qtyInput.sendKeys(qty);
        return this;
    }

    public ProductPage viewCart() {
        SeleniumHelper.waitForClickable(cartButtonRed, driver);
        cartButton.click();
        return this;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getTotalProductPrice() {
        return totalProductPrice;
    }

    public WebElement getItemsCount() {
        return itemsCount;
    }






}
