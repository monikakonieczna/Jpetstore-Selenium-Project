package com.jpetstore.pages;

import com.jpetstore.core.DriverManager;
import com.jpetstore.utils.Helper;
import com.jpetstore.utils.LogHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.jpetstore.utils.TimeUtil.getDriverTimeout;
import static com.jpetstore.utils.TimeUtil.getPolling;

/**
 * Abstract Page class. Extends DriverManager class.
 */
public abstract class Page extends DriverManager {

    private WebDriver driver = getDriver();

    /**
     * Method to find element by css selector
     *
     * @param cssLocator
     * @return WebElement found by css Selector
     */
    public WebElement findElementByCss(String cssLocator) {

        try {

            By by = By.cssSelector(cssLocator);

            WebDriverWait wait = new WebDriverWait(driver,
                    Duration.ofSeconds(getDriverTimeout()), Duration.ofSeconds(getPolling()));

            return wait
                    .until(ExpectedConditions.visibilityOfElementLocated(by));

        } catch (TimeoutException t) {
            throw new TimeoutException();
        }
    }

    /**
     * Method to find element by xpath
     *
     * @param xpathLocator
     * @return WebElement found by xPath locator
     */
    public WebElement findElementByXpath(String xpathLocator) {

        try {

            By by = By.xpath(xpathLocator);

            WebDriverWait wait = new WebDriverWait(driver,
                    Duration.ofSeconds(getDriverTimeout()), Duration.ofSeconds(getPolling()));

            return wait
                    .until(ExpectedConditions.visibilityOfElementLocated(by));

        } catch (TimeoutException t) {
            throw new TimeoutException();
        }
    }

    /**
     * Method to find element by ID locator
     *
     * @param IdLocator
     * @return WebElement found by ID locator
     */
    public WebElement findElementById(String IdLocator) {

        try {

            By by = By.id(IdLocator);

            WebDriverWait wait = new WebDriverWait(driver,
                    Duration.ofSeconds(getDriverTimeout()), Duration.ofSeconds(getPolling()));

            return wait
                    .until(ExpectedConditions.visibilityOfElementLocated(by));

        } catch (TimeoutException t) {
            throw new TimeoutException();
        }
    }

    /**
     * Method to find an element by using By locator
     *
     * @param by
     * @return WebElement found by locator
     */
    public WebElement findElementBy(By by) {
        try {

            WebDriverWait wait = new WebDriverWait(driver,
                    Duration.ofSeconds(getDriverTimeout()), Duration.ofSeconds(getPolling()));

            return wait
                    .until(ExpectedConditions.visibilityOfElementLocated(by));

        } catch (TimeoutException t) {
            throw new TimeoutException();
        }
    }

    /**
     * Method to find an element by using By locator
     *
     * @param by
     * @return List of WebElements found by locator
     */
    public List<WebElement> findElementsBy(By by) {
        try {

            WebDriverWait wait = new WebDriverWait(driver,
                    Duration.ofSeconds(getDriverTimeout()), Duration.ofSeconds(getPolling()));

            return wait
                    .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

        } catch (TimeoutException t) {
            throw new TimeoutException();
        }
    }

    /**
     * Method to enter text inside textbox
     *
     * @param by
     * @param text which will be typed into text box
     */
    public void enterTextIntoTextBox(By by, String text) {

        WebElement textBox = findElementBy(by);
        textBox.clear();
        textBox.sendKeys(text);

        LogHelper.logToReport("Typing text : " + text + " inside textbox" + " with locator: " + by);
        Helper.takeElementScreenshot(textBox, "textbox");

    }

    /**
     * Method to enter text inside textbox
     *
     * @param element
     * @param text    which will be typed into text box
     */
    public void enterTextIntoTextBox(WebElement element, String text) {

        element.clear();
        element.sendKeys(text);

        Helper.takeElementScreenshot(element, "textbox");
    }

    /**
     * Method to click a link or button
     *
     * @param by
     */
    public void clickLinkOrBtn(By by) {

        WebElement btnOrLink = findElementBy(by);
        btnOrLink.click();
    }

    /**
     * Method to click a link or button
     *
     * @param element
     */
    public void clickLinkOrBtn(WebElement element) {

        element.click();
    }

    /**
     * Method to return text
     *
     * @param by
     * @return text from WebElement
     */
    public String getTextFromElement(By by) {
        WebElement element = findElementBy(by);
        return element.getText();
    }

    /**
     * Method to return text
     *
     * @param element
     * @return text from WebElement
     */
    public String getTextFromElement(WebElement element) {

        return element.getText();
    }

    /**
     * Method to return the attribute value
     *
     * @param by
     * @param attr attribute name
     * @return attribute value from WebElement
     */
    public String getAttribute(By by, String attr) {
        WebElement element = findElementBy(by);
        return element.getAttribute(attr);
    }

    /**
     * Method to return the attribute value
     *
     * @param element
     * @param attr    attribute name
     * @return attribute value from WebElement
     */
    public String getAttribute(WebElement element, String attr) {
        return element.getAttribute(attr);
    }

    /**
     * Method to select by visible text
     *
     * @param by
     * @param textValue
     */
    public void selectByVisibleText(By by, String textValue) {

        WebElement selectBox = findElementBy(by);
        Select select = new Select(selectBox);
        select.selectByVisibleText(textValue);
    }

    /**
     * Method to select by visible text
     *
     * @param element
     * @param textValue
     */
    public void selectByVisibleText(WebElement element, String textValue) {

        Select select = new Select(element);
        select.selectByVisibleText(textValue);
    }

    /**
     * Method to select checkbox
     *
     * @param by
     * @return boolean value [TRUE]
     */
    public boolean selectCheckBox(By by) {

        WebElement webElement = findElementBy(by);
        if (webElement.isSelected()) {
            return true;
        }
        webElement.click();
        return true;
    }

    /**
     * Method to select checkbox
     *
     * @param webElement
     * @return boolean value [TRUE]
     */
    public boolean selectCheckBox(WebElement webElement) {

        if (webElement.isSelected()) {
            return true;
        }
        webElement.click();
        return true;
    }

    /**
     * Method to check if text is present on page
     *
     * @param text which presence is checked on the page
     * @return TRUE if text is present on page, or False if not
     */
    public boolean isTextPresentOnPage(String text) {
        String pageSource = driver.getPageSource();
        return pageSource.contains(text);
    }
}
