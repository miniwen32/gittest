package com.own_authority.model;

import java.util.List;

public class Own_AuthorityService {
	Own_AuthorityDAO_interface owndao = null;
	
	public Own_AuthorityService () {
		owndao = new Own_AuthorityJDBCDAO();
	}
	
	public Own_AuthorityVO addOwn_Authority(String ad_no,String auth_no) {
		Own_AuthorityVO own_authorityVO = new Own_AuthorityVO();
		own_authorityVO.setAd_no(ad_no);
		own_authorityVO.setAuth_no(auth_no);
		owndao.insert(own_authorityVO);
		return own_authorityVO;
	}
	
	public void deleteOwn_Authority(String ad_no,String auth_no) {
		owndao.delete(ad_no, auth_no);
	}
	
	public List<Own_AuthorityVO> getOneOwn_Authority(String ad_no){
		return owndao.findByPrimaryKey(ad_no);
	}
	
	public List<Own_AuthorityVO> getAll(){
		return owndao.getAll();
	}
	
	public static void main(String[]args) {
		Own_AuthorityService ownsr = new Own_AuthorityService();
		//new
//		ownsr.addOwn_Authority("AD00006", "AU20");
//		System.out.println("done");
		//getone
//		List<Own_AuthorityVO> list = ownsr.getOneOwn_Authority("AD00001");
//		for(Own_AuthorityVO own:list) {
//			System.out.println(own.getAd_no());
//			System.out.println(own.getAuth_no());
//		}
		
		//getall
//		List<Own_AuthorityVO> list = ownsr.getAll();
//		for(Own_AuthorityVO own:list) {
//			System.out.println(own.getAd_no());
//			System.out.println(own.getAuth_no());
//		}

		//delete
		ownsr.deleteOwn_Authority("AD00004","AU01");
		System.out.println("delete done");
	}
	
	
	
	
}
