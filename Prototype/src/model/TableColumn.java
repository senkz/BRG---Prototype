package model;

public class TableColumn 
{
	private int ID;
	private String name;
	private String type;
	
	public TableColumn(int _ID, String _name, String _type)
	{
		ID = _ID;
		setName(_name);
		setType(_type);
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setName(String _name)
	{
		name = _name;
	}
	
	public void setType(String _type)
	{
		type = _type;
	}
}