package connections;

import java.sql.Connection;
import java.util.ArrayList;

import model.BusinessRule;

public interface DAO 
{
	ArrayList<BusinessRule> getBusinessRules();
	BusinessRule getBusinessRule(int id);
	public  Connection getConnection();
	public boolean testConnection(); 
}
