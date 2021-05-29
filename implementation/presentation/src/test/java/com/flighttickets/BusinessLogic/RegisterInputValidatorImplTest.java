package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.RegisterInputValidator;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
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
            assertThat(this.validator.isNameValid(valid)).as("valid name test").isTrue();
            assertThat(this.validator.isNameValid(invalid)).as("invalid name test").isFalse();
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
            assertThat(this.validator.isEmailValid(valid)).as("valid email test").isTrue();
            assertThat(this.validator.isEmailValid(invalid)).as("invalid email test").isFalse();

        });
    }

    @ParameterizedTest
    @CsvSource({"'n!k@sn1Kos' , 'n!k@s'"
            , "'J@vaC0deG##ks', 'gregorymarjames-law'"
            , "'n!k1abcD#!', ' abcdFg45*'"
            , "'yR95Q@@mNT', 'n!koabcD#AX'"
            , "'n6HPPUBx!LS', 'ABCASWF2'"})
    public void isPasswordValid(String valid, String invalid) {
        SoftAssertions.assertSoftly(s -> {
            assertThat(this.validator.isPasswordValid(valid)).as("valid password test").isTrue();
            assertThat(this.validator.isPasswordValid(invalid)).as("invalid password test").isFalse();
        });
    }

    @ParameterizedTest
    @CsvSource({"'franciscannenstraat 10' , 'franciscanenstraat10'",
            "'caselstraat 99' , '65465465'"})
    public void isAddressValid(String valid, String invalid) {
        SoftAssertions.assertSoftly(s -> {
            assertThat(this.validator.isAddressValid(valid)).as("valid address test").isTrue();
            assertThat(this.validator.isAddressValid(invalid)).as("invalid address test").isFalse();
        });
    }
}
