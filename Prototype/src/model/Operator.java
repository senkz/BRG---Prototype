package model;

import java.util.ArrayList;

public class Operator 
{
	private Value declaredValue;
	private Value comparativeValue;
	
	private boolean sameRow;
	
	ArrayList<String> operatorList = new ArrayList<String>();
	
	private String equalsOperator = "=";
	private String notEqualsOperator = "!=";
	private String greaterThanOperator = ">";
	private String lesserThanOperator = "<";
	private String greaterThanOrEqualsOperator = "=>";
	private String lesserThanOrEqualsOperator = "=>";
	private String operator;
	
	private int ID;
	private int samerow;
	private int tableColumn1;
	private int tableColumn2;
	private int collectionValue;
	
//	private Table _emptyTable = new Table();
//	private String _emptyString = "";
	
	public Operator(Value _declaredValue, String _operator, Value _comparativeValue, boolean _sameRow)// throws Exception
	{
		if
		(
			  !_operator.equals(equalsOperator)
			||!_operator.equals(notEqualsOperator)
			||!_operator.equals(greaterThanOperator)
			||!_operator.equals(lesserThanOperator)
			||!_operator.equals(greaterThanOrEqualsOperator)
			||!_operator.equals(lesserThanOrEqualsOperator)
		)
		{
			//throw new Exception("Operator is invalid");
		}
		operator = _operator;
		declaredValue = _declaredValue;
		comparativeValue = _comparativeValue;
		setSameRow(_sameRow);
	}

	public Operator(int _ID, String operator, int samerow, int tableColumn1, int tableColumn2, int collectionValue) {
		this.setID(_ID);
		this.setOperator(operator);
		this.setSamerow(samerow);
		this.setTableColumn1(tableColumn1);
		this.setTableColumn2(tableColumn2);
		this.setCollectionValue(collectionValue);
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getSamerow() {
		return samerow;
	}

	public void setSamerow(int samerow) {
		this.samerow = samerow;
	}

	public int getTableColumn1() {
		return tableColumn1;
	}

	public void setTableColumn1(int tableColumn1) {
		this.tableColumn1 = tableColumn1;
	}

	public int getTableColumn2() {
		return tableColumn2;
	}

	public void setTableColumn2(int tableColumn2) {
		this.tableColumn2 = tableColumn2;
	}

	public int getCollectionValue() {
		return collectionValue;
	}

	public void setCollectionValue(int collectionValue) {
		this.collectionValue = collectionValue;
	}

	public void setSameRow(boolean _sameRow) 
	{
		_sameRow = sameRow;
	}

	public boolean isSameRow() 
	{
		return sameRow;
	}
	
	public Value getDeclaredValue()
	{
		return declaredValue;
	}
	
	public Value getComparativeValue()
	{
		return comparativeValue;
	}
	
	public String getOperator()
	{
		return operator;
	}
	
	public void setOperator(String s)
	{
		this.operator = s;
	}

	public String toString()
	{
//		String s = "";
//		if(declaredValue.getClass().equals(_emptyTable.getClass()))
//		{
//			declaredValue.
//		}
		return declaredValue.getValue() + " " +operator + " " + comparativeValue.getValue();
	}
}