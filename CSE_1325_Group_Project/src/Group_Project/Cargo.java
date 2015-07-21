package Group_Project;

/*
 * The Cargo class will represent the cargo of either a ship or dock, 
 * which will consist of its description and weight.
 */
public class Cargo {

	private double weight;
	protected String description;

	/*
	 * Default constructor with default values
	 */
	public Cargo() {
		this.weight = 10;
		this.description = "Bananas!";
	}

	/*
	 * Constructor with values based on two parameters of the respective
	 * variable's type.
	 */
	public Cargo(String description, double weight) {
		this.description = description;
		this.weight = weight;
	}

	/*
	 * Constructor based on a string array, which will set the values of the
	 * cargo's properties based on the contents of the string array of length 2.
	 */
	public Cargo(String[] values) {
		this.description = values[0];
		this.weight = Double.parseDouble(values[1]);

	}

	/*
	 * Constructor which uses the values obtained from a CSV string.
	 */
	public Cargo(String data) {
		String[] values = data.split(",");
		this.description = values[0];
		this.weight = Double.parseDouble(values[1]);
	}

	/*
	 * Getters and setters for all of the cargo's properties.
	 */
	public double getWeight() {
		return weight;

	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * Displays cargo info to user neatly.
	 */
	public void displayInfo() {
		System.out.printf("%.2f tons of %s \n", weight, description);
		MainClass.GUI.messageBox.append("\n" + weight + " tons of "
				+ description);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * toString() method to write cargo to file based on it's comma separated
	 * values.
	 */
	@Override
	public String toString() {
		return String.format("%s,%s", this.description, this.weight);
	}

}
