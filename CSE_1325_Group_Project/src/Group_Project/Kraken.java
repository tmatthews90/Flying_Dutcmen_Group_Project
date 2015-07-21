package Group_Project;

/* 
 * Kraken is a child class of the SeaMonster abstract class.
 */
public class Kraken extends SeaMonster {

	public Kraken() {
		this.position = new Position();
		this.monsterCount = 1;
		this.label = "Kraken" + " " + this.monsterCount;
		this.monsterSymbol = 'K';

	}

	public Kraken(int monsterCount) {
		this.position = new Position();
		this.label = "Kraken " + monsterCount;
		this.monsterCount = monsterCount;
		this.monsterSymbol = 'K';

	}

	/*
	 * Whenever the Kraken is in the same position as any of the ships, the
	 * Kraken will release its 'battle cry'.
	 */
	@Override
	public void battleCry() {
		System.out.println("RELEASE ME!");
		MainClass.GUI.messageBox.append("RELEASE ME!\n");
	}

}
