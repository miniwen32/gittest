package com.own_authority.model;
import java.sql.*;
public class Own_AuthorityVO implements java.io.Serializable {
	private String ad_no;
	private String auth_no;
	
	public Own_AuthorityVO() {
		super();
	}
	public String getAd_no() {
		return ad_no;
	}
	public void setAd_no(String ad_no) {
		this.ad_no = ad_no;
	}
	public String getAuth_no() {
		return auth_no;
	}
	public void setAuth_no(String auth_no) {
		this.auth_no = auth_no;
	}
}
