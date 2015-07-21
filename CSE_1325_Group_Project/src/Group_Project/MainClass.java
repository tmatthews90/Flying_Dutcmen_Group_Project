package Group_Project;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/* 
 * Main class
 */
public class MainClass {
	/*
	 * Below are all the variables that will be used within the scope of the
	 * main class.
	 */
	private static Scanner input = new Scanner(System.in);
	private static Scanner stringInputs = new Scanner(System.in);
	public static Map map = new Map();
	public static Port port = new Port();
	public static FileHandler fileHandler = new FileHandler();
	private static Scanner name;
	protected static GUI GUI = new GUI();

	/*
	 * The main method will call the mainMenu() method and will handle all
	 * possible exceptions.
	 */
	public static void main(String[] args) throws InputMismatchException,
			FileNotFoundException, UnsupportedEncodingException {

		try {
			mainMenu();

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();

			System.out.println("-------------");
			System.out.println("FILE NOT FOUND");
			System.out.println("-------------");

			mainMenu();
		} catch (InputMismatchException ime) {
			ime.printStackTrace();

			@SuppressWarnings("unused")
			String throwaway = input.nextLine();
			System.out.println("-----------------");
			System.out.println("NOT A VALID INPUT");
			System.out.println("-----------------");

			mainMenu();
		} catch (NullPointerException npe) {
			npe.printStackTrace();

			System.out.println("------------------------");
			System.out.println("Error performing task...");
			System.out.println("------------------------");
			mainMenu();

		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();

			System.out.println("------------------------");
			System.out.println("Error performing task...");
			System.out.println("------------------------");
		} catch (Exception e) {
			e.printStackTrace();

			System.out.println("------------------------");
			System.out.println("Error performing task...");
			System.out.println("------------------------");
		}

		input.close();
		stringInputs.close();

	}

	/*
	 * The main menu gives the user to select any one of 7 choices as follow: 1)
	 * Show the stundet ID information to the user 2) Load the systoem based on
	 * an user inputted tag to load the .map.txt and .port.txt files. 3) Access
	 * the ship menu. 4) Give the user access to the port menu. 5) Displays the
	 * user a 36x54 text display of the current map representation. 6) Show the
	 * user a current report, which shows the user the current dock(s) and
	 * cargo(s) in the port. 7) Exit the program.
	 */
	public static void mainMenu() throws InputMismatchException,
			FileNotFoundException, UnsupportedEncodingException {

		boolean mainMenu = true;

		while (mainMenu) {
			try {
				System.out.println();
				System.out.println("Main Menu");
				System.out.println("-------------");
				System.out.println("1. Show Group Info");
				System.out.println("2. Load System");
				System.out.println("3. Ship Menu");
				System.out.println("4. Port Menu");
				System.out.println("5. Show Map");
				System.out.println("6. Display Report");
				System.out.println("7. Monster Menu");
				System.out.println("8. Snapshot");
				System.out.println("9. Quit");
				System.out.println();

				int mainMenuChoice = input.nextInt();

				switch (mainMenuChoice) {

				case 1:
					studentInfo();
					break;

				case 2:
					// shipMenu();
					loadMapV2();
					break;

				case 3:
					// portMenu();
					shipMenu();
					break;

				case 4:
					portMenu();
					break;

				case 5:
					map.displayMapV2(port);
					break;

				case 6:
					if (!port.getListOfDocks().isEmpty()) {
						System.out.println("Docks in port");
						System.out
								.println("------------------------------------");
						port.displayDocks();
					} else {
						System.out
								.println("------------------------------------");
						System.out.println("No dock(s) in the port.");
						System.out
								.println("------------------------------------");
					}

					if (!port.getListOfCargos().isEmpty()) {
						System.out.println("Cargos in port");
						System.out
								.println("------------------------------------");
						port.displayCargos();
					} else {
						System.out
								.println("------------------------------------");
						System.out.println("No cargo(s) in the port.");
						System.out
								.println("------------------------------------");
					}

					break;

				case 9:
					mainMenu = false;
					break;

				case 7:
					monsterMenu();
					break;

				case 8:
					fileHandler.snapShot(port, map);
					break;

				default:
					mainMenu = false;
					break;
				}
			} catch (InputMismatchException ime) {
				@SuppressWarnings("unused")
				String throwaway = input.nextLine();
				System.out.println("NOT A VALID INPUT");

			}
		}

	}

