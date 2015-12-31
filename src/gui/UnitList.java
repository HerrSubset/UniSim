package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class UnitList extends JPanel {

	public UnitList(){
		this.setLayout(new BorderLayout());
		String[] sList = {"een", "twee", "drie", "vier", "vijf", "zes", "zeven", "acht", "negen", "tien", "een", "twee", "drie", "vier", "vijf", "zes", "zeven", "acht", "negen", "tien", "een", "twee", "drie", "vier", "vijf", "zes", "zeven", "acht", "negen", "tien"};
		
		JList<String> list = new JList<String>(sList);

		JScrollPane scroller = new JScrollPane(list);
		this.add(scroller, BorderLayout.CENTER);
		
		Border b = BorderFactory.createTitledBorder("Entity List");
		this.setBorder(b);
		this.setPreferredSize(new Dimension(150, 300));
	}
}
