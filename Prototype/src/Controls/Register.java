package Controls;

import connections.*;

public class Register 
{
	static SourceDAO sourceConn;
	static TargetDAO targetConn;
	
	private Register() {}

	public static void initializeTarget() 
	{
		targetConn = (TargetDAO) new TargetDatabaseJDBC_Oracle();		
	}
	
	public static void initializeSource() 
	{
		sourceConn = (SourceDAO) new SourceDatabaseJDBC_Oracle();		
	}
	
	public static SourceDAO getSourceConnection() 
	{
		if (sourceConn == null) 
		{
			initializeSource();
			return sourceConn;
		} 
		else 
		{
			return sourceConn;
		}
	}
	
	public static TargetDAO getTargetConnection() 
	{
		if (targetConn == null) 
		{
			initializeTarget();
			return targetConn;
		} 
		else 
		{
			return targetConn;
		}
	}
}