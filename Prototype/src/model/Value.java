package model;

public class Value {
	private int vl_id;
	private String value;
	private int cv_fk;
	
	public int getVl_id() {
		return vl_id;
	}
	public void setVl_id(int vl_id) {
		this.vl_id = vl_id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getCv_fk() {
		return cv_fk;
	}
	public void setCv_fk(int cv_fk) {
		this.cv_fk = cv_fk;
	}
	
}
