package Group_Project;

import java.text.DecimalFormat;

/*
 * Dock class which is a place where if a ship is located, it can be unloaded.
 */
public class Dock {

	protected String dockName;
	protected char dockSection;
	protected int dockNumber;
	protected double dockLength;
	protected double dockBeam;
	protected double dockDraft;
	protected double dockLongitude;
	protected double dockLatitude;
	protected char dockSymbol;

	/*
	 * Default dock constructor which sets all values to default values.
	 */
	public Dock() {
		this.dockName = "Rudolf's dock";
		this.dockSection = 'N';
		this.dockNumber = 100;
		this.dockLength = 100;
		this.dockBeam = 6;
		this.dockDraft = 15;
		this.dockLongitude = -2.977838;
		this.dockLatitude = 53.410777;
		this.dockSymbol = 'D';
	}

	/*
	 * Contructor with a parameter for each variable in the dock class.
	 */
	public Dock(String dockName, char dockSection, int dockNumber,
			double dockLength, double dockBeam, double dockDraft,
			double dockLongitude, double dockLatitude, char dockSymbol) {
		this.dockName = dockName;
		this.dockSection = dockSection;
		this.dockNumber = dockNumber;
		this.dockLength = dockLength;
		this.dockBeam = dockBeam;
		this.dockDraft = dockDraft;
		this.dockLongitude = dockLongitude;
		this.dockLatitude = dockLatitude;
		this.dockSymbol = dockSymbol;
	}

	/*
	 * Contructor with a parameter for each variable in the dock class. Except
	 * dockSymbol, which will be set to a default value of 'D'.
	 */
	public Dock(String dockName, char dockSection, int dockNumber,
			double dockLength, double dockBeam, double dockDraft,
			double dockLongitude, double dockLatitude) {
		this.dockName = dockName;
		this.dockSection = dockSection;
		this.dockNumber = dockNumber;
		this.dockLength = dockLength;
		this.dockBeam = dockBeam;
		this.dockDraft = dockDraft;
		this.dockLongitude = dockLongitude;
		this.dockLatitude = dockLatitude;
		this.dockSymbol = 'D';
	}

	/*
	 * Constructor based on a string array, which sets each values of the dock
	 * based on the array's indice.
	 */
	public Dock(String[] values) {
		this.dockName = values[0];
		this.dockSection = values[1].charAt(0);
		this.dockNumber = Integer.parseInt(values[2]);
		this.dockLength = Double.parseDouble(values[3]);
		this.dockBeam = Double.parseDouble(values[4]);
		this.dockDraft = Double.parseDouble(values[5]);
		this.dockLongitude = Double.parseDouble(values[6]);
		this.dockLatitude = Double.parseDouble(values[7]);
		this.dockSymbol = 'D';
	}

	/*
	 * Constructor with a string containing CSVs for each variable in the class.
	 */
	public Dock(String data) {
		String[] values = data.split(",");
		this.dockName = values[0];
		this.dockSection = values[1].charAt(0);
		this.dockNumber = Integer.parseInt(values[2]);
		this.dockLength = Double.parseDouble(values[3]);
		this.dockBeam = Double.parseDouble(values[4]);
		this.dockDraft = Double.parseDouble(values[5]);
		this.dockLongitude = Double.parseDouble(values[6]);
		this.dockLatitude = Double.parseDouble(values[7]);
		this.dockSymbol = 'D';
	}

	/*
	 * Getters and setters for all of the dock's properties.
	 */
	public int getDockNumber() {
		return dockNumber;
	}

	public void setDockNumber(int dockNumber) {
		this.dockNumber = dockNumber;
	}

	public double getDockDraft() {
		return dockDraft;
	}

	public void setDockDraft(double dockDraft) {
		this.dockDraft = dockDraft;
	}

	public double getDockLength() {
		return dockLength;
	}

	public void setDockLength(double dockLength) {
		this.dockLength = dockLength;
	}

	public double getDockBeam() {
		return dockBeam;
	}

	public void setDockBeam(double dockBeam) {
		this.dockBeam = dockBeam;
	}

	public double getDockLongitude() {
		return dockLongitude;
	}

	public void setDockLongitude(double dockLongitude) {
		this.dockLongitude = dockLongitude;
	}

	public double getDockLatitude() {
		return dockLatitude;
	}

	public void setDockLatitude(double dockLatitude) {
		this.dockLatitude = dockLatitude;
	}

	public String getDockName() {
		return dockName;
	}

	public void setDockName(String dockName) {
		this.dockName = dockName;
	}

	public char getDockSection() {
		return dockSection;
	}

	public void setDockSection(char dockSection) {
		this.dockSection = dockSection;
	}

	public int getRow() {
		return MapConverter.lat2row(dockLatitude);
	}

	public int getCol() {
		return MapConverter.lon2col(dockLongitude);
	}

	public char getDockSymbol() {
		return dockSymbol;
	}

	public void setDockSymbol(char dockSymbol) {
		this.dockSymbol = dockSymbol;
	}

	/*
	 * Neatly displays all of the dock's info.
	 */
	public void displayDockInfo() {
		DecimalFormat df = new DecimalFormat("##.######");
		System.out.println();
		System.out.printf("Name: %s \n", dockName);
		MainClass.GUI.messageBox.append("\nName: " + dockName + "\n");
		System.out.printf("Dock number: %c%d \n", dockSection, dockNumber);
		MainClass.GUI.messageBox.append("Dock Number: " + dockSection + " "
				+ dockNumber + "\n");
		System.out.printf("Size (metres): %.2fx%.2fx%.2f metres \n",
				dockLength, dockBeam, dockDraft);
		MainClass.GUI.messageBox.append("Dock Size: " + dockLength + " x "
				+ dockBeam + " x " + dockDraft + "\n");
		System.out.printf("Location (longitude, latitude): (%f,%f)\n",
				dockLongitude, dockLatitude);
		MainClass.GUI.messageBox.append("Location (longitude, latitude): ("
				+ df.format(dockLongitude) + ", " + df.format(dockLatitude)
				+ ")\n");
		System.out.printf("Location (column, row): (%d,%d)\n",
				MapConverter.lon2col(dockLongitude) + 1,
				MapConverter.lat2row(dockLatitude) + 1);
		MainClass.GUI.messageBox.append("Location (column, row): ("
				+ (MapConverter.lon2col(dockLongitude)) + ", "
				+ (MapConverter.lat2row(dockLatitude)) + ")\n");
		MainClass.GUI.messageBox.append("Dock Symbol: " + dockSymbol + "\n");
		System.out.println();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * toString() method formats each of the dock's variables separated by
	 * commas to be outputted onto a port file.
	 */
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s,%s,%s,%s", dockName, dockSection,
				dockNumber, dockLength, dockDraft, dockBeam, dockLongitude,
				dockLatitude);
	}

	/*
	 * Returns the character for the type of ship this type of dock can unload.
	 */
	public char shipType() {
		return 'S';
	}

}
