package com.jpetstore.utils;

/**
 * Utils PropKey class.
 */
public enum PropKey {
    URL("url"),
    PORT("port"),
    BROWSER("browser"),
    BROWSER_MANAGER("browserManager"),

    /**
     * Driver Paths
     */

    CHROME_DRIVER_PATH_WIN("chromeDriverPathWin"),
    GECKO_DRIVER_PATH_WIN("geckoDriverPathWin"),
    IE_DRIVER_PATH_WIN("ieDriverPathWin"),

    CHROME_DRIVER_PATH_OSX("chromeDriverPathOsx"),
    GECKO_DRIVER_PATH_OSX("geckoDriverPathOsx"),

    /**
     * Timeouts
     */
    IMPLICIT_WAIT("implicitWait"),
    EXPLICIT_WAIT("explicitWait"),
    DRIVER_TIMEOUT("driverTimeout"),
    POLLING("polling"),

    /**
     * Allure
     */
    ALLURE_REPORT_STEP_LOG("allureReportStepLog"),

    /**
     * Screenshot
     */
    SCREENSHOT("screenshot"),
    ELEMENT_SCREENSHOT("elementScreenshot"),

    /**
     * Selenium Grid
     */

    REMOTE("remote"),
    HUB_URL("hubUrl");

    private String propVal;

    PropKey(String propVal) {
        this.propVal = propVal;
    }

    public String getPropVal() {
        return propVal;
    }
}
