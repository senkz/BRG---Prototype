package test;

import java.io.File;
import javax.management.modelmbean.ModelMBean;

import model.BusinessRule;
import model.Trigger;
import output.Write;
import connections.SourceDatabaseJDBC_Oracle;

public class Main
{

	public static void main(String[] args) 
	{
		TestAttributeCompareRule _testAttributeCompareRule = new TestAttributeCompareRule();
		//Supply Businessrule ID 
		_testAttributeCompareRule.execute(35);
		
		//TestAttributeRangeRule _testAttributeRangeRule = new TestAttributeRangeRule();
		//Write.writeText(new File("test.txt"),_testAttributeRangeRule.execute(), false);
	}

}
