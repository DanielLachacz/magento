package tests;

import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;


public class RegisterTest extends BaseTest {


    @Test
    public void registerUserTest() throws InvalidSelectorException {
        int random = (int) (Math.random() * 1000);

        WebElement myAccountLink = new  HomePage(driver)
                .openCreateAccountPage()
                .registerUserValidData("Daniel", "Tester",
                        "test" + random + "@email.com", "QAZ123qaz")
                .getMyAccountLink();

        Assert.assertEquals(myAccountLink.getText(), "My Account");
    }

    @Test
    public void registerUserWithSameEmailTest() {
        WebElement error = new HomePage(driver)
                .openCreateAccountPage()
                .registerUserInvalidData("test@email.com", "Daniel",
                        "test@email.com", "QAZ123qaz")
                .getErrors();

        System.out.println(error.getText());
        Assert.assertTrue(error.isDisplayed());

    }
}
