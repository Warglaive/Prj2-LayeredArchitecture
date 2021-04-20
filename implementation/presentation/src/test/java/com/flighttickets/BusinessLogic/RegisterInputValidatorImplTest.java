package com.flighttickets.BusinessLogic;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisterInputValidatorImplTest {
    private RegisterInputValidator validator;


    @BeforeEach
    void setUp() {
        this.validator = new RegisterInputValidatorImpl();
    }

    @ParameterizedTest
    @CsvSource({"Tester , 5No"})
    public void isNameValidTest(String valid, String invalid) {
        SoftAssertions.assertSoftly(s -> {
            assertThat(this.validator.isNameValid(valid)).as("valid input test").isTrue();
            assertThat(this.validator.isNameValid(invalid)).as("invalid input test").isFalse();
        });
    }

    @ParameterizedTest
    @CsvSource({"'user@domain.com' , '.username@yahoo.com'"
            , "'user@domain.co.in', 'username@yahoo.com.'"
            , "'user.name@domain.com', 'username@yahoo..com'"
            , "'user_name@domain.com', 'username@yahoo.c'"
            , "'username@yahoo.corporate.in', 'username@yahoo.corporate'"})
    public void isEmailValid(String valid, String invalid) {
        SoftAssertions.assertSoftly(s -> {
            assertThat(this.validator.isEmailValid(valid)).as("valid input test").isTrue();
            assertThat(this.validator.isEmailValid(invalid)).as("invalid input test").isFalse();

        });
    }
}
