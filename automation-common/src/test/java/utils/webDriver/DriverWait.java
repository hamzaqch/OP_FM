package utils.webDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverWait {

    private final WebDriverWait webDriverWait;
    private final long delay;

    public DriverWait() {
        DriverFactory driverFactory = new DriverFactory();
        this.webDriverWait = new WebDriverWait(driverFactory.getDriver(),Duration.ofSeconds(3));
        this.delay = delayInSeconds(5);
    }
    public WebDriverWait getWebDriverWait(WebElement element) {
        this.webDriverWait.until(ExpectedConditions.visibilityOf(element));
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        return this.webDriverWait;
    }

    private long delayInSeconds(long delay) {
        try {
            Thread.sleep(delay * 1000); // Sleep for 'seconds' seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
        return this.delay;
    }
}
