package Group_Project;

/*
 * This class is a child of the SeaMonster class and creates the only rival to godzilla.
 */
public class Mothra extends SeaMonster {

	public Mothra() {
		this.position = new Position();
		this.label = "Mothra";
		this.monsterCount = 1;
		this.monsterSymbol = 'M';
	}

	@Override
	public void battleCry() {
		// sound.playSound("Godzilla");
		System.out.println("Woosh! Woosh! Woosh!");
		MainClass.GUI.messageBox.append("Woosh! Woosh! Woosh!\n");
	}

	/*
	 * Inherits all getters and setters.
	 */

}