	/*
	 * Menu which will be used to handle all tasks pertaining with the monsters
	 * and/or Godzilla.
	 */
	public static void monsterMenu() throws InputMismatchException,
			FileNotFoundException {

		boolean monsterMenu = true;
		int monsterSelection;

		while (monsterMenu) {

			System.out.println();
			System.out.println("Monster Menu");
			System.out.println("----------------------");
			System.out.println("1. Generate Monster(s)");
			System.out.println("2. Display Monster(s)");
			System.out.println("3. Generate Godzilla");
			System.out.println("4. Update Monster(s) Position");
			System.out.println("5. Kill Order");
			System.out.println("6. Clear All Monsters");
			System.out.println("7. Previous menu");
			System.out.println("----------------------");
			System.out.println();

			int monsterMenuChoice = input.nextInt();

			if (((monsterMenuChoice == 4) || (monsterMenuChoice == 5))
					&& map.getMonsterList().size() == 0) {
				System.out.println("There are no monsters to change");
			} else {
				switch (monsterMenuChoice) {

				case 1:
					generateMonsters();
					break;

				case 2:
					if (map.getMonsterList().isEmpty()) {
						System.out
								.println("There are no Mosters to display, please generate monsters.");
					} else {
						map.displayMonsters();
					}
					break;

				case 3:
					int godzillaCount = 0;
					for (int i = 0; i < map.getMonsterList().size(); i++) {
						if (map.getMonsterList().get(i).getLabel() == "Godzilla") {
							godzillaCount++;
							break;
						}
					}

					if (godzillaCount == 0) {
						SeaMonster tempGodzilla = new Godzilla();
						map.getMonsterList().add(tempGodzilla);
						System.out.println();
						System.out.println("Godzilla Created");
					} else {
						System.out.println("Godzilla already Exists");
					}

					break;

				case 4:
					map.displayMonsterByIndice();
					System.out
							.println("Which Monster's row and column would you like to change (Enter Monster number)?");
					monsterSelection = input.nextInt();
					name = new Scanner(System.in);

					System.out
							.println("Enter the monster's row (between 1-36):");
					int newRow = name.nextInt();
					if (newRow >= 1 && newRow <= 36) {
						map.getMonsterList().get(monsterSelection - 1).position
								.setRowPosition(newRow - 1);
						System.out
								.println("Enter the monster's column (between 1-54):");
						int newColumn = name.nextInt();

						if (newColumn >= 1 && newColumn <= 54) {
							map.getMonsterList().get(monsterSelection - 1).position
									.setColumnPosition(newColumn - 1);
						}

						else {
							System.out.println("-----------------------");
							System.out.println("Not a valid column input.");
							System.out.println("-----------------------");
						}

					}

					else {
						System.out.println("----------------------");
						System.out.println("Not a valid row input.");
						System.out.println("----------------------");
					}

					break;

				case 5:
					int shipSelection;
					map.displayMonsterByIndice();
					System.out
							.println("Which Monster would you like to control (Enter Monster number)?");
					monsterSelection = input.nextInt();

					if (map.getMonsterList().get(monsterSelection - 1)
							.getLabel() == "Godzilla") {
						if (map.getMonsterList().size() > 1) {
							map.displayMonsterByIndice();
							System.out
									.println("Which monster would you like Godzilla to kill (Enter monster indice)?");
							int killSelection = input.nextInt();
							if (monsterSelection == killSelection) {
								System.out
										.println("Godzilla can't kill him/herself");
							} else if (killSelection <= map.getMonsterList()
									.size() && killSelection > 0) {
								map.getMonsterList().get(monsterSelection - 1).position
										.setLatitudePosition(map
												.getMonsterList().get(
														killSelection - 1).position
												.getLatitudePosition());
								map.getMonsterList().get(monsterSelection - 1).position
										.setLongitudePosition(map
												.getMonsterList().get(
														killSelection - 1).position
												.getLongitudePosition());
								System.out.println();
								map.getMonsterList().get(monsterSelection - 1)
										.battleCry();
								System.out.println();
								System.out.println(map.getMonsterList()
										.get(monsterSelection - 1).getLabel()
										+ " killed "
										+ map.getMonsterList()
												.get(killSelection - 1)
												.getLabel());
								map.getListOfShips().remove(killSelection - 1);
							}
						} else {
							System.out
									.println("There are no other monsters for Godzilla to kill");
						}
					} else {
						if (map.getListOfShips().size() == 0) {
							System.out.println("There are no ships to destroy");
						} else {
							map.displayShipByIndice();
							System.out
									.printf("\nWhich ship would you like %s to destroy (Enter ship indice)?",
											map.getMonsterList()
													.get(monsterSelection - 1)
													.getLabel());
							shipSelection = input.nextInt();
							if (shipSelection <= map.getListOfShips().size()
									&& shipSelection > 0) {
								map.getMonsterList().get(monsterSelection - 1).position
										.setLatitudePosition(map
												.getListOfShips()
												.get(shipSelection - 1)
												.getLatitude());
								map.getMonsterList().get(monsterSelection - 1).position
										.setLongitudePosition(map
												.getListOfShips()
												.get(shipSelection - 1)
												.getLongitude());
								System.out.println();
								map.getMonsterList().get(monsterSelection - 1)
										.battleCry();
								System.out.println();
								System.out.println(map.getMonsterList()
										.get(monsterSelection - 1).getLabel()
										+ " destroyed "
										+ map.getListOfShips()
												.get(shipSelection - 1)
												.getName());
								map.getListOfShips().remove(shipSelection - 1);
							}
						}
					}
					break;

				case 6:
					map.getMonsterList().clear();
					System.out.println("Monsters Cleared");
					break;

				case 7:
					monsterMenu = false;
					break;
				}
			}
		}
	}

	/*
	 * studentInfo() method displays student info to the user
	 */
	public static void studentInfo() {
		System.out.println("Group Name: Flying Dutchmen");
		System.out.println("Gabino Luna");
		System.out.println("David Camacho");
		System.out.println("Travis Matthews");

	}

	/*
	 * The ship menu gives the user the ability to 1) Generate random ships 2)
	 * Update ships (Loaded or generated) 3) Display all of the ships 4) Remove
	 * all the ships in the map 5) And return to the mainMenu().
	 */
	public static void shipMenu() throws InputMismatchException,
			FileNotFoundException {
		boolean shipMenu = true;

		while (shipMenu) {

			System.out.println();
			System.out.println("Ship Menu");
			System.out.println("----------------------");
			System.out.println("1. Generate Ship(s)");
			System.out.println("2. Update Ship(s)");
			System.out.println("3. Display Ship(s)");
			System.out.println("4. Remove All Ship(s)");
			System.out.println("5. Previous menu");
			System.out.println("----------------------");
			System.out.println();

			int shipMenuChoice = input.nextInt();

			switch (shipMenuChoice) {

			case 1:
				generateShipsV2();
				break;

			case 2:
				if (map.getListOfShips().isEmpty()) {
					System.out
							.println("There are no Ships to update, please generate ships.");
				} else {
					updateShips();
				}
				break;

			case 3:
				map.getShipsInfo();
				break;

			case 4:
				map.getListOfShips().clear();
				break;

			case 5:
				shipMenu = false;
				break;
			}
		}
	}

