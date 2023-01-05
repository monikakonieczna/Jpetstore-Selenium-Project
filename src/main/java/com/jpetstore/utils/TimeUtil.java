package com.jpetstore.utils;

/**
 * Util TimeUtil class which helps in retrieving time variables values from property file.
 */
public class TimeUtil {

    /**
     * Method to return implicit wait from config.properties file
     *
     * @return Implicit wait value as long (used in program as Duration in seconds)
     */
    public static long getImplicitWait() {
        return Long.parseLong(PropertyReader.getInstance()
                                            .getPropertyValueByKey(PropKey.IMPLICIT_WAIT.getPropVal()));
    }

    /**
     * Method to return Duration in seconds for Driver timeout from config.properties file
     *
     * @return Driver timeout as long (used in program as Duration in seconds)
     */
    public static long getDriverTimeout() {
        return Long.parseLong(PropertyReader.getInstance()
                                            .getPropertyValueByKey(PropKey.DRIVER_TIMEOUT.getPropVal()));
    }

    /**
     * Method to return value of Polling for Explicit Wait in seconds from config.properties file
     *
     * @return Driver Polling as long (used in program as Duration in seconds)
     */
    public static long getPolling() {
        return Long.parseLong(PropertyReader.getInstance()
                                            .getPropertyValueByKey(PropKey.POLLING.getPropVal()));
    }
}
