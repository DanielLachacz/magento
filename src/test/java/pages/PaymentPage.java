package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    @FindBy(xpath = "//button[@title='Place Order']")
    WebElement placeOrderButton;

    @FindBy(xpath = "//input[@name='billing-address-same-as-shipping']")
    WebElement billingAddressInput;

    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SuccessPage openSuccessPage() {
        billingAddressInput.click();
        placeOrderButton.click();
        return new SuccessPage(driver);
    }

}
