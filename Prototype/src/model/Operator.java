package model;


public class Operator {
	private int op_id;
	private String operator;
	private String samerow;
	private int br_fk;
	private int tc1_fk;
	private int tc2_fk;
	private int cv_fk;
	
	public int getOp_id() {
		return op_id;
	}
	public void setOp_id(int op_id) {
		this.op_id = op_id;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getSamerow() {
		return samerow;
	}
	public void setSamerow(String samerow) {
		this.samerow = samerow;
	}
	public int getBr_fk() {
		return br_fk;
	}
	public void setBr_fk(int br_fk) {
		this.br_fk = br_fk;
	}
	public int getTc1_fk() {
		return tc1_fk;
	}
	public void setTc1_fk(int tc1_fk) {
		this.tc1_fk = tc1_fk;
	}
	public int getTc2_fk() {
		return tc2_fk;
	}
	public void setTc2_fk(int tc2_fk) {
		this.tc2_fk = tc2_fk;
	}
	public int getCv_fk() {
		return cv_fk;
	}
	public void setCv_fk(int cv_fk) {
		this.cv_fk = cv_fk;
	}
}