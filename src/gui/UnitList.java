package gui;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class UnitList extends JPanel {

	public UnitList(){
		Border b = BorderFactory.createTitledBorder("Entity List");
		this.setBorder(b);
		
		JLabel label = new JLabel("this is where the list goes");
		this.add(label);
	}
}
