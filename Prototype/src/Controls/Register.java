package controls;

import java.util.ArrayList;

import connections.DAO;
import connections.SourceDatabaseJDBC_Oracle;

import model.BusinessRule;

public class Register 
{
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
			initialize();
			return conn;
		} 
		else 
		{
			return conn;
		}
	}
}