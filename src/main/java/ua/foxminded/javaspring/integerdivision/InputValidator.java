package ua.foxminded.javaspring.integerdivision;

/*Class for validation user input,
if user dividend input is integer and non-negative number
and user divisor input is integer and greater than null number*/

public class InputValidator {

	private InputValidator() {
		throw new IllegalStateException("Utility class");
	}

	public static String isInputdValid(String userDividend, String userDivisor) {

		String invalidDividend = "Invalid dividend";
		String invalidDivisor = "Invalid divisor";
		String inputIsValid = "Input is valid";
		boolean validDividend;
		boolean validDivisor;

		try {
			int dividend = Integer.parseInt(userDividend);
			validDividend = dividend >= 0;
		} catch (NumberFormatException ex) {
			validDividend = false;
		}

		try {
			int divisor = Integer.parseInt(userDivisor);
			validDivisor = divisor > 0;
		} catch (NumberFormatException ex) {
			validDivisor = false;
		}
		if (!validDividend) {
			return invalidDividend;
		} else if (!validDivisor) {
			return invalidDivisor;
		} else {
			return inputIsValid;
		}
	}
}
