package com.cus_msg.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

public class Cus_MsgService {
	Cus_MsgDAO_interface cusdao = null;
	
	public Cus_MsgService() {
		cusdao = new Cus_MsgJDBCDAO();
	}  
	
	public Cus_MsgVO addCus_Msg(String mem_no, String ad_no,String msg_note) {
		Cus_MsgVO cus_msgVO = new Cus_MsgVO();
		
		cus_msgVO.setMem_no(mem_no);
		cus_msgVO.setAd_no(ad_no);
		cus_msgVO.setMsg_note(msg_note);
		cusdao.insert(cus_msgVO);
		return cus_msgVO;
	}
	
	public Cus_MsgVO updateCus_Msg(String mem_no,String ad_no,String msg_note, String cus_msg_no) {
		Cus_MsgVO cus_msgVO = new Cus_MsgVO();
		cus_msgVO.setMem_no(mem_no);
		cus_msgVO.setAd_no(ad_no);
		cus_msgVO.setMsg_note(msg_note);
		cus_msgVO.setCus_msg_no(cus_msg_no);
		cusdao.update(cus_msgVO);
		return cus_msgVO;
	}
	
	public Cus_MsgVO getOneCus_Msg(String mem_no,String ad_no) {
		return cusdao.findByPrimaryKey(mem_no,ad_no);
	}
	
	public List<Cus_MsgVO> getAll(){
		return cusdao.getAll();
	}
	
	public static void main(String[]args) {
	Cus_MsgService cusr = new Cus_MsgService();
	//new
//	cusr.addCus_Msg("M00001","AD00001","xxxxxx");
	//change
//	cusr.updateCus_Msg("M00001", "AD00001", "yyyyyyyyyyyy","CUM00010");
	//getone
//	Cus_MsgVO csvo = cusr.getOneCus_Msg("M00001","AD00001");
//	System.out.println(csvo.getMsg_note());
//	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//	System.out.println(df.format(csvo.getMsg_time()));
	
	//getall
//	List<Cus_MsgVO> list = cusr.getAll();
//	for(Cus_MsgVO cuvo : list) {
//		System.out.println(cuvo.getMem_no());
//		System.out.println(cuvo.getMsg_note());
//	}
}
}