	/*
	 * The generateShipsV2() method allows the user to create between 1 and 10
	 * ships. The name, type of ship, and coordinates of the ship are randomly
	 * generated, checked against a map file that has been selected by the user
	 * to be checked on. Meaning if any of the ships generated are on the land
	 * in the created map, the program will regenerate those ships.
	 */
	public static void generateShipsV2() throws FileNotFoundException,
			InputMismatchException {
		System.out
				.println("Please enter the number of cargo ships (15 ships available)");

		int numberOfShips = input.nextInt();

		if (numberOfShips > 0 && numberOfShips <= 15) {

			Random randomIntGen = new Random();
			Random randomLongGen = new Random();
			Random randomGen = new Random();
			int randomNum;
			long transponder;

			String[] firstNames = { "Red ", "Green ", "Dark ", "Light ",
					"Day ", "Night ", "Savanah ", "Mountain ", "Captain's ",
					"Admiral's " };
			String[] secondNames = { "Buffalo", "Pastures", "Knight", "Wave",
					"Star", "Moon", "Lion", "Goat", "Pride", "Joy" };
			String name;
			String[] typeOfShips = { "Cargo Ship", "Container Ship",
					"Tanker Ship" };
			String shipType;

			for (int i = 0; i < numberOfShips; i++) {
				name = null;
				shipType = null;
				randomNum = randomIntGen.nextInt(10);
				name = firstNames[randomNum];
				randomNum = randomIntGen.nextInt(10);
				name += secondNames[randomNum];

				transponder = Long
						.valueOf((randomLongGen.nextInt(8999999) + 1000000));

				randomNum = randomIntGen.nextInt(3);
				shipType = typeOfShips[randomNum];

				if (randomNum == 0) {
					map.getListOfShips().add(
							new CargoShip(shipType, name, transponder));
				}

				if (randomNum == 1) {
					map.getListOfShips().add(
							new ContainerShip(shipType, name, transponder));
				}

				if (randomNum == 2) {
					map.getListOfShips().add(
							new Tanker(shipType, name, transponder));
				}

				int currentShipIndice = map.getListOfShips().size() - 1;

				double shipLatitude = map.getListOfShips()
						.get(currentShipIndice).getLatitude();
				double shipLongitude = map.getListOfShips()
						.get(currentShipIndice).getLongitude();

				int shipRow = MapConverter.lat2row(shipLatitude);
				int shipCol = MapConverter.lon2col(shipLongitude);

				if (map.getMapRepresentation()[shipRow][shipCol] == '*') {
					int newShipRow = shipRow;
					int newShipCol = shipCol;

					while (map.getMapRepresentation()[newShipRow][newShipCol] == '*') {

						double newLongtitude = randomGen.nextDouble()
								* (-2.988478 - (-3.035000)) + (-3.035000);
						double newLatitude = randomGen.nextDouble()
								* (53.457561 - 53.396700) + (53.396700);

						map.getListOfShips().get(currentShipIndice)
								.setLongitude(newLongtitude);
						map.getListOfShips().get(currentShipIndice)
								.setLatitude(newLatitude);

						newShipRow = MapConverter.lat2row(newLatitude);
						newShipCol = MapConverter.lon2col(newLongtitude);
					}

				}
			}

		}

		else if (map.getListOfShips().size() > 0) {
			System.out.println("-------------------");
			System.out.println("Ships already exist.");
			System.out.println("-------------------");
		}

		else {
			System.out.println("-------------------");
			System.out.println("Input out of range.");
			System.out.println("-------------------");
		}
	}

	/*
	 * The generateShipsV4() method allows the user to create any number of
	 * ships. The name, type of ship, and coordinates of the ship are randomly
	 * generated, checked against a map file that has been selected by the user
	 * to be checked on. Meaning if any of the ships generated are on the land
	 * in the created map, the program will regenerate those ships.
	 */
	public static void generateShipsV3(int numberOfShips)
			throws FileNotFoundException, InputMismatchException {

		Random randomIntGen = new Random();
		Random randomLongGen = new Random();
		Random randomGen = new Random();
		int randomNum;
		long transponder;

		String[] firstNames = { "Red ", "Green ", "Dark ", "Light ", "Day ",
				"Night ", "Savanah ", "Mountain ", "Captain's ", "Admiral's " };
		String[] secondNames = { "Buffalo", "Pastures", "Knight", "Wave",
				"Star", "Moon", "Lion", "Goat", "Pride", "Joy" };
		String name;
		String[] typeOfShips = { "Cargo Ship", "Container Ship", "Tanker Ship" };
		String shipType;

		for (int i = 0; i < numberOfShips; i++) {
			name = null;
			shipType = null;
			randomNum = randomIntGen.nextInt(10);
			name = firstNames[randomNum];
			randomNum = randomIntGen.nextInt(10);
			name += secondNames[randomNum];

			transponder = Long
					.valueOf((randomLongGen.nextInt(8999999) + 1000000));

			randomNum = randomIntGen.nextInt(3);
			shipType = typeOfShips[randomNum];

			if (randomNum == 0) {
				map.getListOfShips().add(
						new CargoShip(shipType, name, transponder));
			}

			if (randomNum == 1) {
				map.getListOfShips().add(
						new ContainerShip(shipType, name, transponder));
			}

			if (randomNum == 2) {
				map.getListOfShips().add(
						new Tanker(shipType, name, transponder));
			}

			int currentShipIndice = map.getListOfShips().size() - 1;

			double shipLatitude = map.getListOfShips().get(currentShipIndice)
					.getLatitude();
			double shipLongitude = map.getListOfShips().get(currentShipIndice)
					.getLongitude();

			int shipRow = MapConverter.lat2row(shipLatitude);
			int shipCol = MapConverter.lon2col(shipLongitude);

			if (map.getMapRepresentation()[shipRow][shipCol] == '*') {
				int newShipRow = shipRow;
				int newShipCol = shipCol;

				while (map.getMapRepresentation()[newShipRow][newShipCol] == '*') {

					double newLongtitude = randomGen.nextDouble()
							* (-2.988478 - (-3.035000)) + (-3.035000);
					double newLatitude = randomGen.nextDouble()
							* (53.457561 - 53.396700) + (53.396700);

					map.getListOfShips().get(currentShipIndice)
							.setLongitude(newLongtitude);
					map.getListOfShips().get(currentShipIndice)
							.setLatitude(newLatitude);

					newShipRow = MapConverter.lat2row(newLatitude);
					newShipCol = MapConverter.lon2col(newLongtitude);
				}

			}
		}
	}

