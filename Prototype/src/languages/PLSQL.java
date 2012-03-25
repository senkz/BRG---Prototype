package languages;


public class PLSQL extends Language
{
	private String initiateFunction = "CREATE";
	private String replaceFunction = "OR REPLACE";
	private String function = "TRIGGER";
	
	private String beforeTrigger = "BEFORE";
	private String afterTrigger = "AFTER";
	
	private String updateTrigger = "UPDATE";
	private String createTrigger = "CREATE";
	private String deleteTrigger = "DELETE";
	
	private String begin = "BEGIN";
	
	private String startIf;
	private String closeIf;
	
	private String printLine;
	private String raiseError;
	
	private String action;
	private String actionClose;
	private String close;
	
	public String getInitiateFunction() 
	{
		return initiateFunction;
	}

	public String getReplaceFunction()
	{
		return replaceFunction;
	}
	
	public String getFunction()
	{
		return function;
	}
	
	public String getBeforeTrigger()
	{
		return beforeTrigger;
	}
	
	public String getAfterTrigger()
	{
		return afterTrigger;
	}

	public String getUpdateTrigger()
	{
		return updateTrigger;
	}

	public String getCreateTrigger()
	{
		return createTrigger;
	}

	public String getDeleteTrigger()
	{
		return deleteTrigger;
	}

	public String getBegin()
	{
		return begin;		
	}
	
	public String getStartIf()
	{
		return startIf;		
	}
	
	public String getCloseIf()
	{
		return closeIf;
	}
	
	public String printLine()
	{
		return printLine;
	}
	
	public String raiseError()
	{
		return raiseError;
	}
	
	public String getAction()
	{
		return action;
	}
	
	public String getActionClose()
	{
		return actionClose;
	}
	
	public String getClose()
	{
		return close;
	}
}
