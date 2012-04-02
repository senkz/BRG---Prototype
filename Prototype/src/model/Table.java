package model;

public class Table {
	private int tb_id;
	private String name;
	private int db_fk;
	
	public int getTb_id() {
		return tb_id;
	}
	public void setTb_id(int tb_id) {
		this.tb_id = tb_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDb_fk() {
		return db_fk;
	}
	public void setDb_fk(int db_fk) {
		this.db_fk = db_fk;
	}
}