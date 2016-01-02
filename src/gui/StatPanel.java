/**
***StatPanel Class
***
***Used in the StatisticsPanel class to display the name and value of a statistic
**/

package gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class StatPanel extends JPanel {
	private JLabel label;
	private JLabel value;
	
	
	
	
	// ************************************************************************
	// Constructor
	// ************************************************************************
	
	public StatPanel(String labelMsg){
		//set layout
		this.setLayout(new GridLayout(1, 2));
		//create labels and add them to the panel
		label = new JLabel(labelMsg);
		value = new JLabel();
		
		this.add(label);
		this.add(value);
	}
	
	
	
	
	// ************************************************************************
	// Other Functions
	// ************************************************************************
	
	//updates the value of the "value" label
	public void updateValue(int value){
		this.value.setText(Integer.toString(value));
	}
}
