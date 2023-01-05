package com.jpetstore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * DashboardPage class extends BasePage.
 */
public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    private static final String GREETING_MSG = "//*[@id='WelcomeContent']";

    /**
     * Get greeting message.
     *
     * @return greeting message
     */
    public String getGreetingMessage() {
        return getTextFromElement(By.xpath(GREETING_MSG));
    }
}
