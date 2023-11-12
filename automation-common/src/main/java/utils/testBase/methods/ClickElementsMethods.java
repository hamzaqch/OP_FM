package utils.testBase.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.config.Config;

public class ClickElementsMethods extends Config {

    private WebElement element;

    /**
     * Method to click On the WebElement by element
     * @param element : WebElement
     */
    public void click(WebElement element) {
        this.element = getDriverWait().waitShort().until(ExpectedConditions.elementToBeClickable(element));
        this.element.click();
    }

    /**
     * Method to click On the WebElement by locator
     * @param accessType : By
     */
    public void click(By accessType) {
        element = getDriverWait().waitShort().until(ExpectedConditions.presenceOfElementLocated(accessType));
        element.click();
    }

    /**
     * Method to Force click On the WebElement by element Using JavascriptExecutor
     * @param element : WebElement
     */
    public void clickForcefully(WebElement element) {
        this.element  = getDriverWait().waitShort().until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", this.element);
    }

    /**
     * Method to Force click On the WebElement by locator Using JavascriptExecutor
     * @param accessType : By
     */
    public void clickForcefully(By accessType) {
        element  = getDriverWait().waitShort().until(ExpectedConditions.presenceOfElementLocated(accessType));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Method to double-click On the WebElement by element Using Action Class
     * @param element : WebElement
     */
    public void doubleClick(WebElement element) {
        this.element = getDriverWait().waitShort().until(ExpectedConditions.elementToBeClickable(element));
        Actions action = new Actions(getDriver());
        action.moveToElement(this.element).doubleClick().build().perform();
    }

    /**
     * Method to double-click On the WebElement by locator Using Action Class
     * @param accessType : By
     */
    public void doubleClick(By accessType) {
        element = getDriverWait().waitShort().until(ExpectedConditions.presenceOfElementLocated(accessType));
        Actions action = new Actions(getDriver());
        action.moveToElement(element).doubleClick().build().perform();
    }


}