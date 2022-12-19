package com.jpetstore.tests;

import com.jpetstore.facade.JPetStoreSteps;
import com.jpetstore.utils.ExcelDataReader;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import static com.jpetstore.tags.JPetStoreTags.REGRESSION;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests for Login feature. Parametrized.")
@ExtendWith(TestListener.class)
public class LoginDDTest extends JPetStoreSteps {

    static Object[][] getDataDoLogin() {
        return ExcelDataReader.getData("src/test/resources/data/LoginDDTest.xlsx",
                "doLogin");
    }

    @Tag(REGRESSION)
    @ParameterizedTest
    @DisplayName("Login to application with multiple users & verify greeting messages.")
    @MethodSource("getDataDoLogin")
    public void doLogin_ValidInformationGiven_ShouldLoginSuccessfullyWithCorrectGreetingMessage(String username, String password, String expectedResult) {
        navigateToApp();
        navigateToSignOnPage();
        doLogin(username, password);

        assertEquals(expectedResult, getGreetingMessage());
    }
}
