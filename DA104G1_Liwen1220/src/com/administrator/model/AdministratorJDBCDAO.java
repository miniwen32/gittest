package com.administrator.model;

import java.util.*;
import java.sql.*;

public class AdministratorJDBCDAO implements AdministratorDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "DA104G1";
	String passwd = "DA104G1";

	private static final String INSERT_STMT = "INSERT INTO ADMINISTRATOR (AD_NO, AD_ACCOUNT, AD_PASSWORD, AD_NAME, AD_ADDR, AD_MOBI, AD_WDATE, AD_EMAIL, AD_STATUS) VALUES(('AD'||LPAD(SEQ_AD_NO.NEXTVAL,5,'0')),?,?,?,?,?,sysdate,?,?)";
//	private static final String GET_ALL_STMT = "SELECT AD_NO, AD_ACCOUNT, AD_PASSWORD, AD_NAME, AD_ADDR, AD_MOBI, AD_WDATE, AD_EMAIL, AD_STATUS FROM ADMINISTRATOR";
	private static final String GET_ALL_STMT = "SELECT * FROM ADMINISTRATOR";
	private static final String GET_ONE_STMT = "SELECT AD_NO, AD_ACCOUNT, AD_PASSWORD, AD_NAME, AD_ADDR, AD_MOBI, AD_WDATE, AD_EMAIL, AD_STATUS FROM ADMINISTRATOR WHERE AD_NO=?";
	private static final String GET_ONE_STMT_BY_ACCOUNT = "SELECT AD_NO, AD_ACCOUNT, AD_PASSWORD, AD_NAME, AD_ADDR, AD_MOBI, AD_WDATE, AD_EMAIL, AD_STATUS FROM ADMINISTRATOR WHERE AD_ACCOUNT=?";
	private static final String UPDATE = "UPDATE ADMINISTRATOR SET AD_ACCOUNT=?, AD_PASSWORD=?, AD_NAME=?, AD_ADDR=?, AD_MOBI=?, AD_EMAIL=?, AD_STATUS=? WHERE AD_NO =?";
	private static final String CHECK_ACCOUNT = "SELECT AD_ACCOUNT FROM ADMINISTRATOR WHERE AD_ACCOUNT=?";

	@Override
	public void insert(AdministratorVO administratorVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, administratorVO.getAd_account());
			pstmt.setString(2, administratorVO.getAd_password());
			pstmt.setString(3, administratorVO.getAd_name());
			pstmt.setString(4, administratorVO.getAd_addr());
			pstmt.setString(5, administratorVO.getAd_mobi());
			pstmt.setString(6, administratorVO.getAd_email());
			pstmt.setString(7, administratorVO.getAd_status());

			pstmt.executeQuery();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public void update(AdministratorVO administratorVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, administratorVO.getAd_account());
			pstmt.setString(2, administratorVO.getAd_password());
			pstmt.setString(3, administratorVO.getAd_name());
			pstmt.setString(4, administratorVO.getAd_addr());
			pstmt.setString(5, administratorVO.getAd_mobi());
			pstmt.setString(6, administratorVO.getAd_email());
			pstmt.setString(7, administratorVO.getAd_status());
			pstmt.setString(8, administratorVO.getAd_no());

			pstmt.executeQuery();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

	}

	public AdministratorVO findByPrimaryKey(String ad_no) {
		AdministratorVO administratorVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setString(1, ad_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				administratorVO = new AdministratorVO();
				administratorVO.setAd_no(rs.getString("ad_no"));
				administratorVO.setAd_account(rs.getString("ad_account"));
				administratorVO.setAd_password(rs.getString("ad_password"));
				administratorVO.setAd_name(rs.getString("ad_name"));
				administratorVO.setAd_addr(rs.getString("ad_addr"));
				administratorVO.setAd_mobi(rs.getString("ad_mobi"));
				administratorVO.setAd_wdate(rs.getDate("ad_wdate"));
				administratorVO.setAd_email(rs.getString("ad_email"));
				administratorVO.setAd_status(rs.getString("ad_status"));
			}
		} catch (ClassNotFoundException e) {
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
		return administratorVO;
	}

	public AdministratorVO findByAccount(String ad_account) {
		AdministratorVO administratorVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT_BY_ACCOUNT);
			pstmt.setString(1, ad_account);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				administratorVO = new AdministratorVO();
				administratorVO.setAd_no(rs.getString("ad_no"));
				administratorVO.setAd_account(rs.getString("ad_account"));
				administratorVO.setAd_password(rs.getString("ad_password"));
				administratorVO.setAd_name(rs.getString("ad_name"));
				administratorVO.setAd_addr(rs.getString("ad_addr"));
				administratorVO.setAd_mobi(rs.getString("ad_mobi"));
				administratorVO.setAd_wdate(rs.getDate("ad_wdate"));
				administratorVO.setAd_email(rs.getString("ad_email"));
				administratorVO.setAd_status(rs.getString("ad_status"));
			}
		} catch (ClassNotFoundException e) {
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

		return administratorVO;
	}

	@Override
	public List<AdministratorVO> getAll() {
		List<AdministratorVO> list = new ArrayList<AdministratorVO>();
		AdministratorVO administratorVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				administratorVO = new AdministratorVO();
				administratorVO.setAd_no(rs.getString("ad_no"));
				administratorVO.setAd_account(rs.getString("ad_account"));
				administratorVO.setAd_password(rs.getString("ad_password"));
				administratorVO.setAd_name(rs.getString("ad_name"));
				administratorVO.setAd_addr(rs.getString("ad_addr"));
				administratorVO.setAd_mobi(rs.getString("ad_mobi"));
				administratorVO.setAd_wdate(rs.getDate("ad_wdate"));
				administratorVO.setAd_email(rs.getString("ad_email"));
				administratorVO.setAd_status(rs.getString("ad_status"));
				list.add(administratorVO);
			}

		} catch (ClassNotFoundException e) {
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
		return list;
	}

	public boolean isAdExist(String ad_account) {
		Boolean isAdExist = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(CHECK_ACCOUNT);
			
			pstmt.setString(1, ad_account);
			ResultSet rs = pstmt.executeQuery();
			isAdExist = rs.next();
						
			return isAdExist;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

	public static void main(String[] args) {
		AdministratorJDBCDAO addao = new AdministratorJDBCDAO();

		// 穝糤
//		AdministratorVO adAdministratorVO1 = new AdministratorVO();
//		
//		adAdministratorVO1.setAd_account("a111111");
//		adAdministratorVO1.setAd_password("p22222");
//		adAdministratorVO1.setAd_name("Eason");
//		adAdministratorVO1.setAd_addr("Taipei");
//		adAdministratorVO1.setAd_mobi("0922222222");
//		adAdministratorVO1.setAd_email("eason@123");
//		adAdministratorVO1.setAd_status("0");
//		
//		addao.insert(adAdministratorVO1);
//		System.out.println("穝糤Θ");

		// э
//		AdministratorVO adAdministratorVO2 = new AdministratorVO();
//		
//		adAdministratorVO2.setAd_account("changed");
//		adAdministratorVO2.setAd_password("changedd");
//		adAdministratorVO2.setAd_name("Eason");
//		adAdministratorVO2.setAd_addr("Taipei");
//		adAdministratorVO2.setAd_mobi("123132");
//		adAdministratorVO2.setAd_email("eason@123");
//		adAdministratorVO2.setAd_status("0");
//		adAdministratorVO2.setAd_no("AD00006");
//		
//		addao.update(adAdministratorVO2);
//		System.out.println("эΘ");

		// 琩高虫(眀腹)
//		AdministratorVO adVO = addao.findByAccount("aaaa");
//		System.out.println(adVO.getAd_password());
		// 琩高虫
//		AdministratorVO adAdministratorVO = addao.findByPrimaryKey("AD00006");
//		System.out.println(adAdministratorVO.getAd_no()  +",");
//		System.out.println(adAdministratorVO.getAd_account()  +",");
//		System.out.println(adAdministratorVO.getAd_password()  +",");
//		System.out.println(adAdministratorVO.getAd_name()  +",");
//		System.out.println(adAdministratorVO.getAd_addr()  +",");
//		System.out.println(adAdministratorVO.getAd_mobi()  +",");
//		System.out.println(adAdministratorVO.getAd_wdate()  +",");
//		System.out.println(adAdministratorVO.getAd_email()  +",");
//		System.out.println(adAdministratorVO.getAd_status()  +",");
//		System.out.println();

		// 眀腹琩高虫
//		AdministratorVO adAdministratorVO = addao.findByAccount("b12345");
//		System.out.println(adAdministratorVO.getAd_no() + ",");
//		System.out.println(adAdministratorVO.getAd_account() + ",");
//		System.out.println(adAdministratorVO.getAd_password() + ",");
//		System.out.println(adAdministratorVO.getAd_name() + ",");
//		System.out.println(adAdministratorVO.getAd_addr() + ",");
//		System.out.println(adAdministratorVO.getAd_mobi() + ",");
//		System.out.println(adAdministratorVO.getAd_wdate() + ",");
//		System.out.println(adAdministratorVO.getAd_email() + ",");
//		System.out.println(adAdministratorVO.getAd_status() + ",");
//		System.out.println();

		// 琩高场
//		List<AdministratorVO> list = addao.getAll();
//		for (AdministratorVO adAdministratorVO3 : list) {
//			System.out.println(adAdministratorVO3.getAd_no() + ",");
//			System.out.println(adAdministratorVO3.getAd_account() + ",");
//			System.out.println(adAdministratorVO3.getAd_password() + ",");
//			System.out.println(adAdministratorVO3.getAd_name() + ",");
//			System.out.println(adAdministratorVO3.getAd_addr() + ",");
//			System.out.println(adAdministratorVO3.getAd_mobi() + ",");
//			System.out.println(adAdministratorVO3.getAd_wdate() + ",");
//			System.out.println(adAdministratorVO3.getAd_email() + ",");
//			System.out.println(adAdministratorVO3.getAd_status() + ",");
//			System.out.println();
//		}

		
		
	}

}
