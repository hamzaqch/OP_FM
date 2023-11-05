package utils.webDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.WebDriverListener;

/**
 * DriverManager Class it generate a driver base on the configuration you set
 */
public class DriverManager {
    /**
     * Create a local thread-safe code by given the interface @WebDriver as and input
     */
    private static final ThreadLocal<WebDriver> thread_instanceOfDriver = new ThreadLocal<>();
    private static final Thread close_Thread = new Thread() {
        public void run() {
            driver.quit();
        }
    };
    /**
     * Declare a static object fo the class @WebDriver
     */
    private static WebDriver driver;
    private static final ChromeOptions chromeOptions = new ChromeOptions();
    private static final FirefoxOptions firefoxOptions = new FirefoxOptions();
    private static final boolean headless = false;
    /**
     * Method to select the type of Browsers you want to run
     */
    private static WebDriver setupDriver() {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")  + "/chromedriver");
            driver = new ChromeDriver(getChromeOptions());
        setDriver(driver);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        closeDriver();
    return driver;
    }

    /**
     * Method to set ChromeOptions
     */

    private static ChromeOptions getChromeOptions() {
        chromeOptions.addArguments(Chrome.CHROME.setRemoteAllowOrigin());
        chromeOptions.addArguments(Chrome.CHROME.setNoSandbox());
        chromeOptions.addArguments(Chrome.CHROME.setSizeMaximized());
        if (headless) {
            chromeOptions.addArguments(Chrome.CHROME.setHeadless());
        }
        return chromeOptions;
    }

    /**
     * Method to set instance of the Driver
     */
    private static void setDriver(WebDriver driver) {
        thread_instanceOfDriver.set(driver);
    }

    /**
     * Method to get an instance of the Driver
     */
    public WebDriver getDriver() {
        if(thread_instanceOfDriver.get() != null) return thread_instanceOfDriver.get();
        else return getDefaultDriver();
    }

    private WebDriver getDefaultDriver() {
        if (thread_instanceOfDriver.get() != null) return thread_instanceOfDriver.get();
        driver = setupDriver();
        return getDriver();
    }

    /**
     * Method to close the Driver
     */
    private static void closeDriver() {
        Runtime.getRuntime().addShutdownHook(close_Thread);
    }

}
