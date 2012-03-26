package test;

import java.io.File;

import connections.SourceDatabaseJDBC_Oracle;

import output.Write;

public class Main
{

	public static void main(String[] args) 
	{
		TestAttributeCompareRule _testAttributeCompareRule = new TestAttributeCompareRule();
		_testAttributeCompareRule.execute();
		
		System.out.println("");
		
		TestAttributeRangeRule _testAttributeRangeRule = new TestAttributeRangeRule();
		Write.writeText(new File("test.txt"),_testAttributeRangeRule.execute(), false);
		
		SourceDatabaseJDBC_Oracle conn = new SourceDatabaseJDBC_Oracle();
		conn.getBusinessRules();
	}

}
