package utils.testBase;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.config.Config;

import java.io.File;

public class ScreenShotMethods extends Config {
    public void takeScreenShot() {
        File screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
    }
}
