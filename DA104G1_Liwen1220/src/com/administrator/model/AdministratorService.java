package com.administrator.model;

import java.util.List;

public class AdministratorService {
	
	private AdministratorDAO_interface addao;
	
	public AdministratorService() {
		addao = new AdministratorJDBCDAO();
	} 
	
	public AdministratorVO addAdministrator(
			String ad_account,
			String ad_password, 
			String ad_name, 
			String ad_addr, 
			String ad_mobi,
			String ad_email,
			String ad_status) {
		AdministratorVO administratorVO = new AdministratorVO();
		
		administratorVO.setAd_account(ad_account);
		administratorVO.setAd_password(ad_password);
		administratorVO.setAd_name(ad_name);
		administratorVO.setAd_addr(ad_addr);
		administratorVO.setAd_mobi(ad_mobi);
		administratorVO.setAd_email(ad_email);
		administratorVO.setAd_status(ad_status);
		addao.insert(administratorVO);
		return administratorVO;
	}
	
	public AdministratorVO updateAdministrator(
			String ad_account,
			String ad_password, 
			String ad_name, 
			String ad_addr, 
			String ad_mobi,
			String ad_email,
			String ad_status,
			String ad_no
			) {
		AdministratorVO administratorVO = new AdministratorVO();
		administratorVO.setAd_account(ad_account);
		administratorVO.setAd_password(ad_password);
		administratorVO.setAd_name(ad_name);
		administratorVO.setAd_addr(ad_addr);
		administratorVO.setAd_mobi(ad_mobi);
		administratorVO.setAd_email(ad_email);
		administratorVO.setAd_status(ad_status);
		administratorVO.setAd_no(ad_no);
		
		addao.update(administratorVO);
		return administratorVO;
	}
	
	public AdministratorVO getOneAndministrator(String ad_no) {
		return addao.findByPrimaryKey(ad_no);
	}
	
	public AdministratorVO loginAdministrator(String ad_account) {
		return addao.findByAccount(ad_account);
	}
	
	public List<AdministratorVO> getAll(){
		return addao.getAll();
	}
	
	public Boolean isAdExist(String ad_account) {
		return addao.isAdExist(ad_account);
	}
	
	public static void main(String[]args) {
		AdministratorService adsr = new AdministratorService();
		//�s�W
//		adsr.addAdministrator("account","paswword","name","addr","mobi","email","0");
//		System.out.println("�s�W���\!");
		//�ק�
//		adsr.updateAdministrator("change","paswword","name","addr","mobi","email","0","AD00006");
		//�d�@��
//		AdministratorVO advo = adsr.getOneAndministrator("AD00001");
//		System.out.println(advo.getAd_account());
//		System.out.println(advo.getAd_password());
		
		//�b���d�@��
//		AdministratorVO advo = adsr.logginAndministrator("b12345");
//		System.out.println(advo.getAd_account());
//		System.out.println(advo.getAd_password());
		
		//�d����
		List<AdministratorVO> list = adsr.getAll();
		for(AdministratorVO advo :list) {
			System.out.print("�W�r: "+advo.getAd_name() +",");
			System.out.print("�b��: "+advo.getAd_account() +",");
			System.out.println("�K�X: "+advo.getAd_password());
		}
		
	}
}
