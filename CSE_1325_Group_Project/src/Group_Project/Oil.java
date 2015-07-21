package Group_Project;

/*
 * The oil class inherits from the cargo class
 * and has its own unique variable of barrels.
 */
public class Oil extends Cargo {
	private int barrels;

	public Oil() {
		this.description = "Light Crude";
		this.barrels = 700000;
	}

	/*
	 * Constructor which takes both String and int parameters to be assigned to
	 * respective variables.
	 */
	public Oil(String desciption, int barrels) {
		this.description = desciption;
		this.barrels = barrels;
	}

	/*
	 * Constructor that will take in a string that consisnt of CSVs that will be
	 * assigned to the respective variable by splitting the string into a string
	 * array, and for each respective index assign the correct data to the
	 * correct variable.
	 */
	public Oil(String values) {
		String data[];
		data = values.split(",");

		this.description = data[0];
		this.barrels = Integer.valueOf(data[1]);
	}

	/*
	 * Getters and setters for both variables in the class.
	 */
	public int getBarrels() {
		return barrels;
	}

	public void setBarrels(int barrels) {
		this.barrels = barrels;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see homework3.Cargo#toString()
	 * 
	 * toString method which outputs a string in the form of
	 * "this.description,this.barrels" for easy file writing,
	 */
	@Override
	public String toString() {
		return String.format("%s,%d", this.description, this.barrels);
	}

	/*
	 * Display function which properly display's the oil's cargo information.
	 */

	public void displayInfo() {
		System.out.println();
		System.out.printf("%d barrels of %s\n", this.barrels, this.description);
		MainClass.GUI.messageBox.append("\n" + this.barrels + " barrels of "
				+ this.description);
		System.out.println();
	}
}
