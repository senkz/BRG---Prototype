package test;

import languages.PLSQL;
import model.Error;
import model.*;
import model.rules.*;


//Whitebox testing of the Attribute Compare Rule (Rule nr.2 )
public class TestAttributeCompareRule 
{
	
	
	public void execute()
	{
		Error _error = new Error(1,"Value error", "Value must be 1 or higher", null);
		TableColumn _tableColumn = new TableColumn(1,"price",null);
		Table _table = new Table(1,"product",_tableColumn);
		Trigger _trigger = new Trigger(1,_table,"BEFORE UPDATE");
		BusinessRuleCategory _businessRuleCatagory = new BusinessRuleCategory(1,"");
		Operator _operator = new Operator(new Value(1, _table, _table.getName()), ">",new Value(2,1, "") , false);
		
		BusinessRule _businessRule = new BusinessRule(1, true, "price_constraint", _error, _trigger, null, _operator, _businessRuleCatagory, new PLSQL());
		
		BusinessRuleType _attributeRangeRule = (AttributeRangeRule) new AttributeRangeRule(1, "test", _businessRule);
		System.out.println(_attributeRangeRule.generate());
	}
	
}
