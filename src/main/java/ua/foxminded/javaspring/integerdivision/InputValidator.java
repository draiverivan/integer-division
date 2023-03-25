package ua.foxminded.javaspring.integerdivision;

/*Class for validation user input,
if user dividend input is integer and non-negative number
and user divisor input is integer and greater than null number*/

public class InputValidator {
	
	private InputValidator() {
		throw new IllegalStateException("Utility class");
	}

	static final String ERROR_INVALID_DIVIDEND = "Invalid dividend. Dividend must be integer and non-negative number.";
	static final String ERROR_INVALID_DIVISOR = "Invalid divisor. Divisor must be integer and greater than null number.";

	public static ValidatorResults isInputdValid(String userDividend, String userDivisor) {

		ValidatorResults validatorResults = new ValidatorResults();
		StringBuilder sb = new StringBuilder();

		boolean isDividendValid;
		boolean isDivisorValid;
		boolean isInputValid;

		try {
			int dividend = Integer.parseInt(userDividend);
			if (dividend < 0) {
		        throw new NumberFormatException(ERROR_INVALID_DIVIDEND);
		    }
		    isDividendValid = true;
		} catch (NumberFormatException ex) {
			isDividendValid = false;
			sb.append(ERROR_INVALID_DIVIDEND);
		}

		try {
			int divisor = Integer.parseInt(userDivisor);
			if (divisor <= 0) {
		        throw new NumberFormatException(ERROR_INVALID_DIVIDEND);
		    }
			isDivisorValid = true;
		} catch (NumberFormatException ex) {
			isDivisorValid = false;
			sb.append(ERROR_INVALID_DIVISOR);
		}

		isInputValid = isDividendValid && isDivisorValid;
		validatorResults.setValid(isInputValid);
		validatorResults.setErrorMessage(sb.toString());
		return validatorResults;

	}
}
