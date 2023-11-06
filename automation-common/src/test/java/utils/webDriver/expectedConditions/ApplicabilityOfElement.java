package utils.webDriver.expectedConditions;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.NoSuchElementException;

public class ApplicabilityOfElement extends BaseWait implements ExpectedCondition<WebElement> {

    private final WebElement element;
    public ApplicabilityOfElement(WebElement element) {
        this.element = element;

    }

    @Override
    public WebElement apply(WebDriver driver) {
        try {
            return fluentWait(driver).until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (StaleElementReferenceException | NoSuchElementException message) {
            return element;
        }
        catch (Exception message) {
            throw new Error(message);
        }
    }
}
