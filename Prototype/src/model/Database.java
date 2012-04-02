package model;

public class DataBase {
	private int db_id;
	private String dbType;
	private String hostname;
	private String name;
	private String password;
	private int port;
	private int app_fk;
	
	public int getDb_id() {
		return db_id;
	}
	public void setDb_id(int db_id) {
		this.db_id = db_id;
	}
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getApp_fk() {
		return app_fk;
	}
	public void setApp_fk(int app_fk) {
		this.app_fk = app_fk;
	}
}