	/*
	 * The user will be able to randomly generate any number of monsters to be
	 * displayed on the map. This is used witht the text menu.
	 */
	public static void generateMonsters() throws FileNotFoundException,
			InputMismatchException {

		System.out.println("Please enter number of monsters to create:");

		int numberOfMonsters = input.nextInt();

		int seaSerpentCount = 0;
		int leviathanCount = 0;
		int krakenCount = 0;

		for (int i = 0; i < map.getMonsterList().size(); i++) {
			{
				if (map.getMonsterList().get(i) instanceof SeaSerpent) {
					seaSerpentCount++;
				}
				if (map.getMonsterList().get(i) instanceof Leviathan) {
					leviathanCount++;
				}
				if (map.getMonsterList().get(i) instanceof Kraken) {
					krakenCount++;
				}
			}

		}

		for (int i = 0; i < numberOfMonsters; i++) {

			Random r = new Random();
			int randomMonster = r.nextInt(3);

			switch (randomMonster) {
			case 0: // Sea Serpent
				seaSerpentCount++;

				SeaMonster tempSeaSerpent = new SeaSerpent(seaSerpentCount);
				tempSeaSerpent.setMonsterCount(seaSerpentCount);
				map.getMonsterList().add(tempSeaSerpent);

				break;
			case 1: // Leviathan
				leviathanCount++;
				SeaMonster tempLeviathan = new Leviathan(leviathanCount);
				tempLeviathan.setMonsterCount(leviathanCount);
				map.getMonsterList().add(tempLeviathan);

				break;
			case 2: // Kraken
				krakenCount++;
				SeaMonster tempKraken = new Kraken(krakenCount);
				map.getMonsterList().add(tempKraken);

				break;
			}

			int currentMonsterIndice = map.getMonsterList().size() - 1;

			int monsterRow = map.getMonsterList().get(currentMonsterIndice).position
					.getRowPosition();
			int monsterCol = map.getMonsterList().get(currentMonsterIndice).position
					.getColumnPosition();

			Random randomGen = new Random();

			if (map.getMapRepresentation()[monsterRow][monsterCol] != '.') {
				int newMonsterRow = monsterRow;
				int newMonsterCol = monsterCol;

				while (map.getMapRepresentation()[newMonsterRow][newMonsterCol] == '*') {

					double newLongtitude = randomGen.nextDouble()
							* (-2.988478 - (-3.035000)) + (-3.035000);
					double newLatitude = randomGen.nextDouble()
							* (53.457561 - 53.396700) + (53.396700);

					map.getMonsterList().get(currentMonsterIndice).position
							.setLongitudePosition(newLongtitude);
					map.getMonsterList().get(currentMonsterIndice).position
							.setLatitudePosition(newLatitude);

					newMonsterRow = MapConverter.lat2row(newLatitude);
					newMonsterCol = MapConverter.lon2col(newLongtitude);
				}
			}
		}
		System.out.printf("\n%d Monsters Randomly Created\n", numberOfMonsters);
	}

