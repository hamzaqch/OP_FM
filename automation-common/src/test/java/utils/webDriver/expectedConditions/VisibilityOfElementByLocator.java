package utils.webDriver.expectedConditions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VisibilityOfElementByLocator extends BaseWait<Boolean, By> {

    public VisibilityOfElementByLocator(By input) {
        super(input);
    }

    @Override
    public Boolean apply(WebDriver driver) {
        try {
            return fluentWait(driver).until(ExpectedConditions.visibilityOfElementLocated(input)).isDisplayed();
        }
        catch (NoSuchElementException | StaleElementReferenceException message) {
            return driver.findElement(input).isDisplayed();
        }
        catch (Throwable e) {
            throw new Error(e);
        }
    }
}
