package model;

public class TableColumn {
	private int tbc_id;
	private String name;
	private String type;
	private int tb_fk;
	
	public int getTbc_id() {
		return tbc_id;
	}
	public void setTbc_id(int tbc_id) {
		this.tbc_id = tbc_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getTb_fk() {
		return tb_fk;
	}
	public void setTb_fk(int tb_fk) {
		this.tb_fk = tb_fk;
	}
}