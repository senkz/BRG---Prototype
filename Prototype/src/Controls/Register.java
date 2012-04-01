package controls;

import java.util.ArrayList;

import connections.DAO;
import connections.SourceDatabaseJDBC_Oracle;

import model.BusinessRule;

public class Register 
{
	@SuppressWarnings("unused")
	private ArrayList<BusinessRule> businessRuleList = new ArrayList<BusinessRule>();
	//Voegt alle businessRules toe aan 
	static DAO conn;
	
	private Register() {}

	public static void initialize() 
	{
		conn = (DAO) new SourceDatabaseJDBC_Oracle();		
	}
	
	public static DAO getConnection() 
	{
		if (conn == null) 
		{
			conn = (DAO) new SourceDatabaseJDBC_Oracle();
			return conn;
		} 
		else 
		{
			return conn;
		}
	}
}