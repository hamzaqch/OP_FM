package utils.testBase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.config.Config;

public class BaseTest extends Config {

    @BeforeClass
    public void setupTest() {
        getDriver();
    }

    @AfterClass
    public void tearDown() {
        getDriver().manage().deleteAllCookies();
    }

}
