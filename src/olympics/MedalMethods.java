/**
 * 
 */
package olympics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author Matthew Dickson & Student Number: 40062654
 * 
 */

//class to store all Methods associated with the menu options
public class MedalMethods {

	public void countryAndMedal(ArrayList<Medal> medals, String countryCode, String medal) {
		// I initially had the scanner inputs within each method but it seems to be
		// better practice to have them within the main program as when I closed the
		// scanners in the methods it created issues where the main method scanner
		// stopped working despite having different names

		System.out.println("Medals " + medal + " won by " + countryCode);

		// looping through each medal and outputting it to screen if the country code
		// matches the user input
		for (Medal medalAward : medals) {
			if (medalAward.getCountry().equalsIgnoreCase(countryCode)
					&& medalAward.getMedalType().equalsIgnoreCase(medal)) {
				System.out.println(medalAward.toString());
			}
		}
	}

	public void countryMedalCount(ArrayList<Medal> medals, String countryCode) {

		// declaring and initialising integers for each medal type
		int bronzeCount = 0;
		int silverCount = 0;
		int goldCount = 0;

		System.out.println("Medals won by " + countryCode);

		// Loop through all medals and increment the relevant medal count if the country
		// won a medal
		for (Medal medalAward : medals) {
			if (medalAward.getCountry().equalsIgnoreCase(countryCode)
					&& medalAward.getMedalType().equalsIgnoreCase("Bronze")) {
				bronzeCount++;
			} else if (medalAward.getCountry().equalsIgnoreCase(countryCode)
					&& medalAward.getMedalType().equalsIgnoreCase("Silver")) {
				silverCount++;
			} else if (medalAward.getCountry().equalsIgnoreCase(countryCode)
					&& medalAward.getMedalType().equalsIgnoreCase("Gold")) {
				goldCount++;
			}

		}

		// outputting the total medal counts formatted for appearance
		System.out.printf("Gold   : %4d%n", goldCount);
		System.out.printf("Silver : %4d%n", silverCount);
		System.out.printf("Bronze : %4d%n", bronzeCount);

	}

	public void resultsByYear(ArrayList<Medal> medals, int yearInput) {

		System.out.println("Medals in " + yearInput);

		// loop through all medals to output to screen if they match the year input from
		// the user
		for (Medal medalAward : medals) {
			if (medalAward.getYear() == yearInput) {
				System.out.println(medalAward.toString());
			}
		}

	}

	public void medalsByAthlete(ArrayList<Medal> medals, String athleteInput) {
		// declaring and initialising an int to store the number of medals won
		int medalsCount = 0;

		// looping through all the medals and incrementing medals won by 1
		for (Medal medalAward : medals) {
			if (medalAward.getAthlete().equalsIgnoreCase(athleteInput)) {
				medalsCount++;
			}
		}
		// if the users input has not won any medals output to screen that they may have
		// entered invalid details
		if (medalsCount == 0) {
			System.out.println("Did you enter a valid athlete with their surname followed by their first name?");
		}
		// otherwise output the number of medals won by the athlete that the user input
		else
			System.out.println("Total medals won by " + athleteInput + " : " + medalsCount);
	}

	public void lastSportYear(ArrayList<Medal> medals, String sportInput) {

		// declaring an int and initialising it to 0 to store the most recent year the
		// event was
		// played at the olympics. (It is set to 0 so if it is not updated, the method
		// will ask
		// if the user entered a valid sport)
		int lastYear = 0;
		// declaring a String to store the last city to host the sport and initialised
		// as empty in case no cities are found.
		String lastCity = "";

		// loop through all the medals from 1896 onwards and update last year and last
		// city if there is a sport that matches the user input
		for (Medal medalAward : medals) {
			if (medalAward.getDiscipline().equalsIgnoreCase(sportInput)) {
				lastYear = medalAward.getYear();
				lastCity = medalAward.getCity();
			}
		}
		// catch sports that have been mistyped or never in the olympics
		if (lastYear == 0) {
			System.out.println("Are you sure you entered a valid sport?");
		} // otherwise output the desired result
		else
			System.out.println("Last year for " + sportInput + " : " + lastYear + " in " + lastCity);
		;

	}

	public void germanMedals(ArrayList<Medal> medals) {
		// declaring and initialising an int to store the number of medals won
		int medalCount = 0;
		// looping through all medals and incrementing the medal count if the country
		// matches either Germany, GDR or FRG
		for (Medal medalAward : medals) {
			if (medalAward.getCountry().equalsIgnoreCase("GER") || medalAward.getCountry().equalsIgnoreCase("GDR")
					|| medalAward.getCountry().equalsIgnoreCase("FRG")) {
				medalCount++;
			}
		}
		// outputting final medal count
		System.out.println("Total medals won by Germany (GDR and FRG and unified GER) : " + medalCount);
	}

	public void goldByGenderByCountry(ArrayList<Medal> medals, String genderInput, String countryInput) {
		// declaring an int and initialising it to zero to store the number of golds won
		int goldCount = 0;

		// looping through all the medals and incrementing the goldcount by 1 if the
		// gender and country match the input and the medal won was Gold
		for (Medal medalAward : medals) {
			if (medalAward.getGender().equalsIgnoreCase(genderInput)
					&& medalAward.getCountry().equalsIgnoreCase(countryInput)
					&& medalAward.getMedalType().equalsIgnoreCase("Gold")) {
				goldCount++;
			}
		}
		// outputting the number of golds won by the gender and country specified
		System.out.println(
				"Medals GOLD won by " + genderInput + " from " + countryInput.toUpperCase() + " : " + goldCount);

	}

