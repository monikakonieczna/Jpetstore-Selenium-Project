package com.jpetstore.core;

import com.jpetstore.utils.PropertyReader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * DriverManager class. Extends DriverFactory class.
 */
public class DriverManager extends DriverFactory {

    @BeforeAll
    public static void setUp() {

        prop = PropertyReader.getInstance();
        driver = getDriver();
    }

    @AfterAll
    public static void tearDown() {

        driver = null;
        quitDriver();
    }

    @BeforeEach
    public void beforeEachMethod() {
        getDriver().manage()
                   .deleteAllCookies();
        getDriver().manage()
                   .window()
                   .maximize();

    }
}
