package model.rules;

import model.BusinessRule;

public class BusinessRuleType 
{
	private int ID;
	private String name;
	private String message;
	private String comment;
	protected BusinessRule businessRule;

	
	public BusinessRuleType(int _ID, String _name, BusinessRule _businessRule)
	{
		ID = _ID;
		setName(_name);
		setBusinessRule(_businessRule);
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
		
	public BusinessRule getBusinessRule()
	{
		return businessRule;
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
	
	private void setBusinessRule(BusinessRule _businessRule) 
	{
		businessRule = _businessRule;
	}

	public String generate() 
	{
		return null;
	}
}