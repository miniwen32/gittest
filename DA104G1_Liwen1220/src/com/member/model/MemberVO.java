package com.member.model;
import java.sql.*;
public class MemberVO implements java.io.Serializable {
	private String mem_no;
	private String mem_account;
	private String mem_password;
	private String mem_name;
	private String mem_addr;
	private String mem_mobi;
	private Date sign_up_date;
	private String mem_email;
	private Integer point_count;
	private Integer mre_count;
	private String mem_status;
	private Date birth;
	private String gender;
	private byte[] mem_pic;
	private byte[] mem_pho;
	private String mem_info;
	
	public MemberVO() {
		super();
	}
	
	public byte[] getMem_pho() {
		return mem_pho;
	}
	public void setMem_pho(byte[] mem_pho) {
		this.mem_pho = mem_pho;
	}
	public String getMem_info() {
		return mem_info;
	}
	public void setMem_info(String mem_info) {
		this.mem_info = mem_info;
	}
	
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	public String getMem_account() {
		return mem_account;
	}
	public void setMem_account(String mem_account) {
		this.mem_account = mem_account;
	}
	public String getMem_password() {
		return mem_password;
	}
	public void setMem_password(String mem_password) {
		this.mem_password = mem_password;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	public String getMem_mobi() {
		return mem_mobi;
	}
	public void setMem_mobi(String mem_mobi) {
		this.mem_mobi = mem_mobi;
	}
	public Date getSign_up_date() {
		return sign_up_date;
	}
	public void setSign_up_date(Date sign_up_date) {
		this.sign_up_date = sign_up_date;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public Integer getPoint_count() {
		return point_count;
	}
	public void setPoint_count(Integer point_count) {
		this.point_count = point_count;
	}
	public Integer getMre_count() {
		return mre_count;
	}
	public void setMre_count(Integer mre_count) {
		this.mre_count = mre_count;
	}
	public String getMem_status() {
		return mem_status;
	}
	public void setMem_status(String mem_status) {
		this.mem_status = mem_status;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public byte[] getMem_pic() {
		return mem_pic;
	}
	public void setMem_pic(byte[] mem_pic) {
		this.mem_pic = mem_pic;
	}
	
	
}
