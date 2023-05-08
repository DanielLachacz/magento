package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

public class CheckOutTest extends BaseTest{

    @Test
    public void checkPopUpCartOrder() {

        ProductPage productPage =
                new HomePage(driver)
                        .openWhatsNewPage()
                        .openProduct("Phoebe Zipper Sweatshirt")
                        .addProductToCart("S", "Gray")
                        .viewCart();

        Assert.assertEquals(productPage.getProductName().getText(), "Phoebe Zipper Sweatshirt");

    }
    @Test
    public void checkPopUpCartOrderWithDoubleQuantity() {
        ProductPage productPage =
                new HomePage(driver)
                        .openWhatsNewPage()
                        .openProduct("Phoebe Zipper Sweatshirt")
                        .setQuantity("2")
                        .addProductToCart("XS", "Purple")
                        .viewCart();

        Assert.assertEquals(productPage.getTotalProductPrice().getText(), "$118.00");
        Assert.assertEquals(productPage.getItemsCount().getText(), "2");

    }
}
