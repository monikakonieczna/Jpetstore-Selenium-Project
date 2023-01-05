package com.jpetstore.tests;

import com.jpetstore.facade.JPetStoreSteps;
import io.github.artsok.RepeatedIfExceptionsTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.jpetstore.tags.JPetStoreTags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TestListener.class)
@DisplayName("Tests for Login feature.")
public class LoginTest extends JPetStoreSteps {

    @Nested
    @DisplayName("Positive TC's for Login feature.")
    class PositiveTests {


        //@RepeatedIfExceptionsTest(repeats = 3)
        @Tag(SMOKE)
        @Test
        @Story("User tries to login.")
        @DisplayName("Positive: User tries to login with correct username and password.")
        @Description("Logging into the app via login page.")
        public void loginUser_ValidCredentialsGiven_ShouldEndSuccessfully() {
            navigateToApp();
            navigateToSignOnPage();
            doLogin("j2ee", "j2ee");

            assertAll(
                    () -> assertEquals("Welcome ABC!", getGreetingMessage()),
                    () -> assertEquals("Welcome ABC!", getGreetingMessage())
            );
        }

    }

    @Nested
    @DisplayName("Negative TC's for Login feature.")
    class NegativeTests {

        @Test
        @Story("User tries to login.")
        @DisplayName("Negative: User tries to login with incorrect password.")
        @Description("Impossible logging into the app via login page with incorrect password.")
        public void loginUser_InvalidPasswordGiven_ShouldShowErrorMessage() {
            String expectedText = "Invalid username or password. Signon failed.";
            String validUsername = "j2ee";
            String invalidPassword = "j123456";

            navigateToApp();
            navigateToSignOnPage();
            doLogin(validUsername, invalidPassword);

            assertEquals(expectedText, getMessageOnInvalidLogin());
        }

        @Test
        @Story("User tries to login.")
        @DisplayName("Negative: User tries to login with incorrect username.")
        @Description("Impossible logging into the app via login page with incorrect username.")
        public void loginUser_InvalidUsernameGiven_ShouldShowErrorMessage() {

            String expectedText = "Invalid username or password. Signon failed.";
            String invalidUsername = "j2ee2";
            String validPassword = "j2ee";

            navigateToApp();
            navigateToSignOnPage();
            doLogin(invalidUsername, validPassword);

            assertEquals(expectedText, getMessageOnInvalidLogin());
        }


    }


}

