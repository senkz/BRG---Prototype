package model;

public class BusinessRule 
{
	private int ID;
	private String name;
	
	public BusinessRule(int _ID, String _name)
	{
		ID = _ID;
		setName(_name);
	}
	
	public int getID() 
	{
		return ID;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String _name) 
	{
		name = _name;
	}
}