package Group_Project;

import java.text.DecimalFormat;
import java.util.ArrayList;

/*
 * The class Map with its member variables, which pertain of 
 * characters 
 * to represent the map and a list of ships in the map.
 */
public class Map {
	private char water;
	private char land;
	private char dockWithoutShip;
	private char shipAtSea;
	private char shipAtDock;
	private char unsafeShip;
	private ArrayList<CargoShip> listOfShips;
	private ArrayList<SeaMonster> monsterList;
	private int[] longitudeVals;
	private int[] latitudeVals;
	private char[] terrainChars;
	public char[][] mapRepresentation;
	private Port port;

	/*
	 * The first constructor is a default constructor with no parameters.
	 */
	public Map() {
		this.listOfShips = new ArrayList<CargoShip>();
		this.monsterList = new ArrayList<SeaMonster>();
		this.water = '.';
		this.land = '*';
		this.dockWithoutShip = 'D';
		this.shipAtSea = 'S';
		this.shipAtDock = '$';
		this.unsafeShip = 'X';
		this.mapRepresentation = new char[36][54];
		this.port = new Port();
	}

	public void displayMonsters() {
		DecimalFormat df = new DecimalFormat("##.######");
		for (int i = 0; i < monsterList.size(); i++) {
			System.out.printf("\nMonster:                %s\n", monsterList
					.get(i).getLabel());
			MainClass.GUI.messageBox.append("\nMonster: "
					+ monsterList.get(i).getLabel() + "\n");

			System.out.printf("Battle Cry:             ");
			MainClass.GUI.messageBox.append("Battle Cry: ");
			monsterList.get(i).battleCry();

			System.out.printf("Column/Row Position:    (%s, %s)\n",
					monsterList.get(i).position.getColumnPosition(),
					monsterList.get(i).position.getRowPosition());
			MainClass.GUI.messageBox.append("Column/Row Position: ("
					+ monsterList.get(i).position.getColumnPosition() + ", "
					+ monsterList.get(i).position.getRowPosition() + ")\n");

			System.out.printf("Lon/Lat Position:       (%.4f, %.4f)\n",
					monsterList.get(i).position.getLongitudePosition(),
					monsterList.get(i).position.getLatitudePosition());
			MainClass.GUI.messageBox.append("Lon/Lat Position: ("
					+ df.format(monsterList.get(i).position
							.getLongitudePosition())
					+ ", "
					+ df.format(monsterList.get(i).position
							.getLatitudePosition()) + ")\n");

			System.out.printf("xPixel/yPixel Position: (%s, %s)\n",
					monsterList.get(i).position.getxPosition(),
					monsterList.get(i).position.getyPosition());
			MainClass.GUI.messageBox.append("xPixel/yPixel Position: ("
					+ monsterList.get(i).position.getxPosition() + ", "
					+ monsterList.get(i).position.getyPosition() + ")\n");

		}
	}

	/*
	 * Tbe second constructor sets the map's terrain.
	 */
	public Map(int[] longitudeVals, int[] latitudeVals,
			char[][] mapRepresentation) {
		this.listOfShips = new ArrayList<CargoShip>();
		this.monsterList = new ArrayList<SeaMonster>();
		this.water = '.';
		this.land = '*';
		this.dockWithoutShip = 'D';
		this.shipAtSea = 'S';
		this.shipAtDock = '$';
		this.unsafeShip = 'X';
		this.longitudeVals = longitudeVals;
		this.latitudeVals = latitudeVals;
		this.mapRepresentation = mapRepresentation;
		this.port = MainClass.port;

	}

