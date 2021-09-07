package pageobject_model.test;

import model.Paste;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageobject_model.pageobject.PastePage;
import pageobject_model.pageobject.PastebinHomePage;
import service.PasteService;

import static org.testng.Assert.assertEquals;

public class WebDriverPastebinTest extends CommonConditions {

    @Test
    public void commonSearchTestResultsNotEmpty() throws InterruptedException {
        Paste paste = new PasteService().createPasteWithExpiration10Min();
        String expirationTime = paste.getExpirationTime()+" min";
        String pasteTitle = paste.getTitle();
        String pasteCode = paste.getCode();
        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        WebElement privacyPopup = pastebinHomePage.openPage()
                                                  .getPrivacyPopup();
        pastebinHomePage.waitForVisibilityOfElement(privacyPopup);
        pastebinHomePage.clickOnAgreeBtn();
        WebElement expirationUL = pastebinHomePage.enterCodeToCodeArea(pasteCode)
                                                  .openExpirationBlock()
                                                  .getExpirationUl();
        pastebinHomePage.waitForVisibilityOfElement(expirationUL);
        pastebinHomePage.selectTenMinExpiration()
                        .enterTitle(pasteTitle)
                        .clickOnSubmitBtn();
        PastePage pastePage = new PastePage(driver);
        WebElement newPastesTitleElement = pastePage.getNewPastesTitleElement();
        pastePage.waitForVisibilityOfElement(newPastesTitleElement);
        assertEquals(pastePage.getNewPastesTitle(), pasteTitle, "Current title isn't the same as entered on previous step.");
        assertEquals(pastePage.getNewPastesCodeText(), pasteCode,
                     "Current code text isn't the same as entered on previous step.");
        assertEquals(pastePage.getNewExpireTime(), expirationTime,
                     "Current expiration time isn't the same as selected on previous step.");
    }
}
