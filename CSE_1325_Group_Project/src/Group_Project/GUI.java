package Group_Project;

import static Group_Project.MapConverter.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.SpringLayout;

import Group_Project.Sounds;

/*
 * The GUI class will present a 2-D map to the user, and be
 *  the medium through which the user and system communicate.
 */
public class GUI extends JFrame implements ActionListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	protected int nextShip = 0;
	protected int nextDock = 0;
	protected int nextMonster = 0;

	boolean picked = false;
	SeaMonster tempMonster = null;
	CargoShip tempShip = null;

	Sounds soundFX;

	/*
	 * GUI components.
	 */
	JMenuBar menuBar;
	JMenu menuFile;
	JMenu menuShip;
	JMenu menuPort;
	JMenu menuMonster;
	JButton menuAboutButton;

	// File Menu Items
	JMenuItem menuitemAbout;
	JMenuItem menuitemOpen;
	JMenuItem menuitemClose;
	JMenuItem menuitemSnapShot;
	JMenuItem menuitemExit;
	JMenuItem menuitemClearConsole;
	// Ship Menu Items
	JMenuItem menuitemGenerateShips;
	JMenuItem menuitemUpdateShips;
	JMenuItem menuitemDisplayShips;
	JMenuItem menuitemRemoveShips;
	// Port Menu Items
	JMenuItem menuitemUnloadShip;
	JMenuItem menuitemUpdateDock;
	JMenuItem menuitemDisplayDocks;
	JMenuItem menuitemDisplayCargos;
	// Monster Menu Items
	JMenuItem menuitemGenerateMonsters;
	JMenuItem menuitemUpdateMonsters;
	JMenuItem menuitemDisplayMonsters;
	JMenuItem menuitemRemoveMonsters;
	JMenuItem menuitemSummonGodzilla;

	JTextArea messageBox;
	JPanel imageArea;

	MapComponent map;

	/*
	 * Labels and commands that will be used in the program.
	 */
	public final static String labelFile = "File";
	public final static String labelShip = "Ship";
	public final static String labelPort = "Port";
	public final static String labelMonster = "Monster";
	public final static String labelHelp = "Help";
	public final static String commandOpen = "Open";
	public final static String commandClose = "Close";
	public final static String commandSnapShot = "Snap Shot";
	public final static String commandExit = "Exit";
	public final static String commandAbout = "About";
	public final static String commandGenerateShips = "Generate Ships";
	public final static String commandUpdateShips = "Update Ships";
	public final static String commandDisplayShips = "Display Ships";
	public final static String commandRemoveShips = "Remove Ships";
	public final static String commandGenerateMonsters = "Generate Monsters";
	public final static String commandUpdateMonsters = "Update Monsters";
	public final static String commandDisplayMonsters = "Display Monsters";
	public final static String commandRemoveMonsters = "Remove Monsters";
	public final static String commandSummonGodzilla = "Summon Godzilla";
	public final static String commandUnloadShip = "Unload Ship";
	public final static String commandUpdateDock = "Update Dock";
	public final static String commandDisplayDocks = "Display Docks";
	public final static String commandDisplayCargos = "Display Cargos";
	public final static String commandClearConsole = "Clear Console";

	public GUI() {

		// Set up Menu Bar Items
		menuBar = new JMenuBar();

		menuFile = new JMenu(labelFile);
		menuShip = new JMenu(labelShip);
		menuPort = new JMenu(labelPort);
		menuMonster = new JMenu(labelMonster);

		// File Menu Items
		menuitemOpen = new JMenuItem(commandOpen);
		menuitemOpen.addActionListener(this);
		menuFile.add(menuitemOpen);

		menuitemClose = new JMenuItem(commandClose);
		menuitemClose.addActionListener(this);
		menuFile.add(menuitemClose);

		menuitemSnapShot = new JMenuItem(commandSnapShot);
		menuitemSnapShot.addActionListener(this);
		menuFile.add(menuitemSnapShot);

		menuitemClearConsole = new JMenuItem(commandClearConsole);
		menuitemClearConsole.addActionListener(this);
		menuFile.add(menuitemClearConsole);

		menuitemExit = new JMenuItem(commandExit);
		menuitemExit.addActionListener(this);
		menuFile.add(menuitemExit);

		// about button
		menuAboutButton = new JButton(commandAbout);
		menuAboutButton.addActionListener(this);
		menuAboutButton.setBorderPainted(false);

		// Ship Menu Items
		menuitemGenerateShips = new JMenuItem(commandGenerateShips);
		menuitemGenerateShips.addActionListener(this);
		menuShip.add(menuitemGenerateShips);

		menuitemUpdateShips = new JMenuItem(commandUpdateShips);
		menuitemUpdateShips.addActionListener(this);
		menuShip.add(menuitemUpdateShips);

		menuitemDisplayShips = new JMenuItem(commandDisplayShips);
		menuitemDisplayShips.addActionListener(this);
		menuShip.add(menuitemDisplayShips);

		menuitemRemoveShips = new JMenuItem(commandRemoveShips);
		menuitemRemoveShips.addActionListener(this);
		menuShip.add(menuitemRemoveShips);

		// Port Menu Items
		menuitemUnloadShip = new JMenuItem(commandUnloadShip);
		menuitemUnloadShip.addActionListener(this);
		menuPort.add(menuitemUnloadShip);

		menuitemUpdateDock = new JMenuItem(commandUpdateDock);
		menuitemUpdateDock.addActionListener(this);
		menuPort.add(menuitemUpdateDock);

		menuitemDisplayDocks = new JMenuItem(commandDisplayDocks);
		menuitemDisplayDocks.addActionListener(this);
		menuPort.add(menuitemDisplayDocks);

		menuitemDisplayCargos = new JMenuItem(commandDisplayCargos);
		menuitemDisplayCargos.addActionListener(this);
		menuPort.add(menuitemDisplayCargos);

		// Monster Menu Items
		menuitemGenerateMonsters = new JMenuItem(commandGenerateMonsters);
		menuitemGenerateMonsters.addActionListener(this);
		menuMonster.add(menuitemGenerateMonsters);

		menuitemUpdateMonsters = new JMenuItem(commandUpdateMonsters);
		menuitemUpdateMonsters.addActionListener(this);
		menuMonster.add(menuitemUpdateMonsters);

		menuitemDisplayMonsters = new JMenuItem(commandDisplayMonsters);
		menuitemDisplayMonsters.addActionListener(this);
		menuMonster.add(menuitemDisplayMonsters);

		menuitemRemoveMonsters = new JMenuItem(commandRemoveMonsters);
		menuitemRemoveMonsters.addActionListener(this);
		menuMonster.add(menuitemRemoveMonsters);

		menuitemSummonGodzilla = new JMenuItem(commandSummonGodzilla);
		menuitemSummonGodzilla.addActionListener(this);
		menuMonster.add(menuitemSummonGodzilla);

		// Adding menu items to menu bar
		menuBar.add(menuFile);
		menuBar.add(menuShip);
		menuBar.add(menuPort);
		menuBar.add(menuMonster);
		menuBar.add(menuAboutButton);

		this.setJMenuBar(menuBar);

		// Create Workspace
		this.setTitle("CSE-1325-002 Group Project: The Flying Dutchmen");
		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);

		// console
		messageBox = new JTextArea(10, 20);
		JScrollPane scrollPane = new JScrollPane(messageBox);
		scrollPane.setAutoscrolls(true);
		messageBox.setEditable(false);
		messageBox.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(scrollPane, BorderLayout.SOUTH);

		// map area
		imageArea = new JPanel();
		imageArea.setLayout(new GridLayout(1, 1, 0, 0));
		imageArea.setPreferredSize(new Dimension(540, 360));
		this.add(imageArea, BorderLayout.NORTH);

		soundFX = new Sounds();
		addMouseMotionListener(this);

		/*
		 * End program on closing the GUI window.
		 */
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		Dimension d = new Dimension(560, 600);
		this.setSize(d);
		this.setVisible(true);

		this.setLocationRelativeTo(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * 
	 * Will be the action listener for the GUI, will execute whatever command as
	 * selected by the user.
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			String command = e.getActionCommand();

			switch (command) {
			case commandOpen:
				openFile();
				break;
			case commandClose:
				closeFile();
				break;
			case commandSnapShot:
				snapShot();
				break;
			case commandExit:
				System.exit(0);
				break;
			case commandGenerateShips:
				GenerateShips();
				break;
			case commandUpdateShips:
				if (MainClass.map.getListOfShips().isEmpty()) {
					int result = JOptionPane.showConfirmDialog(this,
							"No ships to update, genearate ships?",
							"No ships to update", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						GenerateShips();
						UpdateShip();
					}
				} else
					UpdateShip();
				break;
			case commandDisplayShips:
				if (MainClass.map.getListOfShips().isEmpty()) {
					int result = JOptionPane.showConfirmDialog(this,
							"No ships to display, genearate ships?",
							"No ships to update", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						GenerateShips();
						DisplayShipsInConsole();
						DisplayShips();
					}
				} else {
					DisplayShipsInConsole();
					DisplayShips();
				}
				break;
			case commandRemoveShips:
				MainClass.map.getListOfShips().clear();
				nextShip = 0;
				messageBox.append("Ships were removed\n");
				break;
			case commandGenerateMonsters:
				GenerateMonsters();
				break;
			case commandUpdateMonsters:
				if (MainClass.map.getMonsterList().isEmpty()) {
					int result = JOptionPane.showConfirmDialog(this,
							"No monsters to update, genearate monsters?",
							"No Monsters to update", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						GenerateMonsters();
						UpdateMonster();
					}
				} else
					UpdateMonster();
				break;
			case commandDisplayMonsters:
				if (MainClass.map.getMonsterList().isEmpty()) {
					int result = JOptionPane.showConfirmDialog(this,
							"No monsters to display, genearate monsters?",
							"No Monsters to update", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						GenerateMonsters();
						DisplayMonstersInConsole();
						DisplayMonsters();
					}
				} else {
					DisplayMonstersInConsole();
					DisplayMonsters();
				}
				break;
			case commandRemoveMonsters:
				MainClass.map.getMonsterList().clear();
				nextMonster = 0;
				messageBox.append("Monsters were removed\n");
				break;
			case commandSummonGodzilla:
				SummonGodzilla();
				break;
			case commandUnloadShip:
				unloadShip();
				break;
			case commandUpdateDock:
				if (MainClass.port.getListOfDocks().isEmpty()) {
					int result = JOptionPane.showConfirmDialog(this,
							"No docks to update, load system?",
							"No docks to update", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						openFile();
						UpdateDock();
					}
				} else
					UpdateDock();
				break;
			case commandDisplayDocks:
				if (MainClass.port.getListOfDocks().isEmpty()) {
					int result = JOptionPane.showConfirmDialog(this,
							"No docks to display, load system?",
							"No docks to update", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						openFile();
						DisplayDocksInConsole();
						DisplayDocks();
					}
				} else {
					DisplayDocksInConsole();
					DisplayDocks();
				}
				break;
			case commandDisplayCargos:
				if (MainClass.port.getListOfCargos().isEmpty())
					JOptionPane
							.showMessageDialog(this, "No cargos to display.");
				else
					MainClass.port.displayCargos();
				break;
			case commandClearConsole:
				messageBox.setText("");
				break;
			case commandAbout:
				JOptionPane.showMessageDialog(this, "Flying Dutchmen\n"
						+ "CSE-1325-002\n" + "[DATE]\n\n" + "David Camacho\n"
						+ "UTA ID: 1000849812\n\n" + "Gabino Luna\n"
						+ "UTA ID: 1000929666\n\n" + "Travis Matthews\n"
						+ "UTA ID: 1001053884\n\n");
				break;
			}
		} catch (UnsupportedEncodingException | FileNotFoundException
				| InputMismatchException ex) {
			Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/*
	 * Opens the .port.txt and .map.txt files specified by the user in the
	 * project's directory.
	 */
	public void openFile() {
		try {
			String openFile = JOptionPane.showInputDialog(this,
					"Enter file to open");
			messageBox.append(openFile + " files loaded\n");
			MainClass.loadMapV3(openFile);
			map = new MapComponent();
			imageArea.add(map);
			this.setSize(547, 583);
			this.setResizable(false);
		} catch (FileNotFoundException ex) {
		}
	}

	/*
	 * Saves a file with all the ships, docks, and monsters in the system.
	 */
	public void snapShot() throws UnsupportedEncodingException,
			FileNotFoundException {
		JFileChooser fileChooser = new JFileChooser(
				System.getProperty("user.home") + "\\desktop");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt",
				"txt", "text");
		fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String destination = fileChooser.getSelectedFile()
					.getAbsolutePath() + ".txt";
			MainClass.fileHandler.snapShotV3(MainClass.port, MainClass.map,
					destination);
		}
		messageBox.append("'" + fileChooser.getSelectedFile().getName()
				+ ".txt'" + " created at location: '"
				+ fileChooser.getSelectedFile().getAbsolutePath() + ".txt'");
	}

	/*
	 * All monsters, docks, and ships will be removed from the system.
	 */
	public void closeFile() {
		nextMonster = 0;
		nextShip = 0;
		nextDock = 0;
		MainClass.map.getMonsterList().clear();
		MainClass.map.getListOfShips().clear();
		MainClass.port.getListOfCargos().clear();
		MainClass.port.getListOfDocks().clear();
		JOptionPane.showMessageDialog(this,
				"Docks, ships, cargos, and monsters were removed.");
	}

	/*
	 * Generates ships from the GUI using the generateShips(int numberOfShips)
	 * method in the main class.
	 */
	public void GenerateShips() {
		try {
			String returnString = JOptionPane.showInputDialog(this,
					"Enter number of ships to create ");
			int numberOfShips = Integer.parseInt(returnString);
			MainClass.generateShipsV3(numberOfShips);
			if (numberOfShips > 0) {
				messageBox.append(numberOfShips + " ships created\n");
				soundFX.playShipBell();
			}

		} catch (FileNotFoundException | NumberFormatException
				| InputMismatchException ex) {
		}
	}

	/*
	 * Displays all of the ships in the system into the GUI console.
	 */
	public void DisplayShipsInConsole() {
		for (int i = 0; i < MainClass.map.getListOfShips().size(); i++) {
			MainClass.map.getListOfShips().get(i).displayShipInfo();
		}
	}

	/*
	 * Displays all of the ships in a popup window.
	 */
	public void DisplayShips() {

		final DecimalFormat df = new DecimalFormat("##.######");

		final JPanel updateShipPanel = new JPanel();
		updateShipPanel.setLayout(new SpringLayout());
		updateShipPanel.update(null);

		int numPairs = 16; // number of fields

		final int numberOfShips = MainClass.map.getListOfShips().size();

		JLabel labelShipNumber = new JLabel("Ship :", JLabel.TRAILING);
		updateShipPanel.add(labelShipNumber);
		final JTextField shipNumberField = new JTextField("1 of "
				+ numberOfShips);
		shipNumberField.setEditable(false);
		labelShipNumber.setLabelFor(shipNumberField);
		updateShipPanel.add(shipNumberField);

		JLabel labelName = new JLabel("Name :", JLabel.TRAILING);
		updateShipPanel.add(labelName);
		final JTextField nameField = new JTextField(MainClass.map
				.getListOfShips().get(0).getName());
		nameField.setEditable(false);
		labelName.setLabelFor(nameField);
		updateShipPanel.add(nameField);
		nameField.setColumns(10);

		JLabel labelShipType = new JLabel("Ship Type :", JLabel.TRAILING);
		updateShipPanel.add(labelShipType);
		final JTextField shipTypeField = new JTextField(MainClass.map
				.getListOfShips().get(0).getTypeOfShip());
		shipTypeField.setEditable(false);
		labelShipType.setLabelFor(shipTypeField);
		updateShipPanel.add(shipTypeField);

		JLabel labelReg = new JLabel("Registration :", JLabel.TRAILING);
		updateShipPanel.add(labelReg);
		final JTextField registrationField = new JTextField(MainClass.map
				.getListOfShips().get(0).getOriginCountry());
		registrationField.setEditable(false);
		labelReg.setLabelFor(registrationField);
		updateShipPanel.add(registrationField);

		JLabel labelTransponder = new JLabel("Transponder :", JLabel.TRAILING);
		updateShipPanel.add(labelTransponder);
		final JTextField transponderField = new JTextField(
				Long.toString(MainClass.map.getListOfShips().get(0)
						.getTransponderNum()));
		transponderField.setEditable(false);
		labelTransponder.setLabelFor(transponderField);
		updateShipPanel.add(transponderField);

		JLabel labelCapacity = new JLabel("Capacity :", JLabel.TRAILING);
		updateShipPanel.add(labelCapacity);
		final JTextField capacityField = new JTextField(
				Double.toString(MainClass.map.getListOfShips().get(0)
						.getCargoCapacity()));
		capacityField.setEditable(false);
		labelCapacity.setLabelFor(capacityField);
		updateShipPanel.add(capacityField);

		JLabel labelLength = new JLabel("Length :", JLabel.TRAILING);
		updateShipPanel.add(labelLength);
		final JTextField lengthField = new JTextField(
				Double.toString(MainClass.map.getListOfShips().get(0)
						.getLength()));
		lengthField.setEditable(false);
		labelLength.setLabelFor(lengthField);
		updateShipPanel.add(lengthField);

		JLabel labelBeam = new JLabel("Beam :", JLabel.TRAILING);
		updateShipPanel.add(labelBeam);
		final JTextField beamField = new JTextField(
				Double.toString(MainClass.map.getListOfShips().get(0).getBeam()));
		beamField.setEditable(false);
		labelBeam.setLabelFor(beamField);
		updateShipPanel.add(beamField);

		JLabel labelDraft = new JLabel("Draft :", JLabel.TRAILING);
		updateShipPanel.add(labelDraft);
		final JTextField draftField = new JTextField(
				Double.toString(MainClass.map.getListOfShips().get(0)
						.getDraft()));
		draftField.setEditable(false);
		labelDraft.setLabelFor(draftField);
		updateShipPanel.add(draftField);

		JLabel labelLongitude = new JLabel("Longitude :", JLabel.TRAILING);
		updateShipPanel.add(labelLongitude);
		final JTextField longitudeField = new JTextField(
				df.format(MainClass.map.getListOfShips().get(0).getLongitude()));
		longitudeField.setEditable(false);
		labelLongitude.setLabelFor(longitudeField);
		updateShipPanel.add(longitudeField);

		JLabel labelLatitude = new JLabel("Latitude :", JLabel.TRAILING);
		updateShipPanel.add(labelLatitude);
		final JTextField latitudeField = new JTextField(df.format(MainClass.map
				.getListOfShips().get(0).getLatitude()));
		latitudeField.setEditable(false);
		labelLatitude.setLabelFor(latitudeField);
		updateShipPanel.add(latitudeField);

		JLabel labelRow = new JLabel("Row :", JLabel.TRAILING);
		updateShipPanel.add(labelRow);
		final JTextField rowField = new JTextField(
				Integer.toString(lat2row(MainClass.map.getListOfShips().get(0)
						.getLatitude())));
		rowField.setEditable(false);
		labelRow.setLabelFor(rowField);
		updateShipPanel.add(rowField);

		JLabel labelColumn = new JLabel("Column :", JLabel.TRAILING);
		updateShipPanel.add(labelColumn);
		final JTextField columnField = new JTextField(
				Integer.toString(lon2col(MainClass.map.getListOfShips().get(0)
						.getLongitude())));
		columnField.setEditable(false);
		labelColumn.setLabelFor(columnField);
		updateShipPanel.add(columnField);

		JLabel labelCargoType = new JLabel("Type of Cargo :", JLabel.TRAILING);
		updateShipPanel.add(labelCargoType);
		final JTextField cargoTypeField = new JTextField(MainClass.map
				.getListOfShips().get(0).getCargoDescription());
		cargoTypeField.setEditable(false);
		labelCargoType.setLabelFor(cargoTypeField);
		updateShipPanel.add(cargoTypeField);

		JLabel labelAmount = new JLabel("Amount of Cargo :", JLabel.TRAILING);
		updateShipPanel.add(labelAmount);
		final JTextField amountField = new JTextField(
				Double.toString(MainClass.map.getListOfShips().get(0)
						.getCargoWeight()));
		amountField.setEditable(false);
		labelAmount.setLabelFor(amountField);
		updateShipPanel.add(amountField);

		JButton previousButton = new JButton("Previous Ship");
		JButton nextButton = new JButton("Next Ship");

		updateShipPanel.add(previousButton);
		updateShipPanel.add(nextButton);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(updateShipPanel, numPairs, 2, // rows,
																		// cols
				6, 6, // initX, initY
				6, 6); // xPad, yPad

		// Create and set up the window.
		JFrame frame = new JFrame("SpringForm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		updateShipPanel.setOpaque(true); // content panes must be opaque
		frame.setContentPane(updateShipPanel);

		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nextShip == numberOfShips - 1) {
					nextShip = 0;
				} else {
					nextShip++;
				}

				shipNumberField
						.setText((nextShip + 1) + " of " + numberOfShips);
				shipTypeField.setText(MainClass.map.getListOfShips()
						.get(nextShip).getTypeOfShip());
				nameField.setText(MainClass.map.getListOfShips().get(nextShip)
						.getName());
				registrationField.setText(MainClass.map.getListOfShips()
						.get(nextShip).getOriginCountry());
				transponderField.setText(Long.toString(MainClass.map
						.getListOfShips().get(nextShip).getTransponderNum()));
				capacityField.setText(Double.toString(MainClass.map
						.getListOfShips().get(nextShip).getCargoCapacity()));
				lengthField.setText(Double.toString(MainClass.map
						.getListOfShips().get(nextShip).getLength()));
				beamField.setText(Double.toString(MainClass.map
						.getListOfShips().get(nextShip).getBeam()));
				draftField.setText(Double.toString(MainClass.map
						.getListOfShips().get(nextShip).getDraft()));
				longitudeField.setText(df.format(MainClass.map.getListOfShips()
						.get(nextShip).getLongitude()));
				latitudeField.setText(df.format(MainClass.map.getListOfShips()
						.get(nextShip).getLatitude()));
				rowField.setText(Integer.toString(lat2row(MainClass.map
						.getListOfShips().get(nextShip).getLatitude())));
				columnField.setText(Integer.toString(lon2col(MainClass.map
						.getListOfShips().get(nextShip).getLongitude())));
				cargoTypeField.setText(MainClass.map.getListOfShips()
						.get(nextShip).getCargoDescription());
				amountField.setText(Double.toString(MainClass.map
						.getListOfShips().get(nextShip).getCargoWeight()));
			}
		});

		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nextShip == 0) {
					nextShip = numberOfShips - 1;
				} else {
					nextShip--;
				}

				shipNumberField
						.setText((nextShip + 1) + " of " + numberOfShips);
				shipTypeField.setText(MainClass.map.getListOfShips()
						.get(nextShip).getTypeOfShip());
				nameField.setText(MainClass.map.getListOfShips().get(nextShip)
						.getName());
				registrationField.setText(MainClass.map.getListOfShips()
						.get(nextShip).getOriginCountry());
				transponderField.setText(Long.toString(MainClass.map
						.getListOfShips().get(nextShip).getTransponderNum()));
				capacityField.setText(Double.toString(MainClass.map
						.getListOfShips().get(nextShip).getCargoCapacity()));
				lengthField.setText(Double.toString(MainClass.map
						.getListOfShips().get(nextShip).getLength()));
				beamField.setText(Double.toString(MainClass.map
						.getListOfShips().get(nextShip).getBeam()));
				draftField.setText(Double.toString(MainClass.map
						.getListOfShips().get(nextShip).getDraft()));
				longitudeField.setText(df.format(MainClass.map.getListOfShips()
						.get(nextShip).getLongitude()));
				latitudeField.setText(df.format(MainClass.map.getListOfShips()
						.get(nextShip).getLatitude()));
				rowField.setText(Integer.toString(lat2row(MainClass.map
						.getListOfShips().get(nextShip).getLatitude())));
				columnField.setText(Integer.toString(lon2col(MainClass.map
						.getListOfShips().get(nextShip).getLongitude())));
				cargoTypeField.setText(MainClass.map.getListOfShips()
						.get(nextShip).getCargoDescription());
				amountField.setText(Double.toString(MainClass.map
						.getListOfShips().get(nextShip).getCargoWeight()));
			}
		});

		JOptionPane
				.showMessageDialog(null, updateShipPanel, "Display Ships", 1);
	}

	/*
	 * Opens up a popup window which can be used to update the ships in the
	 * system.
	 */
	public void UpdateShip() {

		JPanel updateShipPanel = new JPanel();
		updateShipPanel.setLayout(new SpringLayout());

		ArrayList<String> shipNames = new ArrayList<>();
		for (int i = 0; i < MainClass.map.getListOfShips().size(); i++) {
			shipNames.add(MainClass.map.getListOfShips().get(i).getName());
		}
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final JComboBox shipList = new JComboBox(shipNames.toArray());

		String shipTypes[] = { "Cargo Ship", "Container Ship", "Tanker Ship" };

		int numPairs = 15; // number of fields

		JLabel labelSelect = new JLabel("Select Ship: ", JLabel.TRAILING);
		updateShipPanel.add(labelSelect);
		updateShipPanel.add(shipList);
		labelSelect.setLabelFor(shipList);
		updateShipPanel.add(shipList);

		JLabel labelName = new JLabel("Name :", JLabel.TRAILING);
		updateShipPanel.add(labelName);
		JTextField nameField = new JTextField(10);
		labelName.setLabelFor(nameField);
		updateShipPanel.add(nameField);

		JLabel labelShipType = new JLabel("Ship Type :", JLabel.TRAILING);
		updateShipPanel.add(labelShipType);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		final JComboBox shipTypeField = new JComboBox(shipTypes);
		labelShipType.setLabelFor(shipTypeField);
		updateShipPanel.add(shipTypeField);
		shipTypeField.setBackground(Color.WHITE);

		JLabel labelReg = new JLabel("Registration :", JLabel.TRAILING);
		updateShipPanel.add(labelReg);
		JTextField registrationField = new JTextField(10);
		labelReg.setLabelFor(registrationField);
		updateShipPanel.add(registrationField);

		JLabel labelTransponder = new JLabel("Transponder :", JLabel.TRAILING);
		updateShipPanel.add(labelTransponder);
		JTextField transponderField = new JTextField(10);
		labelTransponder.setLabelFor(transponderField);
		updateShipPanel.add(transponderField);

		JLabel labelCapacity = new JLabel("Capacity :", JLabel.TRAILING);
		updateShipPanel.add(labelCapacity);
		JTextField capacityField = new JTextField(10);
		labelCapacity.setLabelFor(capacityField);
		updateShipPanel.add(capacityField);

		JLabel labelLength = new JLabel("Length :", JLabel.TRAILING);
		updateShipPanel.add(labelLength);
		JTextField lengthField = new JTextField(10);
		labelLength.setLabelFor(lengthField);
		updateShipPanel.add(lengthField);

		JLabel labelBeam = new JLabel("Beam :", JLabel.TRAILING);
		updateShipPanel.add(labelBeam);
		JTextField beamField = new JTextField(10);
		labelBeam.setLabelFor(beamField);
		updateShipPanel.add(beamField);

		JLabel labelDraft = new JLabel("Draft :", JLabel.TRAILING);
		updateShipPanel.add(labelDraft);
		JTextField draftField = new JTextField(10);
		labelDraft.setLabelFor(draftField);
		updateShipPanel.add(draftField);

		JLabel labelLongitude = new JLabel("Longitude :", JLabel.TRAILING);
		updateShipPanel.add(labelLongitude);
		JTextField longitudeField = new JTextField(10);
		labelLongitude.setLabelFor(longitudeField);
		updateShipPanel.add(longitudeField);

		JLabel labelLatitude = new JLabel("Latitude :", JLabel.TRAILING);
		updateShipPanel.add(labelLatitude);
		JTextField latitudeField = new JTextField(10);
		labelLatitude.setLabelFor(latitudeField);
		updateShipPanel.add(latitudeField);

		JLabel labelRow = new JLabel("Row :", JLabel.TRAILING);
		updateShipPanel.add(labelRow);
		JTextField rowField = new JTextField(10);
		labelRow.setLabelFor(rowField);
		updateShipPanel.add(rowField);

		JLabel labelColumn = new JLabel("Column :", JLabel.TRAILING);
		updateShipPanel.add(labelColumn);
		JTextField columnField = new JTextField(10);
		labelColumn.setLabelFor(columnField);
		updateShipPanel.add(columnField);

		JLabel labelCargoType = new JLabel("Type of Cargo :", JLabel.TRAILING);
		updateShipPanel.add(labelCargoType);
		JTextField cargoTypeField = new JTextField(10);
		labelCargoType.setLabelFor(cargoTypeField);
		updateShipPanel.add(cargoTypeField);

		JLabel labelAmount = new JLabel("Amount of Cargo :", JLabel.TRAILING);
		updateShipPanel.add(labelAmount);
		JTextField amountField = new JTextField(10);
		labelAmount.setLabelFor(amountField);
		updateShipPanel.add(amountField);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(updateShipPanel, numPairs, 2, // rows,
																		// cols
				6, 6, // initX, initY
				6, 6); // xPad, yPad

		// Create and set up the window.
		JFrame frame = new JFrame("SpringForm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		updateShipPanel.setOpaque(true); // content panes must be opaque
		frame.setContentPane(updateShipPanel);

		shipTypeField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainClass.map
						.getListOfShips()
						.get(shipList.getSelectedIndex())
						.setTypeOfShip(
								shipTypeField.getSelectedItem().toString());
			}
		});

		int result = JOptionPane.showConfirmDialog(null, updateShipPanel,
				"Update Ship", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			if (!nameField.getText().isEmpty())
				MainClass.map.getListOfShips().get(shipList.getSelectedIndex())
						.setName(nameField.getText());
			if (!registrationField.getText().isEmpty())
				MainClass.map.getListOfShips().get(shipList.getSelectedIndex())
						.setOriginCountry(registrationField.getText());
			if (!transponderField.getText().isEmpty())
				MainClass.map
						.getListOfShips()
						.get(shipList.getSelectedIndex())
						.setTransponderNum(
								Long.parseLong(transponderField.getText()));
			if (!capacityField.getText().isEmpty())
				MainClass.map
						.getListOfShips()
						.get(shipList.getSelectedIndex())
						.setCargoCapacity(
								Double.parseDouble(capacityField.getText()));
			if (!lengthField.getText().isEmpty())
				MainClass.map.getListOfShips().get(shipList.getSelectedIndex())
						.setLength(Double.parseDouble(lengthField.getText()));
			if (!beamField.getText().isEmpty())
				MainClass.map.getListOfShips().get(shipList.getSelectedIndex())
						.setBeam(Double.parseDouble(beamField.getText()));
			if (!draftField.getText().isEmpty())
				MainClass.map.getListOfShips().get(shipList.getSelectedIndex())
						.setDraft(Double.parseDouble(draftField.getText()));
			if (!longitudeField.getText().isEmpty())
				MainClass.map
						.getListOfShips()
						.get(shipList.getSelectedIndex())
						.setLongitude(
								Double.parseDouble(longitudeField.getText()));
			if (!latitudeField.getText().isEmpty())
				MainClass.map
						.getListOfShips()
						.get(shipList.getSelectedIndex())
						.setLatitude(
								Double.parseDouble(latitudeField.getText()));
			if (!rowField.getText().isEmpty())
				MainClass.map
						.getListOfShips()
						.get(shipList.getSelectedIndex())
						.setLatitude(
								row2lat(Integer.parseInt(rowField.getText())));
			if (!columnField.getText().isEmpty())
				MainClass.map
						.getListOfShips()
						.get(shipList.getSelectedIndex())
						.setLongitude(
								col2lon(Integer.parseInt(columnField.getText())));
			if (!cargoTypeField.getText().isEmpty())
				MainClass.map.getListOfShips().get(shipList.getSelectedIndex())
						.setCargoDescription(cargoTypeField.getText());
			if (!amountField.getText().isEmpty())
				MainClass.map
						.getListOfShips()
						.get(shipList.getSelectedIndex())
						.setCargoWeight(
								Double.parseDouble(amountField.getText()));
		}
	}

	/*
	 * Unloads any ship in the map that's in their perspective type of dock.
	 */
	public void unloadShip() {
		if (!MainClass.map.getListOfShips().isEmpty()
				&& !MainClass.port.getListOfDocks().isEmpty()) {

			ArrayList<Integer> indicesOfShipsInDock = new ArrayList<>();
			indicesOfShipsInDock.clear();

			for (int i = 0; i < MainClass.map.getListOfShips().size(); i++) {
				for (int j = 0; j < MainClass.port.getListOfDocks().size(); j++) {
					if (MainClass.map.getListOfShips().get(i).getCol() == MainClass.port
							.getListOfDocks().get(j).getCol()
							&& MainClass.map.getListOfShips().get(i).getRow() == MainClass.port
									.getListOfDocks().get(j).getRow()
							&& MainClass.map
									.getListOfShips()
									.get(i)
									.shipFitsInDock(
											MainClass.port.getListOfDocks()
													.get(j))
							&& MainClass.map.getListOfShips().get(i).getCargo() != null) {

						indicesOfShipsInDock.add(i);
					}
				}
			}

			if (indicesOfShipsInDock.size() > 0) {
				JPanel unloadShipPanel = new JPanel();

				unloadShipPanel.setLayout(new SpringLayout());
				ArrayList<String> shipNames = new ArrayList<>();

				for (int i = 0; i < indicesOfShipsInDock.size(); i++) {
					String shipName;
					int shipIndice = indicesOfShipsInDock.get(i);
					shipName = MainClass.map.getListOfShips().get(shipIndice)
							.getName();

					shipNames.add(shipName);

				}
				@SuppressWarnings({ "unchecked", "rawtypes" })
				JComboBox shipList = new JComboBox(shipNames.toArray());

				int numberOfInputFields = 0;

				unloadShipPanel.add(shipList);

				// Lay out the panel.

				SpringUtilities.makeCompactGrid(unloadShipPanel,
						numberOfInputFields, 2, 10, 10, 10, 10);

				// Create and set up the window.
				JFrame frame = new JFrame("SpringForm");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				// Set up the content pane.
				unloadShipPanel.setOpaque(true); // content panes must be opaque
				frame.setContentPane(unloadShipPanel);

				int result = JOptionPane.showConfirmDialog(null,
						unloadShipPanel, "Unload Ship",
						JOptionPane.OK_CANCEL_OPTION);

				if (result == JOptionPane.OK_OPTION) {
					int shipIndice = shipList.getSelectedIndex();
					if (MainClass.map.getListOfShips().get(shipIndice)
							.getCargo() != null) {
						Cargo tempCargo = MainClass.map.getListOfShips()
								.get(shipIndice).getCargo();
						MainClass.port.getListOfCargos().add(tempCargo);
						MainClass.map.getListOfShips().get(shipIndice)
								.setCargo(null);
						messageBox.append("\nShip unloaded");
					}

				}

			} else {
				JOptionPane.showMessageDialog(this,
						"No ships in the docks have cargo to unload.");
			}
		}

		else {
			if (MainClass.map.getListOfShips().isEmpty())
				JOptionPane.showMessageDialog(this, "No ships on map");
			else
				JOptionPane.showMessageDialog(this,
						"No ships in the dock to unload.");

		}
	}

	/*
	 * Displays all of the docks in the port out to the console.
	 */
	public void DisplayDocksInConsole() {
		MainClass.port.displayDocks();
	}

	/*
	 * Displays all of the docks in the port out to a popup window.
	 */
	public void DisplayDocks() {

		final DecimalFormat df = new DecimalFormat("##.######");

		final JPanel updateShipPanel = new JPanel();
		updateShipPanel.setLayout(new SpringLayout());
		updateShipPanel.update(null);

		int numPairs = 12; // number of fields

		final int numberOfDocks = MainClass.port.getListOfDocks().size();

		JLabel labelShipNumber = new JLabel("Dock :", JLabel.TRAILING);
		updateShipPanel.add(labelShipNumber);
		final JTextField numberField = new JTextField("1 of " + numberOfDocks);
		numberField.setEditable(false);
		labelShipNumber.setLabelFor(numberField);
		updateShipPanel.add(numberField);

		JLabel labelName = new JLabel("Name :", JLabel.TRAILING);
		updateShipPanel.add(labelName);
		final JTextField nameField = new JTextField(MainClass.port
				.getListOfDocks().get(0).getDockName());
		nameField.setEditable(false);
		labelName.setLabelFor(nameField);
		updateShipPanel.add(nameField);
		nameField.setColumns(15);

		JLabel labelShipType = new JLabel("Dock Symbol :", JLabel.TRAILING);
		updateShipPanel.add(labelShipType);
		final JTextField dockTypeField = new JTextField(
				Character.toString(MainClass.port.getListOfDocks().get(0)
						.getDockSymbol()));
		dockTypeField.setEditable(false);
		labelShipType.setLabelFor(dockTypeField);
		updateShipPanel.add(dockTypeField);

		JLabel labelReg = new JLabel("Dock Number :", JLabel.TRAILING);
		updateShipPanel.add(labelReg);
		final JTextField dockNumberField = new JTextField(
				Integer.toString(MainClass.port.getListOfDocks().get(0)
						.getDockNumber()));
		dockNumberField.setEditable(false);
		labelReg.setLabelFor(dockNumberField);
		updateShipPanel.add(dockNumberField);

		JLabel labelLength = new JLabel("Length :", JLabel.TRAILING);
		updateShipPanel.add(labelLength);
		final JTextField lengthField = new JTextField(
				Double.toString(MainClass.port.getListOfDocks().get(0)
						.getDockLength()));
		lengthField.setEditable(false);
		labelLength.setLabelFor(lengthField);
		updateShipPanel.add(lengthField);

		JLabel labelBeam = new JLabel("Beam :", JLabel.TRAILING);
		updateShipPanel.add(labelBeam);
		final JTextField beamField = new JTextField(
				Double.toString(MainClass.port.getListOfDocks().get(0)
						.getDockBeam()));
		beamField.setEditable(false);
		labelBeam.setLabelFor(beamField);
		updateShipPanel.add(beamField);

		JLabel labelDraft = new JLabel("Draft :", JLabel.TRAILING);
		updateShipPanel.add(labelDraft);
		final JTextField draftField = new JTextField(
				Double.toString(MainClass.port.getListOfDocks().get(0)
						.getDockDraft()));
		draftField.setEditable(false);
		labelDraft.setLabelFor(draftField);
		updateShipPanel.add(draftField);

		JLabel labelLongitude = new JLabel("Longitude :", JLabel.TRAILING);
		updateShipPanel.add(labelLongitude);
		final JTextField longitudeField = new JTextField(
				df.format(MainClass.port.getListOfDocks().get(0)
						.getDockLongitude()));
		longitudeField.setEditable(false);
		labelLongitude.setLabelFor(longitudeField);
		updateShipPanel.add(longitudeField);

		JLabel labelLatitude = new JLabel("Latitude :", JLabel.TRAILING);
		updateShipPanel.add(labelLatitude);
		final JTextField latitudeField = new JTextField(
				df.format(MainClass.port.getListOfDocks().get(0)
						.getDockLatitude()));
		latitudeField.setEditable(false);
		labelLatitude.setLabelFor(latitudeField);
		updateShipPanel.add(latitudeField);

		JLabel labelRow = new JLabel("Row :", JLabel.TRAILING);
		updateShipPanel.add(labelRow);
		final JTextField rowField = new JTextField(
				Integer.toString(lat2row(MainClass.port.getListOfDocks().get(0)
						.getDockLatitude())));
		rowField.setEditable(false);
		labelRow.setLabelFor(rowField);
		updateShipPanel.add(rowField);

		JLabel labelColumn = new JLabel("Column :", JLabel.TRAILING);
		updateShipPanel.add(labelColumn);
		final JTextField columnField = new JTextField(
				Integer.toString(lon2col(MainClass.port.getListOfDocks().get(0)
						.getDockLongitude())));
		columnField.setEditable(false);
		labelColumn.setLabelFor(columnField);
		updateShipPanel.add(columnField);

		JButton previousButton = new JButton("Previous Dock");
		JButton nextButton = new JButton("Next Dock");
		previousButton.setSize(nextButton.getSize());

		updateShipPanel.add(previousButton);
		updateShipPanel.add(nextButton);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(updateShipPanel, numPairs, 2, // rows,
																		// cols
				6, 6, // initX, initY
				6, 6); // xPad, yPad

		// Create and set up the window.
		JFrame frame = new JFrame("SpringForm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		updateShipPanel.setOpaque(true); // content panes must be opaque
		frame.setContentPane(updateShipPanel);

		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nextDock == numberOfDocks - 1) {
					nextDock = 0;
				} else {
					nextDock++;
				}

				numberField.setText((nextDock + 1) + " of " + numberOfDocks);
				nameField.setText(MainClass.port.getListOfDocks().get(nextDock)
						.getDockName());
				dockTypeField.setText(Character.toString(MainClass.port
						.getListOfDocks().get(nextDock).getDockSymbol()));
				dockNumberField.setText(Integer.toString(MainClass.port
						.getListOfDocks().get(nextDock).getDockNumber()));
				lengthField.setText(Double.toString(MainClass.port
						.getListOfDocks().get(nextDock).getDockLength()));
				beamField.setText(Double.toString(MainClass.port
						.getListOfDocks().get(nextDock).getDockBeam()));
				draftField.setText(Double.toString(MainClass.port
						.getListOfDocks().get(nextDock).getDockDraft()));
				longitudeField.setText(df.format(MainClass.port
						.getListOfDocks().get(nextDock).getDockLongitude()));
				latitudeField.setText(df.format(MainClass.port.getListOfDocks()
						.get(nextDock).getDockLatitude()));
				rowField.setText(Integer.toString(lat2row(MainClass.port
						.getListOfDocks().get(nextDock).getDockLatitude())));
				columnField.setText(Integer.toString(lon2col(MainClass.port
						.getListOfDocks().get(nextDock).getDockLongitude())));
			}
		});

		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nextDock == 0) {
					nextDock = numberOfDocks - 1;
				} else {
					nextDock--;
				}

				numberField.setText((nextDock + 1) + " of " + numberOfDocks);
				nameField.setText(MainClass.port.getListOfDocks().get(nextDock)
						.getDockName());
				dockTypeField.setText(Character.toString(MainClass.port
						.getListOfDocks().get(nextDock).getDockSymbol()));
				dockNumberField.setText(Integer.toString(MainClass.port
						.getListOfDocks().get(nextDock).getDockNumber()));
				lengthField.setText(Double.toString(MainClass.port
						.getListOfDocks().get(nextDock).getDockLength()));
				beamField.setText(Double.toString(MainClass.port
						.getListOfDocks().get(nextDock).getDockBeam()));
				draftField.setText(Double.toString(MainClass.port
						.getListOfDocks().get(nextDock).getDockDraft()));
				longitudeField.setText(df.format(MainClass.port
						.getListOfDocks().get(nextDock).getDockLongitude()));
				latitudeField.setText(df.format(MainClass.port.getListOfDocks()
						.get(nextDock).getDockLatitude()));
				rowField.setText(Integer.toString(lat2row(MainClass.port
						.getListOfDocks().get(nextDock).getDockLatitude())));
				columnField.setText(Integer.toString(lon2col(MainClass.port
						.getListOfDocks().get(nextDock).getDockLongitude())));
			}
		});

		JOptionPane
				.showMessageDialog(null, updateShipPanel, "Display Docks", 1);
	}

	/*
	 * Opens up a window that allows the user to update any of the docks in the
	 * map.
	 */
	public void UpdateDock() {

		JPanel updateDockPanel = new JPanel();
		updateDockPanel.setLayout(new SpringLayout());

		ArrayList<String> dockNames = new ArrayList<>();
		for (int i = 0; i < MainClass.port.getListOfDocks().size(); i++) {
			dockNames.add(MainClass.port.getListOfDocks().get(i).getDockName());
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		final JComboBox dockList = new JComboBox(dockNames.toArray());

		String dockTypes[] = { "Crane", "Dock", "Pier" };
		final Character dockSymbols[] = { 'C', 'D', 'P' };

		int numPairs = 10;

		JLabel labelSelect = new JLabel("Select Dock: ", JLabel.TRAILING);
		updateDockPanel.add(labelSelect);
		updateDockPanel.add(dockList);
		labelSelect.setLabelFor(dockList);
		updateDockPanel.add(dockList);

		JLabel labelName = new JLabel("Name :", JLabel.TRAILING);
		updateDockPanel.add(labelName);
		JTextField nameField = new JTextField(10);
		labelName.setLabelFor(nameField);
		updateDockPanel.add(nameField);

		JLabel labelShipType = new JLabel("Dock Type :", JLabel.TRAILING);
		updateDockPanel.add(labelShipType);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final JComboBox dockTypeField = new JComboBox(dockTypes);
		labelShipType.setLabelFor(dockTypeField);
		updateDockPanel.add(dockTypeField);
		dockTypeField.setBackground(Color.WHITE);

		JLabel labelSection = new JLabel("Section :", JLabel.TRAILING);
		updateDockPanel.add(labelSection);
		JTextField sectionField = new JTextField(10);
		labelSection.setLabelFor(sectionField);
		updateDockPanel.add(sectionField);

		JLabel labelNumber = new JLabel("Number :", JLabel.TRAILING);
		updateDockPanel.add(labelNumber);
		JTextField numberField = new JTextField(10);
		labelNumber.setLabelFor(numberField);
		updateDockPanel.add(numberField);

		JLabel labelLength = new JLabel("Length :", JLabel.TRAILING);
		updateDockPanel.add(labelLength);
		JTextField lengthField = new JTextField(10);
		labelLength.setLabelFor(lengthField);
		updateDockPanel.add(lengthField);

		JLabel labelBeam = new JLabel("Beam :", JLabel.TRAILING);
		updateDockPanel.add(labelBeam);
		JTextField beamField = new JTextField(10);
		labelBeam.setLabelFor(beamField);
		updateDockPanel.add(beamField);

		JLabel labelDraft = new JLabel("Draft :", JLabel.TRAILING);
		updateDockPanel.add(labelDraft);
		JTextField draftField = new JTextField(10);
		labelDraft.setLabelFor(draftField);
		updateDockPanel.add(draftField);

		JLabel labelLongitude = new JLabel("Longitude :", JLabel.TRAILING);
		updateDockPanel.add(labelLongitude);
		JTextField longitudeField = new JTextField(10);
		labelLongitude.setLabelFor(longitudeField);
		updateDockPanel.add(longitudeField);

		JLabel labelLatitude = new JLabel("Latitude :", JLabel.TRAILING);
		updateDockPanel.add(labelLatitude);
		JTextField latitudeField = new JTextField(10);
		labelLatitude.setLabelFor(latitudeField);
		updateDockPanel.add(latitudeField);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(updateDockPanel, numPairs, 2, // rows,
																		// cols
				6, 6, // initX, initY
				6, 6); // xPad, yPad

		// Create and set up the window.
		JFrame frame = new JFrame("SpringForm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		updateDockPanel.setOpaque(true); // content panes must be opaque
		frame.setContentPane(updateDockPanel);

		dockTypeField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainClass.port
						.getListOfDocks()
						.get(dockList.getSelectedIndex())
						.setDockSymbol(
								dockSymbols[dockTypeField.getSelectedIndex()]);
			}
		});

		int result = JOptionPane.showConfirmDialog(null, updateDockPanel,
				"Update Dock", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			if (!nameField.getText().isEmpty())
				MainClass.port.getListOfDocks()
						.get(dockList.getSelectedIndex())
						.setDockName(nameField.getText());
			if (!sectionField.getText().isEmpty())
				MainClass.port.getListOfDocks()
						.get(dockList.getSelectedIndex())
						.setDockSection(nameField.getText().charAt(0));
			if (!numberField.getText().isEmpty())
				MainClass.port.getListOfDocks()
						.get(dockList.getSelectedIndex())
						.setDockNumber(Integer.parseInt(nameField.getText()));
			if (!lengthField.getText().isEmpty())
				MainClass.port.getListOfDocks()
						.get(dockList.getSelectedIndex())
						.setDockLength(Double.parseDouble(nameField.getText()));
			if (!beamField.getText().isEmpty())
				MainClass.port.getListOfDocks()
						.get(dockList.getSelectedIndex())
						.setDockBeam(Double.parseDouble(nameField.getText()));
			if (!draftField.getText().isEmpty())
				MainClass.port.getListOfDocks()
						.get(dockList.getSelectedIndex())
						.setDockDraft(Double.parseDouble(nameField.getText()));
			if (!longitudeField.getText().isEmpty())
				MainClass.port
						.getListOfDocks()
						.get(dockList.getSelectedIndex())
						.setDockLongitude(
								Double.parseDouble(nameField.getText()));
			if (!latitudeField.getText().isEmpty())
				MainClass.port
						.getListOfDocks()
						.get(dockList.getSelectedIndex())
						.setDockLatitude(
								Double.parseDouble(nameField.getText()));
		}
	}

	/*
	 * Generates monster through the GUI, and uses the generateMonstersV2(int
	 * numberOfMonsters) from the main class.
	 */
	public void GenerateMonsters() {
		try {
			String returnString = JOptionPane.showInputDialog(this,
					"Enter number of monster to create ");
			int numberOfMonsters = Integer.parseInt(returnString);
			MainClass.generateMonstersV2(numberOfMonsters);
			if (numberOfMonsters > 0) {
				messageBox.append(numberOfMonsters
						+ " monsters randomly created\n");
				soundFX.playMonstersCreated();
			}
		} catch (FileNotFoundException | NumberFormatException
				| InputMismatchException ex) {
		}
	}

	/*
	 * Displays all of the monsters in the system out in a popup window.
	 */
	public void DisplayMonsters() {

		final DecimalFormat df = new DecimalFormat("##.######");

		final JPanel displayMonsterPanel = new JPanel();
		displayMonsterPanel.setLayout(new SpringLayout());
		displayMonsterPanel.update(null);

		int numPairs = 8; // number of fields

		final int numberOfMonsteres = MainClass.map.getMonsterList().size();

		JLabel labelShipNumber = new JLabel("Monster :", JLabel.TRAILING);
		displayMonsterPanel.add(labelShipNumber);
		final JTextField numberField = new JTextField("1 of "
				+ numberOfMonsteres);
		numberField.setEditable(false);
		labelShipNumber.setLabelFor(numberField);
		displayMonsterPanel.add(numberField);

		JLabel labelName = new JLabel("Name :", JLabel.TRAILING);
		displayMonsterPanel.add(labelName);
		final JTextField nameField = new JTextField(MainClass.map
				.getMonsterList().get(0).getLabel());
		nameField.setEditable(false);
		labelName.setLabelFor(nameField);
		displayMonsterPanel.add(nameField);
		nameField.setColumns(10);

		JLabel labelMonsterType = new JLabel("Monster Symbol :",
				JLabel.TRAILING);
		displayMonsterPanel.add(labelMonsterType);
		final JTextField monsterTypeField = new JTextField(
				Character.toString(MainClass.map.getMonsterList().get(0)
						.getMonsterSymbol()));
		monsterTypeField.setEditable(false);
		labelMonsterType.setLabelFor(monsterTypeField);
		displayMonsterPanel.add(monsterTypeField);

		JLabel labelLongitude = new JLabel("Longitude :", JLabel.TRAILING);
		displayMonsterPanel.add(labelLongitude);
		final JTextField longitudeField = new JTextField(
				df.format(MainClass.map.getMonsterList().get(0).position
						.getLongitudePosition()));
		longitudeField.setEditable(false);
		labelLongitude.setLabelFor(longitudeField);
		displayMonsterPanel.add(longitudeField);

		JLabel labelLatitude = new JLabel("Latitude :", JLabel.TRAILING);
		displayMonsterPanel.add(labelLatitude);
		final JTextField latitudeField = new JTextField(df.format(MainClass.map
				.getMonsterList().get(0).position.getLatitudePosition()));
		latitudeField.setEditable(false);
		labelLatitude.setLabelFor(latitudeField);
		displayMonsterPanel.add(latitudeField);

		JLabel labelRow = new JLabel("Row :", JLabel.TRAILING);
		displayMonsterPanel.add(labelRow);
		final JTextField rowField = new JTextField(
				Integer.toString(MainClass.map.getMonsterList().get(0).position
						.getRowPosition()));
		rowField.setEditable(false);
		labelRow.setLabelFor(rowField);
		displayMonsterPanel.add(rowField);

		JLabel labelColumn = new JLabel("Column :", JLabel.TRAILING);
		displayMonsterPanel.add(labelColumn);
		final JTextField columnField = new JTextField(
				Integer.toString(MainClass.map.getMonsterList().get(0).position
						.getColumnPosition()));
		columnField.setEditable(false);
		labelColumn.setLabelFor(columnField);
		displayMonsterPanel.add(columnField);

		JButton previousButton = new JButton("Previous Monster");
		JButton nextButton = new JButton("Next Monster");
		previousButton.setSize(nextButton.getSize());

		displayMonsterPanel.add(previousButton);
		displayMonsterPanel.add(nextButton);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(displayMonsterPanel, numPairs, 2, // rows,
																			// cols
				6, 6, // initX, initY
				6, 6); // xPad, yPad

		// Create and set up the window.
		JFrame frame = new JFrame("SpringForm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		displayMonsterPanel.setOpaque(true); // content panes must be opaque
		frame.setContentPane(displayMonsterPanel);

		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nextMonster == numberOfMonsteres - 1) {
					nextMonster = 0;
				} else {
					nextMonster++;
				}

				numberField.setText((nextMonster + 1) + " of "
						+ numberOfMonsteres);
				nameField.setText(MainClass.map.getMonsterList()
						.get(nextMonster).getLabel());
				monsterTypeField.setText(Character.toString(MainClass.map
						.getMonsterList().get(nextMonster).getMonsterSymbol()));
				longitudeField.setText(df.format(MainClass.map.getMonsterList()
						.get(nextMonster).position.getLongitudePosition()));
				latitudeField.setText(df.format(MainClass.map.getMonsterList()
						.get(nextMonster).position.getLatitudePosition()));
				rowField.setText(Integer.toString(lat2row(MainClass.map
						.getMonsterList().get(nextMonster).position
						.getLatitudePosition())));
				columnField.setText(Integer.toString(lon2col(MainClass.map
						.getMonsterList().get(nextMonster).position
						.getLongitudePosition())));
			}
		});

		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nextMonster == 0) {
					nextMonster = numberOfMonsteres - 1;
				} else {
					nextMonster--;
				}

				numberField.setText((nextMonster + 1) + " of "
						+ numberOfMonsteres);
				nameField.setText(MainClass.map.getMonsterList()
						.get(nextMonster).getLabel());
				monsterTypeField.setText(Character.toString(MainClass.map
						.getMonsterList().get(nextMonster).getMonsterSymbol()));
				longitudeField.setText(df.format(MainClass.map.getMonsterList()
						.get(nextMonster).position.getLongitudePosition()));
				latitudeField.setText(df.format(MainClass.map.getMonsterList()
						.get(nextMonster).position.getLatitudePosition()));
				rowField.setText(Integer.toString(MainClass.map
						.getMonsterList().get(nextMonster).position
						.getRowPosition()));
				columnField.setText(Integer.toString(MainClass.map
						.getMonsterList().get(nextMonster).position
						.getColumnPosition()));
			}
		});

		JOptionPane.showMessageDialog(null, displayMonsterPanel,
				"Display Monsters", 1);
	}

	/*
	 * Displays all of the monsters in the system out in the GUI console.
	 */
	public void DisplayMonstersInConsole() {
		MainClass.map.displayMonsters();
	}

	/*
	 * Displays a popup window that is used to update any of the monster's
	 * attributes.
	 */
	public void UpdateMonster() {
		JPanel updateMonsterPanel = new JPanel();
		updateMonsterPanel.setLayout(new SpringLayout());

		ArrayList<String> monsterNames = new ArrayList<>();
		for (int i = 0; i < MainClass.map.getMonsterList().size(); i++) {
			monsterNames.add(MainClass.map.getMonsterList().get(i).getLabel());
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox monsterList = new JComboBox(monsterNames.toArray());

		int numPairs = 6; // number of fields

		JLabel labelSelect = new JLabel("Select Monster: ", JLabel.TRAILING);
		updateMonsterPanel.add(labelSelect);
		updateMonsterPanel.add(monsterList);
		labelSelect.setLabelFor(monsterList);
		updateMonsterPanel.add(monsterList);

		JLabel labelName = new JLabel("Name :", JLabel.TRAILING);
		updateMonsterPanel.add(labelName);
		JTextField nameField = new JTextField(10);
		labelName.setLabelFor(nameField);
		updateMonsterPanel.add(nameField);

		JLabel labelLong = new JLabel("Longitude :", JLabel.TRAILING);
		updateMonsterPanel.add(labelLong);
		JTextField longitudeField = new JTextField(10);
		labelLong.setLabelFor(longitudeField);
		updateMonsterPanel.add(longitudeField);

		JLabel labelLat = new JLabel("Latitude :", JLabel.TRAILING);
		updateMonsterPanel.add(labelLat);
		JTextField latitudeField = new JTextField(10);
		labelLat.setLabelFor(latitudeField);
		updateMonsterPanel.add(latitudeField);

		JLabel labelRow = new JLabel("Row :", JLabel.TRAILING);
		updateMonsterPanel.add(labelRow);
		JTextField rowField = new JTextField(10);
		labelRow.setLabelFor(rowField);
		updateMonsterPanel.add(rowField);

		JLabel labelCol = new JLabel("Column :", JLabel.TRAILING);
		updateMonsterPanel.add(labelCol);
		JTextField columnField = new JTextField(10);
		labelCol.setLabelFor(columnField);
		updateMonsterPanel.add(columnField);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(updateMonsterPanel, numPairs, 2, // rows,
																			// cols
				6, 6, // initX, initY
				6, 6); // xPad, yPad

		// Create and set up the window.
		JFrame frame = new JFrame("SpringForm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		updateMonsterPanel.setOpaque(true); // content panes must be opaque
		frame.setContentPane(updateMonsterPanel);

		int result = JOptionPane.showConfirmDialog(null, updateMonsterPanel,
				"Update Monster", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			if (!nameField.getText().isEmpty())
				MainClass.map.getMonsterList()
						.get(monsterList.getSelectedIndex())
						.setLabel(nameField.getText());
			if (!longitudeField.getText().isEmpty())
				MainClass.map.getMonsterList().get(
						monsterList.getSelectedIndex()).position
						.setLongitudePosition(Double.parseDouble(longitudeField
								.getText()));
			if (!latitudeField.getText().isEmpty())
				MainClass.map.getMonsterList().get(
						monsterList.getSelectedIndex()).position
						.setLatitudePosition(Double.parseDouble(latitudeField
								.getText()));
			if (!rowField.getText().isEmpty())
				MainClass.map.getMonsterList().get(
						monsterList.getSelectedIndex()).position
						.setRowPosition(Integer.parseInt(rowField.getText()));
			if (!columnField.getText().isEmpty())
				MainClass.map.getMonsterList().get(
						monsterList.getSelectedIndex()).position
						.setColumnPosition(Integer.parseInt(columnField
								.getText()));
		}
	}

	/*
	 * Summons godzilla.
	 */
	public void SummonGodzilla() {
		int godzillaCount = 0;
		for (int i = 0; i < MainClass.map.getMonsterList().size(); i++) {
			if (MainClass.map.getMonsterList().get(i).getLabel() == "Godzilla") {
				godzillaCount++;
				messageBox.append("Godzilla already Exists\n");
				break;
			}
		}

		if (godzillaCount == 0) {
			SeaMonster tempGodzilla = new Godzilla();
			MainClass.map.getMonsterList().add(tempGodzilla);
			soundFX.playGodzilla();
			messageBox.append("Godzilla Summoned\n");
		}
	}

	/*
	 * Finds a ship based on its row and column position.
	 */
	public CargoShip findShip(int x, int y) {
		for (int count = 0; count < MainClass.map.getListOfShips().size(); count++) {
			if (MainClass.map.getListOfShips().get(count).getCol() == x
					&& MainClass.map.getListOfShips().get(count).getRow() == y) {
				picked = true;
				tempShip = MainClass.map.getListOfShips().get(count);
			}
		}
		return null;
	}

	/*
	 * Finds a monster based on its row and column position.
	 */
	public void findMonster(int x, int y) {
		for (int count = 0; count < MainClass.map.getMonsterList().size(); count++) {
			if (MainClass.map.getMonsterList().get(count).position
					.getColumnPosition() == x
					&& MainClass.map.getMonsterList().get(count).position
							.getRowPosition() == y) {
				picked = true;
				tempMonster = MainClass.map.getMonsterList().get(count);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent
	 * )
	 * 
	 * This is the listener for the actions of the mouse, which will be used to
	 * drag and drop any monster or ship in the map.
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		try {
			int x = e.getX() / 10;
			int y = (e.getY() / 10) - 5;

			if (picked == false) {
				char element;
				element = MainClass.map.mapRepresentation[y][x];
				if (element == 's' || element == 'K' || element == 'G'
						|| element == 'L' || element == 'X' || element == 'M')
					findMonster(x, y);
				if (element == 'S' || element == 'T' || element == 'B'
						|| element == 'X' || element == '$')
					findShip(x, y);
			}

			// moving Sea Monsters and kill ships on collision, can move just on
			// water
			else if (tempMonster != null && tempMonster.monsterSymbol != 'G'
					&& tempMonster.monsterSymbol != 'M' && x >= 0 && x <= 53
					&& y >= 0 && y <= 35
					&& MainClass.map.getMapRepresentation()[y][x] != '*'
					&& MainClass.map.getMapRepresentation()[y][x] != 'P'
					&& MainClass.map.getMapRepresentation()[y][x] != 'C'
					&& MainClass.map.getMapRepresentation()[y][x] != 'D') {
				tempMonster.position.setColumnPosition(x);
				tempMonster.position.setRowPosition(y);
				if (MainClass.map.getMapRepresentation()[y][x] == 'S'
						|| MainClass.map.getMapRepresentation()[y][x] == 'T'
						|| MainClass.map.getMapRepresentation()[y][x] == 'B') {
					for (int count = 0; count < MainClass.map.getListOfShips()
							.size(); count++) {
						if (MainClass.map.getListOfShips().get(count).getCol() == x
								&& MainClass.map.getListOfShips().get(count)
										.getRow() == y) {
							MainClass.map.getListOfShips().remove(count);
							tempMonster.battleCry();
							soundFX.playMonster();
						}
					}
				}

				// method to create Mothra, a seaserpent, kraken, and leviathan
				// have to be at the same position
				if (MainClass.map.getMapRepresentation()[y][x] == 's'
						|| MainClass.map.getMapRepresentation()[y][x] == 'K'
						|| MainClass.map.getMapRepresentation()[y][x] == 'L') {
					int leviathanCount = 0;
					int seaSerpentCount = 0;
					int krakenCount = 0;
					for (int count = 0; count < MainClass.map.getMonsterList()
							.size(); count++) {
						if (MainClass.map.getMonsterList().get(count).position
								.getColumnPosition() == x
								&& MainClass.map.getMonsterList().get(count).position
										.getRowPosition() == y
								&& MainClass.map.getMonsterList().get(count).monsterSymbol == 's') {
							seaSerpentCount++;
						}
						if (MainClass.map.getMonsterList().get(count).position
								.getColumnPosition() == x
								&& MainClass.map.getMonsterList().get(count).position
										.getRowPosition() == y
								&& MainClass.map.getMonsterList().get(count).monsterSymbol == 'K') {
							krakenCount++;
						}
						if (MainClass.map.getMonsterList().get(count).position
								.getColumnPosition() == x
								&& MainClass.map.getMonsterList().get(count).position
										.getRowPosition() == y
								&& MainClass.map.getMonsterList().get(count).monsterSymbol == 'L') {
							leviathanCount++;
						}
					}
					if (leviathanCount > 0 && seaSerpentCount > 0
							&& krakenCount > 0) {
						for (int count = 0; count < MainClass.map
								.getMonsterList().size(); count++) {
							for (int i = 0; i < 3; i++) { // used to go over
															// each montser at
															// mouse (x,y)
															// position
								if (MainClass.map.getMonsterList().get(count).position
										.getColumnPosition() == x
										&& MainClass.map.getMonsterList().get(
												count).position
												.getRowPosition() == y
										&& (MainClass.map.getMonsterList().get(
												count).monsterSymbol == 's'
												|| MainClass.map
														.getMonsterList().get(
																count).monsterSymbol == 'L' || MainClass.map
												.getMonsterList().get(count).monsterSymbol == 'K')) {
									MainClass.map.getMonsterList()
											.remove(count);
								}
							}
						}
						tempMonster = new Mothra();
						tempMonster.position.setColumnPosition(x);
						tempMonster.position.setRowPosition(y);
						MainClass.map.getMonsterList().add(tempMonster);
						tempMonster.battleCry();
						soundFX.playMothra();
					}
				}
			}

			// moving godzilla and killing monsters on impact, can move
			// everywhere
			else if (tempMonster != null && tempMonster.monsterSymbol == 'G'
					&& x >= 0 && x <= 53 && y >= 0 && y <= 35) {
				tempMonster.position.setColumnPosition(x);
				tempMonster.position.setRowPosition(y);
				if (tempMonster.monsterSymbol == 'G'
						&& x >= 0
						&& x <= 53
						&& y >= 0
						&& y <= 35
						&& (MainClass.map.getMapRepresentation()[y][x] == 's'
								|| MainClass.map.getMapRepresentation()[y][x] == 'L'
								|| MainClass.map.getMapRepresentation()[y][x] == 'K' || MainClass.map
								.getMapRepresentation()[y][x] == 'M')) {
					for (int count = 0; count < MainClass.map.getMonsterList()
							.size(); count++) {
						if (MainClass.map.getMonsterList().get(count).position
								.getColumnPosition() == x
								&& MainClass.map.getMonsterList().get(count).position
										.getRowPosition() == y
								&& MainClass.map.getMonsterList().get(count).monsterSymbol != 'G') {
							MainClass.map.getMonsterList().remove(count);
							tempMonster.battleCry();
							soundFX.playGodzillaKill();
						}
					}
				}
				map.repaint();
				map.validate();
			}

			// moving mothra around map, will kill ships and chance of killing
			// godzilla
			else if (tempMonster != null && tempMonster.monsterSymbol == 'M'
					&& x >= 0 && x <= 53 && y >= 0 && y <= 35) {
				tempMonster.position.setColumnPosition(x);
				tempMonster.position.setRowPosition(y);
				if (MainClass.map.getMapRepresentation()[y][x] == 'S'
						|| MainClass.map.getMapRepresentation()[y][x] == 'T'
						|| MainClass.map.getMapRepresentation()[y][x] == 'B') {
					for (int count = 0; count < MainClass.map.getListOfShips()
							.size(); count++) {
						if (MainClass.map.getListOfShips().get(count).getCol() == x
								&& MainClass.map.getListOfShips().get(count)
										.getRow() == y) {
							MainClass.map.getListOfShips().remove(count);
							tempMonster.battleCry();
							soundFX.playMothra();
						}
					}
				} else if (MainClass.map.getMapRepresentation()[y][x] == 'G') {
					for (int count = 0; count < MainClass.map.getMonsterList()
							.size(); count++) {
						if (MainClass.map.getMonsterList().get(count) instanceof Godzilla) {
							MainClass.map.getMonsterList().remove(count);
							tempMonster.battleCry();
							soundFX.playMothra();
						}
					}
				}
				map.repaint();
				map.validate();
			}

			// moving ships around map, can only move on water and to docks
			else if ((tempShip != null && x >= 0 && x <= 53 && y >= 0 && y <= 35)
					&& MainClass.map.getMapRepresentation()[y][x] != '*'
					&& MainClass.map.getMapRepresentation()[y][x] != '$') {
				tempShip.setLongitude(col2lon(x));
				tempShip.setLatitude(row2lat(y));

				map.repaint();
				map.validate();
			}
		} catch (ArrayIndexOutOfBoundsException ex) {

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 * 
	 * This method resets the possible mouse selections to null.
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		picked = false;
		tempMonster = null;
		tempShip = null;
	}
}