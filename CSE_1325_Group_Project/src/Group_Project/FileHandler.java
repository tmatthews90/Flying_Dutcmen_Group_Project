package Group_Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/*
 * Class that will handle all file inputs/outputs.
 */
public class FileHandler {

	/*
	 * The loadPortV2() method will take a comment parameter, which will load a
	 * port file in the form of _____.port.txt where "_____" is the user
	 * inputted comment of the file. Contingent upon the file being present.
	 * Returns a Port object created based on the port file.
	 */
	public Port loadPortV2(String comment) throws FileNotFoundException {
		String fileName = comment;
		fileName += ".port.txt";

		File inputFile = new File(fileName);
		@SuppressWarnings("resource")
		Scanner fileInput = new Scanner(inputFile);

		String[] data;
		String firstLine = fileInput.nextLine();
		data = firstLine.split("[\\s\\,]+");

		String portCity = data[0];
		int numberOfDocks = Integer.valueOf(data[1]);
		int numberOfCranes = Integer.valueOf(data[2]);
		int numberOfPiers = Integer.valueOf(data[3]);
		int numberOfAvailableCargos = Integer.valueOf(data[4]);

		int totalDocks = numberOfCranes + numberOfDocks + numberOfPiers;
		int count = 0;

		Port port = new Port(portCity, totalDocks, numberOfAvailableCargos);

		for (int i = 0; i < numberOfDocks; i++) {
			String temp = fileInput.nextLine();
			port.getListOfDocks().add(new Dock(temp));

			count++;
		}

		for (int i = count; i < numberOfDocks + numberOfCranes; i++) {
			String temp = fileInput.nextLine();
			port.getListOfDocks().add(new Crane(temp));

			count++;
		}

		for (int i = count; i < totalDocks; i++) {
			String temp = fileInput.nextLine();
			port.getListOfDocks().add(new Pier(temp));

			count++;
		}

		for (int i = 0; i < numberOfAvailableCargos; i++) {
			String temp = fileInput.nextLine();
			port.getListOfCargos().add(new Cargo(temp));

		}

		return port;
	}

	/*
	 * The loadMapV2() method loads a map from a user specified file, and
	 * returns a map object based on the file, contingent the ____.map.txt file
	 * exists in the correct directory.
	 */
	public Map loadMapV2(String comment) throws FileNotFoundException {

		boolean successfulInput = false;

		Map tempMap = null;

		String fileName = comment;
		fileName += ".map.txt";
		while (!successfulInput) {

			int count = 0;

			File inputFile = new File(fileName);
			Scanner fileInput = new Scanner(inputFile);

			String[] data;
			String tempString = "";

			while (fileInput.hasNextLine()) {

				tempString += fileInput.nextLine() + ",";
			}

			fileInput.close();
			data = tempString.split(",");

			int[] longitudeVals = new int[data.length / 3];
			int[] latitudeVals = new int[data.length / 3];
			char[] terrainChar = new char[data.length / 3];

			for (int i = 0; i < data.length / 3; i++) {
				longitudeVals[i] = Integer.valueOf(data[count]);
				latitudeVals[i] = Integer.valueOf(data[count + 1]);
				terrainChar[i] = data[count + 2].charAt(0);

				count += 3;
			}

			tempMap = new Map(longitudeVals, latitudeVals, terrainChar);
			successfulInput = true;
		}

		return tempMap;
	}

	/*
	 * The closeAll function takes in ArrayLists of type CargoShip,Dock, Cargo,
	 * and SeaMonster It then erases the current map, dockss, cargos, and sea
	 * monster
	 */
	public void closeAll(ArrayList<CargoShip> myShips, ArrayList<Dock> myDocks,
			ArrayList<Cargo> myCargos /* ArrayList<SeaMonster> myMonsters */) {

		myShips.clear();
		myDocks.clear();
		myCargos.clear();
		// myMonsters.clear();

		System.out.println("Cleared");
	}

