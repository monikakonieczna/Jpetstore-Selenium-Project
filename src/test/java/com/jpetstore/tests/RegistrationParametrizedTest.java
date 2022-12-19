package com.jpetstore.tests;

import com.jpetstore.facade.JPetStoreSteps;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.jpetstore.tags.JPetStoreTags.REGRESSION;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
@DisplayName("Tests for Registration feature. Parametrized.")
@ExtendWith(TestListener.class)
public class RegistrationParametrizedTest extends JPetStoreSteps {

    @Tag(REGRESSION)
    @ParameterizedTest
    @DisplayName("Register multiple users to the JPetStore & verify if new user can login")
    @CsvFileSource(resources = "/data/registration-test.csv", numLinesToSkip = 1)
    public void registerUser_ValidInformationGiven_ShouldLoginSuccessfully(String userName,
                                                                           String password,
                                                                           String repeatPassword,
                                                                           String firstName,
                                                                           String lastName,
                                                                           String email,
                                                                           String phoneNumber,
                                                                           String address1,
                                                                           String address2,
                                                                           String city,
                                                                           String state,
                                                                           String zipCode,
                                                                           String country) {


        navigateToApp();

        navigateToSignOnPage();

        navigateToRegistrationPage();

        addNewUserInformation(userName, password, repeatPassword);

        addAccountInformation(firstName, lastName, email, phoneNumber, address1, address2,
                city, state, zipCode, country);

        addProfileInformation("english", "DOGS",
                true, true);

        clickSaveAccountInformation();

        //Login & verify account creation

        doLogin(userName, password);

        String greetingMsg = getGreetingMessage();

        assertEquals("Welcome " + firstName + "!", greetingMsg);
    }
}
