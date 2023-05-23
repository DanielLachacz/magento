package pages;

import org.example.models.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.SeleniumHelper;

public class ShippingAddressPage {

    @FindBy(xpath = "//div[@class='control _with-tooltip']//input[@id='customer-email']")
    private WebElement emailAddressInput;

    @FindBy(name = "firstname")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='company']")
    private WebElement companyInput;

    @FindBy(xpath = "//input[@name='street[0]']")
    private WebElement streetAddressInput;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement cityInput;

    @FindBy(xpath = "//select[@name='region_id']")
    private WebElement stateProvinceSelect;

    @FindBy(xpath = "//input[@name='postcode']")
    private WebElement zipPostalCodeInput;

    @FindBy(xpath = "//select[@name='country_id']")
    private WebElement countrySelect;

    @FindBy(xpath = "//input[@name='telephone']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@name='ko_unique_1']")
    private WebElement shippingMethod5Dollars;

    @FindBy(xpath = "//input[@name='ko_unique_2']")
    private WebElement shippingMethod10Dollars;

    @FindBy(xpath = "//button[@class='button action continue primary']")
    private WebElement nextButton;

    private WebDriver driver;

    public ShippingAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public PaymentPage fillAddressDetails(Customer customer) {
//        SeleniumHelper.waitForVisible(zipPostalCodeInput, driver);
        emailAddressInput.sendKeys(customer.getEmailAddress());
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        companyInput.sendKeys(customer.getCompany());
        streetAddressInput.sendKeys(customer.getStreetAddress());
        cityInput.sendKeys(customer.getCity());
        Select sSelect = new Select(stateProvinceSelect);
        sSelect.selectByVisibleText(customer.getStateProvince());
        zipPostalCodeInput.sendKeys(customer.getZipPostalCode());
        Select cSelect = new Select(countrySelect);
        cSelect.selectByVisibleText(customer.getCountry());
        phoneNumberInput.sendKeys(customer.getPhoneNumber());
        shippingMethod5Dollars.click();
       // SeleniumHelper.waitForClickable(nextButton, driver);
      //  SeleniumHelper.waitForClickable(nextButton, driver);
        nextButton.click();
        return new PaymentPage(driver);
    }
}
