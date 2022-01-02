
package olympics;

/**
 * @author Matthew Dickson & Student Number: 40062654
 *
 */

//This is the Class for the Medal object which contains the constructors and getters and setters for the Medal objects and associated attributes.
public class Medal {

	// declare variables for all the attributes in the table.
	private int year;
	private String city;
	private String sport;
	private String discipline;
	private String athlete;
	private String country;
	private String gender;
	private String event;
	private String medalType;

	// default constructor for a medal
	public Medal() {

	}

	// constructor for a medal with all attributes
	public Medal(int year, String city, String sport, String discipline, String athlete, String country, String gender,
			String event, String medalType) {
		// using this.setYear etc. to engage with the validation for each attribute.
		this.setYear(year);
		this.setCity(city);
		this.setSport(sport);
		this.setDiscipline(discipline);
		this.setAthlete(athlete);
		this.setCountry(country);
		this.setGender(gender);
		this.setEvent(event);
		this.setMedalType(medalType);

	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year: This is the year to set and is set between 1896 and 2020 so no
	 *              values are accepted beyond the most recent olympic year or
	 *              before the olympics began.
	 */
	public void setYear(int year) {
		// restricted to multiples of 4 as these are the years that the Olympics
		// occurred
		if (year >= 1896 && year <= 2020 && year % 4 == 0) {
			this.year = year;
		} else
			throw new IllegalArgumentException("Invalid Year");
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city: This is the city to set. Restricted to only allow inputs of at
	 *              least 1 character but less than 30 characters
	 */
	public void setCity(String city) {
		if (city.length() >= 1 && city.length() < 30) {
			this.city = city;
		} else {
			throw new IllegalArgumentException("Invalid City format");
		}
	}

	/**
	 * @return the sport
	 */
	public String getSport() {
		return sport;
	}

	/**
	 * @param sport: This is the sport to set. Restricted to only allow inputs of at
	 *               least 1 character but less than 50 characters
	 */
	public void setSport(String sport) {
		if (sport.length() >= 1 && sport.length() < 50) {
			this.sport = sport;
		} else
			throw new IllegalArgumentException("Invalid Sport format");
	}

	/**
	 * @return the discipline
	 */
	public String getDiscipline() {
		return discipline;
	}

	/**
	 * @param discipline: This is the discipline to set. Restricted to only allow
	 *                    inputs of at least 1 character but less than 80 characters
	 */
	public void setDiscipline(String discipline) {
		if (discipline.length() >= 1 && discipline.length() < 80) {
			this.discipline = discipline;
		} else
			throw new IllegalArgumentException("Invalid Discipline format");
	}

	/**
	 * @return the athlete
	 */
	public String getAthlete() {
		return athlete;
	}

	/**
	 * @param athlete: This is the athlete to set. Restricted to only allow inputs
	 *                 of at least 1 character but less than 80 characters
	 */
	public void setAthlete(String athlete) {
		if (athlete.length() >= 1 && athlete.length() < 80) {
			this.athlete = athlete;
		} else
			throw new IllegalArgumentException("Invalid Athlete format");
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country: This is the country to set. Restricted to 3 letter inputs.
	 *                 Further work could be done to restrict this to the valid
	 *                 olympic country abbreviations e.g. not "ZZZ". Noted one of the countries is RU1 but the question didn't specify to only accept alphabetic characters
	 */
	public void setCountry(String country) {
		if (country.length() == 3) {
			this.country = country;
		} else
			throw new IllegalArgumentException("Invalid Country format");
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender: This is the gender to set. Restricted to at least 1 character
	 *                but less than 10. Should be restricted to men/women rather
	 *                than just any character input >=1 and < 10
	 */
	public void setGender(String gender) {
		if (gender.length() >= 1 && gender.length() < 10) {
			this.gender = gender;
		} else
			throw new IllegalArgumentException("Invalid Gender format");
	}

	/**
	 * @return the event
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * @param event: This is the event to set. Restricted to only allow inputs of at
	 *               least 1 character but less than to 50 characters although 1
	 *               event is 50 characters in length - "75 - 82.5KG One-Two Hand 3
	 *               E. (Light-Heavyweight)". I think this is an oversight
	 * 
	 */
	public void setEvent(String event) {
		if (event.length() >= 1 && event.length() < 50) {
			this.event = event;
		} else
			throw new IllegalArgumentException("Invalid Event format");
			
	}

	/**
	 * @return the medal
	 */
	public String getMedalType() {
		return medalType;
	}

	/**
	 * @param medal: This is the medal to set. Restricted to strings of either '1',
	 *               '2' or '3'.
	 */
	public void setMedalType(String medalType) {
		// if input is 1, 2 or 3, the medalType is set to GOLD, SILVER or BRONZE
		// respectively.
		if (medalType.equalsIgnoreCase("1")) {
			this.medalType = "GOLD";
		} else if (medalType.equalsIgnoreCase("2")) {
			this.medalType = "SILVER";
		} else if (medalType.equalsIgnoreCase("3")) {
			this.medalType = "BRONZE";
		} else
			throw new IllegalArgumentException("Not a valid Medal type format");
	}

	@Override
	// toString method to assist with displaying medals in console
	public String toString() {
		return "Medal [year=" + year + ", city=" + city + ", sport=" + sport + ", discipline=" + discipline
				+ ", athlete=" + athlete + ", country=" + country + ", gender=" + gender + ", event=" + event
				+ ", medalType=" + medalType + "]";
	}

}
