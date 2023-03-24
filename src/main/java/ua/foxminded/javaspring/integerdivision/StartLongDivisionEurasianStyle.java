package ua.foxminded.javaspring.integerdivision;

import java.util.Scanner;

/*This is Java application that divides integer numbers, and prints process and results in long division algorithm 
 * into the console. The long division algorithm will be in Eurasian style. 
 * Dividend must be integer and non-negative number.
 * Divisor must be integer and greater than null number.*/

public class StartLongDivisionEurasianStyle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the dividend: ");
		String userDividend = scanner.nextLine();
		System.out.print("Enter the divisor: ");
		String userDivisor = scanner.nextLine();

		while (!InputValidator.isInputdValid(userDividend, userDivisor)) {
			System.out.println(
					"Dividend must be integer and non-negative number. Dividend must be integer and non-negative number.Please try again.");
			System.out.print("Enter the dividend: ");
			userDividend = scanner.nextLine();
			System.out.print("Enter the divisor: ");
			userDivisor = scanner.nextLine();
		}
		scanner.close();
		int dividend = Integer.parseInt(userDividend);
		int divisor = Integer.parseInt(userDivisor);
		LongDivisionEurasianStyle division = new LongDivisionEurasianStyle();
		System.out.println(division.makeDivision(dividend, divisor));

	}
}