	/*
	 * The user will be able to randomly generate any number of monsters to be
	 * displayed on the map. V2 is used witht the GUI.
	 */
	public static void generateMonstersV2(int numberOfMonsters)
			throws FileNotFoundException, InputMismatchException {

		int seaSerpentCount = 0;
		int leviathanCount = 0;
		int krakenCount = 0;

		for (int i = 0; i < map.getMonsterList().size(); i++) {
			{
				if (map.getMonsterList().get(i) instanceof SeaSerpent) {
					seaSerpentCount++;
				}
				if (map.getMonsterList().get(i) instanceof Leviathan) {
					leviathanCount++;
				}
				if (map.getMonsterList().get(i) instanceof Kraken) {
					krakenCount++;
				}
			}

		}

		for (int i = 0; i < numberOfMonsters; i++) {

			Random r = new Random();
			int randomMonster = r.nextInt(3);

			switch (randomMonster) {
			case 0: // Sea Serpent
				seaSerpentCount++;

				SeaMonster tempSeaSerpent = new SeaSerpent(seaSerpentCount);
				tempSeaSerpent.setMonsterCount(seaSerpentCount);
				map.getMonsterList().add(tempSeaSerpent);

				break;
			case 1: // Leviathan
				leviathanCount++;
				SeaMonster tempLeviathan = new Leviathan(leviathanCount);
				tempLeviathan.setMonsterCount(leviathanCount);
				map.getMonsterList().add(tempLeviathan);

				break;
			case 2: // Kraken
				krakenCount++;
				SeaMonster tempKraken = new Kraken(krakenCount);
				map.getMonsterList().add(tempKraken);

				break;
			}

			int currentMonsterIndice = map.getMonsterList().size() - 1;

			int monsterRow = map.getMonsterList().get(currentMonsterIndice).position
					.getRowPosition();
			int monsterCol = map.getMonsterList().get(currentMonsterIndice).position
					.getColumnPosition();

			Random randomGen = new Random();

			if (map.getMapRepresentation()[monsterRow][monsterCol] != '.') {
				int newMonsterRow = monsterRow;
				int newMonsterCol = monsterCol;

				while (map.getMapRepresentation()[newMonsterRow][newMonsterCol] != '.') {

					double newLongtitude = randomGen.nextDouble()
							* (-2.988478 - (-3.035000)) + (-3.035000);
					double newLatitude = randomGen.nextDouble()
							* (53.457561 - 53.396700) + (53.396700);

					map.getMonsterList().get(currentMonsterIndice).position
							.setLongitudePosition(newLongtitude);
					map.getMonsterList().get(currentMonsterIndice).position
							.setLatitudePosition(newLatitude);

					newMonsterRow = MapConverter.lat2row(newLatitude);
					newMonsterCol = MapConverter.lon2col(newLongtitude);
				}
			}
		}
	}

	/*
	 * The user will be displayed each ship available by its indice and its
	 * name. Then the user will be able to change any of the ship's properties
	 * by selecting which property to change, and the selecting the ship by
	 * indice.
	 */
	public static void updateShips() throws NullPointerException,
			InputMismatchException {
		boolean updateShipMenu = true;
		while (updateShipMenu) {

			map.displayShipByIndice();
			System.out.println();
			System.out.println("Ship Properties Menu");
			System.out.println("--------------------");
			System.out.println("1. Update Name");
			System.out.println("2. Update Registration");
			System.out.println("3. Update Transponder");
			System.out.println("4. Update Capacity");
			System.out.println("5. Update Length");
			System.out.println("6. Update Beam");
			System.out.println("7. Update Draft");
			System.out.println("8. Update Longitude and Latitude");
			System.out.println("9. Update Ship's row and column position");
			System.out.println("10. Update Cargo");
			System.out.println("11. Display the Ship");
			System.out.println("12. Previous Menu");
			System.out.println();

			int updateShipChoice = input.nextInt();
			int shipSelection;

			switch (updateShipChoice) {

			case 1:
				System.out
						.println("Which ship's name would you like to change (Enter ship indice)?");
				shipSelection = input.nextInt();
				if (shipSelection <= map.getListOfShips().size()
						&& shipSelection > 0) {
					System.out.println("Enter the ship's name:");
					name = new Scanner(System.in);
					String newName = name.nextLine();
					map.getListOfShips().get(shipSelection - 1)
							.setName(newName);
				}

				else {
					System.out.println("Input out of range.");
				}

				break;

			case 2:
				System.out
						.println("Which ship's registration would you like to change (Enter ship indice)?");
				shipSelection = input.nextInt();
				if (shipSelection <= map.getListOfShips().size()
						&& shipSelection > 0) {
					System.out.println("Enter the ship's registration:");
					name = new Scanner(System.in);
					String newRegistration = name.nextLine();
					map.getListOfShips().get(shipSelection - 1)
							.setOriginCountry(newRegistration);
				}

				else {
					System.out.println("Input out of range.");
				}

				break;

			case 3:
				System.out
						.println("Which ship's transponder would you like to change (Enter ship indice)?");
				shipSelection = input.nextInt();
				if (shipSelection <= map.getListOfShips().size()
						&& shipSelection > 0) {
					System.out.println("Enter the ship's transponder:");
					name = new Scanner(System.in);
					Long newTransponder = name.nextLong();
					map.getListOfShips().get(shipSelection - 1)
							.setTransponderNum(newTransponder);
				}

				else {
					System.out.println("Input out of range.");
				}

				break;

			case 4:
				System.out
						.println("Which ship's capacity would you like to change (Enter ship indice)?");
				shipSelection = input.nextInt();
				if (shipSelection <= map.getListOfShips().size()
						&& shipSelection > 0) {
					System.out.println("Enter the ship's capacity:");
					name = new Scanner(System.in);
					Double newCapacity = name.nextDouble();
					map.getListOfShips().get(shipSelection - 1)
							.setCargoCapacity(newCapacity);
				}

				else {
					System.out.println("Input out of range.");
				}

				break;

			case 5:
				System.out
						.println("Which ship's length would you like to change (Enter ship indice)?");
				shipSelection = input.nextInt();
				if (shipSelection <= map.getListOfShips().size()
						&& shipSelection > 0) {
					System.out.println("Enter the ship's length:");
					name = new Scanner(System.in);
					Double newLength = name.nextDouble();
					map.getListOfShips().get(shipSelection - 1)
							.setLength(newLength);
				}

				else {
					System.out.println("Input out of range.");
				}

				break;

			case 6:
				System.out
						.println("Which ship's beam would you like to change (Enter ship indice)?");
				shipSelection = input.nextInt();
				if (shipSelection <= map.getListOfShips().size()
						&& shipSelection > 0) {
					System.out.println("Enter the ship's beam:");
					name = new Scanner(System.in);
					Double newBeam = name.nextDouble();
					map.getListOfShips().get(shipSelection - 1)
							.setBeam(newBeam);
				}

				else {
					System.out.println("Input out of range.");
				}

				break;

			case 7:
				System.out
						.println("Which ship's draft would you like to change (Enter ship indice)?");
				shipSelection = input.nextInt();
				if (shipSelection <= map.getListOfShips().size()
						&& shipSelection > 0) {
					System.out.println("Enter the ship's draft:");
					name = new Scanner(System.in);
					Double newDraft = name.nextDouble();
					map.getListOfShips().get(shipSelection - 1)
							.setDraft(newDraft);
				}

				else {
					System.out.println("Input out of range.");
				}

				break;

			case 8:
				System.out
						.println("Which ship's longitude and latitude would you like to change (Enter ship number)?");
				shipSelection = input.nextInt();
				if (shipSelection <= map.getListOfShips().size()
						&& shipSelection > 0) {
					System.out.println("Enter the ship's longitude:");
					name = new Scanner(System.in);
					double newCoordinate = name.nextDouble();
					map.getListOfShips().get(shipSelection - 1)
							.setLongitude(newCoordinate);

					System.out.println("Enter the ship's latitude:");
					newCoordinate = name.nextDouble();
					map.getListOfShips().get(shipSelection - 1)
							.setLatitude(newCoordinate);
				}

				else {
					System.out.println("Input out of range.");
				}

				break;

			case 9:
				System.out
						.println("Which ship's row and column would you like to change (Enter ship number)?");
				shipSelection = input.nextInt();
				name = new Scanner(System.in);

				System.out.println("Enter the ship's row (between 1-36):");
				int newRow = name.nextInt();
				if (newRow >= 1 && newRow <= 36) {
					map.getListOfShips().get(shipSelection - 1)
							.setLatitude(MapConverter.row2lat(newRow - 1));
					System.out
							.println("Enter the ship's column (between 1-54):");
					int newColumn = name.nextInt();

					if (newColumn >= 1 && newColumn <= 54) {
						map.getListOfShips()
								.get(shipSelection - 1)
								.setLongitude(
										MapConverter.col2lon(newColumn - 1));
					}

					else {
						System.out.println("-----------------------");
						System.out.println("Not a valid column input.");
						System.out.println("-----------------------");

					}

				}

				else {
					System.out.println("----------------------");
					System.out.println("Not a valid row input.");
					System.out.println("----------------------");
				}

				break;

			case 10:
				System.out
						.println("Which ship's cargo would you like to change (Enter ship indice)?");
				shipSelection = input.nextInt();
				if (shipSelection <= map.getListOfShips().size()
						&& shipSelection > 0) {
					System.out.println("Enter the ship's cargo description:");
					name = new Scanner(System.in);
					String newCargoDescription = name.nextLine();
					map.getListOfShips().get(shipSelection - 1)
							.setCargoDescription(newCargoDescription);

					System.out.println("Enter the ship's cargo weight:");
					double newWeight = name.nextDouble();
					map.getListOfShips().get(shipSelection - 1)
							.setCargoWeight(newWeight);
				}

				else {
					System.out.println("Input out of range.");
				}

				break;

			case 11:
				System.out
						.println("Which ship's information would you like to see (Enter ship indice)?");
				shipSelection = input.nextInt();
				if (shipSelection <= map.getListOfShips().size()
						&& shipSelection > 0) {

					map.getListOfShips().get(shipSelection - 1)
							.displayShipInfo();

				}

				else {
					System.out.println("Input out of range.");
				}

				break;

			case 12:
				updateShipMenu = false;
				break;
			}

		}
	}

