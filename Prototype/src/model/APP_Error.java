package model;

public class APP_Error {
	private int err_id;
	private int code;
	private String err_comment;
	private String name;
	
	public int getErr_id() {
		return err_id;
	}
	public void setErr_id(int err_id) {
		this.err_id = err_id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getErr_comment() {
		return err_comment;
	}
	public void setErr_comment(String err_comment) {
		this.err_comment = err_comment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
