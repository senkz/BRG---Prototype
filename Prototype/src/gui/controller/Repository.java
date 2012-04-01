package gui.controller;

import gui.model.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Repository
{
	private final static String credentialsString = "credentials";
	private final static File credentialFile = new File(credentialsString+".txt");

	private static String line;
	private static BufferedReader br;
	
	public static void initialize()
	{
		try 
		{
			File  _file = new File("test");
			_file.createNewFile();
			
			int size = _file.getName().length();
			String path = _file.getCanonicalPath().substring(0,_file.getCanonicalPath().length()-size);
				
			//System.out.println(path);
			
			  String files;
			  File folder = new File(path);
			  File[] listOfFiles = folder.listFiles(); 
			 
			  for (int i = 0; i < listOfFiles.length; i++) 
			  {
				  if (listOfFiles[i].isFile()) 
				  {
					  files = listOfFiles[i].getName();
				       if (files.endsWith(".data") || files.endsWith(".DATA"))
				       {
				         // System.out.println(files);
				          
				       // Read from disk using FileInputStream
				          FileInputStream f_in = new FileInputStream(files);

						// Read object using ObjectInputStream
						  ObjectInputStream obj_in = new ObjectInputStream (f_in);

						// Read an object
						  User _user = (User) obj_in.readObject();
							
						//Add to register
						  GUIRegister.userList.add(_user);
				       }
			     }
			  }
		} 
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		} 
		catch (ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		} 
		getCredentials();
	}
	
	public static String getCredentials()
	{
		try 
		{
			credentialFile.createNewFile();
			br = new BufferedReader(new FileReader(credentialFile));
			
			while((line = br.readLine()) != null)
			{
				//System.out.println(line);
				return line;
			}
		} 
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		return "";
	}
	
	public static void setCredentials(String _name, char [] _password)
	{
		  try
		  {
			  credentialFile.delete();
			  credentialFile.createNewFile();
			  // Create file 
			  FileWriter fstream = new FileWriter(credentialFile);
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.write(_name+":"+new String(_password));
			  //Close the output stream
			  out.close();
			  }
		  catch (Exception e) //Catch exception if any
		  {
			  System.out.println(e.getMessage());
		  }
	}

	public static boolean isAvailableId(String _username, char [] _password) 
	{
		for (User s : GUIRegister.userList)
		{
			if (s.getUsername().equals(_username)&&s.getPassword().equals(new String(_password)))
			{
				return false;
			}
		}
		return true;	
	}
	
	public static void updateUser(User _newUser)
	{
		try 
		{
			// Write to disk with FileOutputStream
			File _file = new File(_newUser.getUsername()+".data");
			_file.delete();
			
			FileOutputStream f_out = new FileOutputStream(_newUser.getUsername()+".data");

			// Write object with ObjectOutputStream
			ObjectOutputStream obj_out = new ObjectOutputStream (f_out);

			// Write object out to disk
			obj_out.writeObject(_newUser);
		} 
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		Repository.initialize();
	}
	
	public static void newUser(User _newUser)
	{
		try 
		{
			// Write to disk with FileOutputStream
			FileOutputStream f_out = new FileOutputStream(_newUser.getUsername()+".data");

			// Write object with ObjectOutputStream
			ObjectOutputStream obj_out = new ObjectOutputStream (f_out);

			// Write object out to disk
			obj_out.writeObject(_newUser );
			Repository.initialize();
		} 
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public static void removeCredentials() //Does not seem to work!
	{
		credentialFile.deleteOnExit();
	}
}