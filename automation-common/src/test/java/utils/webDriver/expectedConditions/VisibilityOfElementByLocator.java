package utils.webDriver.expectedConditions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VisibilityOfElementByLocator extends BaseWait{

    private final By locator;

    public VisibilityOfElementByLocator(By locator) {
        this.locator = locator;
    }

    @Override
    public WebElement apply(WebDriver driver) {
        try {
            return fluentWait(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch (NoSuchElementException | StaleElementReferenceException message) {
            return driver.findElement(locator);
        }
        catch (Throwable e) {
            throw new Error(e);
        }
    }
}
