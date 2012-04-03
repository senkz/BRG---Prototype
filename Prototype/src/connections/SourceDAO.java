package connections;

import java.sql.Connection;

public interface SourceDAO {

	public abstract String testConnection(String _username, String _password,
			String _URL);

	public abstract Connection getConnection(String _username,
			String _password, String _URL);

	public abstract void loadObjects();

}