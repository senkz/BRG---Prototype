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
	
	/**
	 * Expect of the following chars, U,I,D
	 * @param String
	 */
	public void setEvent(String s)
	{
		char[] chars = s.toCharArray();
		int i = 0;
		s = "";
		
		for (char c : chars) {
			switch (c) {
			case 'U':
				s += (i!=0) ? " OR UPDATE" : "UPDATE";i++;
				break;
			case 'I':
				s += (i!=0) ? " OR INSERT" : "INSERT";i++;
				break;
			case 'D':
				s += (i!=0) ? " OR DELETE" : "DELETE";i++;
				break;
			}
		}
		
		this.event = s;
	}
	
	public void setTable(Table _table)
	{
		table = _table;
	}
}