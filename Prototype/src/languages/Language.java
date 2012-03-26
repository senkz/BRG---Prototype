package languages;

public interface Language 
{

	public String getInitiateFunction() ;
	
	
	public String getReplaceFunction();

	
	public String getBeforeTrigger();

	
	public String getAfterTrigger();


	public String getUpdateTrigger();


	public String getCreateTrigger();

	public String getDeleteTrigger();

	public String getBegin();
	
	public String getStartIf();
	
	public String getCloseIf();
	
	public String getPrintLine();
	
	public String getRaiseError();
	
	public String getAction();
	
	public String getActionClose();
	
	public String getClose();
	
	public String getFunction();
	
	public String getOldReference();
	
	public String getAndFunction();
	
	public String getBetweenFunction();
}
