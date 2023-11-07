package utils.webDriver.expectedConditions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InVisibilityOfElement extends BaseWait<Boolean, WebElement> {
    protected InVisibilityOfElement(WebElement input) {
        super(input);
    }

    @Override
    public Boolean apply(WebDriver driver) {
        try {
            return fluentWait(driver).until(ExpectedConditions.invisibilityOf(input));
        }
        catch (NoSuchElementException | StaleElementReferenceException message) {
            return true;
        }
        catch (Throwable e) {
            throw new Error(e);
        }
    }
}
