package com.own_authority.model;

import java.util.*;

public interface Own_AuthorityDAO_interface {
	 public void insert(Own_AuthorityVO own_AuthorityVO);
	 public void delete(String ad_no,String au_no);
	 public List<Own_AuthorityVO> findByPrimaryKey(String ad_no);
	 public List<Own_AuthorityVO> getAll();
	}
