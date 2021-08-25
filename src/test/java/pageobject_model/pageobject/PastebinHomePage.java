package pageobject_model.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinHomePage extends BasePage {
    @FindBy(id = "postform-text")
    private WebElement codeArea;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expirationSpan;

    @FindBy(id = "select2-postform-expiration-results")
    private WebElement expirationUl;

    @FindBy(xpath = "//ul[@id='select2-postform-expiration-results']//li[text()='10 Minutes']")
    private WebElement tenMinExpirationLi;

    @FindBy(id = "postform-name")
    private WebElement titleInput;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement submitBtn;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePage enterCodeToCodeArea(String code) {
        codeArea.clear();
        codeArea.sendKeys(code);
        return this;
    }

    public PastebinHomePage openExpirationBlock() {
        expirationSpan.click();
        return this;
    }

    public WebElement getExpirationUl(){
        return expirationUl;
    }

    public PastebinHomePage selectTenMinExpiration() {
        tenMinExpirationLi.click();
        return this;
    }

    public PastebinHomePage enterTitle(String title) {
        titleInput.clear();
        titleInput.sendKeys(title);
        return this;
    }

    public void clickOnSubmitBtn() {
        submitBtn.click();
    }
}
