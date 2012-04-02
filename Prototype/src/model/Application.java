package model;

import java.sql.Date;

public class Application {
	private int app_id;
	private String app_comment;
	private Date creationDate;
	private String name;
	private Date lastEdited;
	
	public int getApp_id() {
		return app_id;
	}
	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}
	public String getApp_comment() {
		return app_comment;
	}
	public void setApp_comment(String app_comment) {
		this.app_comment = app_comment;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getLastEdited() {
		return lastEdited;
	}
	public void setLastEdited(Date lastEdited) {
		this.lastEdited = lastEdited;
	}
}