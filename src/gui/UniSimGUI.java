package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class UniSimGUI extends JFrame {

	public UniSimGUI(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("University Simulator");
		
		this.loadContentPanels();
		
		this.setVisible(true);
		this.pack();
	}
	
	
	
	//creates a main menu and puts in the contentpane of the frame
	private void loadContentPanels(){
		this.getContentPane().removeAll();;
		
		MapPanel mapPanel = new MapPanel();
		this.getContentPane().add(mapPanel, BorderLayout.CENTER);
		
		UnitList list = new UnitList();
		this.getContentPane().add(list, BorderLayout.EAST);
	}
}
