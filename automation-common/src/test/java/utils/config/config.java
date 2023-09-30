package utils.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.webDriver.DriverManager;
import utils.webDriver.DriverWait;

public abstract class config {
    private final DriverManager driverManager = new DriverManager();
    private final DriverWait driverWait = new DriverWait();

    protected config() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }
    protected WebDriver getDriver() {
        return driverManager.getDriver();
    }
    protected void setDelay(long delay) {
        driverWait.delayInSeconds(delay);
    }
}
