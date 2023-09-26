package utils.webDriver;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class DriverFactory implements Setup{
    DriverManager manager = new DriverManager();
    @Override
    public void setupDriver(@NotNull Browser browser, boolean headless) {
        manager.setupDriver(browser, headless);
    }
    @Override
    public WebDriver getDriver() {
        return manager.getDriver();
    }

    @Override
    public void closeDriver() {
        manager.closeDriver();
    }
}
