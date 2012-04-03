package test;

import gui.view.BusinessRuleFrame;
import connections.SourceDAO;
import connections.SourceDatabaseJDBC_Oracle;

public class Main
{

	public static void main(String[] args) 
	{
		BusinessRuleFrame brf = new BusinessRuleFrame();
		SourceDAO mc = new SourceDatabaseJDBC_Oracle();
		mc.loadObjects();
		brf.init();	
	}
}
