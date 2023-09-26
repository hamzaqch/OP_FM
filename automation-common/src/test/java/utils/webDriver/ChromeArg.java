package utils.webDriver;

public abstract class ChromeArg {
     /**
      * Some Options to add as an argument for ChromeOption Class
      */
     protected static final String setRemoteAllowOrigin = "--remote-allow-origins=*";
     protected static final String setWindowSizeTo1920By1080 = "window-size=1920,1080";
     protected static final String setIncognito = "-incognito";
     protected static final String setSizeMaximized = "start-maximized";
     protected static final String setDisableExtensions = "--disable-extensions";
     protected static final String setNoSandbox = "--no-sandbox";
     protected static final String setHeadless = "--headless";
}
