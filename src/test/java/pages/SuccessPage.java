package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage {

    @FindBy(xpath = "//div[@class='checkout-success']//p")
    private WebElement checkoutSuccessTitle;

    private WebDriver driver;

    public SuccessPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getCheckoutSuccessTitle() {
        return checkoutSuccessTitle;
    }
}
