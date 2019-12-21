package com.administrator.model;

import java.util.List;
public interface AdministratorDAO_interface {
	public void insert(AdministratorVO administratorVO);
	public void update(AdministratorVO administratorVO);
	public AdministratorVO findByPrimaryKey(String ad_no);
	public AdministratorVO findByAccount(String ad_account);
	public boolean isAdExist(String ad_account);
	public List<AdministratorVO> getAll();
	
}
