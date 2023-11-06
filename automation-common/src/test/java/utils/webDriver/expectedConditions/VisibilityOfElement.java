package utils.webDriver.expectedConditions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VisibilityOfElement extends BaseWait implements ExpectedCondition<WebElement> {

    private final WebElement element;

    public VisibilityOfElement(WebElement element) {
        this.element = element;
    }

    @Override
    public WebElement apply(WebDriver driver) {
        try {
            return fluentWait(driver).until(ExpectedConditions.visibilityOf(element));
        }
        catch (NoSuchElementException | StaleElementReferenceException message) {
            return element;
        }
        catch (Throwable e) {
            throw new Error(e);
        }
    }
}
