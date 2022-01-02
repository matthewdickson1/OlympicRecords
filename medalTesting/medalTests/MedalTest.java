/**
 * 
 */
package medalTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import olympics.Medal;

/**
 * @author Matthew Dickson & Student Number: 40062654
 * 
 */

//This is the class containing all the Medal tests
class MedalTest {

	// test data to include valid cases and invalid cases for both lower and upper
	// bounds
	String city, sport, discipline, athlete, country, gender, event, medalType;

	String cityInvalidLower, sportInvalidLower, disciplineInvalidLower, athleteInvalidLower, countryInvalidLower,
			genderInvalidLower, eventInvalidLower, medalTypeInvalidLower;

	String cityInvalidUpper, sportInvalidUpper, disciplineInvalidUpper, athleteInvalidUpper, countryInvalidUpper,
			genderInvalidUpper, eventInvalidUpper, medalTypeInvalidUpper;

	int year, yearInvalidLower, yearInvalidUpper;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// valid test data below per table in question
		year = 1896;
		city = "Valid City";
		sport = "Valid Sport";
		discipline = "Valid Discipline";
		athlete = "Valid Athlete";
		country = "VLD";
		gender = "Valid gen";
		event = "Valid event";
		medalType = "1";

		// using 1895 as the lower 3 point boundary. Further testing could include 1896
		// and 1897 to ensure the lower boundary is correctly implemented and similarly
		// for boundaries for all other attributes of the Medal class

		yearInvalidLower = 1895;

		cityInvalidLower = ""; // string of length 0 as this is the lower bound for city
		sportInvalidLower = "";
		disciplineInvalidLower = "";
		athleteInvalidLower = "";
		countryInvalidLower = "";
		genderInvalidLower = "";
		eventInvalidLower = "";
		medalTypeInvalidLower = "0"; // string equal to 0 as the medalType should only accept string inputs 1, 2 and
										// 3

