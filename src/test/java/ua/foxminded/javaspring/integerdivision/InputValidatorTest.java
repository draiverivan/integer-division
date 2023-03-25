package ua.foxminded.javaspring.integerdivision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/*
 * Unit test for InputValidator. User can input anything. But our program need dividend be integer and non-negative 
 * number and divisor be integer and greater than null number. So this test validate if InputValidator class work as supposed. 
 */
class InputValidatorTest {

	@ParameterizedTest
    @CsvSource({ "100,3", "14569,7", "0,55", "5,2", "3,1", "10,101", "1,5", "53,23", "99,66" })
    void isInputdValid_SetValidTrue_ForValidInput(String userDividend, String userDivisor) {
        ValidatorResults result = InputValidator.isInputdValid(userDividend, userDivisor);
        assertTrue(result.isValid());
        assertEquals("", result.getErrorMessage());
    }

    @ParameterizedTest
    @CsvSource({ "-100,100", "14.569,55", "0.5,3", "five,44", "hundred,100", "60%,34", "40$,1", "5.555,22", "100.0,5", "zero,4", "Integer.MAX_VALUE,Integer.MAX_VALUE" })
    void isInputdValid_SetValidFalse_ForInvalidDividend(String userDividend, String userDivisor) {
        ValidatorResults result = InputValidator.isInputdValid(userDividend, userDivisor);
        assertFalse(result.isValid());
        assertTrue(result.getErrorMessage().contains(InputValidator.ERROR_INVALID_DIVIDEND));
    }

    @ParameterizedTest
    @CsvSource({ ",33", " ,1", "      ,2", "\t,44", "\n,22", "   ,11", "    ,5", "   ,31", "   ,67" })
    void isInputdValid_SetValidFalse_ForEmptyOrNullDividend(String userDividend, String userDivisor) {
        ValidatorResults result = InputValidator.isInputdValid(userDividend, userDivisor);
        assertFalse(result.isValid());
        assertTrue(result.getErrorMessage().contains(InputValidator.ERROR_INVALID_DIVIDEND));
    }

    @ParameterizedTest
    @CsvSource({ "51,-100", "55,0", "4,null", "45,one", "0,3.5", "2130,55.5", "331566,-1", "6413,100.0", "1235,99.9", "0,-15646645" })
    void isInputdValid_SetValidFalse_ForInvalidDivisor(String userDividend, String userDivisor) {
        ValidatorResults result = InputValidator.isInputdValid(userDividend, userDivisor);
        assertFalse(result.isValid());
        assertTrue(result.getErrorMessage().contains(InputValidator.ERROR_INVALID_DIVISOR));
    }

    @ParameterizedTest
    @CsvSource({ "324,", "2, ", "0,      ", "4,\t", "55,\n" })
    void isInputValid_SetValidFalse_ForEmptyOrNullDivisor(String userDividend,
            String userDivisor) {
        ValidatorResults result = InputValidator.isInputdValid(userDividend, userDivisor);
        assertFalse(result.isValid());
        assertTrue(result.getErrorMessage().contains(InputValidator.ERROR_INVALID_DIVISOR));
    }

    @ParameterizedTest
    @CsvSource(value = { "null,null", "null,", ",null", "   ,null", "null,   ", " ,null", ",  ", "null,", "," },
            nullValues = { "null" })
    void isInputValid_SetValidFalse_ForDividendAndDivisorIsNullOrEmptyOrOnlySpaces(String userDividend,
            String userDivisor) {
        ValidatorResults result = InputValidator.isInputdValid(userDividend, userDivisor);
        assertFalse(result.isValid());
        assertTrue(result.getErrorMessage().contains(InputValidator.ERROR_INVALID_DIVIDEND));
        assertTrue(result.getErrorMessage().contains(InputValidator.ERROR_INVALID_DIVISOR));
    }

}
