package Group_Project;

/*
 * The 'Sea Monster' class is a parent abstract class with
 * a 'label' and 'monster count' variables, that will be used 
 * to keep track on the name, and number of monsters.
 */
public abstract class SeaMonster {
	protected Position position;
	protected String label;
	protected int monsterCount;
	protected Map map;
	protected char monsterSymbol;

	/*
	 * Each child of this super class will have its own unique 'battle cry',
	 * which will be called whenever any of the monsters is in the same location
	 * as any of the ships,
	 */
	public abstract void battleCry();

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getMonsterCount() {
		return this.monsterCount;
	}

	public void setMonsterCount(int monsterCount) {
		this.monsterCount = monsterCount;
	}

	public char getMonsterSymbol() {
		return this.monsterSymbol;
	}

	public void setMonsterSymbol(char monsterSymbol) {
		this.monsterSymbol = monsterSymbol;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * Outputs all of the mosnter's information in a CSV format.
	 */
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s,%s,%s", this.label,
				this.position.getRowPosition(),
				this.position.getColumnPosition(),
				this.position.getLatitudePosition(),
				this.position.getLongitudePosition(),
				this.position.getyPosition(), this.position.getxPosition());

	}
}
