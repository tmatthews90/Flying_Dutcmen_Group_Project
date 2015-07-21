package Group_Project;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

/*
 * This class will be the workhorse behind the 2-D map displayed in the GUI.
 */
public class MapComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	BufferedImage image;
	ArrayList<CargoShip> ships;
	ArrayList<Port> docks;

	BufferedImage imageCargoShip;
	BufferedImage imageLand;
	BufferedImage imageSea;
	BufferedImage imageContainerShip;
	BufferedImage imageCrane;
	BufferedImage imageDock;
	BufferedImage imageGodzilla;
	BufferedImage imageKraken;
	BufferedImage imageLeviathan;
	BufferedImage imageOilTanker;
	BufferedImage imagePier;
	BufferedImage imageSafe;
	BufferedImage imageSeaSerpent;
	BufferedImage imageUnsafe;
	BufferedImage imageMothra;

	public MapComponent() {

		this.setLayout(new GridLayout(36, 54, 0, 0));

		File fileCargoShip = null;
		File fileContainerShip = null;
		File fileCrane = null;
		File fileDock = null;
		File fileGodzilla = null;
		File fileKraken = null;
		File fileLand = null;
		File fileLeviathan = null;
		File fileOilTanker = null;
		File filePier = null;
		File fileSafe = null;
		File fileSea = null;
		File fileSeaSerpent = null;
		File fileUnsafe = null;
		File fileMothra = null;

		try {
			fileCargoShip = new File("CargoShip.png");
			imageCargoShip = ImageIO.read(fileCargoShip);

			fileContainerShip = new File("ContainerShip.png");
			imageContainerShip = ImageIO.read(fileContainerShip);

			fileCrane = new File("Crane.png");
			imageCrane = ImageIO.read(fileCrane);

			fileDock = new File("Dock.png");
			imageDock = ImageIO.read(fileDock);

			fileGodzilla = new File("Godzilla.png");
			imageGodzilla = ImageIO.read(fileGodzilla);

			fileKraken = new File("Kraken.png");
			imageKraken = ImageIO.read(fileKraken);

			fileLand = new File("Land.png");
			imageLand = ImageIO.read(fileLand);

			fileLeviathan = new File("Leviathan.png");
			imageLeviathan = ImageIO.read(fileLeviathan);

			fileOilTanker = new File("OilTanker.png");
			imageOilTanker = ImageIO.read(fileOilTanker);

			filePier = new File("Pier.png");
			imagePier = ImageIO.read(filePier);

			fileSafe = new File("SAFE.png");
			imageSafe = ImageIO.read(fileSafe);

			fileSea = new File("Sea.png");
			imageSea = ImageIO.read(fileSea);

			fileSeaSerpent = new File("SeaSerpent.png");
			imageSeaSerpent = ImageIO.read(fileSeaSerpent);

			fileUnsafe = new File("UNSAFE.png");
			imageUnsafe = ImageIO.read(fileUnsafe);

			fileMothra = new File("Mothra.png");
			imageMothra = ImageIO.read(fileMothra);

		} catch (IOException e) {
			e.printStackTrace();
		}

		validate();
		repaint();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 * 
	 * Constantly repaints the map in accordance with the char
	 * mapRepresentation[][] array in the map component of the main class.
	 * Updates every change in any component of the map in real time.
	 */
	public void paint(Graphics g) {
		super.paint(g);

		MainClass.map.displayMapV2(MainClass.port);

		// Drawing Land and Sea
		for (int row = 0; row < 36; row++) {
			for (int col = 0; col < 54; col++) {
				if (MainClass.map.mapRepresentation[row][col] == '*') {
					g.drawImage(imageLand, col * 10, row * 10, this);
				}
				if (MainClass.map.mapRepresentation[row][col] == '.')
					g.drawImage(imageSea, col * 10, row * 10, this);
			}
		}

		// Drawing elements on map from previous Display Map Method
		for (int row = 0; row < MainClass.map.mapRepresentation.length; row++) {
			for (int col = 0; col < MainClass.map.mapRepresentation[row].length; col++) {
				if (MainClass.map.mapRepresentation[row][col] == 'T')
					g.drawImage(imageOilTanker, col * 10, row * 10, this);
				else if (MainClass.map.mapRepresentation[row][col] == 'S')
					g.drawImage(imageCargoShip, col * 10, row * 10, this);
				else if (MainClass.map.mapRepresentation[row][col] == 'B')
					g.drawImage(imageContainerShip, col * 10, row * 10, this);
				else if (MainClass.map.mapRepresentation[row][col] == 'L')
					g.drawImage(imageLeviathan, col * 10, row * 10, this);
				else if (MainClass.map.mapRepresentation[row][col] == 's')
					g.drawImage(imageSeaSerpent, col * 10, row * 10, this);
				else if (MainClass.map.mapRepresentation[row][col] == 'K')
					g.drawImage(imageKraken, col * 10, row * 10, this);
				else if (MainClass.map.mapRepresentation[row][col] == 'G')
					g.drawImage(imageGodzilla, col * 10, row * 10, this);
				else if (MainClass.map.mapRepresentation[row][col] == 'D')
					g.drawImage(imageDock, col * 10, row * 10, this);
				else if (MainClass.map.mapRepresentation[row][col] == 'P')
					g.drawImage(imagePier, col * 10, row * 10, this);
				else if (MainClass.map.mapRepresentation[row][col] == 'C')
					g.drawImage(imageCrane, col * 10, row * 10, this);
				else if (MainClass.map.mapRepresentation[row][col] == 'X')
					g.drawImage(imageUnsafe, col * 10, row * 10, this);
				else if (MainClass.map.mapRepresentation[row][col] == '$')
					g.drawImage(imageSafe, col * 10, row * 10, this);
				else if (MainClass.map.mapRepresentation[row][col] == 'M')
					g.drawImage(imageMothra, col * 10, row * 10, this);
			}
		}
		repaint();
	}
}
