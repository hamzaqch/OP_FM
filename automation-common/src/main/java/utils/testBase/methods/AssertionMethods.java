package utils.testBase.methods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.config.Config;

public class AssertionMethods extends Config {

    private WebElement element = null;
    private Select select = null;

    /**
     * Method to get Page Title
     * @return String
     */
    public  String getPageTitle() {
        return getDriver().getTitle();
    }

    /**
     * Method to get WebElement Text
     * @param element : WebElement
     * @return String
     */
    public String getElementText(WebElement element) {
        return getDriverWait().waitShort()
                .until(ExpectedConditions.visibilityOf(element)).getText();
    }

}
