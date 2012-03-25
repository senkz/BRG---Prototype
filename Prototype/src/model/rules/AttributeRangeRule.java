package model.rules;

import model.BusinessRule;

public class AttributeRangeRule extends BusinessRuleType
{
	
	public AttributeRangeRule(int _ID, String _name, BusinessRule _businessRule)
	{
		super(_ID, _name, _businessRule);
		
	}

	public String generate()
	{
		String s = businessRule.getLanguage().getInitiateFunction();
		if (businessRule.isReplace())
		{
			s+=" "+businessRule.getLanguage().getReplaceFunction();
		}
		s+=" " + businessRule.getLanguage().getFunction() + " " + businessRule.getName();
		s+="\n" + businessRule.trigger.getEvent() + " ON "+businessRule.trigger.table.getName();
		if (businessRule.trigger.table.tableColumn!=null)
		{
			s+="." + businessRule.trigger.table.tableColumn.getName();
		}
		s+="\n"+businessRule.getLanguage().getBegin();
		s+="\n" + businessRule.getLanguage().getStartIf() + " :old.";
		
		if(businessRule.getOperatorList().get(0).getDeclaredValue().getValueString().equals(""))
		{
			s+=businessRule.getOperatorList().get(0).getDeclaredValue().getValue();
		}
		else
		{
			s+=businessRule.getOperatorList().get(0).getDeclaredValue().getValueString();
		}
		
		s+= " "+businessRule.getOperatorList().get(0).getOperator() + " ";
		
		if(businessRule.getOperatorList().get(0).getComparativeValue().getValueString().equals(""))
		{
			s+=businessRule.getOperatorList().get(0).getComparativeValue().getValue();
		}
		else
		{
			s+=businessRule.getOperatorList().get(0).getComparativeValue().getValueString();
		}
		
		s+="\n"+businessRule.getLanguage().getPrintLine()+businessRule.getError().getMessage()+"');";
		s+="\n"+ businessRule.getLanguage().getCloseIf();
		s+="\n"+businessRule.getLanguage().getClose();
		 
		return s;
	}
}	