		yearInvalidUpper = 2021;
		cityInvalidUpper = String.format("%0" + 30 + "d", 0); // this creates a string of zeroes of length 30 which is
																// the upper bound for city
		sportInvalidUpper = String.format("%0" + 50 + "d", 0);
		disciplineInvalidUpper = String.format("%0" + 80 + "d", 0);
		athleteInvalidUpper = String.format("%0" + 80 + "d", 0);
		countryInvalidUpper = String.format("%0" + 4 + "d", 0);
		genderInvalidUpper = String.format("%0" + 10 + "d", 0);
		eventInvalidUpper = String.format("%0" + 50 + "d", 0);
		medalTypeInvalidUpper = "4";

	}

	/**
	 * Test method for the Medal Constructor with valid arguments
	 * 
	 */
	@Test
	final void testMedalValidArgs() {

		// create a valid medal object using the data from above
		Medal validMedal = new Medal(year, city, sport, discipline, athlete, country, gender, event, medalType);

		// testing that all the Medal Constructor and getters have been implemented
		// correctly
		assertEquals(year, validMedal.getYear());
		assertEquals(city, validMedal.getCity());
		assertEquals(sport, validMedal.getSport());
		assertEquals(discipline, validMedal.getDiscipline());
		assertEquals(athlete, validMedal.getAthlete());
		assertEquals(country, validMedal.getCountry());
		assertEquals(gender, validMedal.getGender());
		assertEquals(event, validMedal.getEvent());
		// using "GOLD" here rather than "1" as the setter should change the 1 to "GOLD"
		assertEquals("GOLD", validMedal.getMedalType());

	}

	/**
	 * Test method for the Medal constructor using valid criteria for all of the attributes
	 * except 1. Covering both lower and upper bounds
	 */
	// suppressing the warning that the Medal m is not used
	@SuppressWarnings("unused")
	@Test
	final void testMedalInvalidArgs() {

		// testing each invalid attribute separately in case one of them does not throw
		// an exception which would not be picked up if I had one constructor with only
		// invalid args.
		// testing lower bounds that they should all throw an illegal argument exception
		assertThrows(IllegalArgumentException.class, () -> {
			Medal m = new Medal(yearInvalidLower, city, sport, discipline, athlete, country, gender, event, medalType);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Medal m = new Medal(year, cityInvalidLower, sport, discipline, athlete, country, gender, event, medalType);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Medal m = new Medal(year, city, sportInvalidLower, discipline, athlete, country, gender, event, medalType);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Medal m = new Medal(year, city, sport, disciplineInvalidLower, athlete, country, gender, event, medalType);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Medal m = new Medal(year, city, sport, discipline, athleteInvalidLower, country, gender, event, medalType);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Medal m = new Medal(year, city, sport, discipline, athlete, countryInvalidLower, gender, event, medalType);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Medal m = new Medal(year, city, sport, discipline, athlete, country, genderInvalidLower, event, medalType);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Medal m = new Medal(year, city, sport, discipline, athlete, country, gender, eventInvalidLower, medalType);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Medal m = new Medal(year, city, sport, discipline, athlete, country, gender, event, medalTypeInvalidLower);
		});

		// testing upper bounds
		assertThrows(IllegalArgumentException.class, () -> {
			Medal m = new Medal(yearInvalidUpper, city, sport, discipline, athlete, country, gender, event, medalType);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Medal m = new Medal(year, cityInvalidUpper, sport, discipline, athlete, country, gender, event, medalType);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Medal m = new Medal(year, city, sportInvalidUpper, discipline, athlete, country, gender, event, medalType);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Medal m = new Medal(year, city, sport, disciplineInvalidUpper, athlete, country, gender, event, medalType);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Medal m = new Medal(year, city, sport, discipline, athleteInvalidUpper, country, gender, event, medalType);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Medal m = new Medal(year, city, sport, discipline, athlete, countryInvalidUpper, gender, event, medalType);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Medal m = new Medal(year, city, sport, discipline, athlete, country, genderInvalidUpper, event, medalType);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Medal m = new Medal(year, city, sport, discipline, athlete, country, gender, eventInvalidUpper, medalType);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Medal m = new Medal(year, city, sport, discipline, athlete, country, gender, event, medalTypeInvalidUpper);
		});

	}

	/**
	 * Test method for valid year
	 */
	@Test
	final void testValidYear() {
		Medal medal = new Medal();
		medal.setYear(year);
		assertEquals(year, medal.getYear());

	}

	/**
	 * Test method for invalid year
	 */
	@Test
	final void testInvalidYearLower() {
		Medal medal = new Medal();

		// Test for invalid Lower bound
		assertThrows(IllegalArgumentException.class, () -> {
			medal.setYear(yearInvalidLower);
		});

		// Test for invalid upper bound
		assertThrows(IllegalArgumentException.class, () -> {
			medal.setYear(yearInvalidUpper);
		});

	}

	/**
	 * Test method for valid city
	 */
	@Test
	final void testValidCity() {
		Medal medal = new Medal();
		medal.setCity(city);
		assertEquals(city, medal.getCity());
	}

	/**
	 * Test method for invalid city
	 */
	@Test
	final void testInvalidCity() {
		Medal medal = new Medal();

		// Test for invalid Lower bound
		assertThrows(IllegalArgumentException.class, () -> {
			medal.setCity(cityInvalidLower);
		});

		// Test for invalid upper bound
		assertThrows(IllegalArgumentException.class, () -> {
			medal.setCity(cityInvalidUpper);
		});

	}

	/**
	 * Test method for valid sport.
	 */
	@Test
	final void testValidSport() {
		Medal medal = new Medal();
		medal.setSport(sport);
		assertEquals(sport, medal.getSport());
	}

	/**
	 * Test method for invalid sport.
	 */
	@Test
	final void testInvalidSport() {
		Medal medal = new Medal();

		// Test for invalid Lower bound
		assertThrows(IllegalArgumentException.class, () -> {
			medal.setSport(sportInvalidLower);
		});

		// Test for invalid upper bound
		assertThrows(IllegalArgumentException.class, () -> {
			medal.setSport(sportInvalidUpper);
		});

	}

	/**
	 * Test method for valid discipline.
	 */
	@Test
	final void testValidDiscipline() {
		Medal medal = new Medal();
		medal.setDiscipline(discipline);
		assertEquals(discipline, medal.getDiscipline());
	}

	/**
	 * Test method for invalid discipline.
	 */
	@Test
	final void testInvalidDiscipline() {
		Medal medal = new Medal();

		// Test for invalid Lower bound
		assertThrows(IllegalArgumentException.class, () -> {
			medal.setDiscipline(disciplineInvalidLower);
		});

		// Test for invalid upper bound
		assertThrows(IllegalArgumentException.class, () -> {
			medal.setDiscipline(disciplineInvalidUpper);
		});

	}

	/**
	 * Test method for valid athlete
	 */
	@Test
	final void testValidAthlete() {
		Medal medal = new Medal();
		medal.setAthlete(athlete);
		assertEquals(athlete, medal.getAthlete());
	}

	/**
	 * Test method for invalid athlete
	 */
	@Test
	final void testInvalidAthlete() {
		Medal medal = new Medal();

		// Test for invalid Lower bound
		assertThrows(IllegalArgumentException.class, () -> {
			medal.setAthlete(athleteInvalidLower);
		});

		// Test for invalid upper bound
		assertThrows(IllegalArgumentException.class, () -> {
			medal.setAthlete(athleteInvalidUpper);
		});

	}

	/**
	 * Test method for valid country
	 */
	@Test
	final void testSetCountry() {
		Medal medal = new Medal();
		medal.setCountry(country);
		assertEquals(country, medal.getCountry());
	}

	/**
	 * Test method for invalid country
	 */
	@Test
	final void testInvalidCountry() {
		Medal medal = new Medal();

		// Test for invalid Lower bound
		assertThrows(IllegalArgumentException.class, () -> {
			medal.setCountry(countryInvalidLower);
		});

		// Test for invalid upper bound
		assertThrows(IllegalArgumentException.class, () -> {
			medal.setCountry(countryInvalidUpper);
		});

	}

	/**
	 * Test method for valid gender
	 */
	@Test
	final void testValidGender() {
		Medal medal = new Medal();
		medal.setGender(gender);
		assertEquals(gender, medal.getGender());
	}

	/**
	 * Test method for invalid gender
	 */
	@Test
	final void testInvalidGender() {
		Medal medal = new Medal();

		// Test for invalid Lower bound
		assertThrows(IllegalArgumentException.class, () -> {
			medal.setGender(genderInvalidLower);
		});

		// Test for invalid upper bound
		assertThrows(IllegalArgumentException.class, () -> {
			medal.setGender(genderInvalidUpper);
		});

	}

	/**
	 * Test method for valid event
	 */
	@Test
	final void testValidEvent() {
		Medal medal = new Medal();
		medal.setEvent(event);
		assertEquals(event, medal.getEvent());
	}

	/**
	 * Test method for invalid event
	 */
	@Test
	final void testInvalidEvent() {
		Medal medal = new Medal();

		// Test for invalid Lower bound
		assertThrows(IllegalArgumentException.class, () -> {
			medal.setEvent(eventInvalidLower);
		});

		// Test for invalid upper bound
		assertThrows(IllegalArgumentException.class, () -> {
			medal.setEvent(eventInvalidUpper);
		});

	}

	/**
	 * Test method for valid medal type
	 */
	@Test
	final void testValidMedal() {
		Medal medal = new Medal();
		medal.setMedalType(medalType);
		assertEquals("GOLD", medal.getMedalType());
	}

	/**
	 * Test method for invalid medal type
	 */
	@Test
	final void testInvalidMedal() {
		Medal medal = new Medal();

		// Test for invalid Lower bound
		assertThrows(IllegalArgumentException.class, () -> {
			medal.setMedalType(medalTypeInvalidLower);
		});

		// Test for invalid upper bound
		assertThrows(IllegalArgumentException.class, () -> {
			medal.setMedalType(medalTypeInvalidUpper);
		});

	}
}