	/*
	 * This is the menu that'll be used to update the monsters (if any) in the
	 * map.
	 */
	public static void updateMonsters() throws NullPointerException,
			InputMismatchException {
		boolean updateMonsterMenu = true;
		while (updateMonsterMenu) {
			System.out.println();
			System.out.println("Monster Properties Menu");
			System.out.println("--------------------");
			System.out.println("1. Update Position");
			System.out.println("2. Move to ship");
			System.out.println("3. Previous Menu");
			System.out.println();

			int updateMonsterChoice = input.nextInt();
			int monsterSelection;

			switch (updateMonsterChoice) {

			case 1:
				map.displayMonsterByIndice();
				System.out
						.println("Which Monster's row and column would you like to change (Enter Monster number)?");
				monsterSelection = input.nextInt();
				name = new Scanner(System.in);

				System.out.println("Enter the monster's row (between 1-36):");
				int newRow = name.nextInt();
				if (newRow >= 1 && newRow <= 36) {
					map.getMonsterList().get(monsterSelection - 1).position
							.setRowPosition(newRow - 1);
					System.out
							.println("Enter the monster's column (between 1-54):");
					int newColumn = name.nextInt();

					if (newColumn >= 1 && newColumn <= 54) {
						map.getMonsterList().get(monsterSelection - 1).position
								.setColumnPosition(newColumn - 1);
					}

					else {
						System.out.println("-----------------------");
						System.out.println("Not a valid column input.");
						System.out.println("-----------------------");
					}

				}

				else {
					System.out.println("----------------------");
					System.out.println("Not a valid row input.");
					System.out.println("----------------------");
				}

				break;

			case 2:
				int shipSelection;
				map.displayMonsterByIndice();
				System.out
						.println("Which Monster would you like to control (Enter Monster number)?");
				monsterSelection = input.nextInt();

				if (map.getMonsterList().get(monsterSelection - 1).getLabel() == "Godzilla") {
					map.displayMonsterByIndice();
					System.out
							.println("Which monster would you like to move Godzilla to (Enter monster indice)?");
					int killSelection = input.nextInt();
					if (monsterSelection == killSelection) {
						System.out.println("Godzilla can't kill him/herself");
					} else if (killSelection <= map.getMonsterList().size()
							&& killSelection > 0) {
						map.getMonsterList().get(monsterSelection - 1).position
								.setLatitudePosition(map.getMonsterList().get(
										killSelection - 1).position
										.getLatitudePosition());
						map.getMonsterList().get(monsterSelection - 1).position
								.setLongitudePosition(map.getMonsterList().get(
										killSelection - 1).position
										.getLongitudePosition());
						System.out.println();
						map.getMonsterList().get(monsterSelection - 1)
								.battleCry();
						System.out.println();
						System.out.println(map.getMonsterList()
								.get(monsterSelection - 1).getLabel()
								+ " destroyed "
								+ map.getMonsterList().get(killSelection - 1)
										.getLabel());
						map.getListOfShips().remove(killSelection - 1);
					}
				} else {
					map.displayShipByIndice();
					System.out
							.printf("\nWhich ship would you like %s to destroy (Enter ship indice)?",
									map.getMonsterList()
											.get(monsterSelection - 1)
											.getLabel());
					shipSelection = input.nextInt();
					if (shipSelection <= map.getListOfShips().size()
							&& shipSelection > 0) {
						map.getMonsterList().get(monsterSelection - 1).position
								.setLatitudePosition(map.getListOfShips()
										.get(shipSelection - 1).getLatitude());
						map.getMonsterList().get(monsterSelection - 1).position
								.setLongitudePosition(map.getListOfShips()
										.get(shipSelection - 1).getLongitude());
						System.out.println();
						map.getMonsterList().get(monsterSelection - 1)
								.battleCry();
						System.out.println();
						System.out.println(map.getMonsterList()
								.get(monsterSelection - 1).getLabel()
								+ " destroyed "
								+ map.getListOfShips().get(shipSelection - 1)
										.getName());
						map.getListOfShips().remove(shipSelection - 1);
					}
				}
				break;

			case 3:
				updateMonsterMenu = false;
				break;
			}

		}
	}

