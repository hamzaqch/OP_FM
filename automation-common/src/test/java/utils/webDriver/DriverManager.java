package utils.webDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * DriverManager Class it generate a driver base on the configuration you set
 */
public class DriverManager implements Setup{
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

    /**
     * Method to select the type of Browser you want to run
     * @param browser: For now can CHROME or FIREFOX
     * @param headless: True to run headless or False for not
     */
    @Override
    public void setupDriver(@NotNull Browser browser, boolean headless) {
    switch (browser) {
        case CHROME:
            WebDriverManager.chromedriver().setup();
            getChromeOptions(headless);
            driver = new ChromeDriver(chromeOptions);
            break;
        case FIREFOX:
            WebDriverManager.firefoxdriver().setup();
            firefoxOptions.setHeadless(headless);
            driver = new FirefoxDriver(firefoxOptions);
            break;
    }
    setDriver();
    }

    /**
     * Method to set ChromeOptions
     * @param headless: True to run headless or False for not
     */
    @NotNull
    private static ChromeOptions getChromeOptions(boolean headless) {

        chromeOptions.addArguments(ChromeArg.setRemoteAllowOrigin);
        chromeOptions.addArguments(ChromeArg.setNoSandbox);
        chromeOptions.addArguments(ChromeArg.setSizeMaximized);
        if (headless) {
            chromeOptions.addArguments(ChromeArg.setHeadless);
        }
        return chromeOptions;
    }

    /**
     * Method to set instance of the Driver
     */
    private static void setDriver() {
        thread_instanceOfDriver.set(driver);
    }

    /**
     * Method to get an instance of the Driver
     * @return
     */
    @Override
    public WebDriver getDriver() {
        return thread_instanceOfDriver.get();
    }

    /**
     * Method to close the Driver
     */
    @Override
    public void closeDriver() {
        Runtime.getRuntime().addShutdownHook(close_Thread);
    }



}
