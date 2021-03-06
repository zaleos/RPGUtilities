package server;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GUIServer extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel tabDice;
	private JPanel tabCharacterList;
	private JPanel tabCharacterCreator;
	private PanePlayersServer panePlayers;
	private JPanel paneGM;
	private PaneMapServer paneMap;
	private ControllerServer controller;
	
	public GUIServer() {
		initializeComponents();
		addComponents();
		setTitle("RPG Utilities-GM Perspective");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	private void initializeComponents() {
		// Give components declared at the top particular values, eg
		tabDice=new TabDice(); //(same for server or client?)
		tabCharacterList=new TabCharacterListServer();
		tabCharacterCreator=new TabCharacterCreatorServer();
		panePlayers=new PanePlayersServer();
		paneGM=new PaneGMServer();
		paneMap=new PaneMapServer();
		controller=ControllerServer.getInstance();
		controller.setPaneMap(paneMap);
		controller.setChatWindow(panePlayers.getChatWindow());
	}
	
	private void addComponents() {
		JTabbedPane tabs=new JTabbedPane();
		tabs.addTab("Character List", tabCharacterList);
		tabs.addTab("Character Creator", tabCharacterCreator);
		tabs.addTab("Dice Roller", tabDice);
		add(tabs, BorderLayout.SOUTH);
		add(paneMap, BorderLayout.WEST);
		add(paneGM, BorderLayout.CENTER);
		add(panePlayers, BorderLayout.EAST);
	}

}