	/*
	 * The user will be able to select whether to update any of the properties
	 * of the dock on any dock in the port, unload any ships in the port, and
	 * select to be displayed either all cargos or docks in the port.
	 */
	public static void portMenu() throws InputMismatchException,
			NullPointerException {
		int portMenuChoice;
		boolean portMenu = true;

		while (portMenu) {
			System.out.println();
			System.out.println("Port Menu");
			System.out.println("---------");
			System.out.println("1. Update Dock");
			System.out.println("2. Unload Ship");
			System.out.println("3. Display Cargo(s)");
			System.out.println("4. Display Dock(s)");
			System.out.println("5. Previous Menu");
			System.out.println();

			portMenuChoice = input.nextInt();

			switch (portMenuChoice) {

			case 1: {
				if (!port.getListOfDocks().isEmpty()) {
					updateDock();
				}

				else {
					System.out.println("-----------------------");
					System.out.println("No docks are available.");
					System.out.println("-----------------------");

				}
				break;
			}

			case 2: {
				unloadShip();
				break;
			}

			case 3: {
				port.displayCargos();
				break;
			}

			case 4: {
				port.displayDocks();
				break;
			}

			case 5: {
				portMenu = false;
				break;
			}

			}

		}

	}

	/*
	 * The update updateDock() method displays the user each dock by its name
	 * and indice in the port, with the ability to change any of the dock's
	 * properties
	 */
	public static void updateDock() throws InputMismatchException,
			NullPointerException {
		int updateDockChoice;
		boolean updateDockMenu = true;

		while (updateDockMenu) {
			System.out.println("Indice     Name");
			System.out.println("---------------");
			for (int i = 0; i < port.getListOfDocks().size(); i++) {
				System.out.printf("%d: ", (i + 1));
				System.out.println(port.getListOfDocks().get(i).getDockName());
			}

			System.out.println();
			System.out.println("Dock Properties Menu");
			System.out.println("--------------------");
			System.out.println("1. Update the dock name");
			System.out.println("2. Update the dock section");
			System.out.println("3. Update the dock number");
			System.out.println("4. Update the dock length");
			System.out.println("5. Update the dock beam");
			System.out.println("6. Update the dock draft");
			System.out.println("7. Update dock's longitude and latitude");
			System.out.println("8. Previous Menu");
			System.out.println();

			updateDockChoice = input.nextInt();

			switch (updateDockChoice) {

			case 1: {
				System.out
						.println("Which dock's name would you like to update(enter dock's indice)?");
				int dockSelection = input.nextInt();
				System.out.println("Enter the dock's name:");
				name = new Scanner(System.in);
				String dockName = name.nextLine();
				port.getListOfDocks().get(dockSelection - 1)
						.setDockName(dockName);
				break;
			}

			case 2: {
				System.out
						.println("Which dock's section would you like to update(enter dock's indice)?");
				int dockSelection = input.nextInt();
				System.out.println("Enter the dock's section (N or S):");
				name = new Scanner(System.in);
				String dockSection = name.nextLine();
				if (dockSection.charAt(0) == 'N'
						|| dockSection.charAt(0) == 'n'
						|| dockSection.charAt(0) == 'S'
						|| dockSection.charAt(0) == 's') {

					port.getListOfDocks().get(dockSelection - 1)
							.setDockSection(dockSection.charAt(0));
				}

				else {
					System.out.println("-------------------------");
					System.out.println("Not a valid section input.");
					System.out.println("-------------------------");

				}

				break;
			}

			case 3: {
				System.out
						.println("Which dock's number would you like to update(enter dock's indice)?");
				int dockSelection = input.nextInt();
				System.out.println("Enter the dock's number:");
				name = new Scanner(System.in);
				int dockNumber = name.nextInt();
				port.getListOfDocks().get(dockSelection - 1)
						.setDockNumber(dockNumber);
				break;
			}

			case 4: {
				System.out
						.println("Which dock's length would you like to update(enter dock's indice)?");
				int dockSelection = input.nextInt();
				System.out.println("Enter the dock's length (metres):");
				name = new Scanner(System.in);
				Double dockLength = name.nextDouble();
				port.getListOfDocks().get(dockSelection - 1)
						.setDockLength(dockLength);
				break;
			}

			case 5: {
				System.out
						.println("Which dock's beam would you like to update(enter dock's indice)?");
				int dockSelection = input.nextInt();
				System.out.println("Enter the dock's beam (metres):");
				name = new Scanner(System.in);
				Double dockBeam = name.nextDouble();
				port.getListOfDocks().get(dockSelection - 1)
						.setDockBeam(dockBeam);
				break;
			}

			case 6: {
				System.out
						.println("Which dock's draft would you like to update(enter dock's indice)?");
				int dockSelection = input.nextInt();
				System.out.println("Enter the dock's draft (metres):");
				name = new Scanner(System.in);
				Double dockDraft = name.nextDouble();
				port.getListOfDocks().get(dockSelection - 1)
						.setDockDraft(dockDraft);
				break;
			}

			case 7: {
				System.out
						.println("Which dock's coordinates would you like to update(enter dock's indice)?");
				int dockSelection = input.nextInt();

				System.out.println("Enter the dock's longitude (metres):");
				name = new Scanner(System.in);
				double dockCoordinate = name.nextDouble();
				port.getListOfDocks().get(dockSelection - 1)
						.setDockLongitude(dockCoordinate);
				System.out.println("Enter the dock's latitude (metres):");
				dockCoordinate = name.nextDouble();
				port.getListOfDocks().get(dockSelection - 1)
						.setDockLatitude(dockCoordinate);
				break;
			}

			case 8: {
				updateDockMenu = false;
				break;
			}

			}

		}
	}

