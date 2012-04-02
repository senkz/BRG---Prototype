package connections;

import java.sql.Connection;
import java.util.ArrayList;

import model.BusinessRule;

public interface SourceDAO extends DAO
{
	ArrayList<BusinessRule> getBusinessRules();
	BusinessRule getBusinessRule(int id);
	public  Connection getConnection(String username, String password, String URL);
	public String testConnection(String username, String password, String URL); 
}
