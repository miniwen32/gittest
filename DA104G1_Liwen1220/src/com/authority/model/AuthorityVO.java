package com.authority.model;
import java.sql.*;
public class AuthorityVO implements java.io.Serializable {
	private String auth_no;
	private String auth_name;
	private String auth_note;
	
	
	public AuthorityVO() {
		super();
	}
	public String getAuth_no() {
		return auth_no;
	}
	public void setAuth_no(String auth_no) {
		this.auth_no = auth_no;
	}
	public String getAuth_name() {
		return auth_name;
	}
	public void setAuth_name(String auth_name) {
		this.auth_name = auth_name;
	}
	public String getAuth_note() {
		return auth_note;
	}
	public void setAuth_note(String auth_note) {
		this.auth_note = auth_note;
	}
	
}