	/*
	 * For any ship in the port, the unloadShip() method will display the user
	 * the ships located at any of the docks in the port, and the ability to
	 * unload the ship's cargo onto the port. Resulting with added cargo to the
	 * port, and cargo being removed from the selected ship.
	 */
	public static void unloadShip() throws NullPointerException {
		if (!map.getListOfShips().isEmpty() && !port.getListOfDocks().isEmpty()) {
			int shipSelection;
			ArrayList<Integer> indicesOfShipsInDock = new ArrayList<>();
			indicesOfShipsInDock.clear();

			for (int i = 0; i < map.getListOfShips().size(); i++) {
				for (int j = 0; j < port.getListOfDocks().size(); j++) {
					if (map.getListOfShips().get(i).getCol() == port
							.getListOfDocks().get(j).getCol()
							&& map.getListOfShips().get(i).getRow() == port
									.getListOfDocks().get(j).getRow()
							&& map.getListOfShips()
									.get(i)
									.shipFitsInDock(
											port.getListOfDocks().get(j))) {

						indicesOfShipsInDock.add(i);
					}
				}
			}

			if (indicesOfShipsInDock.size() > 0) {
				System.out.println(" Indice      Name");
				System.out.println("-----------------");
				for (int i = 0; i < indicesOfShipsInDock.size(); i++) {
					String shipName;
					int shipIndice = indicesOfShipsInDock.get(i);
					shipName = map.getListOfShips().get(shipIndice).getName();

					System.out.printf("%d: %s\n", (i + 1), shipName);
				}

				System.out
						.println("Enter the number of the ship you'd like to unload:");
				shipSelection = input.nextInt();

				if (shipSelection > 0
						&& shipSelection <= indicesOfShipsInDock.size()) {
					int shipIndice = indicesOfShipsInDock
							.get(shipSelection - 1);
					if (map.getListOfShips().get(shipIndice).getCargo() != null) {
						Cargo tempCargo = map.getListOfShips().get(shipIndice)
								.getCargo();
						port.getListOfCargos().add(tempCargo);
						map.getListOfShips().get(shipIndice).setCargo(null);
					}

					else {
						System.out.println("---------------------------");
						System.out.println("Ship has no cargo to unload.");
						System.out.println("---------------------------");

					}
				}

				else {
					System.out.println("-----------------");
					System.out.println("Not a valid input.");
					System.out.println("-----------------");
				}
			}
		}

		else {
			System.out.println("-----------------------------");
			System.out.println("No ship(s) in dock to unload.");
			System.out.println("-----------------------------");

		}
	}

	/*
	 * Loads all files, used alone for the text based menu.
	 */
	public static void loadMapV2() throws FileNotFoundException {
		System.out.println("Please enter a tag for your load files:");
		String comment = stringInputs.next();
		map = fileHandler.loadMapV2(comment);
		port = fileHandler.loadPortV2(comment);
	}

	/*
	 * Loads all files, used along with the loadMapV2() for the GUI.
	 */
	public static void loadMapV3(String comment) throws FileNotFoundException {
		map = fileHandler.loadMapV2(comment);
		port = fileHandler.loadPortV2(comment);
	}

}
