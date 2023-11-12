package utils.webDriver.expectedConditions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ApplicabilityOfElement extends BaseWait<WebElement, WebElement> {

    public ApplicabilityOfElement(WebElement input) {
        super(input);
    }

    @Override
    public WebElement apply(WebDriver driver) {
        try {
            return fluentWait(driver).until(ExpectedConditions.elementToBeClickable(input));
        }
        catch (StaleElementReferenceException | NoSuchElementException message) {
            return input;
        }
        catch (Throwable e) {
            throw new Error(e);
        }
    }
}
