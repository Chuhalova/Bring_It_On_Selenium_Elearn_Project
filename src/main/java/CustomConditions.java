import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {
    public static ExpectedCondition<Boolean> jQueryAJAXCompleted() {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return (Boolean) ((JavascriptExecutor)
                        webDriver).executeScript("return (window.jQuery != null) && (jQuery.active == 0); ");
            }
        };
    }
}
