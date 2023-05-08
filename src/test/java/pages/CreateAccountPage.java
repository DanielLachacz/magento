package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    @FindBy(id = "firstname")
    private WebElement regFirstNameInput;

    @FindBy(id = "lastname")
    private WebElement regLastNameInput;

    @FindBy(id = "email_address")
    private WebElement regEmailInput;

    @FindBy(id = "password")
    private WebElement regPasswordInput;

    @FindBy(name = "password_confirmation")
    private WebElement regPasswordConfirmationInput;

    @FindBy(css = ".action.submit.primary")
    private WebElement createAccountButton;

    @FindBy(css = ".page.messages")
    private WebElement errors;
    
    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage registerUserValidData(String firstName, String lastName, String email, String password) {
        registerUser(firstName, lastName, email, password);
        return new LoggedUserPage(driver);
    }

    public CreateAccountPage registerUserInvalidData(String firstName, String lastName, String email, String password) {
        registerUser(firstName, lastName, email, password);
        return this;
    }

    private void registerUser(String firstName, String lastName, String email, String password) {
        regFirstNameInput.sendKeys(firstName);
        regLastNameInput.sendKeys(lastName);
        regEmailInput.sendKeys(email);
        regPasswordInput.sendKeys(password);
        regPasswordConfirmationInput.sendKeys(password);
        createAccountButton.click();
    }

    public WebElement getErrors() {
        return errors;
    }
}
