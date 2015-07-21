package Group_Project;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/*
 * This class will handle all of the gif images to be called when a 
 * type monster destroys another object.
 */
public class GifImageHandler extends JComponent{
    
	private URL godzillaGifSource;
	private URL seaSerpentGifSource;
	private URL leviathanGifSource;
	private URL krakenGifSource;
	private URL monsterKillGifSource;
	private URL monsterCreatedGifSource;

	private ImageIcon godzillaGif;
	private ImageIcon leviathanGif;
	private ImageIcon seaSerpentGif;
	private ImageIcon krakenGif;
	private ImageIcon killGif;
	private ImageIcon monsterCreatedGif;

	protected JLabel label;
	protected JFrame gifFrame;
        protected JPanel gifPanel;
	
	public GifImageHandler() throws IOException {
            
            godzillaGifSource = new URL("http://media.giphy.com/media/xpTX7IlkIDHoY/giphy.gif");
            seaSerpentGifSource = new URL("http://26.media.tumblr.com/tumblr_m2pkcxt8fx1qb2gmgo1_500.gif");
            leviathanGifSource = new URL("http://media.tumblr.com/tumblr_mdnh6f838B1qgv3yf.gif");
            krakenGifSource = new URL("http://media.giphy.com/media/5xtDarq58MkOIN4Fv2M/giphy.gif");
            monsterKillGifSource = new URL("https://33.media.tumblr.com/f7a8a4f7ab227d96ad9a79c5b616bf06/tumblr_nmnuhnLHZ71r6z7czo1_500.gif");
            monsterCreatedGifSource = new URL("http://cdn0.sbnation.com/imported_assets/2033143/the-kraken.gif");
            

            godzillaGif = new ImageIcon(godzillaGifSource);
            seaSerpentGif = new ImageIcon(seaSerpentGifSource);
            leviathanGif = new ImageIcon(leviathanGifSource);
            krakenGif = new ImageIcon(krakenGifSource);
            killGif = new ImageIcon(monsterKillGifSource);
            monsterCreatedGif = new ImageIcon(monsterCreatedGifSource);

            label = new JLabel();
            gifFrame = new JFrame();
        }
	
	public void showGodzillaGif() {
            label = new JLabel(godzillaGif);
            gifFrame.getContentPane().add(label);
            gifFrame.pack();
            gifFrame.setVisible(true);
	}
	
	public void showSeaSerpentGif() {
            label = new JLabel(seaSerpentGif);
            gifFrame.getContentPane().add(label);
            gifFrame.pack();
            gifFrame.setVisible(true);
	}
	
	public void showLeviathanGif() {
            label = new JLabel(leviathanGif);
            gifFrame.getContentPane().add(label);
            gifFrame.pack();
            gifFrame.setVisible(true);
	}
	
	public void showKrakenGif() {
            label = new JLabel(krakenGif);
            gifFrame.getContentPane().add(label);
            gifFrame.pack();
            gifFrame.setVisible(true);
        }
            
	public void showKillGif() {
            label = new JLabel(killGif);
            gifFrame.getContentPane().add(label);
            gifFrame.pack();
            gifFrame.setVisible(true);
	}
        
	public void showMonsterCreatedGif() {
            label = new JLabel(monsterCreatedGif);
            gifFrame.getContentPane().add(label);
            gifFrame.pack();
            gifFrame.setVisible(true);
	}
}
