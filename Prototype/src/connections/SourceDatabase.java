package connections;

import java.sql.Connection;
import java.util.ArrayList;

import model.BusinessRule;

public interface SourceDatabase 
{

	ArrayList<BusinessRule> getBusinessRules();
	//public  Connection getConnection();
	//public 
}
