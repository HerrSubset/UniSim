/**
***MapPanel Class
***
***this class is part of the GUI screen. It is the textarea on which the map
***is drawn. The amount of columns in which the map is drawn depends on user
***settings.
**/

package gui;

import java.awt.Dimension;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class MapPanel extends JTextArea {
	private int numberOfCols = 3;
	private List<String> mapStrings;

	
	
	
	//************************************************************************
	// Constructor
	//************************************************************************
	
	public MapPanel() {
		Border b = BorderFactory.createTitledBorder("Map");
		this.setBorder(b);
		this.setPreferredSize(new Dimension(300, 300));
	}

	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	
	// print the given strings to the screen. The amount of columns that will
	// be used for printing is stored in the "numberOfCols" variable
	public void updateInfo(List<String> mapStrings) {
		this.mapStrings = mapStrings;
		this.drawMap();
	}

	
	
	//draws the map on the screen
	private void drawMap() {
		// empty the text area
		this.setText("");

		// get the length of the longest string in mapStrings
		int maxLength = getMaxLength(mapStrings);

		// print strings to screen
		Iterator<String> it = mapStrings.iterator();

		while (it.hasNext()) {
			String line = "";

			for (int i = 0; i < numberOfCols; i++) {
				if (it.hasNext())
					line += stretch(it.next(), maxLength + 2);
			}

			this.append(line + "\n");
		}
	}

	
	
	//returns the lenght of the longest string in the given list
	private int getMaxLength(List<String> strings) {
		int res = 0;

		Iterator<String> it = strings.iterator();

		while (it.hasNext()) {
			String curString = it.next();
			if (curString.length() > res)
				res = curString.length();
		}

		return res;
	}

	
	
	//appends spaces to the given string until it's length is the target length
	private String stretch(String s, int targetLength) {
		String res = s;

		while (res.length() < targetLength)
			res += " ";

		return res;
	}

	

	//change the # of coumns in which the map has to be drawn. Immediately
	//re-draw the map so that this setting is applied.
	public void setCols(int cols) {
		this.numberOfCols = cols;
		this.drawMap();
	}
}
