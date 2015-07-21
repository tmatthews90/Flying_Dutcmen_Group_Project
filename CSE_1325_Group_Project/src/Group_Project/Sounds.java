package Group_Project;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/* The sound class will have all of the sounds to be used in the GUI
 * And will be used whenever a sound is needed.
 */
public class Sounds {

	private File godzillaSound;
	private File monsterSound;
	private File mothraSound;
	private File shipBellSound;
	private File monsterSpawnSound;
	private File godzillaKillSound;

	private AudioInputStream godzillaIn;
	private AudioInputStream monsterIn;
	private AudioInputStream mothraIn;
	private AudioInputStream shipBellIn;
	private AudioInputStream monsterSpawnIn;
	private AudioInputStream godzillaKillIn;

	private Clip clipMonster;
	private Clip clipGodzilla;
	private Clip clipMothra;
	private Clip clipShipBell;
	private Clip clipMonsterSpawn;
	private Clip clipGodzillaKill;

	public Sounds() {
		try {
			godzillaSound = new File("Godzilla.wav");
			monsterSound = new File("kraken.wav");
			mothraSound = new File("mothra.wav");
			shipBellSound = new File("shipBell.wav");
			monsterSpawnSound = new File("monsterSpawn.wav");
			godzillaKillSound = new File("godzillaKill.wav");

			godzillaIn = AudioSystem.getAudioInputStream(godzillaSound);
			monsterIn = AudioSystem.getAudioInputStream(monsterSound);
			mothraIn = AudioSystem.getAudioInputStream(mothraSound);
			shipBellIn = AudioSystem.getAudioInputStream(shipBellSound);
			monsterSpawnIn = AudioSystem.getAudioInputStream(monsterSpawnSound);
			godzillaKillIn = AudioSystem.getAudioInputStream(godzillaKillSound);

			clipMonster = AudioSystem.getClip();
			clipGodzilla = AudioSystem.getClip();
			clipMothra = AudioSystem.getClip();
			clipShipBell = AudioSystem.getClip();
			clipMonsterSpawn = AudioSystem.getClip();
			clipGodzillaKill = AudioSystem.getClip();

			clipMonster.open(monsterIn);
			clipGodzilla.open(godzillaIn);
			clipMothra.open(mothraIn);
			clipShipBell.open(shipBellIn);
			clipMonsterSpawn.open(monsterSpawnIn);
			clipGodzillaKill.open(godzillaKillIn);

		} catch (UnsupportedAudioFileException | IOException
				| LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	/*
	 * The followung methods play the sound for the respective monster and their
	 * action.
	 */
	public void playGodzilla() {
		clipGodzilla.setMicrosecondPosition(0);
		clipGodzilla.start();
	}

	public void playMonster() {
		clipMonster.setMicrosecondPosition(0);
		clipMonster.start();
	}

	public void playMothra() {
		clipMothra.setMicrosecondPosition(0);
		clipMothra.start();
	}

	public void playMonstersCreated() {
		clipMonsterSpawn.setMicrosecondPosition(0);
		clipMonsterSpawn.start();
	}

	public void playGodzillaKill() {
		clipGodzillaKill.setMicrosecondPosition(0);
		clipGodzillaKill.start();
	}

	public void playShipBell() {
		clipShipBell.setMicrosecondPosition(0);
		clipShipBell.start();
	}
}
