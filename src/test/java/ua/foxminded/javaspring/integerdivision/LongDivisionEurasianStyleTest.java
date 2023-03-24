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
        String expected =   "_78945│4" +  System.lineSeparator() + 
                            " 4    │-----" +  System.lineSeparator() + 
                            " -    │19736" +  System.lineSeparator() + 
                            "_38" +  System.lineSeparator() + 
                            " 36" +  System.lineSeparator() + 
                            " --" +  System.lineSeparator() + 
                            " _29" +  System.lineSeparator() + 
                            "  28" +  System.lineSeparator() + 
                            "  --" +  System.lineSeparator() + 
                            "  _14" +  System.lineSeparator()+
                            "   12" +  System.lineSeparator()+
                            "   --" +  System.lineSeparator()+
                            "   _25" +  System.lineSeparator()+
                            "    24" +  System.lineSeparator()+
                            "    --" +  System.lineSeparator()+
                            "     1" +  System.lineSeparator();
        // @formatter:on
		assertEquals(expected, division.makeDivision(78945, 4).toString());
	}

	@Test
	void makeDivision_ShouldMakeLongDivision_DividendIs14789DivisorIs20() {
		// @formatter:off
        String expected =   "_14789│20" +  System.lineSeparator() + 
                            " 140  │---" +  System.lineSeparator() + 
                            " ---  │739" +  System.lineSeparator() + 
                            "  _78" +  System.lineSeparator() + 
                            "   60" +  System.lineSeparator() + 
                            "   --" +  System.lineSeparator() + 
                            "  _189" +  System.lineSeparator() + 
                            "   180" +  System.lineSeparator() + 
                            "   ---" +  System.lineSeparator() + 
                            "     9" +  System.lineSeparator();
        // @formatter:on
		assertEquals(expected, division.makeDivision(14789, 20).toString());
	}

	@Test
	void makeDivision_ShouldMakeLongDivision_DividendIs0DivisorIs20() {
		// @formatter:off
		String expected = "0/20=0" + System.lineSeparator()+ "It's impossible make long division.";
		// @formatter:on
		assertEquals(expected, division.makeDivision(0, 20));
	}

	@Test
	void makeDivision_ShouldMakeLongDivision_DividendIs44DivisorIs77() {
		// @formatter:off
		String expected = "44/77=0" + System.lineSeparator()+ "It's impossible make long division.";
		// @formatter:on
		assertEquals(expected, division.makeDivision(44, 77));
	}

}
