package ua.foxminded.javaspring.integerdivision;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Unit test for InputValidator. User can input anything. But our program need dividend be integer and non-negative 
 * number and divisor be integer and greater than null number. So this test validate if InputValidator class work as supposed. 
 */
class InputValidatorTest {

	InputValidator inputValidator = new InputValidator();

	@ParameterizedTest
	@ValueSource(strings = { "100", "14569", "0", "5", "3", "10", "1", "53", "99", "15646645" })
	void isDividendValid_ReturnTrue_DividendIsIntegerAndNonNegative(String userDividend) {
		assertTrue(inputValidator.isDividendValid(userDividend));
	}

	@ParameterizedTest
	@ValueSource(strings = { "-100", "14.569", "0.5", "five", "hundred", "60%", "40$", "5.555", "100.0", "zero" })
	void isDividendValid_ReturnFalse_DividendIsNotIntegerAndNonNegative(String userDividend) {
		assertFalse(inputValidator.isDividendValid(userDividend));
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "", " ", "      ", "\t", "\n", "   ", "    ", "   ", "   " })
	void isDividendValid_ReturnFalse_DividendIsNullAndEmptyAndOnlySpaces(String userDividend) {
		assertFalse(inputValidator.isDividendValid(userDividend));
	}

	@ParameterizedTest
	@ValueSource(strings = { "100", "14569", "555", "5", "3", "10", "1", "53", "99", "15646645" })
	void isDivisorValid_ReturnTrue_DivisorIsIntegerAndGreaterThanNull(String userDivisor) {
		assertTrue(inputValidator.isDivisorValid(userDivisor));
	}

	@ParameterizedTest
	@ValueSource(strings = { "-100", "0", "null", "one", "3.5", "55.5", "-1", "100.0", "99.9", "-15646645" })
	void isDivisorValid_ReturnFalse_DivisorIsNotIntegerAndGreaterThanNull(String userDivisor) {
		assertFalse(inputValidator.isDivisorValid(userDivisor));
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "", " ", "      ", "\t", "\n", "   ", "    ", "   ", "   " })
	void isDivisorValid_ReturnFalse_DivisorIsNullAndEmptyAndOnlySpaces(String userDivisor) {
		assertFalse(inputValidator.isDivisorValid(userDivisor));
	}

}
