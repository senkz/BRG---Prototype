package model;

public class BusinessRuleType {
	private int brt_id;
	private String code;
	private String brt_comment;
	private String name;
	private int cat_fk;
	private int err_fk;
	
	public int getBrt_id() {
		return brt_id;
	}
	public void setBrt_id(int brt_id) {
		this.brt_id = brt_id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBrt_comment() {
		return brt_comment;
	}
	public void setBrt_comment(String brt_comment) {
		this.brt_comment = brt_comment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCat_fk() {
		return cat_fk;
	}
	public void setCat_fk(int cat_fk) {
		this.cat_fk = cat_fk;
	}
	public int getErr_fk() {
		return err_fk;
	}
	public void setErr_fk(int err_fk) {
		this.err_fk = err_fk;
	}
}