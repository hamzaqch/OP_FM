package utils.webDriver.expectedConditions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ApplicabilityOfElementByLocator extends BaseWait implements ExpectedCondition<WebElement> {
    private final By locator;

    public ApplicabilityOfElementByLocator(By locator) {
        this.locator = locator;
    }

    @Override
    public WebElement apply(WebDriver driver) {
        try {
            return fluentWait(driver).until(ExpectedConditions.elementToBeClickable(locator));
        }
        catch (NoSuchElementException | StaleElementReferenceException message) {
            return driver.findElement(locator);
        }
        catch (Throwable message) {
            throw new Error(message);
        }
    }
}
