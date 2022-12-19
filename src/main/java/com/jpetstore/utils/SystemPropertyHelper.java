package com.jpetstore.utils;

import com.jpetstore.core.BrowserType;

/**
 * Util SystemPropertyHelper class which helps in getting system properties values.
 */
public class SystemPropertyHelper {

    /**
     * Method to get value for elementScreenshot.
     *
     * @return value of elementScreenshot property: [ENABLE, DISABLE]
     */
    public static String getElementScreenshotValue() {
        StringBuffer msg = new StringBuffer();
        String valueFromPropFile = PropertyReader.getInstance()
                                                 .getPropertyValueByKey(PropKey.ELEMENT_SCREENSHOT.getPropVal());

        String valueFromSystemVariable = System.getProperty("elementScreenshot");

        if (valueFromSystemVariable.length() > 0) {

            if (valueFromSystemVariable.equalsIgnoreCase("ENABLE") ||
                    valueFromSystemVariable.equalsIgnoreCase("DISABLE")) {

                return valueFromSystemVariable;
            }
            else {

                msg.append("Incorrect system property ")
                   .append(valueFromSystemVariable)
                   .append(" value specified for")
                   .append(PropKey.ELEMENT_SCREENSHOT.getPropVal())
                   .append(" ...defaulting to property provided by the config.properties file ")
                   .append(PropKey.ELEMENT_SCREENSHOT.getPropVal())
                   .append(" : ")
                   .append(valueFromPropFile);
                System.out.println(msg);

            }
        }

        msg.append("No system property specified" + " ...defaulting to config.properties file ->  ")
           .append(PropKey.ELEMENT_SCREENSHOT.getPropVal())
           .append(" : ")
           .append(valueFromPropFile);

        System.out.println(msg);
        return valueFromPropFile;

    }

    /**
     * Method to get browser from system variable
     * @return BrowserType: [Chrome, Firefox, Internet Explorer, null]
     */
    public static BrowserType getBrowserFromSystemVariable() {

        String browser = System.getProperty(PropKey.BROWSER.getPropVal());

        if (browser.length() == 0) browser = PropertyReader.getInstance()
                                                           .getPropertyValueByKey(PropKey.BROWSER.getPropVal());


        if (browser.equalsIgnoreCase("CHROME")) {
            return BrowserType.CHROME;
        }
        else
            if (browser.equalsIgnoreCase("FIREFOX")) {

                return BrowserType.FIREFOX;
            }
            else
                if (browser.equalsIgnoreCase("IE")) {
                    return BrowserType.IE;
                }
                else {
                    return null;
                }


    }


    /**
     * Get is Remote Value.
     *
     * @return boolean value [TRUE, FALSE]
     */
    public static String getRemoteVal() {

        StringBuffer msg = new StringBuffer();

        String valueFromPropFile = PropertyReader.getInstance()
                                                 .getPropertyValueByKey(PropKey.REMOTE.getPropVal());

        String remoteVal = System.getProperty(PropKey.REMOTE.getPropVal());

        if (remoteVal.length() > 0) {
            if (remoteVal.equalsIgnoreCase("TRUE") ||
                    remoteVal.equalsIgnoreCase("FALSE")) {

                return remoteVal;
            }
            else {
                msg.append("Incorrect system property ")
                   .append(remoteVal)
                   .append(" value specified for")
                   .append(PropKey.REMOTE.getPropVal())
                   .append(" ...defaulting to property provided by the config.properties file ")
                   .append(PropKey.REMOTE.getPropVal())
                   .append(" : ")
                   .append(valueFromPropFile);

                System.out.println(msg);
            }
        }

        msg.append("No system property specified" + " ...defaulting to config.properties file ->  ")
           .append(PropKey.REMOTE.getPropVal())
           .append(" : ")
           .append(valueFromPropFile);

        System.out.println(msg);

        return valueFromPropFile;
    }


    /**
     * Get Hub Url
     *
     * @return Hub URL
     */
    public static String getHubUrl() {

        String hubUrl = System.getProperty(PropKey.HUB_URL.getPropVal());

        if (hubUrl.length() > 0) {
            return hubUrl;
        }

        return PropertyReader.getInstance()
                             .getPropertyValueByKey(PropKey.HUB_URL.getPropVal());
    }

}
