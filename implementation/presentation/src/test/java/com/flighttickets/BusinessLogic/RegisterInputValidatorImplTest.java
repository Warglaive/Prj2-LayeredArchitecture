package com.flighttickets.BusinessLogic;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisterInputValidatorImplTest {
    private RegisterInputValidator validator;


    @BeforeEach
    void setUp() {
        this.validator = new RegisterInputValidatorImpl();
    }

    @Test
    public void isNameValidTest() {
        String validName = "Tester";
        String invalidName = "55No";


        SoftAssertions.assertSoftly(s -> {
            assertThat(this.validator.isNameValid(validName)).as("valid input test").isTrue();
            assertThat(this.validator.isNameValid(invalidName)).as("invalid input test").isFalse();
        });
    }
}
