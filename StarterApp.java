package olympics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Matthew Dickson & Student Number: 40062654
 * 
 * 
 */
public class StarterApp {

	// stores the data read and mapped for the csv file
	// could do this using a set as well but I used what the default starter file
	// used
	public static ArrayList<Medal> medals = new ArrayList<Medal>();

	public static void main(String[] args) {
		// read the csv file data
		readMedalFile();

		// show the menu
		showMenu();

		// test case Medal medal = new Medal(1895, "Berlin", "Football", "11men", "Bob",
		// "GBR", "Male", "1");

		// testing it - delete System.out.println(medal.getAthlete());

	}

	public static void showMenu() {
		System.out.println();
		// scanner for menu choices
		Scanner scanner = new Scanner(System.in);
		// 2nd scanner to record user inputs for particular methods
		Scanner sc = new Scanner(System.in);

		int option;
		System.out.println("Olympics stats ");
		do {
			// outputting to screen all the menu options
			System.out.println("1.  Display all medals.");
			System.out.println(
					"2.  Output to screen the details of all medals for a specified medal type won by a specified country.");
			System.out.println("3.  Output to screen the total of all medal types won by a specified country.");
			System.out.println("4.  Output to screen the results of all medals won in a particular Olympic year.");
			System.out.println("5.  Output to screen the total medals won by a specified athlete.");
			System.out.println("6.  Output to screen the last year that medals were presented for a particular sport.");
			System.out.println(
					"7.  Output to screen the total medals won by Germany (East and West and Unified Germany).");
			System.out.println("8.  Output to screen Gold medals by Gender won by a particular country.");
			System.out.println(
					"9.  Output to screen the role of honour of Olympic champions (male and female) for a particular Event.");

			System.out.println(
					"10. Output to screen each country (sorted alphabetically) with the total gold medals each has won.");
			System.out.println(
					"11. Sorted by athlete name (in reverse alphabetical order) output to screen each medal won by a particular country in a particular year in a particular sport.");
			System.out.println("12. Output to screen all host cities in alphabetical order (no duplicates).");
			System.out.println(
					"13. Capitalise the Host City e.g. Beijing to BEIJING. Then export/write to a new file (summer_updated.csv).");
			System.out.println("14. Quit");
			System.out.println("Enter option ...");
			// initialise option to 0 to initiate the while loop
			option = 0;

			// checking the user input is a valid option, otherwise prompt the user again
			while (option < 1 || option > 14) {

				// if statement to stop the message being output if the first input is valid
				if (option != 0) {
					System.out.println("Input was not between 1 and 14. Please try again");
				}
				// try to parse the input read in as a string to an integer. Otherwise catch the
				// invalid int format exception and prompt the user for another input
				try {
					option = Integer.parseInt(scanner.nextLine());

				} catch (NumberFormatException ex) {
					System.out.println("Input was not an integer. Please try again");

				}

			}

			// switch for the user inputs
			switch (option) {

			case 1:
				// output all medal awards to screen
				for (Medal medalAward : medals) {
					System.out.println(medalAward.toString());
				}
				break;
			case 2:
				// get scanner inputs for country and medal to search.
				System.out.println("Enter a 3 character country code e.g. IRL");
				
				String countryCode = sc.nextLine();

				// check if the countryCode input is a valid countryCode. Otherwise ask the user again
				while (countryCode.length() != 3) {
					System.out.println("Please enter a 3 character country code");
					countryCode = sc.nextLine();
				}

				System.out.println("Enter medal type Gold, Silver or Bronze");

				String medal = sc.nextLine();
				
				// check if the medalType input is valid, otherwise ask the user again
				while (!medal.equalsIgnoreCase("gold") && !medal.equalsIgnoreCase("silver")
						&& !medal.equalsIgnoreCase("bronze")) {
					System.out.println("Please enter a valid medal type Gold, Silver or Bronze");
					medal = sc.nextLine();
				}
				
				// call relevant method using the user inputs
				new MedalMethods().countryAndMedal(medals, countryCode, medal);

				break;
			case 3:
				// ask user to input a 3 character country
				System.out.println("Please enter a 3 character country code e.g. IRL");
				countryCode = sc.nextLine();

				// check if the countryCode input is a valid countryCode. Otherwise ask the user again
				while (countryCode.length() != 3) {
					System.out.println("Please enter a 3 character country code");
					countryCode = sc.nextLine();
				}

				// call relevant method using the user input
				new MedalMethods().countryMedalCount(medals, countryCode);
				break;

			case 4:
				// declaring int variable for user input. Initialised to 1 so it keeps asking the user
				// until a valid year is input
				int yearInput = 1;

				// ask user for a year until a valid year is entered (Olympic years are
				// divisible by 4)
				while (yearInput % 4 != 0 || (yearInput < 1896 || yearInput > 2020)) {

					System.out.println("Please enter a valid Olympic year e.g. 2012");
					// catch exceptions for inputs that are not integers
					try {
						yearInput = Integer.parseInt(sc.nextLine());
					} catch (NumberFormatException ex) {
						System.out.println("Input was not a valid year");
					}
				}
				// call relevant method using the user input
				new MedalMethods().resultsByYear(medals, yearInput);
				break;

			case 5:
				// ask user for the name of an athlete
				System.out.println("Enter an athlete e.g. Lewis Carl");
				String athleteInput = sc.nextLine();
				// call relevant method using the user input
				new MedalMethods().medalsByAthlete(medals, athleteInput);
				break;

			case 6:
				// ask user for a sport
				System.out.println("Enter a sport e.g. rugby");
				String sportInput = sc.nextLine();
				// call relevant method using the user input
				new MedalMethods().lastSportYear(medals, sportInput);
				break;

			case 7:
				// call relevant method
				new MedalMethods().germanMedals(medals);
				break;

			case 8:
				// ask user for a gender and a country
				System.out.println("Please input a gender (Men/Women)");
				String genderInput = sc.nextLine();
				System.out.println("Please enter a 3 digit country code e.g. AUS");
				String countryInput = sc.nextLine();

				// call relevant method using the user inputs
				new MedalMethods().goldByGenderByCountry(medals, genderInput, countryInput);
				break;

			case 9:
				// ask user for an olympic event
				System.out.println("Enter an olympic event e.g. shot put");
				String eventInput = sc.nextLine();
				// call relevant method using the user input
				new MedalMethods().olympicChampions(medals, eventInput);
				break;

			case 10:
				// call relevant method
				new MedalMethods().totalGoldsByCountry(medals);
				break;

			case 11:
				// ask user for a country, year and sport
				System.out.println("Please enter a country code e.g. USA");
				countryCode = sc.nextLine();
				//check if input is 3 characters. Otherwise, prompt user again
				while (countryCode.length() != 3) {
					System.out.println("Please enter a 3 character country code");
					countryCode = sc.nextLine();
				}
				
				yearInput = 1;
				//check if input is a valid olympic year. Otherwise prompt user again
				while (yearInput % 4 != 0 || (yearInput < 1896 || yearInput > 2020)) {

					System.out.println("Please enter a valid Olympic year e.g. 2012");
					// catch exceptions for inputs that are not integers
					try {
						yearInput = Integer.parseInt(sc.nextLine());
					} catch (NumberFormatException ex) {
						System.out.println("Input was not a valid year");
					}
				}
				
				System.out.println("Please enter a sport e.g. Athletics");
				String sport = sc.nextLine();

				// call relevant method using the user inputs
				new MedalMethods().medalsByCountryYearAndSport(medals, countryCode, yearInput, sport);
				break;

			case 12:
				// call relevant method
				new MedalMethods().hostCities(medals);
				break;
			case 13:
				// call relevant method
				new MedalMethods().updateSummer(medals);
				break;
			case 14:
				// exit the program
				System.out.println("Quitting");
				break;
			default:
				System.out.println("Try options again...");
			}
		} while (option != 14);
		scanner.close();
		sc.close();
	}

