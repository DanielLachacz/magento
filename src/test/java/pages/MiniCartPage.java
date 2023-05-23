package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;

public class MiniCartPage {

    @FindBy(xpath = "//span[@class=('count')]")
    private WebElement itemInCart;

    @FindBy(xpath = "//a[@title=('Edit item')]")
    private WebElement miniCartEditButton;

    @FindBy(xpath = "//button[@title=('Update Cart')]")
    private WebElement updateCart;

    @FindBy(xpath = "//a[@class=('action delete')]")
    private WebElement deleteButton;

    @FindBy(xpath = "//button[@class=('action-primary action-accept')]")
    private WebElement deleteConfirmationButton;

    @FindBy(xpath = "//strong[@class=('subtitle empty')]")
    private WebElement noItemsInTheMiniCartInformation;

    @FindBy(xpath = "//button[@id='top-cart-btn-checkout']")
    private WebElement proceedToCheckoutButton;

    private WebDriver driver;

    public MiniCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ShippingAddressPage openShippingAddressPage() {
        SeleniumHelper.waitForElement(driver, proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        return new ShippingAddressPage(driver);
    }

    public WebElement getItemInCart() {
        return itemInCart;
    }

    public WebElement getMiniCartEditButton() {
        return miniCartEditButton;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public WebElement getDeleteConfirmationButton() {
        return deleteConfirmationButton;
    }

    public WebElement getNoItemsInTheMiniCartInformation() {
        return noItemsInTheMiniCartInformation;
    }

    public WebElement getUpdateCart() {
        return updateCart;
    }
}
