package utils.webDriver.expectedConditions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VisibilityOfElement extends BaseWait<Boolean, WebElement> {

    public VisibilityOfElement(WebElement input) {
        super(input);
    }

    @Override
    public Boolean apply(WebDriver driver) {
        try {
            return fluentWait(driver).until(ExpectedConditions.visibilityOf(input)).isDisplayed();
        }
        catch (NoSuchElementException | StaleElementReferenceException message) {
            return input.isDisplayed();
        }
        catch (Throwable e) {
            throw new Error(e);
        }
    }

}
