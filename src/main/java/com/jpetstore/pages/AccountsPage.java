package com.jpetstore.pages;

import com.jpetstore.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * AccountsPage class extends BasePage class.
 */
public class AccountsPage extends BasePage {
    public AccountsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static final String USER_NAME_INPUT = "//*[@id='Catalog']//input[@name='username']";

    private static final String PASSWORD_INPUT = "//*[@id='Catalog']//input[@name='password']";

    private static final String REAPEATED_PASSWORD_INPUT = "//*[@id='Catalog']//input[@name='repeatedPassword']";

    private static final String FIRST_NAME_INPUT = "//*[@id='Catalog']//input[@name='account.firstName']";

    private static final String LAST_NAME_INPUT = "//*[@id='Catalog']//input[@name='account.lastName']";

    private static final String EMAIL_INPUT = "//*[@id='Catalog']//input[@name='account.email']";

    private static final String PHONE_INPUT = "//*[@id='Catalog']//input[@name='account.phone']";

    private static final String ADDR1_INPUT = "//*[@id='Catalog']//input[@name='account.address1']";

    private static final String ADDR2_INPUT = "//*[@id='Catalog']//input[@name='account.address2']";

    private static final String CITY_INPUT = "//*[@id='Catalog']//input[@name='account.city']";

    private static final String STATE_INPUT = "//*[@id='Catalog']//input[@name='account.state']";

    private static final String ZIP_INPUT = "//*[@id='Catalog']//input[@name='account.zip']";

    private static final String COUNTRY_INPUT = "//*[@id='Catalog']//input[@name='account.country']";

    private static final String LANGUAGE_PREFERENCE_DROPDOWN = "//*[@id='Catalog']//select[@name='account.languagePreference']";

    private static final String FAVOURITE_CATEGORY_DROPDOWN = "//*[@id='Catalog']//select[@name='account.favouriteCategoryId']";

    private static final String ENABLE_MY_LIST_CHECKBOX = "//*[@id='Catalog']//input[@name='account.listOption']";

    private static final String ENABLE_BANNER_CHECKBOX = "//*[@id='Catalog']//input[@name='account.bannerOption']";

    private static final String SAVE_ACCT_INFO_BUTTON = "//*[@id='Catalog']//input[@value='Save Account Information']";


    /**
     * Method to add new user information.
     *
     * @param userName       username
     * @param password       password
     * @param repeatPassword repeated password, can have the same value as password or different dependently of testing needs.
     * @return AccountsPage
     */
    public AccountsPage addNewUserInformation(String userName, String password,
                                              String repeatPassword) {

        isTextPresentOnPage("User Information");

        enterTextIntoTextBox(By.xpath(USER_NAME_INPUT), userName);
        enterTextIntoTextBox(By.xpath(PASSWORD_INPUT), password);
        enterTextIntoTextBox(By.xpath(REAPEATED_PASSWORD_INPUT), repeatPassword);

        return this;
    }


    /**
     * Method to enter account information.
     *
     * @param firstName First Name
     * @param lastName  Last Name
     * @param email     E-mail address
     * @param phone     Phone number
     * @param address1  Address
     * @param address2  Address continuation
     * @param city      City name
     * @param state     State name
     * @param zip       Zip code
     * @param country   Country Name
     * @return AccountsPage
     */
    public AccountsPage addAccountInformation(String firstName,
                                              String lastName,
                                              String email,
                                              String phone,
                                              String address1,
                                              String address2,
                                              String city,
                                              String state,
                                              String zip,
                                              String country) {

        isTextPresentOnPage("Account Information");

        enterTextIntoTextBox(By.xpath(FIRST_NAME_INPUT), firstName);
        enterTextIntoTextBox(By.xpath(LAST_NAME_INPUT), lastName);
        enterTextIntoTextBox(By.xpath(EMAIL_INPUT), email);
        enterTextIntoTextBox(By.xpath(PHONE_INPUT), phone);
        enterTextIntoTextBox(By.xpath(ADDR1_INPUT), address1);
        enterTextIntoTextBox(By.xpath(ADDR2_INPUT), address2);
        enterTextIntoTextBox(By.xpath(CITY_INPUT), city);
        enterTextIntoTextBox(By.xpath(STATE_INPUT), state);
        enterTextIntoTextBox(By.xpath(ZIP_INPUT), zip);
        enterTextIntoTextBox(By.xpath(COUNTRY_INPUT), country);

        return this;
    }

    /**
     * Method to add profile information.
     *
     * @param language language name e.g. english, polish etc.
     * @param category favourite pet category between PetCategories defined in PetCategories.class
     * @param myList
     * @param myBanner
     * @return this AccountPage
     */
    public AccountsPage addProfileInformation(String language,
                                              String category,
                                              boolean myList,
                                              boolean myBanner) {

        isTextPresentOnPage("Profile Information");

        selectByVisibleText(By.xpath(LANGUAGE_PREFERENCE_DROPDOWN), language);

        selectByVisibleText(By.xpath(FAVOURITE_CATEGORY_DROPDOWN), category);

        selectCheckBox(By.xpath(ENABLE_MY_LIST_CHECKBOX));

        selectCheckBox(By.xpath(ENABLE_BANNER_CHECKBOX));

        return this;
    }

    /**
     * Saving Account Information.
     *
     * @return DashboardPage
     */
    public DashboardPage clickSaveAccountInformation() {

        clickLinkOrBtn(By.xpath(SAVE_ACCT_INFO_BUTTON));
        return new DashboardPage(DriverFactory.driver);
    }

}
