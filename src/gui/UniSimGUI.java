package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UniSimGUI extends JFrame {

	public UniSimGUI(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("University Simulator");
		this.setPreferredSize( new Dimension(300, 200));
		this.setVisible(true);
		
		JPanel panel = new JPanel();
		
		panel.add(new JLabel("Yo World!"));
		
		this.getContentPane().add(panel);
		this.pack();
	}
}
