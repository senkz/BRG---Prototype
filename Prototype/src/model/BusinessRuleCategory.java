package model;

public class BusinessRuleCategory 
{
	private int ID;
	private String name;
	
	public BusinessRuleCategory(int _ID, String _name)
	{
		setName(_name);
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return name ;
	}
	
	public void setName(String _name)
	{
		name = _name ;
	}

}
