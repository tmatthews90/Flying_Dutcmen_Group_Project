package Group_Project;

/* 
 * Leviathan is a child class of the SeaMonster abstract class.
 */
public class Leviathan extends SeaMonster {

	public Leviathan() {
		this.position = new Position();
		this.monsterCount = 1;
		this.label = "Leviathan" + " " + this.monsterCount;
		this.monsterSymbol = 'L';

	}

	public Leviathan(int monsterCount) {
		this.position = new Position();
		this.label = "Leviathan " + monsterCount;
		this.monsterCount = monsterCount;
		this.monsterSymbol = 'L';

	}

	/*
	 * Whenever the Leviathan is in the same position as any of the ships, the
	 * leviathan will release its 'battle cry'.
	 */
	@Override
	public void battleCry() {
		System.out.println("Come! Ahab beckons!");
		MainClass.GUI.messageBox.append("Come! Ahab beckons\n");
	}
}
