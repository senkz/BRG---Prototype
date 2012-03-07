import java.util.ArrayList;


public class Register 
{
	private static User activeUser = null;
	private static ArrayList<User> userList = new ArrayList<User>();
	
	public static void addUser(User s)
	{
		userList.add(s);
	}
}
