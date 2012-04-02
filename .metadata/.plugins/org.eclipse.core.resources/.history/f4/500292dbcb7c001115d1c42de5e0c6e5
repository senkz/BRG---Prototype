package controls;

import connections.*;

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