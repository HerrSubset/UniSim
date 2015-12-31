package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class EntityInfoScreen extends JFrame {
	private static EntityInfoScreen instance = null;

	//make sure the constructor can't be called from outside
	private EntityInfoScreen(){
		this.getContentPane().add(new JLabel("hi"));
		this.setVisible(true);
		this.pack();
	}



	//returns the single instance if it exists. Otherwise create it first.
	public static EntityInfoScreen getInstance(){
		if (instance == null)
			instance = new EntityInfoScreen();

		return instance;
	}
}
