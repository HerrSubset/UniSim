/**
***SettingsPanel Class
***
***This panel shows some statistics about the simulation every turn
**/

package gui;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import passables.SimulationStateSummary;

@SuppressWarnings("serial")
public class StatisticsPanel extends JPanel {
	private StatPanel entities;
	private StatPanel turn;
	
	
	
	
	// ************************************************************************
	// Constructor
	// ************************************************************************

	public StatisticsPanel(){
		Border b = BorderFactory.createTitledBorder("Statistics");
		this.setBorder(b);
		
		this.setLayout(new GridLayout(3, 5));
		
		turn = new StatPanel("Turn: ");
		this.add(turn);
		
		entities = new StatPanel("# of Entities: ");
		this.add(entities);
	}
	
	
	
	
	// ************************************************************************
	// Other Functions
	// ************************************************************************
	
	//takes a state and uses its info to update the panel's info
	public void updateValues(SimulationStateSummary state){
		this.turn.updateValue(state.turn);
		this.entities.updateValue(state.inhabitantsNumber);
	}
}
