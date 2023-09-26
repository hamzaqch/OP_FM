package utils.webDriver;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public interface Setup {
    void setupDriver(@NotNull Browser browser, boolean headless);
    WebDriver getDriver();
    void closeDriver();
}
