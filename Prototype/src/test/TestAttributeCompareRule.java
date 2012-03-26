package test;

import java.util.ArrayList;

import connections.SourceDatabaseJDBC_Oracle;

import languages.Language;
import languages.PLSQL;
import model.Error;
import model.*;
import model.rules.*;


//Whitebox testing of the Attribute Compare Rule (Rule nr.2 )
public class TestAttributeCompareRule 
{
	
	
	public void execute(int BRID)
	{
		SourceDatabaseJDBC_Oracle conn = new SourceDatabaseJDBC_Oracle();
		
		BusinessRule br = conn.getBusinessRule(BRID);
		model.Error error = conn.getError(br.getIerror());
		Trigger trigger = conn.getTrigger(br.getItrigger());
		Operator operator = conn.getOperatorByBrFk(br.getID());
		TableColumn _tableColumn = conn.getTableColumn(operator.getTableColumn1());
		Value value = conn.getValueByCvFk(operator.getCollectionValue());
		Table table = conn.getTableByTrigger(trigger.getID());
		
		trigger.setTable(table);
		/*
		Error _error = new Error(1,"Value error", "Value must be 1 or higher", null);
		TableColumn _tableColumn = new TableColumn(1,"price",null);
		Table _table = new Table(1,"product",_tableColumn);
		Trigger _trigger = new Trigger(1,_table,"BEFORE UPDATE");
		BusinessRuleCategory _businessRuleCatagory = new BusinessRuleCategory(1,"");
		*/
		ArrayList<Operator> _operator = new ArrayList<Operator>();
		
		_operator.add(new Operator(new Value(value.getID(), table, table.getName()), operator.getOperator(), value , false));
		
		BusinessRule _businessRule = new BusinessRule(br.getID(), true, br.getName(), error, trigger, null, _operator, null, new PLSQL());
		/* 
		 * 
		 * attributeRangeRule in COMPARE rule test?!?!
		 * 
		 * */
		BusinessRuleType _attributeRangeRule = (AttributeRangeRule) new AttributeRangeRule(1, "test", _businessRule);
		System.out.println(_attributeRangeRule.generate());
	}
	
}
