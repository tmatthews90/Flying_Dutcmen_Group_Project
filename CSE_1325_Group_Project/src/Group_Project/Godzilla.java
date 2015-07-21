package Group_Project;

/* 
 * Godzilla is a child class of the SeaMonster abstract class.
 */
public class Godzilla extends SeaMonster {

	public Godzilla() {
		this.position = new Position();
		this.label = "Godzilla";
		this.monsterCount = 1;
		this.monsterSymbol = 'G';
	}

	/*
	 * Whenever the Godzilla is in the same position as any of the other sea
	 * monsters, the Godzilla will release its 'battle cry'.
	 */
	@Override
	public void battleCry() {
		// sound.playSound("Godzilla");
		System.out.println("Baraaaawr-rompf!");
		MainClass.GUI.messageBox.append("Baraaaawr-rompf!\n");
	}

}
