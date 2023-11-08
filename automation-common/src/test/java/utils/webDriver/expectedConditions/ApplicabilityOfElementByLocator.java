package utils.webDriver.expectedConditions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ApplicabilityOfElementByLocator extends BaseWait<WebElement, By> {

    public ApplicabilityOfElementByLocator(By input) {
        super(input);
    }

    @Override
    public WebElement apply(WebDriver driver) {
        try {
            return fluentWait(driver).until(ExpectedConditions.visibilityOfElementLocated(input));
        }
        catch (NoSuchElementException | StaleElementReferenceException message) {
            return driver.findElement(input);
        }
        catch (Throwable e) {
            throw new Error(e);
        }
    }
}
