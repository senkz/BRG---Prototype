package gui.view.brf;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.BusinessRule;
import connections.ModelController;

@SuppressWarnings("serial")
public class SelectBusinessRules extends JPanel implements Observer{

	private ModelController mc = ModelController.getInstance();
	
	private JList selectList;
	private JComboBox selectTypeRule;
	private ArrayList<BusinessRule> tempList;
	private String what;
	private String filter = null;
	
	private BRList BRList;
	
	public SelectBusinessRules(String w, BRList brl, Object[] ruleTypes){
		what = w;
		
		BRList = brl;
		
		new JPanel();
		setPreferredSize(new Dimension(300,600));
		setLayout(new BorderLayout());
		
		selectTypeRule = new JComboBox(ruleTypes);
		selectTypeRule.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent ie) {
				if(ie.getStateChange() == 1){
					if(!ie.getItem().toString().equals("All Business Rules")){
						filter = ie.getItem().toString();
						update(null, null);
					} else {
						filter = null;
						update(null, null);
					}
				}
				
			}
			
		});
		add(selectTypeRule, BorderLayout.NORTH);
		
		
		JPanel brListPanel = new JPanel();
		brListPanel.setSize(new Dimension(200,500));
		brListPanel.setLayout(new BorderLayout());
		selectList = new JList();
		selectList.setSelectedIndex(1);
		if(what.equals("SELECTING")){
			makeTempList(BRList.getBusinessRuleList());
			selectList.setListData(tempList.toArray());
		} else {
			makeTempList(BRList.getBusinessToGenerate());
			selectList.setListData(tempList.toArray());
		}
		brListPanel.add(new JScrollPane(selectList), BorderLayout.CENTER);
		add(brListPanel, BorderLayout.CENTER);
	}
	
	public ArrayList<BusinessRule> getGeselecteerdeSelected(){
		return new ArrayList<BusinessRule> (selectList.getSelectedValuesList());
	}
	
	@Override
	public void update(Observable o, Object arg) {
		selectList.setVisible(false);
		if(what.equals("SELECTING")){
			if(makeTempList(BRList.getBusinessRuleList())){
				selectList.setListData(tempList.toArray());
			}
		} else {
			if(makeTempList(BRList.getBusinessToGenerate())){
				selectList.setListData(tempList.toArray());
			}
		}
		selectList.setVisible(true);
	}
	
	public boolean makeTempList(ArrayList<BusinessRule> brl){
		tempList = new ArrayList<BusinessRule>();
		if(filter != null){
			for(BusinessRule b : brl){
				if(mc.findBusinessRuleType(b.getBrt_fk()).getName().equals(filter)){
					tempList.add(b);
				}
			}
			
		} else {
			tempList = brl;
		}
		return true;
	}
	
}
