package com.authority.model;

import java.util.List;

public class AuthorityService {
	AuthorityDAO_interface audao;
	
	public AuthorityService() {
		audao = new AuthorityJDBCDAO();	
	}
	
	public AuthorityVO addAuthority(String auth_no,String auth_name,String auth_note) {
		AuthorityVO authorityVO = new AuthorityVO();
		
		authorityVO.setAuth_no(auth_no);
		authorityVO.setAuth_name(auth_name);
		authorityVO.setAuth_note(auth_note);
		audao.insert(authorityVO);
		return authorityVO;
	}
	
	public AuthorityVO updateAuthority(String auth_name,String auth_note,String auth_no) {
		AuthorityVO authorityVO = new AuthorityVO();
		
		authorityVO.setAuth_name(auth_name);
		authorityVO.setAuth_note(auth_note);
		authorityVO.setAuth_no(auth_no);
		audao.update(authorityVO);
		
		return authorityVO;
	}
	
	public AuthorityVO getOneAuthority(String auth_no) {
		return audao.findByPrimaryKey(auth_no);
	}
	
	public List<AuthorityVO> getAll(){
		return audao.getAll();
	}
	
	public static void main(String[]args) {
		AuthorityService ausr = new AuthorityService();
		//新增
//		ausr.addAuthority("AU20","測試權限","測設權限內容");
//		System.out.println("新增成功");
		//修改
//		ausr.updateAuthority("修改權限", "修改內容", "AU20");
//		System.out.println("修改成功");
		//查一個
//		AuthorityVO auvo = ausr.getOneAuthority("AU20");
//		System.out.println("編號: " +auvo.getAuth_no());
//		System.out.println("名稱: " +auvo.getAuth_name());
//		System.out.println("內容: " +auvo.getAuth_note());
		
		//全部
		List<AuthorityVO> list = ausr.getAll();
		for(AuthorityVO auvo: list) {
			System.out.println("編號:  " + auvo.getAuth_no());
		}
		
		
	}
	
	
}
