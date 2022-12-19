package com.jpetstore.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Util Helper class.
 */
public class Helper {

    /**
     * Method to return variable which determines WebDriver Manager usage.
     * TRUE value determine to use binary from the WebDriver Manager,
     * FAlSE value determine to use binary that is present in the project.
     *
     * @return TRUE or FALSE
     */
    public static boolean isWebDriverManager() {

        return PropertyReader.getInstance()
                             .getPropertyValueByKey(
                                     PropKey.BROWSER_MANAGER.getPropVal())
                             .equalsIgnoreCase("webDriverManager");

    }

    /**
     * Method to obtain app url from 'config.property' file
     *
     * @return String Application URL
     */
    public static String getAppUrl() {

        String baseUrl = PropertyReader.getInstance()
                                       .getPropertyValueByKey(PropKey.URL.getPropVal());
        String port = PropertyReader.getInstance()
                                    .getPropertyValueByKey(PropKey.PORT.getPropVal());

        return baseUrl + port;
    }


    /**
     * Method to get value of variable 'screenshot' from property file.
     * Determines whether screenshot functionality should be enabled or disabled.
     *
     * @param driver
     * @param name   Screenshot name
     * @return TRUE or FALSE
     */
    public static synchronized boolean takeScreenshot(WebDriver driver, String name) {
        boolean isScreenshot = PropertyReader.getInstance()
                                             .getPropertyValueByKey(PropKey.SCREENSHOT.getPropVal())
                                             .equalsIgnoreCase("ENABLE");

        if (isScreenshot) {

            attachScreenshot(driver, name);
            return true;
        }
        return false;
    }

    /**
     * Method to take screenshot and attach to Allure report
     *
     * @param driver WebDriver
     * @param name   Screenshot name
     * @return Screenshot in bytes form
     */
    @Attachment(value = "{name}", type = "image/png")
    private static synchronized byte[] attachScreenshot(WebDriver driver,
                                                        String name) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    /**
     * Method to get value of variable 'elementScreenshot' from property file.
     * Determines whether element screenshot functionality should be enabled or disabled.
     *
     * @param element WebElement
     * @param name    Screenshot name
     * @return TRUE or FALSE
     */
    public static synchronized boolean takeElementScreenshot(WebElement element,
                                                             String name) {

        String getElementScreenShot = SystemPropertyHelper
                .getElementScreenshotValue();

        if (getElementScreenShot.equalsIgnoreCase("ENABLE")) {
            attachElementScreenshot(element, name);
            return true;
        }
        return false;
    }

    /**
     * Method to take Element screenshot and attach to Allure report
     *
     * @param element WebElement
     * @param name    Element screenshot name
     * @return Element Screenshot in bytes form
     */
    @Attachment(value = "{name}", type = "image/png")
    private static synchronized byte[] attachElementScreenshot(WebElement element,
                                                               String name) {
        return element.getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Method to return variable of remote variable from 'config.properties' file.
     *
     * @return TRUE or FALSE
     */
    public static boolean isRemote() {
        String isRemote = SystemPropertyHelper.getRemoteVal();

        if (isRemote.equalsIgnoreCase("TRUE")) {
            return true;
        }
        return false;
    }

    /**
     * Method to get Hub Url variable from 'config.property' file or system property if defined
     * @return String Hub URL
     */
    public static String getHubUrl() {

        return SystemPropertyHelper.getHubUrl();
    }

}
