package Group_Project;

import java.text.DecimalFormat;

public class Pier extends Dock {
	public Pier() {
		super();
		this.dockSymbol = 'P';
	}

	/*
	 * Contructor with a parameter for each variable in the dock class. Except
	 * dockSymbol, which will be set to a default value of 'P'.
	 */
	public Pier(String dockName, char dockSection, int dockNumber,
			double dockLength, double dockBeam, double dockDraft,
			double dockLongitude, double dockLatitude) {

		super(dockName, dockSection, dockNumber, dockLength, dockBeam,
				dockDraft, dockLongitude, dockLatitude);
		this.dockSymbol = 'P';

	}

	/*
	 * Contructor with a parameter for each variable in the dock class.
	 */
	public Pier(String dockName, char dockSection, int dockNumber,
			double dockLength, double dockBeam, double dockDraft,
			double dockLongitude, double dockLatitude, char dockSymbol) {

		super(dockName, dockSection, dockNumber, dockLength, dockBeam,
				dockDraft, dockLongitude, dockLatitude, dockSymbol);

	}

	/*
	 * Constructor based on a string array, which sets each values of the dock
	 * based on the array's indice.
	 */
	public Pier(String data) {
		super(data);
		this.dockSymbol = 'P';
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * toString() method formats each of the pier's variables separated by
	 * commas to be outputted onto a port file.
	 */
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s,%s,%s,%s", dockName, dockSection,
				dockNumber, dockLength, dockDraft, dockBeam, dockLongitude,
				dockLatitude);
	}

	/*
	 * Neatly displays all of the pier's info.
	 */
	@Override
	public void displayDockInfo() {
		DecimalFormat df = new DecimalFormat("##.######");
		System.out.println();
		System.out.printf("Name: %s \n", dockName);
		MainClass.GUI.messageBox.append("\nName: " + dockName + "\n");
		System.out.printf("Pier number: %c%d \n", dockSection, dockNumber);
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
	 * Returns the character for the type of ship this type of dock can unload.
	 */
	@Override
	public char shipType() {
		return 'T';
	}

	/*
	 * Getters and setters inherited.
	 */
}
