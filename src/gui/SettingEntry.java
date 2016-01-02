package gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class SettingEntry extends JPanel {
	private JTextArea input;
	private JLabel label;

	public SettingEntry(String name, int value){
		this.setLayout(new GridLayout(1, 2));
		
		this.label = new JLabel(name);
		this.add(label);
		
		this.input = new JTextArea(Integer.toString(value));
		this.add(input);
	}
	
	
	public String getKey(){
		return this.label.getText();
	}
	
	
	
	public int getValue() throws NumberFormatException{
		return Integer.parseInt(this.input.getText());
	}
}
