package com.authority.model;

import java.util.List;

public interface AuthorityDAO_interface {
	public void insert(AuthorityVO authorityVO);
	public void update(AuthorityVO authorityVO);
	public AuthorityVO findByPrimaryKey(String auth_no);
	public List<AuthorityVO> getAll();
}
