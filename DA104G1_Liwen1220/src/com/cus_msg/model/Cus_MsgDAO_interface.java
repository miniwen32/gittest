package com.cus_msg.model;

import java.util.*;

public interface Cus_MsgDAO_interface {
	public void insert(Cus_MsgVO cus_MsgVO);
	public void update(Cus_MsgVO cus_MsgVO);
	public Cus_MsgVO findByPrimaryKey(String mem_no,String ad_no);
	public List<Cus_MsgVO> getAll();
}
