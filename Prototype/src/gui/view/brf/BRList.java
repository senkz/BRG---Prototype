package gui.view.brf;

import java.util.ArrayList;

import model.BusinessRule;
import connections.ModelController;

public class BRList {
	private ModelController mc = ModelController.getInstance();
	
	private ArrayList<BusinessRule> br_listed = new ArrayList<BusinessRule> ();
	private ArrayList<BusinessRule> br_generate = new ArrayList<BusinessRule> ();
	
	public BRList() {
		br_listed = mc.getBr_list();
	}
	
	public ArrayList<BusinessRule> getBusinessRuleList() {
		return br_listed;
	}
	
	public ArrayList<BusinessRule> getBusinessToGenerate() {
		return br_generate;
	}

	public void RemoveFromGenerate(ArrayList<BusinessRule> geselecteerdeSelected) {
		for(BusinessRule br : geselecteerdeSelected) {
			br_listed.add(br);
			br_generate.remove(br);
		}
	}

	public void SetToGenerate(ArrayList<BusinessRule> geselecteerdeSelected) {
		for(BusinessRule br : geselecteerdeSelected) {
			br_generate.add(br);
			br_listed.remove(br);
		}
	}

	public void allToGenerateB() {
		if(br_listed == null || br_listed.size() == 0) return;
		for(BusinessRule br : br_listed) {
			br_generate.add(br);
		}
		br_listed.clear();
	}

	public void allToSelectedB() {
		if(br_generate == null || br_generate.size() == 0) return;
		for(BusinessRule br : br_generate) {
			br_listed.add(br);
		}
		br_generate.clear();
	}
}