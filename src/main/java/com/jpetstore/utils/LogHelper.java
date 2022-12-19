package com.jpetstore.utils;

import io.qameta.allure.Step;

/**
 * Util LogHelper class.
 */
public class LogHelper {

    /**
     * Method to log step information to reports
     *
     * @param message
     * @return TRUE or FALSE
     */
    public static synchronized boolean logToReport(String message) {

        boolean isLogEnabled = PropertyReader.getInstance()
                                             .getPropertyValueByKey(PropKey.ALLURE_REPORT_STEP_LOG.getPropVal())
                                             .equalsIgnoreCase("ENABLED");

        if (isLogEnabled) {
            logToAllureReport(message);
            return true;
        }

        return false;
    }

    @Step("{0}")
    private static synchronized void logToAllureReport(String message) {

    }
}
