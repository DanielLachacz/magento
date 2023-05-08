package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();     //Selenium bug workaround
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }
}
