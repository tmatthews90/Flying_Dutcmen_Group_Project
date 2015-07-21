package Group_Project;

import static Group_Project.MapConverter.*;
import java.util.ArrayList;
import java.util.Random;

/*
 * The position class is used in every monster in the system to store all its position information.
 */
public class Position {
	private String monsterLabel;
	private int columnPosition;
	private int rowPosition;
	private double latitudePosition;
	private double longitudePosition;
	private int xPosition;
	private int yPosition;
	private SeaMonster monster;

	public Position() {
		this.columnPosition = randomColumn();
		this.rowPosition = randomRow();
		this.latitudePosition = row2lat(this.rowPosition);
		this.longitudePosition = col2lon(this.columnPosition);
		this.xPosition = this.columnPosition * 10;
		this.yPosition = this.rowPosition * 10;
	}

	public int getColumnPosition() {
		return columnPosition;
	}

	public void setColumnPosition(int columnPosition) {
		this.longitudePosition = col2lon(columnPosition);
		this.xPosition = columnPosition * 10;
		this.columnPosition = columnPosition;
	}

	public int getRowPosition() {
		return rowPosition;
	}

	public void setRowPosition(int rowPosition) {
		this.latitudePosition = row2lat(rowPosition);
		this.yPosition = rowPosition * 10;
		this.rowPosition = rowPosition;
	}

	public double getLatitudePosition() {
		return latitudePosition;
	}

	public void setLatitudePosition(double latitudePosition) {
		this.rowPosition = lat2row(latitudePosition);
		this.yPosition = this.rowPosition * 10;
		this.latitudePosition = latitudePosition;
	}

	public double getLongitudePosition() {
		return longitudePosition;
	}

	public void setLongitudePosition(double longitudePosition) {
		this.columnPosition = lon2col(longitudePosition);
		this.xPosition = this.columnPosition * 10;
		this.longitudePosition = longitudePosition;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.columnPosition = xPosition / 10;
		this.longitudePosition = col2lon(this.columnPosition);
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.rowPosition = yPosition / 10;
		this.latitudePosition = row2lat(rowPosition);
		this.yPosition = yPosition;
	}

	/*
	 * Generates an initial random row and column for the monster.
	 */
	public int randomRow() {
		Random r = new Random();
		int randomRow = r.nextInt(36);
		return randomRow;
	}

	public int randomColumn() {
		Random r = new Random();
		int randomCol = r.nextInt(54);
		return randomCol;
	}

}
