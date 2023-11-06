package utils.webDriver.expectedConditions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.webDriver.Constants;

import java.time.Duration;

public abstract class BaseWait {


    protected Wait<WebDriver> fluentWait(WebDriver driver) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(Constants.timeoutShort))
                .pollingEvery(Duration.ofSeconds(Constants.pollingShort))
                .ignoring(NoSuchElementException.class, NoSuchElementException.class);
        return wait;
    }

}
