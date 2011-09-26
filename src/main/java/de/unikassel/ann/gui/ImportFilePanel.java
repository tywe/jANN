package de.unikassel.ann.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import de.unikassel.ann.config.NetConfig;
import de.unikassel.ann.controller.GraphController;
import de.unikassel.ann.controller.Settings;
import de.unikassel.ann.io.NetIO;

public class ImportFilePanel extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel searchFilePanel;

	private JCheckBox topologieCB;
	private JCheckBox synapseCB;
	private JCheckBox trainigDataCB;

	private JFileChooser fileopen;

	private JTextArea textAreaFileName;

	/**
	 * Create the panel.
	 */
	public ImportFilePanel() {

		searchFilePanel = new JPanel();
		searchFilePanel.setLayout(new BorderLayout());

		setTitle("Import");
		setSize(250, 210);
		setLocationRelativeTo(null);
		setModal(true);
		setResizable(false);

		JPanel importDialogPanel = new JPanel();

		JLabel lblImportFile = new JLabel("File Importieren");
		JButton btnSearch = new JButton();
		btnSearch.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("img/search-icon.png")));

		//
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				openFileChooser();
			}

		});

		JLabel lblTopology = new JLabel("Topologie");
		topologieCB = new JCheckBox("");
		JLabel lblSynapse = new JLabel("Synapse");
		synapseCB = new JCheckBox("");
		JLabel lblTrainingData = new JLabel("Training Data");
		trainigDataCB = new JCheckBox("");
		JButton btnImport = new JButton("Import");
		// TODO Nach Import JungView Aktualisieren
		JButton btnCancel = new JButton("Abbrechen");

		btnImport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				File file = fileopen.getSelectedFile();
				NetIO reader = new NetIO();
				try {
					reader.readConfigFile(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				NetConfig netConfig = reader.generateNetwork();
				Settings.getInstance().createNewSession(file.getName());
				Settings.getInstance().getCurrentSession().setNetworkConfig(netConfig);
				GraphController.getInstance().renderNetwork(netConfig.getNetwork());
				dispose();
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				dispose();
			}
		});

		textAreaFileName = new JTextArea();

		GroupLayout gl_importDialogPanel = new GroupLayout(importDialogPanel);
		gl_importDialogPanel.setHorizontalGroup(gl_importDialogPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_importDialogPanel
								.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_importDialogPanel
												.createParallelGroup(Alignment.TRAILING)
												.addGroup(
														gl_importDialogPanel.createSequentialGroup().addComponent(btnImport)
																.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
																.addComponent(btnCancel).addContainerGap())
												.addGroup(
														gl_importDialogPanel
																.createSequentialGroup()
																.addComponent(lblImportFile)
																.addGap(29)
																.addComponent(textAreaFileName, GroupLayout.DEFAULT_SIZE, 67,
																		Short.MAX_VALUE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 35,
																		GroupLayout.PREFERRED_SIZE).addGap(15))
												.addGroup(
														gl_importDialogPanel
																.createSequentialGroup()
																.addGroup(
																		gl_importDialogPanel
																				.createParallelGroup(Alignment.LEADING)
																				.addGroup(
																						gl_importDialogPanel
																								.createSequentialGroup()
																								.addComponent(lblTrainingData)
																								.addPreferredGap(
																										ComponentPlacement.RELATED, 101,
																										Short.MAX_VALUE)
																								.addComponent(trainigDataCB))
																				.addGroup(
																						gl_importDialogPanel
																								.createSequentialGroup()
																								.addComponent(lblSynapse)
																								.addPreferredGap(
																										ComponentPlacement.RELATED, 127,
																										Short.MAX_VALUE)
																								.addComponent(synapseCB))
																				.addGroup(
																						gl_importDialogPanel
																								.createSequentialGroup()
																								.addComponent(lblTopology)
																								.addPreferredGap(
																										ComponentPlacement.RELATED, 120,
																										Short.MAX_VALUE)
																								.addComponent(topologieCB))).addGap(45)))));
		gl_importDialogPanel.setVerticalGroup(gl_importDialogPanel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_importDialogPanel
						.createSequentialGroup()
						.addGap(10)
						.addGroup(
								gl_importDialogPanel
										.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblImportFile)
										.addComponent(btnSearch)
										.addComponent(textAreaFileName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_importDialogPanel
										.createParallelGroup(Alignment.LEADING)
										.addGroup(
												gl_importDialogPanel.createSequentialGroup().addComponent(lblTopology)
														.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblSynapse)
														.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblTrainingData))
										.addGroup(
												gl_importDialogPanel.createSequentialGroup().addComponent(topologieCB)
														.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(synapseCB)
														.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(trainigDataCB)))
						.addGap(18)
						.addGroup(
								gl_importDialogPanel.createParallelGroup(Alignment.BASELINE).addComponent(btnCancel)
										.addComponent(btnImport)).addContainerGap(14, Short.MAX_VALUE)));
		importDialogPanel.setLayout(gl_importDialogPanel);
		getContentPane().add(importDialogPanel);

	}

	private void openFileChooser() {

		fileopen = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("csv files", "csv");
		fileopen.addChoosableFileFilter(filter);

		int ret = fileopen.showDialog(searchFilePanel, "Open file");

		if (ret == JFileChooser.APPROVE_OPTION) {
			// textAreaFileName.setText(fileopen.getSelectedFile().toString());
			// TODO: show choosen file name

		}

	}

	private String readFile(final File file) {

		StringBuffer fileBuffer = null;
		String fileString = null;
		String line = null;

		try {
			FileReader in = new FileReader(file);
			BufferedReader brd = new BufferedReader(in);
			fileBuffer = new StringBuffer();

			while ((line = brd.readLine()) != null) {
				fileBuffer.append(line).append(System.getProperty("line.separator"));
			}

			in.close();
			fileString = fileBuffer.toString();
		} catch (IOException e) {
			return null;
		}
		return fileString;
	}
}
