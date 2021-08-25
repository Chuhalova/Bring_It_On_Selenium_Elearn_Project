package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.pageobject.PastePage;
import pageobject_model.pageobject.PastebinHomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class WebDriverPastebinTest {

    public static final String CODE_TEXT = "Hello from WebDriver";

    public static final String TITLE = "helloweb";

    public static final String EXP_TIME = "10 min";

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "/Users/Veronika_Chukhalova/Downloads/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://pastebin.com");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void commonSearchTestResultsNotEmpty() {
        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        WebElement expirationUL = pastebinHomePage.enterCodeToCodeArea(CODE_TEXT)
                                    .openExpirationBlock()
                                    .getExpirationUl();
        pastebinHomePage.waitForVisibilityOfElement(expirationUL);
        pastebinHomePage.selectTenMinExpiration()
                                    .enterTitle(TITLE)
                                    .clickOnSubmitBtn();
        PastePage pastePage = new PastePage(driver);
        WebElement newPastesTitleElement = pastePage.getNewPastesTitleElement();
        pastePage.waitForVisibilityOfElement(newPastesTitleElement);
        assertEquals(pastePage.getNewPastesTitle(), TITLE,
                     "Current title isn't the same as entered on previous step.");
        assertEquals(pastePage.getNewPastesCodeText(), CODE_TEXT,
                     "Current code text isn't the same as entered on previous step.");
        assertEquals(pastePage.getNewExpireTime(), EXP_TIME,
                     "Current expiration time isn't the same as selected on previous step.");
    }
}
