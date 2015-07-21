package Group_Project;

import java.util.ArrayList;

/*
 * Port class which will consist of a list of 
 * docks, cargos, and the city in which the port is in.
 */
public class Port {

	private String portCity;
	private ArrayList<Dock> listOfDocks;
	private ArrayList<Cargo> listOfCargos;

	/*
	 * Default constructor with default values.
	 */
	public Port() {
		portCity = "Liverpool";
		this.listOfDocks = new ArrayList<>();
		this.listOfCargos = new ArrayList<>();

	}

	/*
	 * Constructor based on a string array, which will indicate the port's city
	 * name, and amount of docks and cargos.
	 */
	public Port(String portCity, int dockListSize, int cargoListSize) {
		this.portCity = portCity;
		this.listOfDocks = new ArrayList<>(dockListSize);
		this.listOfCargos = new ArrayList<>(cargoListSize);
	}

	/*
	 * Getters and setter for all of the port's properties.
	 */
	public String getPortCity() {
		return portCity;
	}

	public void setPortCity(String portCity) {
		this.portCity = portCity;
	}

	public ArrayList<Dock> getListOfDocks() {
		return listOfDocks;
	}

	public void setListOfDocks(ArrayList<Dock> listOfDocks) {
		this.listOfDocks = listOfDocks;
	}

	public ArrayList<Cargo> getListOfCargos() {
		return listOfCargos;
	}

	public void setListOfCargos(ArrayList<Cargo> listOfCargos) {
		this.listOfCargos = listOfCargos;
	}

	/*
	 * Neatly displays the port's docks.
	 */
	public void displayDocks() {
		if (!listOfDocks.isEmpty()) {
			for (int i = 0; i < listOfDocks.size(); i++) {
				listOfDocks.get(i).displayDockInfo();
			}
		}

		else {
			System.out.println("-----------------------");
			System.out.println("No docks are available.");
			System.out.println("-----------------------");

		}
	}

	/*
	 * Neatly displays the port's cargos.
	 */
	public void displayCargos() {
		if (!listOfCargos.isEmpty()) {
			for (int i = 0; i < listOfCargos.size(); i++) {
				listOfCargos.get(i).displayInfo();
			}
		}

		else {
			System.out.println("-----------------------");
			System.out.println("No cargos are available.");
			System.out.println("-----------------------");

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * toString() method which formats the port's file input with the toString()
	 * returning a string containing the port's city name and amounts of docks
	 * and cargo's in the dock.
	 */
	@Override
	public String toString() {
		return String.format("%s,%s,%s", portCity, listOfDocks.size(),
				listOfCargos.size());
	}

}
