package com.member.model;
import java.util.*;
public interface MemberDAO_interface {
	public void insert(MemberVO memberVO);
	public void update(MemberVO memberVO);
	public void delete(String mem_no);
	public MemberVO findByPrimaryKey(String mem_no);
	public MemberVO findByAccount(String mem_account);
	public boolean isMemExist(String mem_account);
	public List<MemberVO> getAll();
}
