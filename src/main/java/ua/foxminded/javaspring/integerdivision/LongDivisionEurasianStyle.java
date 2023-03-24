package ua.foxminded.javaspring.integerdivision;

/*Class for make long division algorithm in Eurasian style.*/

public class LongDivisionEurasianStyle {

	private StringBuilder result = new StringBuilder();
	private StringBuilder quotient = new StringBuilder();
	private StringBuilder reminder = new StringBuilder();
	private static final String EMPTY = "";
	private static final char SPACE = ' ';
	private static final String VERTICAL_LINE = "│";

	public String makeDivision(int dividend, int divisor) {

		if (dividend < divisor) {
			return EMPTY + dividend + "/" + divisor + "=0" + System.lineSeparator()
					+ "It's impossible make long division.";
		}

		String[] digits = String.valueOf(dividend).split(EMPTY);
		int reminderNumber;
		int multiplyResult;
		int divisorDigit = calculateDigit(divisor);
		int mod;

		for (int i = 0; i < digits.length; i++) {
			reminder.append(digits[i]);
			reminderNumber = Integer.parseInt(reminder.toString());

			if (reminderNumber >= divisor) {
				mod = reminderNumber % divisor;
				multiplyResult = reminderNumber / divisor * divisor;

				String lastReminder = String.format("%" + (i + 2) + "s", "_" + reminderNumber);
				result.append(lastReminder).append(System.lineSeparator());

				String multiply = String.format("%" + (i + 2) + "d", multiplyResult);
				result.append(multiply).append(System.lineSeparator());

				int tab = lastReminder.length() - calculateDigit(multiplyResult);
				result.append(makeDivider(reminderNumber, tab)).append(System.lineSeparator());

				quotient.append(reminderNumber / divisor);

				reminder.replace(0, reminder.length(), String.valueOf(mod));
				reminderNumber = Integer.parseInt(reminder.toString());
			} else {
				if (i >= divisorDigit) {
					quotient.append(0);
				}
			}

			if (i == digits.length - 1) {
				result.append(String.format("%" + (i + 2) + "s", reminderNumber)).append(System.lineSeparator());
			}
		}
		modifyResultToView(dividend, divisor);
		return result.toString();
	}

	private String makeDivider(int reminderNumber, int tab) {
		return assemblyString(tab, SPACE) + assemblyString(calculateDigit(reminderNumber), '-');
	}

	private void modifyResultToView(Integer dividend, int divisor) {
		int[] index = new int[3];
		for (int i = 0, j = 0; i < result.length(); i++) {
			if (result.charAt(i) == System.lineSeparator().charAt(0)) {
				index[j] = i;
				j++;
			}

			if (j == 3) {
				break;
			}
		}

		int tab = calculateDigit(dividend) + 1 - index[0];
		result.insert(index[2], assemblyString(tab, SPACE) + VERTICAL_LINE + quotient.toString());
		result.insert(index[1], assemblyString(tab, SPACE) + VERTICAL_LINE + assemblyString(quotient.length(), '-'));
		result.insert(index[0], VERTICAL_LINE + divisor);
		result.replace(1, index[0], dividend.toString());
	}

	private int calculateDigit(int i) {
		return (int) Math.log10(i) + 1;
	}

	private String assemblyString(int numberOfSymbols, char symbol) {
		StringBuilder string = new StringBuilder();
		for (int i = 0; i < numberOfSymbols; i++) {
			string.append(symbol);
		}
		return string.toString();
	}

}