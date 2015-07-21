package Group_Project;

/*
 * The box class is a child class of the cargo class.
 *  Has a description variable inherited from the parent 
 *  class, and a private teu (twenty-foot equivalent units) variable.
 */

public class Box extends Cargo {

	private int teu;

	/*
	 * Default constructor without any parameter(s).
	 */
	public Box() {
		this.description = "Marble";
		this.teu = 10000;
	}

	/*
	 * Constructor which takes both String and int parameters to be assigned to
	 * respective variables.
	 */
	public Box(String desciption, int teu) {
		this.description = desciption;
		this.teu = teu;
	}

	/*
	 * Constructor that will take in a string that consisnt of CSVs that will be
	 * assigned to the respective variable by splitting the string into a string
	 * array, and for each respective index assign the correct data to the
	 * correct variable.
	 */
	public Box(String values) {
		String data[];
		data = values.split(",");

		this.description = data[0];
		this.teu = Integer.valueOf(data[1]);
	}

	/*
	 * Getters and setters for both variables in the class.
	 */
	public int getTeu() {
		return teu;
	}

	public void setTeu(int teu) {
		this.teu = teu;
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
	 * "this.description,this.teu" for easy file writing,
	 */
	@Override
	public String toString() {
		return String.format("%s,%d", this.description, this.teu);
	}

	/*
	 * Display function which properly display's the box's information.
	 */

	public void displayInfo() {
		System.out.println();
		System.out.printf("%d teus of %s\n", this.teu, this.description);
		MainClass.GUI.messageBox.append("\n" + this.teu + " teus of "
				+ this.description);
		System.out.println();
	}

}