	// method for reading the Medal file
	public static void readMedalFile() {
		try {
			FileReader fr = new FileReader(new File("summer.csv"));
			BufferedReader br = new BufferedReader(fr);
			String[] medalDetails;
			String medalRecord;

			// Skip over the first line as it is the header of the file
			try {
				br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// read next medal in list
			medalRecord = br.readLine();

			while (medalRecord != null) {
				// declaring a new Medal object called medalAward
				Medal medalAward = new Medal();
				// parse/split the line that is separated by commas
				medalDetails = medalRecord.split(",");

				// setting the medal attributes accordingly

				try {
					// The Year is parsed from a String to an Int so it is stored as an Int
					medalAward.setYear(Integer.parseInt(medalDetails[0]));
					medalAward.setCity(medalDetails[1]);
					medalAward.setSport(medalDetails[2]);
					medalAward.setDiscipline(medalDetails[3]);
					medalAward.setAthlete(medalDetails[4]);
					medalAward.setCountry(medalDetails[5]);
					medalAward.setGender(medalDetails[6]);
					medalAward.setEvent(medalDetails[7]);
					medalAward.setMedalType(medalDetails[8]);

					// add the medal to the Arraylist of Medals
					medals.add(medalAward);

					// catching any exceptions where the data in the csv doesn't comply with the
					// specified parameters in the question. This allows the program to continue
					// running and doesn't create medals with any null attributes
				} catch (IllegalArgumentException e) {
					// output the medal that caused the issue so the user knows what is causing the
					// exception
					// Could also print the stack trace but I understand this is bad practice
					System.out.println(
							"This medal result isn't valid. The medal that caused the exception was:\n" + medalAward);
				}

				// read next medal in list
				medalRecord = br.readLine();
			}
			// close the buffered reader and the file reader
			br.close();
			fr.close();
			// catch any exceptions e.g. if the file can't be found
		} catch (FileNotFoundException e) {
			System.out.println("Can't find summer.csv file");
		} catch (IOException e) {
			System.out.println("Connection problems");
		}

	}

}
