package utils.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.webDriver.DriverManager;
import utils.webDriver.DriverWait;

public abstract class Config {
    protected Config() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driverManager.getDriver(), 10), this);
    }

    private final DriverManager driverManager = new DriverManager();

    private final DriverWait driverWait = new DriverWait(driverManager,1);

    protected WebDriver getDriver() {
        return driverManager.getDriver();
    }

    protected DriverWait getDriverWait() {
        return driverWait;
    }

    protected void setDelay(long delay) {
        driverWait.delayInSeconds(delay);
    }
}
