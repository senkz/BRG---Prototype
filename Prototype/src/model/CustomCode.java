package model;

public class CustomCode {
	private int cc_id;
	private String customcode;
	private int op_fk;
	
	public int getCc_id() {
		return cc_id;
	}
	public void setCc_id(int cc_id) {
		this.cc_id = cc_id;
	}
	public String getCustomcode() {
		return customcode;
	}
	public void setCustomcode(String customcode) {
		this.customcode = customcode;
	}
	public int getOp_fk() {
		return op_fk;
	}
	public void setOp_fk(int op_fk) {
		this.op_fk = op_fk;
	}
}