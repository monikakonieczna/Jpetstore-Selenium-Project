package com.jpetstore.facade;

import com.jpetstore.core.DriverManager;
import com.jpetstore.pages.AccountsPage;
import com.jpetstore.pages.BasePage;
import com.jpetstore.pages.DashboardPage;
import com.jpetstore.pages.LoginPage;
import com.jpetstore.utils.Helper;
import io.qameta.allure.Step;

/**
 * JPetStoreSteps class. Inherit from DriverManager parent class.
 */
public class JPetStoreSteps extends DriverManager {

    private BasePage basePage = new BasePage(getDriver());
    private LoginPage loginPage = new LoginPage(getDriver());

    private DashboardPage dashboardPage = new DashboardPage(getDriver());
    private AccountsPage accountsPage = new AccountsPage(driver);

    @Step("Navigating to JPetStore Application")
    public void navigateToApp() {
        basePage.navigateToApp();
    }

    @Step("Navigating to Login Page")
    public LoginPage navigateToSignOnPage() {

        return basePage.navigateToSignOnPage();
    }

    @Step("Logging in with username: {0} & password: {1}")
    public DashboardPage doLogin(String username, String password) {

        basePage.clickSignInLink();
        Helper.takeScreenshot(driver, "doLogin");
        return loginPage.doLogin(username, password);
    }

    @Step("Get greeting message")
    public String getGreetingMessage() {
        return dashboardPage.getGreetingMessage();
    }

    @Step("Return message on invalid login")
    public String getMessageOnInvalidLogin() {
        return loginPage.getMessageOnInvalidLogin();
    }

    @Step("Navigating to user registration page")
    public AccountsPage navigateToRegistrationPage() {

        return loginPage.navigateToRegistrationPage();
    }

    @Step("Adding new user information with userName: {0} , password: {1} , repeatPassword {2}")
    public AccountsPage addNewUserInformation(String userName, String password,
                                              String repeatPassword) {

        return accountsPage.addNewUserInformation(userName, password, repeatPassword);
    }

    @Step("Adding account information- firstname:{0} , lastName:{1}," +
            " email:{2}, phone:{3}, addr1:{4}, addr2: {5}, city:{6}, " +
            "state:{7}, zip:{8}, country:{9} ")
    public AccountsPage addAccountInformation(String firstName,
                                              String lastName,
                                              String email,
                                              String phone,
                                              String addr1,
                                              String addr2,
                                              String city,
                                              String state,
                                              String zip,
                                              String country) {


        return accountsPage.addAccountInformation(firstName,
                lastName,
                email,
                phone,
                addr1,
                addr2,
                city,
                state,
                zip,
                country);
    }

    @Step("Adding profile information - language:{0} ,category: {1} ,myList: {2} ,myBanner:{3}")
    public AccountsPage addProfileInformation(String language,
                                              String category,
                                              boolean myList,
                                              boolean myBanner) {

        return accountsPage.addProfileInformation(language,
                category,
                myList,
                myBanner);
    }

    @Step("Saving account information")
    public DashboardPage clickSaveAccountInformation() {

        return accountsPage.clickSaveAccountInformation();

    }

}
