package gui.model;

import java.io.Serializable;

public class User implements Serializable
{
	private static final long serialVersionUID = -7825939887632075837L;
	private String userName;
	private String password;
	
	private String sourceDatabaseUsername;
	private String targetDatabaseUsername;
	private String sourceDatabasePassword;
	private String targetDatabasePassword;
	private String sourceDatabaseURL;
	private String targetDatabaseURL;	
	
	public User(String un, String up, String su, String tu, String sp, String tp, String surl, String turl)
	{
		userName = un;
		password = up;
		sourceDatabaseUsername = su;
		targetDatabaseUsername = tu;
		sourceDatabasePassword = sp;
		targetDatabasePassword = tp;
		sourceDatabaseURL = surl;		
		targetDatabaseURL = turl;
	}
	
	public void setSourceDatabaseUsername(String _sourceDatabaseUsername)
	{
		sourceDatabaseUsername = _sourceDatabaseUsername;
	}
	
	public void setTargetDatabaseUsername(String _targetDatabaseUsername)
	{
		targetDatabaseUsername = _targetDatabaseUsername;
	}
	
	public void setSourceDatabasePassword(String _sourceDatabasePassword)
	{
		sourceDatabasePassword = _sourceDatabasePassword;
	}
	
	public void setTargetDatabasePassword(String _targetDatabasePassword)
	{
		targetDatabasePassword = _targetDatabasePassword;
	}
	
	public void setSourceDatabaseURL(String _sourceDatabaseURL)
	{
		sourceDatabaseURL = _sourceDatabaseURL;
	}
	
	public void setTargetDatabaseURL(String _targetDatabaseURL)
	{
		targetDatabaseURL = _targetDatabaseURL;
	}
	
	public User(String un, String up)
	{
		userName = un;
		password = up;
	}
	
	public String getUsername()
	{
		return userName;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String _password)
	{
		password = _password;
	}
	
	public String getSourceDatabaseUsername()
	{
		return sourceDatabaseUsername;
	}
	
	public String getSourceDatabasePassword()
	{
		return sourceDatabasePassword;
	}
	
	public String getTargetDatabaseUsername()
	{
		return targetDatabaseUsername;
	}
	
	public String getTargetDatabasePassword()
	{
		return targetDatabasePassword;
	}
	
	
	public String getSourceDatabaseURL()
	{
		return sourceDatabaseURL;
	}
	
	public String getTargetDatabaseURL()
	{
		return targetDatabaseURL;
	}
	
	public String toString()
	{
		return userName+password;
	}

}
