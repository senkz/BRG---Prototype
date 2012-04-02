package model;

public class BusinessRule {
	private int br_id;
	private String name;
	private int brt_fk;
	private int err_fk;
	private int app_fk;
	private int tg_fk;
	
	public String toString() {
		return this.name;
	}
	
	public int getBr_id() {
		return br_id;
	}
	public void setBr_id(int br_id) {
		this.br_id = br_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBrt_fk() {
		return brt_fk;
	}
	public void setBrt_fk(int brt_fk) {
		this.brt_fk = brt_fk;
	}
	public int getErr_fk() {
		return err_fk;
	}
	public void setErr_fk(int err_fk) {
		this.err_fk = err_fk;
	}
	public int getApp_fk() {
		return app_fk;
	}
	public void setApp_fk(int app_fk) {
		this.app_fk = app_fk;
	}
	public int getTg_fk() {
		return tg_fk;
	}
	public void setTg_fk(int tg_fk) {
		this.tg_fk = tg_fk;
	}
}
