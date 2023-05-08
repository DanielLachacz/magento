package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    @FindBy(xpath = "//a[text()='Create an Account']")
    private WebElement createAccountLink;

    @FindBy(className = "authorization-link")
    private WebElement loginLink;

    @FindBy(xpath = "//a[@id='ui-id-3']")
    private WebElement whatsNewLink;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CreateAccountPage openCreateAccountPage() {
        createAccountLink.click();
        return new CreateAccountPage(driver);
    }

    public LoginPage openLoginPage() {
        loginLink.click();
        return new LoginPage(driver);
    }

    public WhatsNewPage openWhatsNewPage() {
        whatsNewLink.click();
        return new WhatsNewPage(driver);
    }

}
