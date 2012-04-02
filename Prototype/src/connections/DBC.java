package connections;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;

import logger.GLogger;

public class DBC {
	private static DBC instance = null;
	private static Properties properties = null;
	private static Connection connection = null;
	
	private DBC() {}
	
	private synchronized static void createInstance() {
		if(instance == null) instance = new DBC();
		
		properties = new Properties();
		try {
			properties.load(new FileInputStream("dbsetting.ini"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DBC getInstance() {
		if(instance == null)
			createInstance();
		
		return instance;
	}
	
	public Connection connect() {
		if(properties == null || properties.size() == 0)
			return null;
		
		try 
		{
			Class.forName(properties.getProperty("driverpath"));
			connection = DriverManager.getConnection(properties.getProperty("connectionstring"), properties.getProperty("user"), properties.getProperty("password"));
			
			GLogger.log(Level.INFO, "Made an database connection with:");
			GLogger.log(Level.INFO, "Username: " + properties.getProperty("user"));
			GLogger.log(Level.INFO, "Connectionstring: " + properties.getProperty("connectionstring"));
			GLogger.log(Level.INFO, "Driver: " + properties.getProperty("driverpath"));
		} 
		catch(Exception e)
		{
			GLogger.log(Level.SEVERE, "Failed to connect to database.");
		}
		return connection;
	}
}
