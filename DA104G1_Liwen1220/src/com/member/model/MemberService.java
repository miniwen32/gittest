package com.member.model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class MemberService {
	
	private MemberDAO_interface dao;
	
	public MemberService() {
		dao = new MemberJDBCDAO();
	}
	
	public MemberVO addMember(
			String mem_account,
			String mem_password,
			String mem_name, 
			String mem_addr,
			String mem_mobi,
			String mem_email,
			Integer point_count,
			Integer mre_count,
			String mem_status,
			Date birth,
			String gender,
			byte[] mem_pic,
			byte[] mem_pho,
			String mem_info) {
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setMem_account(mem_account);
		memberVO.setMem_password(mem_password);
		memberVO.setMem_name(mem_name);
		memberVO.setMem_addr(mem_addr);
		memberVO.setMem_mobi(mem_mobi);
		memberVO.setMem_email(mem_email);
		memberVO.setPoint_count(point_count);
		memberVO.setMre_count(mre_count);
		memberVO.setMem_status(mem_status);
		memberVO.setBirth(birth);
		memberVO.setGender(gender);
		memberVO.setMem_pic(mem_pic);
		memberVO.setMem_pho(mem_pho);
		memberVO.setMem_info(mem_info);
		dao.insert(memberVO);
		
		return memberVO;
	}
	
	public MemberVO updateMember(String mem_no,String mem_account,
			String mem_password,
			String mem_name, 
			String mem_addr,
			String mem_mobi,
			String mem_email,
			Integer point_count,
			Integer mre_count,
			String mem_status,
			Date birth,
			String gender,
			byte[] mem_pic,
			byte[] mem_pho,
			String mem_info) {
		MemberVO memberVO = new MemberVO();
		memberVO.setMem_no(mem_no);
		memberVO.setMem_account(mem_account);
		memberVO.setMem_password(mem_password);
		memberVO.setMem_name(mem_name);
		memberVO.setMem_addr(mem_addr);
		memberVO.setMem_mobi(mem_mobi);
		memberVO.setMem_email(mem_email);
		memberVO.setPoint_count(point_count);
		memberVO.setMre_count(mre_count);
		memberVO.setMem_status(mem_status);
		memberVO.setBirth(birth);
		memberVO.setGender(gender);
		memberVO.setMem_pic(mem_pic);
		memberVO.setMem_pho(mem_pho);
		memberVO.setMem_info(mem_info);
		dao.update(memberVO);
		
		return memberVO;
	}
	
	public void deleteMember(String mem_no) {
		dao.delete(mem_no);
	}
	public MemberVO getOneMember(String mem_no) {
		return	dao.findByPrimaryKey(mem_no);
	}
	
	public MemberVO loginMember(String mem_account) {
		return	dao.findByAccount(mem_account);
	}
	
	public List<MemberVO> getAll(){
		return dao.getAll();
	}
	
	public boolean isMemExist(String mem_account) {
		return dao.isMemExist(mem_account);
	}
	
	public  static void main(String[] args) {
		MemberService ms = new MemberService();
		byte[] pic1 = getPic("C:/liwen/5.jpg");
		byte[] pic2 = getPic("C:/liwen/6.jpg");
		
		//�s�W
//		ms.addMember("account","password","name","addr","mobi","email",1000,3,"0",java.sql.Date.valueOf("1911-01-06"),"0",pic1,pic2,"���մ���");
//		System.out.println("�s�W���\");
		//�ק�
//		ms.updateMember("M00010", "service", "service", "�睊���\", "�a�}", "�q��", "you@happy", 30000, 2, "1", java.sql.Date.valueOf("1989-01-06"), "1", pic1, pic2, "Service�睊���\!");
//		System.out.println("�ק令�\!");
		//�d�ߤ@��
//		MemberVO member =ms.getOneMember("M00010");
//		System.out.println(member.getMem_name());
//		System.out.println(member.getMem_info());
		
		//�b���d�ߤ@��
		MemberVO member =ms.loginMember("text123");
		System.out.println(member.getMem_name());
		System.out.println(member.getMem_info());
		//�d����
//		List<MemberVO> list = ms.getAll();
//		for(MemberVO mem:list) {
//			System.out.print(mem.getMem_name());
//			System.out.println(mem.getBirth());
//		}
	}
	
	//�Ϥ��i��Ʈw��k(�w�g�imyUtil)
	public static byte[] getPic(String path) {
		File file = new File(path);
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		
		try {
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[2048];
			int i;
			while ((i = fis.read(buffer)) != -1) {
				bao.write(buffer, 0, i);
			}
			bao.close();
			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException se) {
			se.printStackTrace();
		}
		return bao.toByteArray();
	}
	
}
