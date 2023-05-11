package pages;

import io.opentelemetry.sdk.metrics.internal.view.ExponentialHistogramAggregation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;

public class ShoppingCartPage {

    @FindBy(xpath = "//div[contains(@data-bind,'html: $parent.prepareMessageForHtml(message.text)')]")
    private WebElement updateInfoBar;

    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

   public WebElement getUpdateInfoBar() {
        SeleniumHelper.waitForVisible(updateInfoBar, driver);
        return updateInfoBar;
   }
}
