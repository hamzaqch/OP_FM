package utils.webDriver;

public enum Chrome {
    CHROME (
        "--remote-allow-origins=*",
        "window-size=1920,1080",
        "-incognito",
        "start-maximized",
        "--disable-extensions",
        "--no-sandbox",
        "--headless"
    );

    private final String RemoteAllowOrigin;

    public String setRemoteAllowOrigin() {
        return RemoteAllowOrigin;
    }

    public String setWindowSizeTo1920By1080() {
        return WindowSizeTo1920By1080;
    }

    public String setIncognito() {
        return Incognito;
    }

    public String setSizeMaximized() {
        return SizeMaximized;
    }

    public String setDisableExtensions() {
        return DisableExtensions;
    }

    public String setNoSandbox() {
        return NoSandbox;
    }

    public String setHeadless() {
        return Headless;
    }

    private final String WindowSizeTo1920By1080;
    private final String Incognito;
    private final String SizeMaximized;
    private final String DisableExtensions;
    private final String NoSandbox;
    private final String Headless;

    Chrome(String setRemoteAllowOrigin, String setWindowSizeTo1920By1080, String setIncognito, String setSizeMaximized, String setDisableExtensions, String setNoSandbox, String setHeadless) {
        this.RemoteAllowOrigin = setRemoteAllowOrigin;
        this.WindowSizeTo1920By1080 = setWindowSizeTo1920By1080;
        this.Incognito = setIncognito;
        this.SizeMaximized = setSizeMaximized;
        this.DisableExtensions = setDisableExtensions;
        this.NoSandbox = setNoSandbox;
        this.Headless = setHeadless;
    }

}
