package com.jpetstore.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import static com.jpetstore.utils.Helper.isWebDriverManager;

/**
 * BrowserType Enum Class. Implements IDRiverSetup interface.
 */
public enum BrowserType implements IDriverSetup {

    CHROME {
        @Override
        public Capabilities getBrowserCapabilities() {
            Capabilities capabilities = getBrowserOptions();
            return capabilities;
        }

        @Override
        public ChromeOptions getBrowserOptions() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            return options;
        }

        @Override
        public WebDriver getWebDriver() {

            if (isWebDriverManager()) {
                WebDriverManager.chromedriver().setup();
            }
            else {
                System.setProperty("webdriver.chrome.driver", "");
            }
            ChromeOptions chromeOptions = getBrowserOptions();
            return new ChromeDriver(chromeOptions);
        }
    },

    FIREFOX {
        @Override
        public Capabilities getBrowserCapabilities() {
            Capabilities capabilities = getBrowserOptions();
            return capabilities;
        }

        @Override
        public FirefoxOptions getBrowserOptions() {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--private");
            return options;
        }

        @Override
        public WebDriver getWebDriver() {

            if (isWebDriverManager()) {
                WebDriverManager.firefoxdriver().setup();
            }
            else {
                System.setProperty("webdriver.gecko.driver", "");
            }
            FirefoxOptions options = getBrowserOptions();
            return new FirefoxDriver(options);

        }
    },

    IE {
        @Override
        public Capabilities getBrowserCapabilities() {
            Capabilities capabilities = getBrowserOptions();
            return capabilities;
        }

        @Override
        public InternetExplorerOptions getBrowserOptions() {
            InternetExplorerOptions options = new InternetExplorerOptions();
            return options;
        }

        @Override
        public WebDriver getWebDriver() {

            if (isWebDriverManager()) {
                WebDriverManager.iedriver().setup();
            }
            else {
                System.setProperty("webdriver.ie.driver", "");
            }
            InternetExplorerOptions options = getBrowserOptions();
            return new InternetExplorerDriver(options);

        }
    }
}