	/*
	 * Constructor for map from file
	 */
	public Map(int[] longitudeVals, int[] latitudeVals, char[] terrainChars) {
		this.listOfShips = new ArrayList<CargoShip>();
		this.monsterList = new ArrayList<SeaMonster>();
		this.water = '.';
		this.land = '*';
		this.dockWithoutShip = 'D';
		this.shipAtSea = 'S';
		this.shipAtDock = '$';
		this.unsafeShip = 'X';
		this.longitudeVals = longitudeVals;
		this.latitudeVals = latitudeVals;
		this.terrainChars = terrainChars;
		this.mapRepresentation = new char[36][54];
		this.port = MainClass.port;

		int count = 0;

		for (int i = 0; i < 36; i++) {
			for (int j = 0; j < 54; j++) {
				mapRepresentation[i][j] = terrainChars[count];
				count++;
			}
		}
	}

	/*
	 * Getters and setters for all the member variables of the Map class, except
	 * the final variable original map which holds the representation of the map
	 * without any docks or ships.
	 */
	public char getWater() {
		return water;
	}

	public void setWater(char water) {
		this.water = water;
	}

	public char getLand() {
		return land;
	}

	public void setLand(char land) {
		this.land = land;
	}

	public char getDockWithoutShip() {
		return dockWithoutShip;
	}

	public void setDockWithoutShip(char dockWithoutShip) {
		this.dockWithoutShip = dockWithoutShip;
	}

	public char getShipAtSea() {
		return shipAtSea;
	}

	public void setShipAtSea(char shipAtSea) {
		this.shipAtSea = shipAtSea;
	}

	public char getShipAtDock() {
		return shipAtDock;
	}

	public void setShipAtDock(char shipAtDock) {
		this.shipAtDock = shipAtDock;
	}

	public char getUnsafeShip() {
		return unsafeShip;
	}

	public void setUnsafeShip(char unsafeShip) {
		this.unsafeShip = unsafeShip;
	}

	public ArrayList<CargoShip> getListOfShips() {
		return listOfShips;
	}

	public void setListOfShips(ArrayList<CargoShip> listOfShips) {
		this.listOfShips = listOfShips;
	}

	public int[] getLongitudeVals() {
		return longitudeVals;
	}

	public void setLongitudeVals(int[] longitudeVals) {
		this.longitudeVals = longitudeVals;
	}

	public int[] getLatitudeVals() {
		return latitudeVals;
	}

	public void setLatitudeVals(int[] latitudeVals) {
		this.latitudeVals = latitudeVals;
	}

	public char[][] getMapRepresentation() {
		return mapRepresentation;
	}

	/*
	 * All of the ships in the map will be displayed to the user by name and
	 * indice with the following method.
	 */
	public void displayShipByIndice() {
		if (listOfShips.size() > 0) {
			System.out.println("Indice     Name");
			System.out.println("---------------");
			for (int i = 0; i < listOfShips.size(); i++) {
				System.out.printf("%5d:  %s\n", (i + 1), listOfShips.get(i)
						.getName());
			}
		}

		else {
			System.out.println("-------------------");
			System.out.println("No ships available.");
			System.out.println("-------------------");

		}
	}

	public void displayMonsterByIndice() {
		if (monsterList.size() > 0) {
			System.out.println("Indice     Name");
			System.out.println("---------------");
			for (int i = 0; i < monsterList.size(); i++) {
				System.out.printf("%5d:  %s\n", (i + 1), monsterList.get(i)
						.getLabel());
			}
		}

		else {
			System.out.println("-------------------");
			System.out.println("No Monsters available.");
			System.out.println("-------------------");

		}
	}

	/*
	 * Displays all the ships to the user along with all of its properties.
	 */
	public void getShipsInfo() {
		for (int i = 0; i < listOfShips.size(); i++) {
			listOfShips.get(i).displayShipInfo();
		}
	}

