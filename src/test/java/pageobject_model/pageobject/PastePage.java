package pageobject_model.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class PastePage extends BasePage {
    @FindBy(xpath = "//div[@class='info-top']/h1")
    private WebElement newPastesTitle;

    @FindBy(className = "li1")
    private WebElement newPastesCodeText;

    @FindBy(className = "expire")
    private WebElement newExpireTime;

    public PastePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getNewPastesTitleElement() {
        return newPastesTitle;
    }

    public String getNewPastesTitle() {
        return newPastesTitle.getText();
    }

    public String getNewPastesCodeText() {
        return newPastesCodeText.getText();
    }

    public String getNewExpireTime() {
        return newExpireTime.getText().toLowerCase(Locale.ROOT);
    }
}