	public void olympicChampions(ArrayList<Medal> medals, String eventInput) {
		// string to hold sex of athlete
		String sex;

		System.out.println("Gold medal winners in " + eventInput);
		// looping through all medal awards
		for (Medal medalAward : medals) {
			// check if the event matches the one the user input and the medal won was gold
			if (medalAward.getEvent().equalsIgnoreCase(eventInput)
					&& medalAward.getMedalType().equalsIgnoreCase("Gold")) {
				// check the sex to update how the gender is formatted when printed
				if (medalAward.getGender().equalsIgnoreCase("Men")) {
					sex = "(M)";

				} else
					sex = "(F)";
				System.out.println(medalAward.getYear() + " " + medalAward.getAthlete() + sex);
			}
		}
	}

	public void totalGoldsByCountry(ArrayList<Medal> medals) {

		// create Map to map the country codes with the integer count of gold medals
		Map<String, Integer> medalMap = new HashMap<String, Integer>();
		// loop through all medals and increment the gold count for a particular country
		// if the country already exists in the map, otherwise create a country and give
		// it a gold count of 1
		for (Medal medalAward : medals) {
			if (medalAward.getMedalType().equalsIgnoreCase("GOLD")) {
				medalMap.merge(medalAward.getCountry(), 1, Integer::sum);
			}
		}

		// create TreeMap to sort the HashMap
		Map<String, Integer> sortedMap = new TreeMap<String, Integer>(medalMap);
		// loop through the TreeMap and print out the countries(key) and the gold count
		// (values)
		for (String i : sortedMap.keySet()) {
			System.out.println(i + " : " + sortedMap.get(i));
		}

	}

//method to output medals won by a user specified country, year and sport. Sorted in reverse alphabetical order by athlete name
	public void medalsByCountryYearAndSport(ArrayList<Medal> medals, String countryCode, int year, String sport) {

		// create arraylist to store medal winners depending on the country, year and
		// sport input by the user. Used arraylist rather than a map with athletes names
		// as keys to catch any athletes who won more than 1 medal
		ArrayList<Medal> winners = new ArrayList<Medal>();

		// Add to arraylist only those results that meet the user inputs
		for (Medal medalAward : medals) {
			if (medalAward.getCountry().equalsIgnoreCase(countryCode) && medalAward.getYear() == year
					&& medalAward.getSport().equalsIgnoreCase(sport)) {
				winners.add(medalAward);
			}
		}

		// sort the arraylist by athletes name
		Collections.sort(winners, (athlete1, athlete2) -> athlete1.getAthlete().compareTo(athlete2.getAthlete()));

		// reverse the arrayList
		Collections.reverse(winners);

		// Check if there were medal winners and output a message if not. Otherwise Loop
		// through the list of winners and output the Medal details
		if (winners.isEmpty() == true) {
			System.out.println(
					"There were no medal winners for the parameters entered. Please check what you entered and try again");
		}

		else {
			for (Medal result : winners) {
				System.out.println(result);
			}
		}
	}

//method to output unique host cities to screen
	public void hostCities(ArrayList<Medal> medals) {
		// create array list to store the cities
		ArrayList<String> hostCity = new ArrayList<String>();
		// loop through each medal result and add the host city to it if it hasn't
		// already been added.
		// could do this using a Hashset but would have to iterate over the array to
		// create the set so do not think there is a significant difference in
		// efficiency
		for (Medal medalAward : medals) {
			if (!hostCity.contains(medalAward.getCity())) {
				hostCity.add(medalAward.getCity());
			}
		}
		// sort the array list in alphabetical order
		hostCity.sort(String::compareToIgnoreCase);

		// output the hostCity arraylist. Reformatted to remove the square brackets per
		// the example output in the question
		System.out.println(hostCity.stream().map(i -> i.toString()).collect(Collectors.joining(", ")));
	}

	public void updateSummer(ArrayList<Medal> medals) {
		// create csv file called summer_updated
		File newSummerFile = new File("summer_updated.csv");
		try {

			// Create a filewriter using false to clear the file if there is already existing
			// data in the file
			FileWriter fw = new FileWriter(newSummerFile, false);
			BufferedWriter bw = new BufferedWriter(fw);

			// Writing the header to the file
			bw.write("Year,City,Sport,Athlete,Country,Medal");

			// looping through all the results and writing them to the file as instructed
			for (Medal medalAward : medals) {
				bw.newLine();
				bw.write(String.valueOf(medalAward.getYear()));
				bw.write(",");
				bw.write(medalAward.getCity().toUpperCase());
				bw.write(",");
				bw.write(medalAward.getSport());
				bw.write(",");
				bw.write(medalAward.getAthlete());
				bw.write(",");
				bw.write(medalAward.getCountry());
				bw.write(",");
				bw.write(medalAward.getMedalType());

			}
			bw.close();
			fw.close();
			System.out.println("File write successful");

			// catch exceptions e.g. if the file is not found
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
