package model;

public class Value 
{
	private int ID;
	private Object value;
	private String valueString;
//	private boolean isTable;
	
	public Value(int _ID, Object _value, String _valueString)
	{
		ID = _ID;
		setValue(_value);
		setValueString(_valueString);
	}

	public Value(int _ID, String _valueString) {
		ID = _ID;
		setValueString(_valueString);
	}

	public int getID()
	{
		return ID;
	}
	
	public void setValueString(String _valueString)
	{
		valueString = _valueString;
	}
	
	public String getValueString()
	{
		return valueString;
	}
	
	public Object getValue()
	{
		return value;
	}
	
	private void setValue(Object _value) 
	{
		value = _value;
	}
	
}
