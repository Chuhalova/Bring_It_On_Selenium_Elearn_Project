package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingelton {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/Veronika_Chukhalova/Downloads/drivers/chromedriver");
        driver = new ChromeDriver();
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
