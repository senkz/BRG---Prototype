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
		s+=" "+businessRule.getLanguage().getBegin();
		s+="\nIF " + ":old.";
		
		if(businessRule.operator.getDeclaredValue().getValueString().equals(""))
		{
			s+=businessRule.operator.getDeclaredValue().getValue();
		}
		else
		{
			s+=businessRule.operator.getDeclaredValue().getValueString();
		}
		
		s+= " "+businessRule.operator.getOperator() + " ";
		
		if(businessRule.operator.getComparativeValue().getValueString().equals(""))
		{
			s+=businessRule.operator.getComparativeValue().getValue();
		}
		else
		{
			s+=businessRule.operator.getComparativeValue().getValueString();
		}
		
		s+="\nTHEN DBMS_OUTPUT.PUT_LINE('"+businessRule.error.getMessage()+"');";
		s+="\nEND IF;";
		s+="\nEND;";
		
		 
		return s;
	}
}	
