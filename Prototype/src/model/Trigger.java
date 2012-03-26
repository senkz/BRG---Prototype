package model;

public class Trigger 
{
	private int ID;
	public Table table;
	private String event; //Only valid states are allowed like: Before Update etc.!
	
	public Trigger(int _ID, Table _table, String _event)
	{
		ID = _ID;
		table = _table;
		setEvent(_event);
	}
	
	public Trigger(int _ID, String _event) {
		ID = _ID;
		setEvent(_event);
	}

	public int getID()
	{
		return ID;
	}
	
	public Table getTable()
	{
		return table;
	}
	
	public String getEvent()
	{
		return event;
	}
	
	public void setEvent(String _event)
	{
		event = _event;
	}
	
	public void setTable(Table _table)
	{
		table = _table;
	}
}