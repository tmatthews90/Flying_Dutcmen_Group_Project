package Group_Project;

import java.text.DecimalFormat;

/*
 * Child of the CargoShipClass, holds cargo of type 'Oil'.
 */
public class Tanker extends CargoShip {
	private int barrelCapacity;

	/*
	 * Default constructor without any parameters.
	 */
	public Tanker() {
		super();
		this.typeOfShip = "Tanker Ship";
		this.barrelCapacity = 700000;
		this.cargo = new Oil();
		this.shipSymbol = 'T';

	}

	/*
	 * Constructor with parameters for each of the variables in the class
	 */
	public Tanker(String typeOfShip, String name, String originCountry,
			long transponderNum, double cargoCapacity, double length,
			double beam, double draft, double longitude, double latitude,
			Cargo cargo, char shipSymbol) {
		super(typeOfShip, name, originCountry, transponderNum, cargoCapacity,
				length, beam, draft, longitude, latitude, cargo, shipSymbol);
		this.barrelCapacity = 700000;
		this.cargo = new Oil();
		this.shipSymbol = 'T';

	}

	/*
	 * Constructor consisting of a string parameters containing CSVs.
	 */
	public Tanker(String data) {
		super(data);

		this.typeOfShip = "Tanker Ship";
		this.barrelCapacity = 700000;
		this.cargo = new Oil();
		this.shipSymbol = 'T';

	}

	/*
	 * Constructor for a randomly generated ship.
	 */
	public Tanker(String typeOfShip, String name, long transponderNum) {
		super(typeOfShip, name, transponderNum);
		this.barrelCapacity = 700000;
		this.cargo = new Oil();
		this.shipSymbol = 'T';

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * toString() method neatly formats the tanker ship's properties to be
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
	@Override
	public void displayShipInfo() {
		DecimalFormat df = new DecimalFormat("##.######");
		if (this.cargo != null) {
			System.out.printf("Tanker Ship: %s \n", name);
			MainClass.GUI.messageBox.append("\nTanker Ship: " + name + "\n");

			System.out.printf("Country of origin: %s \n", originCountry);
			MainClass.GUI.messageBox.append("Contry of Origin: "
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

			System.out.printf("Barrel Capacity: %d\n", barrelCapacity);
			MainClass.GUI.messageBox.append("Barrel Capacity: "
					+ barrelCapacity + "\n");

			System.out.printf("Cargo: %.0f barrels of %s",
					this.cargo.getWeight(), this.cargo.getDescription());
			MainClass.GUI.messageBox.append("Cargo: " + this.cargo.getWeight()
					+ " barrels of " + this.cargo.getDescription() + "\n");
			System.out.println();
			System.out.println();

		}

		else {
			System.out.printf("Tanker Ship: %s \n", name);
			MainClass.GUI.messageBox.append("\n" + "Tanker Ship: " + name
					+ "\n");

			System.out.printf("Country of origin: %s \n", originCountry);
			MainClass.GUI.messageBox.append("Contry of Origin: "
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

			System.out.printf("Barrel Capacity: %d\n", barrelCapacity);
			MainClass.GUI.messageBox.append("Barrel Capacity: "
					+ barrelCapacity + "\n");

			System.out.printf("Cargo: %.0f barrels of %s",
					this.cargo.getWeight(), this.cargo.getDescription());
			MainClass.GUI.messageBox.append("Cargo: " + this.cargo.getWeight()
					+ " barrels of " + this.cargo.getDescription() + "\n");

			System.out.print("Cargo: EMPTY\n");
			MainClass.GUI.messageBox.append("Cargo: EMPTY\n");

			System.out.println();
			System.out.println();

		}

	}

	/*
	 * Most getters and setters are inherited, except for the barrelCapacity
	 * variable.
	 */
	public int getBarrelCapacity() {
		return this.barrelCapacity;
	}

	public void setBarrelCapacity(int barrelCapacity) {
		this.barrelCapacity = barrelCapacity;
	}

}
