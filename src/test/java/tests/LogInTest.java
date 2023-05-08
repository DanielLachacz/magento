package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class LogInTest extends BaseTest{

    @Test
    public void loginTest() {

        WebElement loggedInText = new HomePage(driver)
                .openLoginPage()
                .logInValidData("test@email.com", "QAZ123qaz")
                .getLoggedInText();

        Assert.assertTrue(loggedInText.isDisplayed());
    }

    @Test
    public void loginWithInvalidDataTest() {
        WebElement error = new HomePage(driver)
                .openLoginPage()
                .logInInvalidData("error@test.com", "error123test")
                .getError();

        Assert.assertTrue(error.isDisplayed());
    }
}
