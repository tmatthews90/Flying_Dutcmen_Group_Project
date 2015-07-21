package Group_Project;

import java.text.DecimalFormat;
import java.util.Random;

/*
 * The CargoShip class is a super class, 
 * which is the foundation for the Tanker and Container ship classes.  
 */
public class CargoShip {
	protected String typeOfShip;
	protected String name;
	protected String originCountry;
	protected long transponderNum;
	protected double cargoCapacity;
	protected double length;
	protected double beam;
	protected double draft;
	protected double longitude;
	protected double latitude;
	protected Cargo cargo;
	protected char shipSymbol;

	/*
	 * Default CargoShip constructor with its default values.
	 */
	public CargoShip() {
		this.typeOfShip = "Cargo Ship";
		this.name = "Zenda";
		this.originCountry = "Ruritania";
		this.transponderNum = 0;
		this.cargoCapacity = 10;
		this.length = 90;
		this.beam = 10;
		this.draft = 5;
		this.longitude = -2.977838;
		this.latitude = 53.410777;
		this.cargo = new Cargo();
		this.shipSymbol = 'S';
	}

	/*
	 * Constructor with parameters for each of the variables in the class.
	 */
	public CargoShip(String typeOfShip, String name, String originCountry,
			long transponderNum, double cargoCapacity, double length,
			double beam, double draft, double longitude, double latitude,
			Cargo cargo, char shipSymbol) {
		this.typeOfShip = typeOfShip;
		this.name = name;
		this.originCountry = originCountry;
		this.transponderNum = transponderNum;
		this.cargoCapacity = cargoCapacity;
		this.length = length;
		this.beam = beam;
		this.draft = draft;
		this.longitude = longitude;
		this.latitude = latitude;
		this.cargo = cargo;
		this.shipSymbol = shipSymbol;
		this.shipSymbol = 'S';

	}

	/*
	 * Constructor with parameters for each of the variables in the class except
	 * the type of ship.
	 */
	public CargoShip(String name, String originCountry, long transponderNum,
			double cargoCapacity, double length, double beam, double draft,
			double longitude, double latitude, Cargo cargo, char shipSymbol) {
		this.typeOfShip = "Cargo Ship";
		this.name = name;
		this.originCountry = originCountry;
		this.transponderNum = transponderNum;
		this.cargoCapacity = cargoCapacity;
		this.length = length;
		this.beam = beam;
		this.draft = draft;
		this.longitude = longitude;
		this.latitude = latitude;
		this.cargo = cargo;
		this.shipSymbol = shipSymbol;
		this.shipSymbol = 'S';

	}

	/*
	 * Constructor with parameters for each of the variables in the class except
	 * the type of ship and ship symbol.
	 */
	public CargoShip(String name, String originCountry, long transponderNum,
			double cargoCapacity, double length, double beam, double draft,
			double longitude, double latitude, Cargo cargo) {
		this.typeOfShip = "Cargo Ship";
		this.name = name;
		this.originCountry = originCountry;
		this.transponderNum = transponderNum;
		this.cargoCapacity = cargoCapacity;
		this.length = length;
		this.beam = beam;
		this.draft = draft;
		this.longitude = longitude;
		this.latitude = latitude;
		this.cargo = cargo;
		this.shipSymbol = 'S';
	}

	/*
	 * Constructor consisting of a string parameters containing CSVs.
	 */
	public CargoShip(String data) {
		String[] values = data.split(",");

		if (values.length == 11) {
			this.name = values[0];
			this.originCountry = values[1];
			this.transponderNum = Long.valueOf(values[2]);
			this.cargoCapacity = Double.valueOf(values[3]);
			this.length = Double.valueOf(values[4]);
			this.beam = Double.valueOf(values[5]);
			this.draft = Double.valueOf(values[6]);
			this.longitude = Double.valueOf(values[7]);
			this.latitude = Double.valueOf(values[8]);
			this.cargo = new Cargo(values[9], Double.valueOf(values[10]));

		}

		else if (values.length == 9) {
			this.name = values[0];
			this.originCountry = values[1];
			this.transponderNum = Long.valueOf(values[2]);
			this.cargoCapacity = Double.valueOf(values[3]);
			this.length = Double.valueOf(values[4]);
			this.beam = Double.valueOf(values[5]);
			this.draft = Double.valueOf(values[6]);
			this.longitude = Double.valueOf(values[7]);
			this.latitude = Double.valueOf(values[8]);
			this.cargo = null;
		}

		this.typeOfShip = "Cargo Ship";
	}

