package utils.webDriver.expectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InVisibilityOfElementByLocator extends BaseWait<Boolean, By> {
    protected InVisibilityOfElementByLocator(By input) {
        super(input);
    }

    @Override
    public Boolean apply(WebDriver driver) {
        try {
            return fluentWait(driver).until(ExpectedConditions.invisibilityOfElementLocated(input));
        }
        catch (NoSuchElementException | StaleElementReferenceException message) {
            return true;
        }
        catch (Throwable e) {
            throw new Error(e);
        }

    }
}
