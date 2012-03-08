package model;

import java.util.Calendar;

public class Application 
{
	private String name;
	private String comment;
	private Calendar creationDate;
	private Calendar lastEdited;
	
	public Application(String _name, String _comment, Calendar _creationDate, Calendar _lastEdited)
	{
		setName(_name);
		setComment(_comment);
		setLastEdited(lastEdited);
		creationDate = _creationDate;
	}

	public String getName()
	{
		return name;
	}
	
	public String getComment()
	{
		return comment;
	}
	
	public Calendar getCreationDate()
	{
		return creationDate;
	}
	
	public Calendar getLastEdited()
	{
		return lastEdited;
	}
	
	private void setName(String _name) 
	{
		name = _name;
	}

	private void setComment(String _comment)
	{
		comment = _comment;
	}
	
	private void setLastEdited(Calendar _lastEdited)
	{		
		lastEdited = _lastEdited;
	}
}