	/*
	 * Constructor which is primarily used to randomly create the ships with a
	 * random type of ship, name, and transponder created externally, and its
	 * coordinates randomly created within the constructor.
	 */
	public CargoShip(String typeOfShip, String name, long transponderNum) {
		Random randomGen = new Random();

		this.typeOfShip = typeOfShip;
		this.name = name;
		this.originCountry = "Ruritania";
		this.transponderNum = transponderNum;
		this.cargoCapacity = 10;
		this.length = 90;
		this.beam = 10;
		this.draft = 5;
		this.longitude = (randomGen.nextDouble() * (-2.988478 - (-3.035)) + (-3.035));
		this.latitude = (randomGen.nextDouble() * (53.457561 - 53.396700) + (53.396700));
		this.cargo = new Cargo();
		this.shipSymbol = 'S';

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * toString() method neatly formats the cargo ship's properties to be
	 * outputted to a file, varying on amount of values based on whether the
	 * ship has cargo or not.
	 */
	@Override
	public String toString() {
		if (cargo != null) {
			return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
					typeOfShip, name, originCountry, transponderNum,
					cargoCapacity, length, beam, draft, longitude, latitude,
					cargo.getDescription(), cargo.getWeight());
		}

		else {
			return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", typeOfShip,
					name, originCountry, transponderNum, cargoCapacity, length,
					beam, draft, longitude, latitude);
		}
	}

	/*
	 * Neatly displays the cargo ship's complete info.
	 */
	public void displayShipInfo() {
		DecimalFormat df = new DecimalFormat("##.######");
		if (this.cargo != null) {
			System.out.printf("Cargo Ship: %s \n", name);
			MainClass.GUI.messageBox
					.append("\n" + "Cargo Ship: " + name + "\n");
			System.out.printf("Country of origin: %s \n", originCountry);
			MainClass.GUI.messageBox.append("Country of origin: "
					+ originCountry + "\n");
			System.out.printf("Transponder: %d \n", transponderNum);
			MainClass.GUI.messageBox.append("Transponder: " + transponderNum
					+ "\n");
			System.out.printf("Length (metres): %.2f \n", length);
			MainClass.GUI.messageBox
					.append("Length (metres): " + length + "\n");
			System.out.printf("Beam (metres): %.2f \n", beam);
			MainClass.GUI.messageBox.append("Beam (metres): " + beam + "\n");
			System.out.printf("Draft (metres): %.2f \n", draft);
			MainClass.GUI.messageBox.append("Draft (metres): " + draft + "\n");
			System.out.printf("Capacity (tonnage): %.2f \n", cargoCapacity);
			MainClass.GUI.messageBox.append("Capacity (tonnage): "
					+ cargoCapacity + "\n");
			System.out.printf("Location (longitude, latitude): (%f,%f)\n",
					longitude, latitude);
			MainClass.GUI.messageBox
					.append("Location (longitude, latitude): ("
							+ df.format(longitude) + ", " + df.format(latitude)
							+ ")\n");
			System.out.printf("Location (column, row): (%d,%d)\n",
					MapConverter.lon2col(longitude),
					MapConverter.lat2row(latitude));
			MainClass.GUI.messageBox.append("Location (column, row): ("
					+ MapConverter.lon2col(longitude) + ", "
					+ MapConverter.lat2row(latitude) + ")\n");
			System.out.print("Cargo: ");
			// GUI.messageBox.append("Cargo Ship: " + name + "\n");
			this.cargo.displayInfo();
			System.out.println();
		}

		else {
			System.out.printf("Cargo Ship: %s \n", name);
			MainClass.GUI.messageBox
					.append("\n" + "Cargo Ship: " + name + "\n");
			System.out.printf("Country of origin: %s \n", originCountry);
			MainClass.GUI.messageBox.append("Country of origin: "
					+ originCountry + "\n");
			System.out.printf("Transponder: %d \n", transponderNum);
			MainClass.GUI.messageBox.append("Transponder: " + transponderNum
					+ "\n");
			System.out.printf("Length (metres): %.2f \n", length);
			MainClass.GUI.messageBox
					.append("Length (metres): " + length + "\n");
			System.out.printf("Beam (metres): %.2f \n", beam);
			MainClass.GUI.messageBox.append("Beam (metres): " + beam + "\n");
			System.out.printf("Draft (metres): %.2f \n", draft);
			MainClass.GUI.messageBox.append("Draft (metres): " + draft + "\n");
			System.out.printf("Capacity (tonnage): %.2f \n", cargoCapacity);
			MainClass.GUI.messageBox.append("Capacity (tonnage): "
					+ cargoCapacity + "\n");
			System.out.printf("Location (longitude, latitude): (%f,%f)\n",
					longitude, latitude);
			MainClass.GUI.messageBox
					.append("Location (longitude, latitude): ("
							+ df.format(longitude) + ", " + df.format(latitude)
							+ ")\n");
			System.out.printf("Location (column, row): (%d,%d)\n",
					MapConverter.lon2col(longitude) + 1,
					MapConverter.lat2row(latitude) + 1);
			MainClass.GUI.messageBox.append("Location (column, row): ("
					+ (MapConverter.lon2col(longitude) + 1) + ", "
					+ (MapConverter.lat2row(latitude) + 1) + ")\n");
			System.out.print("Cargo: EMPTY\n");
			MainClass.GUI.messageBox.append("Cargo: EMPTY\n");
			System.out.println();
		}

	}

	/*
	 * Getters and setters for each of the variables.
	 */
	public String getTypeOfShip() {
		return typeOfShip;
	}

	public void setTypeOfShip(String typeOfShip) {
		this.typeOfShip = typeOfShip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOriginCountry() {
		return originCountry;
	}

	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}

	public long getTransponderNum() {
		return transponderNum;
	}

	public void setTransponderNum(long transponderNum) {
		this.transponderNum = transponderNum;
	}

	public double getCargoCapacity() {
		return cargoCapacity;
	}

	public void setCargoCapacity(double cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getBeam() {
		return beam;
	}

	public void setBeam(double beam) {
		this.beam = beam;
	}

	public double getDraft() {
		return draft;
	}

	public void setDraft(double draft) {
		this.draft = draft;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public char getShipSymbol() {
		return shipSymbol;
	}

	public void setShipSymbol(char shipSymbol) {
		this.shipSymbol = shipSymbol;
	}

	public String getCargoDescription() {
		if (this.cargo.getDescription() != null)
			return this.cargo.getDescription();
		return "";
	}

	public void setCargoDescription(String description) {
		if (this.cargo != null) {
			this.cargo.setDescription(description);
		}

		else {
			this.cargo = new Cargo();
			this.cargo.setDescription(description);
		}
	}

	public double getCargoWeight() {
		return this.cargo.getWeight();
	}

	public void setCargoWeight(double weight) {
		if (this.cargo != null) {
			this.cargo.setWeight(weight);
		}

		else {
			this.cargo = new Cargo();
			this.cargo.setWeight(weight);
		}
	}

	public int getRow() {
		return MapConverter.lat2row(latitude);
	}

	public int getCol() {
		return MapConverter.lon2col(longitude);
	}

	/*
	 * Displays ship's cargo.
	 */
	public void displayCargo() {
		if (this.cargo != null) {
			this.cargo.displayInfo();
		}

		else {
			System.out.println("Cargo is empty.");
		}
	}

	/*
	 * The shopFitsDock method returns a boolean type, that will check as to
	 * whether or not the type of ship fits in the dock it's on, and the ship
	 * type is in the correct type of dock. (e.g a tanker ship is in a dock of
	 * type pier, and not a crane)
	 */
	public boolean shipFitsInDock(Dock dock) {
		boolean fitChecker = false;
		boolean dockTypeChecker = false;

		if (this.length <= dock.getDockLength()
				&& this.beam <= dock.getDockBeam()
				&& this.draft <= dock.getDockDraft()) {
			fitChecker = true;
		}

		if (this.shipSymbol == dock.shipType()) {
			dockTypeChecker = true;
		}

		if (fitChecker && dockTypeChecker) {
			return true;
		}

		else {
			return false;
		}

	}
}
