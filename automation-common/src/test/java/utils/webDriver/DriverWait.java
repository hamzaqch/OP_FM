package utils.webDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class DriverWait {

    private final long delay;
    private  final DriverManager driverManager ;

    public DriverWait() {
        this.driverManager = new DriverManager();
        this.delay = delayInSeconds(5);
    }

    public long delayInSeconds(long delay) {
        try {
            Thread.sleep(delay * 1000); // Sleep for 'seconds' seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
        return this.delay;
    }

    protected Wait<WebDriver> waitLong() {
        //TODO: delayInSeconds(2);
        return new FluentWait<>(driverManager.getDriver())
                .withTimeout(Duration.ofSeconds(Constants.timeoutLong))
                .pollingEvery(Duration.ofSeconds(Constants.pollingLong))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    protected Wait<WebDriver> waitShort() {
        //TODO: delayInSeconds(1);
        return new FluentWait<>(driverManager.getDriver())
                .withTimeout(Duration.ofSeconds(Constants.timeoutShort))
                .pollingEvery(Duration.ofSeconds(Constants.pollingShort))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    private void waitForElementVisible(WebElement element) throws NoSuchFieldException {
        try {
            waitLong().until(ExpectedConditions.visibilityOf(element));
        }
        catch (Exception message) {
            throw new NoSuchFieldException("Element is not visible " + element + " @ " + message.getMessage());
        }
    }

    private void waitForElementVisibleByLocator(By accessType) throws NoSuchFieldException {
        try {
            waitLong().until(ExpectedConditions.visibilityOfElementLocated(accessType));
        }
        catch (Exception message) {
            throw new NoSuchFieldException("Element is not visible " + accessType + " @ " + message.getMessage());
        }
    }

    private void waitForElementClickable(WebElement element) throws NoSuchFieldException {
        try {
            waitLong().until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (Exception message) {
            throw new NoSuchFieldException("Could not interact with the element " + element + " @ " + message.getMessage());
        }
    }

    private void waitForElementClickableByLocator(By accessType) throws NoSuchFieldException {
        try {
            waitLong().until(ExpectedConditions.elementToBeClickable(accessType));
        }
        catch (Exception message) {
            throw new NoSuchFieldException("Could not interact with the element by locator " + accessType + " @ " + message.getMessage());
        }
    }

    public void waitForElementToLoad(WebElement element) throws NoSuchFieldException {
        waitForElementVisible(element);
        waitForElementClickable(element);
    }

    public void waitForElementToLoad(By accessType) throws NoSuchFieldException {
        waitForElementVisibleByLocator(accessType);
        waitForElementClickableByLocator(accessType);
    }
}
