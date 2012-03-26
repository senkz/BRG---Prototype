package model;

public class Error 
{
	private int ID;
	private String name;
	private String message;
	private String comment;
	
	public Error(int _ID, String _message, String _comment, String _name)
	{
		ID = _ID;
		setName(_name);
		setMessage(_message);
		setComment(_comment);
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public String getComment()
	{
		return comment;
	}
	
	public void setName(String _name)
	{
		name = _name;
	}
	
	public void setMessage(String _message)
	{
		message = _message;
	}
	
	public void setComment(String _comment)
	{
		comment = _comment;
	}
}
