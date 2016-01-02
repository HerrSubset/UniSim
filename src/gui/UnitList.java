/**
***UnitList Class
***
***This class is a list displaying all the entities in the simulation. 
***Double-clicking an entity shows its history.
**/

package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import passables.EntityState;

@SuppressWarnings("serial")
public class UnitList extends JPanel {
	private JList<EntityState> list;
	private UniSimGUI parent;

	
	
	
	// ************************************************************************
	// Constructor
	// ************************************************************************
	
	public UnitList(UniSimGUI parent){
		this.parent = parent;
		this.setLayout(new BorderLayout());
		
		list = new JList<EntityState>();

		JScrollPane scroller = new JScrollPane(list);
		this.add(scroller, BorderLayout.CENTER);
		
		Border b = BorderFactory.createTitledBorder("Entity List");
		this.setBorder(b);
		this.setPreferredSize(new Dimension(200, 300));
		
		addListAction();
	}
	
	
	
	
	// ************************************************************************
	// Other Functions
	// ************************************************************************
	
	//pass a new list of entities to the UnitList to update its old list
	public void updateList(List<EntityState> entities){
		DefaultListModel<EntityState> model = new DefaultListModel<>();
		
		Iterator<EntityState> it = entities.iterator();
		
		while (it.hasNext())
			model.addElement(it.next());
		
		this.list.setModel(model);
	}
	
	
	
	//when a list item is double clicked, show that entity's history
	private void addListAction(){
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt){
				
				@SuppressWarnings("unchecked")
				JList<EntityState> list = (JList<EntityState>) evt.getSource();
				
				if (evt.getClickCount() == 2) {
					//execute this when double clicked
					int index = list.locationToIndex(evt.getPoint());
					
					EntityState state = list.getModel().getElementAt(index);
		
					parent.openEntityInfoScreen(state);
				}
			}
		});
	}
}
