package com.jpetstore.core;

import com.jpetstore.utils.PropKey;
import com.jpetstore.utils.PropertyReader;
import com.jpetstore.utils.SystemPropertyHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.jpetstore.utils.Helper.getHubUrl;
import static com.jpetstore.utils.Helper.isRemote;
import static com.jpetstore.utils.TimeUtil.getImplicitWait;

/**
 * DriverFactory class
 */
public class DriverFactory {

    public static PropertyReader prop;

    protected static WebDriver driver = null;

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();


    /**
     * Static method to get WebDriver Type.
     * Returns the WebDriver instance in the current thread's copy of this thread-local variable.
     * This method can return ChromeDriver, GeckoDriver, IEDriver or RemoteWebDriver dependently of set values of variables: remote, browser.
     *
     * @return WebDriver [ChromeDriver, GeckoDriver, IEDriver, RemoteWebDriver]
     */
    public static WebDriver getDriver() {

        if (driver == null) {

            if (isRemote()) {
                try {
                    driverThreadLocal.set(new RemoteWebDriver(new URL(getHubUrl()),
                            getBrowser().getBrowserCapabilities()));

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            else {
                driverThreadLocal.set(getBrowser().getWebDriver());
            }
        }

        driverThreadLocal.get()
                         .manage()
                         .timeouts()
                         .implicitlyWait(Duration.ofSeconds(getImplicitWait()));

        return driverThreadLocal.get();
    }


    /**
     * Static method to quit WebDriver
     */
    public static void quitDriver() {
        driverThreadLocal.get()
                         .quit();
    }


    /**
     * Determine browser based on property file or system variable value if determined.
     * This method can return BrowserType such as Chrome, Firefox or Internet Explorer.
     * If there is no browser value set in system variable and in 'config.properties' file
     * default BrowserType will be returned, which is CHROME BrowserType.
     *
     * @return BrowserType: [Chrome, Firefox, Internet Explorer]
     */
    private static BrowserType getBrowser() {

        BrowserType browserType = SystemPropertyHelper.getBrowserFromSystemVariable();

        if (browserType != null) {
            return browserType;
        }
        else {

            if (prop.getPropertyValueByKey(PropKey.BROWSER.getPropVal())
                    .equalsIgnoreCase("CHROME")) {

                return BrowserType.CHROME;
            }
            else
                if (prop.getPropertyValueByKey(PropKey.BROWSER.getPropVal())
                        .equalsIgnoreCase("FIREFOX")) {

                    return BrowserType.FIREFOX;
                }
                else
                    if (prop.getPropertyValueByKey(PropKey.BROWSER.getPropVal())
                            .equalsIgnoreCase("IE")) {

                        return BrowserType.IE;
                    }
                    else {
                        return BrowserType.CHROME;
                    }
        }
    }
}
