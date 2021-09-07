package pageobject_model.test;

import driver.DriverSingelton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;

    protected static final String USER_NAME = "test-automation-user";

    protected static final String USER_PASSWORD = "Time4Death!";


    @BeforeMethod()
    public void setUp() {
        driver = DriverSingelton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingelton.closeDriver();
    }
}
