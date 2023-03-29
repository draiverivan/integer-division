package ua.foxminded.javaspring.integerdivision;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*This is Java application that divides integer numbers, and prints process and results in long division algorithm 
 * into the console. The long division algorithm will be in Eurasian style. 
 * Dividend must be integer and non-negative number.
 * Divisor must be integer and greater than null number.*/
public class StartLongDivisionEurasianStyle {
	

	public static void main(String[] args) {
		
		Logger logger = LoggerFactory.getLogger(StartLongDivisionEurasianStyle.class);
		Scanner scanner = new Scanner(System.in);
		logger.info("Enter the dividend: ");
		String userDividend = scanner.nextLine();
		logger.info("Enter the divisor: ");
		String userDivisor = scanner.nextLine();
		ValidatorResults validatorResults = InputValidator.isInputdValid(userDividend, userDivisor);

		while (!validatorResults.isValid()) {

			logger.info(validatorResults.getErrorMessage());

			if (validatorResults.getErrorMessage().contains(InputValidator.ERROR_INVALID_DIVIDEND)) {
				logger.info("Please try again to enter the dividend: ");
				userDividend = scanner.nextLine();
			}

			if (validatorResults.getErrorMessage().contains(InputValidator.ERROR_INVALID_DIVISOR)) {
				logger.info("Please try again to enter the divisor: ");
				userDivisor = scanner.nextLine();
			}
			validatorResults = InputValidator.isInputdValid(userDividend, userDivisor);

		}
		scanner.close();
		int dividend = Integer.parseInt(userDividend);
		int divisor = Integer.parseInt(userDivisor);
		LongDivisionEurasianStyle division = new LongDivisionEurasianStyle();
		logger.info(System.lineSeparator() + division.makeDivision(dividend, divisor));

	}
}