	/*
	 * Displays a 36x54 character representation of the map to the user.
	 */
	public void displayMapV2(Port port) {

		int count = 0;

		for (int i = 0; i < 36; i++) {
			for (int j = 0; j < 54; j++) {
				mapRepresentation[i][j] = terrainChars[count];
				count++;
			}
		}

		for (int i = 0; i < port.getListOfDocks().size(); i++) {
			int dockRow = port.getListOfDocks().get(i).getRow();
			int dockCol = port.getListOfDocks().get(i).getCol();

			if (port.getListOfDocks().get(i) instanceof Pier) {
				mapRepresentation[dockRow][dockCol] = 'P';
			}

			if (port.getListOfDocks().get(i) instanceof Crane) {
				mapRepresentation[dockRow][dockCol] = 'C';
			}

			if (!(port.getListOfDocks().get(i) instanceof Pier)
					&& !(port.getListOfDocks().get(i) instanceof Crane)) {
				mapRepresentation[dockRow][dockCol] = 'D';
			}

		}

		for (int i = 0; i < listOfShips.size(); i++) {

			int shipRow = listOfShips.get(i).getRow();
			int shipCol = listOfShips.get(i).getCol();

			if (mapRepresentation[shipRow][shipCol] == land

			|| mapRepresentation[shipRow][shipCol] == unsafeShip) {

				mapRepresentation[shipRow][shipCol] = unsafeShip;
			}

			if (mapRepresentation[shipRow][shipCol] == 'S'
					|| mapRepresentation[shipRow][shipCol] == 'T'
					|| mapRepresentation[shipRow][shipCol] == 'B') {

				for (int j = 0; j < i; j++) {
					if (listOfShips.get(j).getRow() == listOfShips.get(i)
							.getRow()
							&& listOfShips.get(j).getCol() == listOfShips
									.get(i).getCol()) {

						mapRepresentation[shipRow][shipCol] = unsafeShip;

					}

				}
			}

			if (mapRepresentation[shipRow][shipCol] == water) {
				if (listOfShips.get(i) instanceof Tanker) {
					mapRepresentation[shipRow][shipCol] = 'T';
				}

				if (listOfShips.get(i) instanceof ContainerShip) {
					mapRepresentation[shipRow][shipCol] = 'B';
				}

				if (!(listOfShips.get(i) instanceof Tanker)
						&& !(listOfShips.get(i) instanceof ContainerShip)) {
					mapRepresentation[shipRow][shipCol] = 'S';
				}
			}

			if (mapRepresentation[shipRow][shipCol] == 'P'
					|| mapRepresentation[shipRow][shipCol] == 'C'
					|| mapRepresentation[shipRow][shipCol] == 'D') {

				for (int j = 0; j < port.getListOfDocks().size(); j++) {

					if (listOfShips.get(i).getRow() == port.getListOfDocks()
							.get(j).getRow()
							&& listOfShips.get(i).getCol() == port
									.getListOfDocks().get(j).getCol()) {

						if (listOfShips.get(i).shipFitsInDock(
								port.getListOfDocks().get(j))) {
							if (listOfShips.get(i).getShipSymbol() == 'S'
									&& port.getListOfDocks().get(j)
											.getDockSymbol() == 'D') {
								mapRepresentation[shipRow][shipCol] = '$';
							} else if (listOfShips.get(i).getShipSymbol() == 'B'
									&& port.getListOfDocks().get(j)
											.getDockSymbol() == 'C') {
								mapRepresentation[shipRow][shipCol] = '$';
							} else if (listOfShips.get(i).getShipSymbol() == 'T'
									&& port.getListOfDocks().get(j)
											.getDockSymbol() == 'P') {
								mapRepresentation[shipRow][shipCol] = '$';
							} else
								mapRepresentation[shipRow][shipCol] = 'X';
						}

						else {
							mapRepresentation[shipRow][shipCol] = 'X';
						}
					}
				}
			}
		}

		for (int i = 0; i < this.monsterList.size(); i++) {
			int monsterRow = monsterList.get(i).position.getRowPosition();
			int monsterCol = monsterList.get(i).position.getColumnPosition();

			this.mapRepresentation[monsterRow][monsterCol] = monsterList.get(i)
					.getMonsterSymbol();
		}
	}

	public ArrayList<SeaMonster> getMonsterList() {
		return monsterList;
	}

}
