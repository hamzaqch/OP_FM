package utils.testBase;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.config.Config;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ScreenShotMethods extends Config {

    /**
     * Method to take Screen Shot and Save it in Project Folder
     * @throws IOException
     */
    public void takeScreenShot() throws IOException {
        File screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy-HH:mm:ss", Locale.ENGLISH);
        Calendar calendar = Calendar.getInstance();
        FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir") + "/ScreenShots" + dateFormat.format(calendar.getTime()) + ".png"));
    }
}
