package com.cus_msg.model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Cus_MsgJDBCDAO implements Cus_MsgDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "DA104G1";
	String passwd = "DA104G1";

	private static final String INSERT_STMT = "INSERT INTO CUS_MSG(CUS_MSG_NO,MEM_NO,AD_NO,MSG_NOTE) VALUES (('CUM'||LPAD(SEQ_CUS_MSG_NO.NEXTVAL,5,'0')),?,?,?)";
//	private static final String GET_ALL_STMT = "SELECT CUS_MSG_NO,MEM_NO,AD_NO,MSG_NOTE,MSG_TIME FROM CUS_MSG ORDER BY MSG_TIME DESC";
	private static final String GET_ALL_STMT = "SELECT * FROM CUS_MSG ORDER BY MSG_TIME DESC";
	private static final String GET_ONE_STMT = "SELECT CUS_MSG_NO,MEM_NO,AD_NO,MSG_NOTE,MSG_TIME FROM CUS_MSG where MEM_NO=? and AD_NO=?";
	private static final String UPDATE = "UPDATE CUS_MSG SET MEM_NO=?,AD_NO=?,MSG_NOTE=? ,MSG_TIME=systimestamp WHERE CUS_MSG_NO=?";

	@Override
	public void insert(Cus_MsgVO cus_MsgVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, cus_MsgVO.getMem_no());
			pstmt.setString(2, cus_MsgVO.getAd_no());
			pstmt.setString(3, cus_MsgVO.getMsg_note());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(Cus_MsgVO cus_MsgVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, cus_MsgVO.getMem_no());
			pstmt.setString(2, cus_MsgVO.getAd_no());
			pstmt.setString(3, cus_MsgVO.getMsg_note());
			pstmt.setString(4, cus_MsgVO.getCus_msg_no());
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public Cus_MsgVO findByPrimaryKey(String mem_no,String ad_no) {
		Cus_MsgVO cus_MsgVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,userid,passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setString(1,mem_no);
			pstmt.setString(2,ad_no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cus_MsgVO = new Cus_MsgVO();
				cus_MsgVO.setCus_msg_no(rs.getString("cus_msg_no"));
				cus_MsgVO.setMem_no(rs.getString("mem_no"));
				cus_MsgVO.setAd_no(rs.getString("ad_no"));
				cus_MsgVO.setMsg_note(rs.getString("msg_note"));
				cus_MsgVO.setMsg_time(rs.getTimestamp("msg_time"));
			}
			}catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. " + se.getMessage());
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
			return cus_MsgVO;
	}

	@Override
	public List<Cus_MsgVO> getAll() {
		List<Cus_MsgVO> list = new ArrayList<Cus_MsgVO>();
		Cus_MsgVO cus_MsgVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,userid,passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cus_MsgVO = new Cus_MsgVO();
				cus_MsgVO.setCus_msg_no(rs.getString("cus_msg_no"));
				cus_MsgVO.setMem_no(rs.getString("mem_no"));
				cus_MsgVO.setAd_no(rs.getString("ad_no"));
				cus_MsgVO.setMsg_note(rs.getString("msg_note"));
				cus_MsgVO.setMsg_time(rs.getTimestamp("msg_time"));
				list.add(cus_MsgVO);
			}
			
		}catch(ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException se) {
					se.printStackTrace();
				}

			}
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
				if(con != null) {
					try {
						con.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
		
		}
		
		return list;
	}

	public static void main(String[] args) {
		Cus_MsgJDBCDAO cdao = new Cus_MsgJDBCDAO();
		// 穝糤
//		Cus_MsgVO cus_MsgVO = new Cus_MsgVO();
//		cus_MsgVO.setMem_no("M00006");
//		cus_MsgVO.setAd_no("AD00002");
//		cus_MsgVO.setMsg_note("代刚");
//		cdao.insert(cus_MsgVO);
//		System.out.println("穝糤Θ");

		// 穝
//		Cus_MsgVO cus_MsgVO = new Cus_MsgVO();
//		cus_MsgVO.setMem_no("M00006");
//		cus_MsgVO.setAd_no("AD00002");
//		cus_MsgVO.setMsg_note("change代刚");
//		cus_MsgVO.setCus_msg_no("CUM00006");
//		cdao.update(cus_MsgVO);
//		System.out.println("穝Θ");

		// 琩高1掸
		Cus_MsgVO cus_MsgVO = cdao.findByPrimaryKey("M00001","AD00001");
		System.out.println(cus_MsgVO.getCus_msg_no() + ",");
		System.out.println(cus_MsgVO.getMem_no() + ",");
		System.out.println(cus_MsgVO.getAd_no() + ",");
		System.out.println(cus_MsgVO.getMsg_note() + ",");
		
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(time.format(cus_MsgVO.getMsg_time()));
		
		System.out.println();

		// 琩高ALL
//		List<Cus_MsgVO> list = cdao.getAll();
//		for(Cus_MsgVO cus_MsgVO:list) {
//		System.out.print(cus_MsgVO.getCus_msg_no() + ",");
//		System.out.print(cus_MsgVO.getMem_no() + ",");
//		System.out.print(cus_MsgVO.getAd_no() + ",");
//		System.out.print(cus_MsgVO.getMsg_note() + ",");
//		
//		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.print(time.format(cus_MsgVO.getMsg_time()));
//		System.out.println();
//		}
	}
}
