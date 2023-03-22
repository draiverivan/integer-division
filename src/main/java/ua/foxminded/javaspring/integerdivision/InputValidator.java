package ua.foxminded.javaspring.integerdivision;

/*Class for validation user input,
if user dividend input is integer and non-negative number
and user divisor input is integer and greater than null number*/

public class InputValidator {

	public boolean isDividendValid(String userDividend) {

		if (userDividend == null) {
			return false;
		}
		try {
			int dividend = Integer.parseInt(userDividend);
			return dividend >= 0;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	public boolean isDivisorValid(String userDivisor) {

		if (userDivisor == null) {
			return false;
		}
		try {
			int divisor = Integer.parseInt(userDivisor);
			return divisor > 0;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
}
