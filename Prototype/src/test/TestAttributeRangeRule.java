package test;

import java.util.ArrayList;

import languages.PLSQL;
import model.Error;
import model.*;
import model.rules.*;


//Whitebox testing of the Attribute Range Rule (Rule nr.1)
public class TestAttributeRangeRule 
{
	public String execute()
	{
		Error _error = new Error(1,"Value error", "Value must be 1.0 or higher", null);
		TableColumn _tableColumn = new TableColumn(1,"price",null);
		Table _table = new Table(1,"product",_tableColumn);
		Trigger _trigger = new Trigger(1,_table,"BEFORE UPDATE");
		BusinessRuleCategory _businessRuleCatagory = new BusinessRuleCategory(1,"");
		
		ArrayList<Operator> _operator = new ArrayList<Operator>();
		
		_operator.add(new Operator(new Value(1, _table, _table.getName()), ">",new Value(1,1, "") , false));
		_operator.add(new Operator(new Value(1, _table, _table.getName()), ">",new Value(2,3, "") , false));
		
		BusinessRule _businessRule = new BusinessRule(1, true, "price_constraint", _error, _trigger, null, _operator, _businessRuleCatagory, new PLSQL());
		
		BusinessRuleType _attributeCompareRule = (AttributeCompareRule) new AttributeCompareRule(1, "test", _businessRule);
		return _attributeCompareRule.generate();
	}	
}