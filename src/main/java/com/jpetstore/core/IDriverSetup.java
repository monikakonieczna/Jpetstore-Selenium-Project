package com.jpetstore.core;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

/**
 * IDriverSetup interface.
 */
public interface IDriverSetup {

    Capabilities getBrowserCapabilities();

    Object getBrowserOptions();

    WebDriver getWebDriver();


}
