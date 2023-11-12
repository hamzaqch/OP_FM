package utils.webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

    /**
     * Method to select the type of Browsers you want to run
     */
    private static WebDriver setupDriver() {
        if (System.getProperty("os.name").equalsIgnoreCase(SystemPlatform.LINUX.name())) {
            SystemPlatform linux = SystemPlatform.LINUX;
        } else if (System.getProperty("os.name").equalsIgnoreCase(SystemPlatform.WINDOWS.name())) {
            SystemPlatform linux = SystemPlatform.WINDOWS;
        }
        driver = new ChromeDriver(getChromeOptions(false));
        setDriver(driver);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        //closeDriver();
    return driver;
    }

    /**
     * Method to set ChromeOptions
     */
    private static ChromeOptions getChromeOptions(Boolean setHeadless) {
        ChromeOptions chromeOptions = new ChromeOptions();;
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("window-size=1920,1080");
        chromeOptions.addArguments("-incognito");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");
        if (setHeadless == true) chromeOptions.addArguments("--headless");
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
