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

    @Test
    public void isEmailValid() {

    }
}
