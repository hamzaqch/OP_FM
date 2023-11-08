package utils.webDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.webDriver.expectedConditions.*;

import java.time.Duration;

public class DriverWait {

    private final long delay;
    private  final DriverManager driverManager ;

    public DriverWait(DriverManager driverManager, long delay) {
        this.driverManager = driverManager;
        this.delay = delayInSeconds(delay);
    }

    /**
     * Method to add a Delay Time to the WebDriver By holding the current running Thread
     * @param delay : long
     */
    public long delayInSeconds(long delay) {
        try {
            Thread.sleep(delay * 1000); // Sleep for 'seconds' seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
        return this.delay;
    }

    /**
     * Method to add long WaitTime to WebDriver
     */
    public Wait<WebDriver> waitLong() {
        return new FluentWait<>(driverManager.getDriver())
                .withTimeout(Duration.ofSeconds(Constants.timeoutLong))
                .pollingEvery(Duration.ofSeconds(Constants.pollingLong))
                .ignoring(StaleElementReferenceException.class, ElementClickInterceptedException.class);
    }

    /**
     * Method to add short WaitTime to WebDriver
     */
    public Wait<WebDriver> waitShort() {
        return new FluentWait<>(driverManager.getDriver())
                .withTimeout(Duration.ofSeconds(Constants.timeoutShort))
                .pollingEvery(Duration.ofSeconds(Constants.pollingShort))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    /**
     * Method to Wait for the Element to be Visible WebElement
     * @param element : WebElement
     * @throws NoSuchFieldException
     */
    private void waitForElementVisible(WebElement element) throws NoSuchFieldException {
        try {
            waitLong().until(new VisibilityOfElement(element));
        }
        catch (Exception message) {
            throw new NoSuchFieldException("Element is not visible " + element + " @ " + message.getMessage());
        }
    }

    /**
     * Method to Wait for the Element to be Visible By Locators
     * @param accessType : By : Locator type (id, name, class, xpath, css)
     * @throws NoSuchFieldException
     */
    private void waitForElementVisibleByLocator(By accessType) throws NoSuchFieldException {
        try {
            waitLong().until(new VisibilityOfElementByLocator(accessType));
        }
        catch (Exception message) {
            throw new NoSuchFieldException("Element is not visible " + accessType + " @ " + message.getMessage());
        }
    }

    /**
     * Method to Wait for the Element to be Clickable WebElement
     * @param element : WebElement
     * @throws NoSuchFieldException
     */
    private void waitForElementClickable(WebElement element) throws NoSuchFieldException {
        try {
            waitLong().until(new ApplicabilityOfElement(element));
        }
        catch (Exception message) {
            throw new NoSuchFieldException("Could not interact with the element " + element + " @ " + message.getMessage());
        }
    }

    /**
     * Method to Wait for the Element to be Clickable By Locators
     * @param accessType : By : Locator type (id, name, class, xpath, css)
     * @throws NoSuchFieldException
     */
    private void waitForElementClickableByLocator(By accessType) throws NoSuchFieldException {
        try {
            waitLong().until(new ApplicabilityOfElementByLocator(accessType));
        }
        catch (Exception message) {
            throw new NoSuchFieldException("Could not interact with the element by locator " + accessType + " @ " + message.getMessage());
        }
    }

    /**
     * Method to Wait for the Element to Load WebElement
     * @param element : WebElement
     * @throws NoSuchFieldException
     */
    public void waitForElementToLoad(WebElement element) throws NoSuchFieldException {
        waitForElementVisible(element);
        waitForElementClickable(element);
    }

    /**
     * Method to Wait for the Element to Load By Locators
     * @param accessType : By : Locator type (id, name, class, xpath, css)
     * @throws NoSuchFieldException
     */
    public void waitForElementToLoad(By accessType) throws NoSuchFieldException {
        waitForElementVisibleByLocator(accessType);
        waitForElementClickableByLocator(accessType);
    }
}
