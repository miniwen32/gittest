package com.cus_msg.model;
import java.sql.*;
public class Cus_MsgVO implements java.io.Serializable {
	private String cus_msg_no;
	private String mem_no;
	private String ad_no;
	private String msg_note;
	private Timestamp msg_time;
	
	
	public Cus_MsgVO() {
		super();
	}
	public String getCus_msg_no() {
		return cus_msg_no;
	}
	public void setCus_msg_no(String cus_msg_no) {
		this.cus_msg_no = cus_msg_no;
	}
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	public String getAd_no() {
		return ad_no;
	}
	public void setAd_no(String ad_no) {
		this.ad_no = ad_no;
	}
	public String getMsg_note() {
		return msg_note;
	}
	public void setMsg_note(String msg_note) {
		this.msg_note = msg_note;
	}
	public Timestamp getMsg_time() {
		return msg_time;
	}
	public void setMsg_time(Timestamp msg_time) {
		this.msg_time = msg_time;
	}
}
