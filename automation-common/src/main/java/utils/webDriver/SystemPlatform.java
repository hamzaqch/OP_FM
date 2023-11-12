package utils.webDriver;

public enum SystemPlatform {

    LINUX {
        @Override
        String setProperty() {
            return System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")  + "/drivers/chromedriver_linux");
        }
    },
    WINDOWS {
        @Override
        String setProperty() {
            return null;
        }
    };

    SystemPlatform() {
    this.setProperty();
    }

    abstract String setProperty();
}
