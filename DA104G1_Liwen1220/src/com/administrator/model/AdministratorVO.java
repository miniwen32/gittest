package com.administrator.model;

import java.sql.*;

public class AdministratorVO implements java.io.Serializable {

	private String ad_no;
	private String ad_account;
	private String ad_password;
	private String ad_name;
	private String ad_addr;
	private String ad_mobi;
	private Date ad_wdate;
	private String ad_email;
	private String ad_status;
	
	public AdministratorVO() {
		super();
	}
	public String getAd_no() {
		return ad_no;
	}
	public void setAd_no(String ad_no) {
		this.ad_no = ad_no;
	}
	public String getAd_account() {
		return ad_account;
	}
	public void setAd_account(String ad_account) {
		this.ad_account = ad_account;
	}
	public String getAd_password() {
		return ad_password;
	}
	public void setAd_password(String ad_password) {
		this.ad_password = ad_password;
	}
	public String getAd_name() {
		return ad_name;
	}
	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}
	public String getAd_addr() {
		return ad_addr;
	}
	public void setAd_addr(String ad_addr) {
		this.ad_addr = ad_addr;
	}
	public String getAd_mobi() {
		return ad_mobi;
	}
	public void setAd_mobi(String ad_mobi) {
		this.ad_mobi = ad_mobi;
	}
	public Date getAd_wdate() {
		return ad_wdate;
	}
	public void setAd_wdate(Date ad_wdate) {
		this.ad_wdate = ad_wdate;
	}
	public String getAd_email() {
		return ad_email;
	}
	public void setAd_email(String ad_email) {
		this.ad_email = ad_email;
	}
	public String getAd_status() {
		return ad_status;
	}
	public void setAd_status(String ad_status) {
		this.ad_status = ad_status;
	}
	
	
}
