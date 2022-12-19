package com.jpetstore.tests;

import com.github.javafaker.Faker;
import com.jpetstore.facade.JPetStoreSteps;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import static com.jpetstore.tags.JPetStoreTags.BUG_FIX;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag(BUG_FIX)
@ExtendWith(TestListener.class)
@DisplayName("Tests for Registration feature.")
public class RegistrationTest extends JPetStoreSteps {

    @Test
    @DisplayName("Add a new user to the store & verify if the user can login")
    public void registerUser_ValidInformationGiven_ShouldLoginSuccessfully() {

        Faker faker = new Faker();

        String userName = "j2ee" + faker.number()
                                        .randomNumber(10, false);

        String password = faker.internet()
                               .password();
        String repeatPassword = faker.internet()
                                       .password();


        String firstName = faker.name()
                                .firstName();
        String lastName = faker.name()
                               .lastName();
        String email = faker.internet()
                            .emailAddress();
        String phoneNumber = faker.phoneNumber()
                                  .cellPhone();
        String address1 = faker.address()
                               .buildingNumber();
        String address2 = faker.address()
                               .streetAddress();
        String city = faker.address()
                           .city();
        String state = faker.address()
                            .state();
        String zipCode = faker.address()
                              .zipCode();
        String country = faker.address()
                              .country();

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

