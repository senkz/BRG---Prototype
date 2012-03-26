package connections;

import java.sql.*;
import java.util.ArrayList;

import model.BusinessRule;

public class SourceDatabaseJDBC_Oracle implements SourceDatabase
{
	static String userid="THO7_2011_2B_TEAM3A", password = "THO7_2011_2B_TEAM3A";
	static String url = "jdbc:oracle:thin:@ondora01.hu.nl:8521:cursus01";
	static Statement stmt;
	static Connection con;
	
	public static Connection getConnection()
	{		
		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
		} 
		catch(java.lang.ClassNotFoundException e) 
		{
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try 
		{
			con = DriverManager.getConnection(url, userid, password);
		} 
		catch(SQLException ex)
		{
			System.err.println("SQLException:  " + ex.getMessage());
		}
		
		return con;
	}
	
	public ArrayList<BusinessRule> getBusinessRules()
	{
		String sql = "SELECT NAME FROM APP_BUSINESSRULE";
		ArrayList<BusinessRule> _temp = new ArrayList<BusinessRule>();
		Connection con = getConnection();
		try 
		{
           	stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        while (rs.next())
	        {
	           
	            
	            BusinessRule _businessRule = new BusinessRule(rs.getString(1));
	            _temp.add(_businessRule);
	            System.out.println(_businessRule.getName());
	        }
	        stmt.close();
		    con.close();
		} 
		catch(SQLException ex)
		{
			System.err.println("SQLException: " + ex.getMessage());
		}
		
		return _temp;
	}
}