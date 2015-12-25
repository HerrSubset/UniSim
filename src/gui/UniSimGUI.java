package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class UniSimGUI extends JFrame {

	public UniSimGUI(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("University Simulator");
		
		this.loadMainMenu();
		
		this.setVisible(true);
		this.pack();
	}
	
	
	
	//creates a main menu and puts in the contentpane of the frame
	private void loadMainMenu(){
		this.getContentPane().removeAll();;
		
		MainMenu main = new MainMenu();
		this.getContentPane().add(main, BorderLayout.CENTER);
	}
}
