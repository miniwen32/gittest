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
		//�s�W
//		ausr.addAuthority("AU20","�����v��","���]�v�����e");
//		System.out.println("�s�W���\");
		//�ק�
//		ausr.updateAuthority("�ק��v��", "�ק鷺�e", "AU20");
//		System.out.println("�ק令�\");
		//�d�@��
//		AuthorityVO auvo = ausr.getOneAuthority("AU20");
//		System.out.println("�s��: " +auvo.getAuth_no());
//		System.out.println("�W��: " +auvo.getAuth_name());
//		System.out.println("���e: " +auvo.getAuth_note());
		
		//����
		List<AuthorityVO> list = ausr.getAll();
		for(AuthorityVO auvo: list) {
			System.out.println("�s��:  " + auvo.getAuth_no());
		}
		
		
	}
	
	
}
