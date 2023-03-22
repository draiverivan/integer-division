package ua.foxminded.javaspring.integerdivision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Unit test for LongDivisionEurasianStyle. In this class in method makeDivision(int dividend, int divisor) 
 * always will be taken only valid dividend and divisor. Because Class InputValidator does validation before. 
 *  So this test is for valid dividends and divisors. In this case dividend must be integer and non-negative 
 * number and divisor must be integer and greater than null number.
 */
class LongDivisionEurasianStyleTest {

	LongDivisionEurasianStyle division = new LongDivisionEurasianStyle();

	@Test
	void makeDivision_ShouldMakeLongDivision_DividendIs78945DivisorIs4() {
		// @formatter:off
        String expected =   "_78945│4\n" + 
                            " 4    │-----\n" + 
                            " -    │19736\n" + 
                            "_38\n" + 
                            " 36\n" + 
                            " --\n" + 
                            " _29\n" + 
                            "  28\n" + 
                            "  --\n" + 
                            "  _14\n"+
                            "   12\n"+
                            "   --\n"+
                            "   _25\n"+
                            "    24\n"+
                            "    --\n"+
                            "     1\n";
        // @formatter:on
		assertEquals(expected, division.makeDivision(78945, 4));
	}

	@Test
	void makeDivision_ShouldMakeLongDivision_DividendIs14789DivisorIs20() {
		// @formatter:off
        String expected =   "_14789│20\n" + 
                            " 140  │---\n" + 
                            " ---  │739\n" + 
                            "  _78\n" + 
                            "   60\n" + 
                            "   --\n" + 
                            "  _189\n" + 
                            "   180\n" + 
                            "   ---\n" + 
                            "     9\n";
        // @formatter:on
		assertEquals(expected, division.makeDivision(14789, 20));
	}

	@Test
	void makeDivision_ShouldMakeLongDivision_DividendIs0DivisorIs20() {
		// @formatter:off
		String expected = "0/20=0\nIt's impossible make long division.";
		// @formatter:on
		assertEquals(expected, division.makeDivision(0, 20));
	}

	@Test
	void makeDivision_ShouldMakeLongDivision_DividendIs44DivisorIs77() {
		// @formatter:off
		String expected = "44/77=0\nIt's impossible make long division.";
		// @formatter:on
		assertEquals(expected, division.makeDivision(44, 77));
	}

}
