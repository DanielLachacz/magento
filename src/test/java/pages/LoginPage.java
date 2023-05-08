package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(name = "login[username]")
    private WebElement usernameInput;

    @FindBy(name = "login[password]")
    private WebElement passwordInput;

    @FindBy(id = "send2")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='message-error error message']")
    private WebElement error;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage logInValidData(String username, String password) {
        logIn(username, password);
        return new LoggedUserPage(driver);
    }

    public LoginPage logInInvalidData(String username, String password) {
        logIn(username, password);
        return this;
    }

    private void logIn(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.click();
    }

    public WebElement getError() {
        return error;
    }
}
