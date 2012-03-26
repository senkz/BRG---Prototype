package Controls;

import java.util.ArrayList;

import connections.SourceDatabase;
import connections.SourceDatabaseJDBC_Oracle;

import model.BusinessRule;

public class Register 
{
	@SuppressWarnings("unused")
	private ArrayList<BusinessRule> businessRuleList = new ArrayList<BusinessRule>();
	//Voegt alle businessRules toe aan 

	public static void initialize() 
	{
		SourceDatabase conn = (SourceDatabase) new SourceDatabaseJDBC_Oracle();
		conn.getBusinessRules();
		
		
	}
}
