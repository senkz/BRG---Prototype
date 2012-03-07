import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Initializer
{
	private final static String userNameList = "UserList";
	private final static File userNameFile = new File(userNameList+".txt");
	private static ArrayList<String> users = new ArrayList<String>();
	private static ArrayList<String> tempList= new ArrayList<String>();

	public static void initialize() throws IOException
	{
		String line;
		BufferedReader br;
		userNameFile.createNewFile();
		
		br = new BufferedReader(new FileReader(userNameList));
			
		while((line = br.readLine()) != null)
		{
			users.add(line);
		}
		
		line = "";
		for (String _user : users)
		{
			br = new BufferedReader(new FileReader(_user+".txt"));
			while((line = br.readLine()) != null)
			{
				tempList.add(line);
				Register.addUser(new User(tempList.get(0), _user, _user, _user, _user, _user, _user, _user));
			}
			
		}
	}
}