package gui.controller;
import gui.model.User;

import java.util.ArrayList;


public class Register 
{
	public static User activeUser = null;
	public static ArrayList<String> userNames = new ArrayList<String>();
	public  static ArrayList<User> userList = new ArrayList<User>();
	
	public static void addUser(User s)
	{
		userList.add(s);
	}
}
