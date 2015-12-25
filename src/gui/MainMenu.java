package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class MainMenu extends JPanel {
	
	public MainMenu(){
		this.setLayout(new BorderLayout());
		
		JPanel centerPanel = this.getCenterPanel();
		this.add(centerPanel, BorderLayout.CENTER);
			
		JPanel buttonPanel = this.getButtonPanel();
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	
	
	private JPanel getCenterPanel(){
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		JLabel label = new JLabel("How would you like to start a new simulation?");
		centerPanel.add(label);
		
		JRadioButton defaultSettings = new JRadioButton("Default Settings");
		JRadioButton customSettings = new JRadioButton("Custom Settings");
		JRadioButton loadSettings = new JRadioButton("Load Settings");
		
		ButtonGroup group = new ButtonGroup();
		group.add(defaultSettings);
		group.add(customSettings);
		group.add(loadSettings);
		
		centerPanel.add(defaultSettings);
		centerPanel.add(customSettings);
		centerPanel.add(loadSettings);
		
		return centerPanel;
	}
	
	
	
	private JPanel getButtonPanel(){
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton startButton = new JButton("Start Simulation");
		JButton exitButton = new JButton("Exit");
		
		buttonPanel.add(exitButton);
		buttonPanel.add(startButton);
		
		return buttonPanel;
	}
}
