package model;

import java.util.ArrayList;

import languages.Language;


public class BusinessRule 
{
	private int ID;
	private boolean replace; //Optioneel!! ALIJD CREATE OR REPLACE!
	private String name;
	public Error error;
	public Trigger trigger;
	public Application application;
	public ArrayList<Operator> operators;
	public BusinessRuleCategory _businessRuleCategory;
	public Language language;
	
	private int Ierror;
	private int Itrigger;
	private int IbrType;
	private int Iapplication;
	
	public BusinessRule(String s)
	{
		name = s;
	}
	
	public BusinessRule(int _ID, boolean _replace,String _name, Error _error, Trigger _trigger, Application _application, ArrayList<Operator> _operators, BusinessRuleCategory _businessRuleCategory, Language _language)
	{
		ID = _ID;
		setName(_name);
		setError(_error);
		setReplace(_replace);
		setTrigger(_trigger);
		setApplication(_application);
		setOperator(_operators);
		setBusinessRuleCategory(_businessRuleCategory);
		setLanguage(_language);
	}

	public BusinessRule(int _ID, boolean _replace, String _name, int _error, int _trigger, int _application, ArrayList<Operator> _operators, int _businessruleType, Language _language) {
		ID = _ID;
		setReplace(_replace);
		Itrigger = _trigger;
		Ierror = _error;
		IbrType = _businessruleType;
		Iapplication = _application;
		setOperator(_operators);
		setLanguage(_language);
		setName(_name);
	}
	
	public int getItrigger() {
		return Itrigger;
	}
	
	public int getIerror() {
		return Ierror;
	}
	
	public int getIbrTtype() {
		return IbrType;
	}
	
	public int getIapplication() {
		return Iapplication;
	}

	private void setBusinessRuleCategory
	(
		BusinessRuleCategory _businessRuleCategory2) {		
	}

	public int getID() 
	{
		return ID;
	}
	
	public String getName()
	{
		return name;
	}
	
	
	public Error getError()
	{
		return error;
	}
	
	public Language getLanguage()
	{
		return language;
	}

	public void setLanguage(Language _language)
	{
		language = _language ;
	}

	
	public void setName(String _name) 
	{
		name = _name;
	}
	
	public void setError(Error _error)
	{
		error = _error;
	}

	public void setTrigger(Trigger _trigger) {
		trigger = _trigger;
	}

	public Trigger getTrigger() {
		return trigger;
	}

	public void setApplication(Application _application)
	{
		application = _application;
	}

	public Application getApplication()
	{
		return application;
	}

	public void setOperator(ArrayList<Operator> _operators)
	{
		operators = _operators;
	}

	public ArrayList<Operator> getOperatorList()
	{
		return operators;
	}
	
//	public boolean addOperator(Operator _operator)
//	{
//		for(Operator o : operatorList)
//		{
//			if (o.equals(_operator))
//			{
//				return false;	//Operator already exists
//			}
//		}
//		operatorList.add(_operator);
//		return true;
//	}
//	
//	public boolean removeOperator(Operator _operator)
//	{
//		for(Operator o : operatorList)
//		{
//			if (o.equals(_operator))
//			{
//				return false;	//Operator already exists
//			}
//		}
//		operatorList.remove(_operator);
//		return true;	
//	}


	public void setReplace(boolean _replace) 
	{
		replace = _replace;
	}

	public boolean isReplace() {
		return replace;
	}
}