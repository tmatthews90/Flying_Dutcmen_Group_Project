package Group_Project;

/* 
 * SeaSerpent is a child class of the SeaMonster abstract class.
 */
public class SeaSerpent extends SeaMonster {

	public SeaSerpent() {
		this.position = new Position();
		this.monsterCount = 1;
		this.label = "Sea Serpent" + " " + this.monsterCount;
		this.monsterSymbol = 's';
	}

	public SeaSerpent(int monsterCount) {
		this.position = new Position();
		this.label = "Sea Serpent " + monsterCount;
		this.monsterCount = monsterCount;
		this.monsterSymbol = 's';
	}

	/*
	 * Whenever the Sea Serpent is in the same position as any of the ships, the
	 * sea serpent will release its 'battle cry'.
	 */
	@Override
	public void battleCry() {
		System.out.println("Suddenly, you hear bagpipes!");
		MainClass.GUI.messageBox.append("Suddenly, you hear bagpipes!\n");
	}
}
