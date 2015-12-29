package gui;

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
		
	}
}
