package tests;

import org.example.models.Customer;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckOutTest extends BaseTest{

    @Test
    public void checkPopUpCartOrder() {

        ProductPage productPage =
                new HomePage(driver)
                        .openWhatsNewPage()
                        .openProduct("Phoebe Zipper Sweatshirt")
                        .addProductToCart("S", "Gray")
                        .viewMiniCart();

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
                        .viewMiniCart();

        Assert.assertEquals(productPage.getTotalProductPrice().getText(), "$118.00");
        Assert.assertEquals(productPage.getItemInCart().getText(), "2");

    }

    @Test
    public void editItem() {
        ShoppingCartPage shoppingCartPage =
                new HomePage(driver)
                        .openWhatsNewPage()
                        .openProduct("Phoebe Zipper Sweatshirt")
                        .addProductToCart("XS", "Purple")
                        .viewMiniCart()
                        .editProductInTheMiniCart()
                        .updateProduct("S", "White");

        Assert.assertEquals(shoppingCartPage.getUpdateInfoBar()
                .getText(), "Phoebe Zipper Sweatshirt was updated in your shopping cart.");

    }

    @Test
    public void deleteButtonInTheSmallCart() {
        ProductPage productPage =
                new HomePage(driver)
                        .openWhatsNewPage()
                        .openProduct("Phoebe Zipper Sweatshirt")
                        .addProductToCart("XS", "Purple")
                        .viewMiniCart()
                        .deleteItemFromTheMiniCart();

        Assert.assertEquals(
                productPage
                        .getNoItemsInTheMiniCartInformation()
                        .getText(), "You have no items in your shopping cart.");

    }

    @Test
    public void checkoutTest() {
        Customer customer = new Customer();

        SuccessPage successPage =
                new HomePage(driver)
                        .openWhatsNewPage()
                        .openProduct("Phoebe Zipper Sweatshirt")
                        .addProductToCart("S", "Purple")
                        .viewMiniCart()
                        .openShippingAddressPage()
                        .fillAddressDetails(customer)
                                .openSuccessPage();

        Assert.assertTrue(successPage.getCheckoutSuccessTitle().isDisplayed());

    }
}
