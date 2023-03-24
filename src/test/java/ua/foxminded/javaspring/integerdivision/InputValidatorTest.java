package ua.foxminded.javaspring.integerdivision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/*
 * Unit test for InputValidator. User can input anything. But our program need dividend be integer and non-negative 
 * number and divisor be integer and greater than null number. So this test validate if InputValidator class work as supposed. 
 */
class InputValidatorTest {

	@ParameterizedTest
	@CsvSource({ "100,3", "14569,7", "0,55", "5,2", "3,1", "10,101", "1,5", "53,23", "99,66" })
	void isInputdValid_ReturnFalse_DividendIsIntegerAndNonNegativeAndDivisorIsIntegerAndGreaterThanNull(
			String userDividend, String userDivisor) {
		assertEquals("Input is valid", InputValidator.isInputdValid(userDividend, userDivisor));
	}

	@ParameterizedTest
	@CsvSource({ "-100,100", "14.569,55", "0.5,3", "five,44", "hundred,100", "60%,34", "40$,1", "5.555,22", "100.0,5",
			"zero,4", "Integer.MAX_VALUE,Integer.MAX_VALUE" })
	void isInputdValid_ReturnFalse_DividendIsNotIntegerAndNonNegativeAndDivisorIsValid(String userDividend,
			String userDivisor) {
		assertEquals("Invalid dividend", InputValidator.isInputdValid(userDividend, userDivisor));
	}

	@ParameterizedTest
	@CsvSource({ ",33", " ,1", "      ,2", "\t,44", "\n,22", "   ,11", "    ,5", "   ,31", "   ,67" })
	void isInputdValid_ReturnFalse_DividendIsNullAndEmptyAndOnlySpacesAndDivisorIsValid(String userDividend,
			String userDivisor) {
		assertEquals("Invalid dividend", InputValidator.isInputdValid(userDividend, userDivisor));
	}

	@ParameterizedTest
	@CsvSource({ "51,-100", "55,0", "4,null", "45,one", "0,3.5", "2130,55.5", "331566,-1", "6413,100.0", "1235,99.9",
			"0,-15646645" })
	void isInputdValid_ReturnFalse_DividendIsValidAndDivisorIsNotIntegerAndGreaterThanNull(String userDividend,
			String userDivisor) {
		assertEquals("Invalid divisor", InputValidator.isInputdValid(userDividend, userDivisor));
	}

	@ParameterizedTest
	@CsvSource({ "324,", "2, ", "0,      ", "4,\t", "55,\n" })
	void isInputdValid_ReturnFalse_DividendIsValidAndDivisorIsNullAndEmptyAndOnlySpaces(String userDividend,
			String userDivisor) {
		assertEquals("Invalid divisor", InputValidator.isInputdValid(userDividend, userDivisor));
	}

	@ParameterizedTest
	@CsvSource(value = { "null,null", "null,", ",null", "   ,null", "null,   ", " ,null", ",  ", "null,",
			"," }, nullValues = { "null" })
	void isInputdValid_ReturnFalse_DividendOrDivisorIsNullOrEmptyOrOnlySpaces(String userDividend, String userDivisor) {
		assertEquals("Invalid dividend", InputValidator.isInputdValid(userDividend, userDivisor));
	}

}
