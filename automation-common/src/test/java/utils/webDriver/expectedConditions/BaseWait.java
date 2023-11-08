package utils.webDriver.expectedConditions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.webDriver.Constants;

import java.time.Duration;

public abstract class BaseWait<T,K> implements ExpectedCondition<T> {

    protected final K input;

    public BaseWait(K input) {
        this.input = input;
    }


    protected synchronized Wait<WebDriver> fluentWait(WebDriver driver) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(Constants.timeoutShort))
                .pollingEvery(Duration.ofSeconds(Constants.pollingShort))
                .ignoring(NoSuchElementException.class, NoSuchElementException.class);
        return wait;
    }

}
