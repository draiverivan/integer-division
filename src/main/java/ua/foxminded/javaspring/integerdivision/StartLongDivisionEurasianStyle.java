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
		InputValidator checkDividend = new InputValidator();
		while (!checkDividend.isDividendValid(userDividend)) {
			System.out.println("Dividend must be integer and non-negative number.Please try again:");
			userDividend = scanner.nextLine();
		}
		int dividend = Integer.parseInt(userDividend);

		System.out.print("Enter the divisor: ");
		String userDivisor = scanner.nextLine();
		InputValidator checkDivisor = new InputValidator();
		while (!checkDivisor.isDivisorValid(userDivisor)) {
			System.out.println("Divisor must be integer and greater than null number.Please try again:");
			userDivisor = scanner.nextLine();
		}
		int divisor = Integer.parseInt(userDivisor);

		scanner.close();

		LongDivisionEurasianStyle division = new LongDivisionEurasianStyle();
		System.out.println(division.makeDivision(dividend, divisor));
	}
}
