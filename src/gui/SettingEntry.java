/**
***SettingEntry Class
***
***this is a simple GUI element. It consists of a label which contains the name
***of a setting, and a textfield with it's value. It also has two methods to
***retrieve the values of both key and value in this entry.
***
***This class is used in the SettingsPanel class
**/

package gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class SettingEntry extends JPanel {
	private JTextArea input;
	private JLabel label;

	
	
	
	//************************************************************************
	// Constructor
	//************************************************************************
	
	public SettingEntry(String name, int value){
		this.setLayout(new GridLayout(1, 2));
		
		this.label = new JLabel(name);
		this.add(label);
		
		this.input = new JTextArea(Integer.toString(value));
		this.add(input);
	}
	
	
	
	
	//************************************************************************
	// Other functions
	//************************************************************************
	
	public String getKey(){
		return this.label.getText();
	}
	
	
	
	public int getValue() throws NumberFormatException{
		return Integer.parseInt(this.input.getText());
	}
}
