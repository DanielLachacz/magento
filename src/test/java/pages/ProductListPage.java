package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;

public class ProductListPage {

    private WebDriver driver;

    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage openProduct(String title) { //Phoebe Zipper Sweatshirt
        By productXpath = By.xpath("//li[@class='product-item']//a[@title='"+ title +"']");
        SeleniumHelper.waitForClickable(productXpath, driver);
        driver.findElement(productXpath).click();
        return new ProductPage(driver);
    }
}
