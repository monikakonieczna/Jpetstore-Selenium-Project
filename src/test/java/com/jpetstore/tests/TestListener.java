package com.jpetstore.tests;

import com.jpetstore.core.DriverManager;
import com.jpetstore.utils.Helper;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestListener extends DriverManager implements TestWatcher {

    @Override
    public void testDisabled(ExtensionContext extensionContext, Optional<String> reason) {
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
    }

    @Override
    public void testAborted(ExtensionContext extensionContext, Throwable cause) {
    }

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable cause) {

        Helper.takeScreenshot(driver, extensionContext.getDisplayName());
    }


}
