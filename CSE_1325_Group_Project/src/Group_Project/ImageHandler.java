package Group_Project;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageHandler {
    
    BufferedImage imgCargoShip = null;
    BufferedImage imgContainerShip = null;
    BufferedImage imgCrane = null;
    BufferedImage imgDock = null;
    BufferedImage imgGodzilla = null;
    BufferedImage imgKraken = null;
    BufferedImage imgLand = null;
    BufferedImage imgLeviathan = null;
    BufferedImage imgOilTanker = null;
    BufferedImage imgPier = null;
    BufferedImage imgSafe = null;
    BufferedImage imgSea = null;
    BufferedImage imgSeaSerpent = null;
    BufferedImage imgUnsafe = null;
    
    public ImageHandler(){
        try {
            imgCargoShip = ImageIO.read(new File("CargoShip.png"));
            imgContainerShip = ImageIO.read(new File("ContainerShip.png"));
            imgCrane = ImageIO.read(new File("Crane.png"));
            imgDock = ImageIO.read(new File("Dock.png"));
            imgGodzilla = ImageIO.read(new File("Godzilla.png"));
            imgKraken = ImageIO.read(new File("Kraken.png"));
            imgLand = ImageIO.read(new File("Land.png"));
            imgLeviathan = ImageIO.read(new File("Leviathan.png"));
            imgOilTanker = ImageIO.read(new File("OilTanker.png"));
            imgPier = ImageIO.read(new File("Pier.png"));
            imgSafe = ImageIO.read(new File("SAFE.png"));
            imgSea = ImageIO.read(new File("Sea.png"));
            imgSeaSerpent = ImageIO.read(new File("SeaSerpent.png"));
            imgUnsafe = ImageIO.read(new File("UNSAFE.png"));
        } catch (IOException e) {
        }
    }
}