	/*
	 * The snapShot function prompts the user for a file name and a directory
	 * and writes the ship, dock, cargo, and sea monster info into said file
	 */
	public void snapShot(Port port, Map map /* ,SeaMonster monsters */)
			throws FileNotFoundException, UnsupportedEncodingException {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.print("Type File Name(eg snapShot):");
		String fileName = scan.next() + ".txt";
		System.out.println("\nEnter Directory");
		System.out.print("Use double back slash between destinations(eg "
				+ "C:\\\\Users\\\\David\\\\Desktop\\\\):");
		String directory = scan.next();

		String path = directory + "/" + fileName;

		PrintWriter outToFile = new PrintWriter(path, "UTF-8");

		outToFile.println("Ships");
		for (int i = 0; i < map.getListOfShips().size(); i++) {
			outToFile.println(map.getListOfShips().get(i).toString());
		}
		outToFile.println();

		outToFile.println("Docks");
		outToFile.println(port.toString());
		for (int i = 0; i < port.getListOfDocks().size(); i++) {
			outToFile.println(port.getListOfDocks().get(i).toString());
		}

		outToFile.println();
		outToFile.println("Cargos");
		for (int i = 0; i < port.getListOfCargos().size(); i++) {
			outToFile.println(port.getListOfCargos().get(i).toString());
		}

		outToFile.println("\nMonsters");

		for (int i = 0; i < map.getMonsterList().size(); i++) {
			outToFile.println(map.getMonsterList().get(i).toString());
		}

		outToFile.flush();
		outToFile.close();

	}

	/*
	 * The snapShot function prompts the user for a file name and a directory
	 * and writes the ship, dock, cargo, and sea monster info into said file
	 */
	public void snapShotV2(Port port, Map map, String fileName, String path)
			throws FileNotFoundException, UnsupportedEncodingException {

		fileName += ".txt";

		path = path + "/" + fileName;

		PrintWriter outToFile = new PrintWriter(path, "UTF-8");

		outToFile.println("Ships");
		for (int i = 0; i < map.getListOfShips().size(); i++) {
			outToFile.println(map.getListOfShips().get(i).toString());
		}
		outToFile.println();

		outToFile.println("Docks");
		outToFile.println(port.toString());
		for (int i = 0; i < port.getListOfDocks().size(); i++) {
			outToFile.println(port.getListOfDocks().get(i).toString());
		}

		outToFile.println();
		outToFile.println("Cargos");
		for (int i = 0; i < port.getListOfCargos().size(); i++) {
			outToFile.println(port.getListOfCargos().get(i).toString());
		}

		outToFile.println("\nMonsters");

		for (int i = 0; i < map.getMonsterList().size(); i++) {
			outToFile.println(map.getMonsterList().get(i).toString());
		}

		outToFile.flush();
		outToFile.close();

	}

	/*
	 * The snapShot function prompts the user for a file name and a directory
	 * and writes the ship, dock, cargo, and sea monster info into said file
	 */
	public void snapShotV3(Port port, Map map, String path)
			throws FileNotFoundException, UnsupportedEncodingException {

		PrintWriter outToFile = new PrintWriter(path, "UTF-8");

		outToFile.println("Ships");
		for (int i = 0; i < map.getListOfShips().size(); i++) {
			outToFile.println(map.getListOfShips().get(i).toString());
		}
		outToFile.println();

		outToFile.println("Docks");
		outToFile.println(port.toString());
		for (int i = 0; i < port.getListOfDocks().size(); i++) {
			outToFile.println(port.getListOfDocks().get(i).toString());
		}

		outToFile.println();
		outToFile.println("Cargos");
		for (int i = 0; i < port.getListOfCargos().size(); i++) {
			outToFile.println(port.getListOfCargos().get(i).toString());
		}

		outToFile.println();
		outToFile.println("Monsters");

		for (int i = 0; i < map.getMonsterList().size(); i++) {
			outToFile.println(map.getMonsterList().get(i).toString());
		}

		outToFile.flush();
		outToFile.close();

	}

	/*
	 * The exitAll function simply terminates the whole program
	 */
	public void exitAll() {
		System.exit(0);
	}

}
