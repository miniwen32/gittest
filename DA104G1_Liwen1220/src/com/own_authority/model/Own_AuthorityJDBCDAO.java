package com.own_authority.model;

import java.sql.*;
import java.util.*;

public class Own_AuthorityJDBCDAO implements Own_AuthorityDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "DA104G1";
	String passwd = "DA104G1";
	
	private static final String INSERT_STMT = "INSERT INTO Own_Authority(AD_NO,AUTH_NO)VALUES (?,?)";
//	private static final String GET_ALL_STMT = "SELECT AD_NO,AUTH_NO FROM Own_Authority";
	private static final String GET_ALL_STMT = "SELECT * FROM Own_Authority";
	private static final String GET_ONE_STMT = "SELECT AD_NO,AUTH_NO FROM Own_Authority where AD_NO=?";
	private static final String UPDATE = "UPDATE Own_Authority SET AUTH_NO=? WHERE AD_NO =? and AUTH_NO=?";
	private static final String DELETE = 
			"DELETE FROM Own_Authority WHERE AD_NO=? and AUTH_NO=?";
	@Override
	public void insert(Own_AuthorityVO own_AuthorityVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, own_AuthorityVO.getAd_no());
			pstmt.setString(2, own_AuthorityVO.getAuth_no());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public void delete(String ad_no,String auth_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setString(1, ad_no);
			pstmt.setString(2, auth_no);
			pstmt.executeUpdate();
		}catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public List<Own_AuthorityVO> findByPrimaryKey(String ad_no) {
		Own_AuthorityVO own_AuthorityVO = new Own_AuthorityVO();
		List<Own_AuthorityVO> list = new ArrayList<Own_AuthorityVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setString(1, ad_no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				own_AuthorityVO =new Own_AuthorityVO();
 				own_AuthorityVO.setAd_no(rs.getString("ad_no"));
				own_AuthorityVO.setAuth_no(rs.getString("auth_no"));
				list.add(own_AuthorityVO);
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
	@Override
	public List<Own_AuthorityVO> getAll() {
		List<Own_AuthorityVO> list = new ArrayList<Own_AuthorityVO>();
		Own_AuthorityVO own_AuthorityVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,userid,passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				own_AuthorityVO = new Own_AuthorityVO();
				own_AuthorityVO.setAd_no(rs.getString("ad_no"));
				own_AuthorityVO.setAuth_no(rs.getString("auth_no"));
				list.add(own_AuthorityVO);
			}
		}catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
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
		return list;
	}
	
	public static void main(String[]args) {
		Own_AuthorityJDBCDAO oadao = new Own_AuthorityJDBCDAO();
		
		// 新增
//		Own_AuthorityVO own_AuthorityVO1 = new Own_AuthorityVO();
//		own_AuthorityVO1.setAd_no("AD00004");
//		own_AuthorityVO1.setAuth_no("AU02");
//		oadao.insert(own_AuthorityVO1);
//		System.out.println("新增成功");
		
		//查一個
//		List<Own_AuthorityVO> list = oadao.findByPrimaryKey("AD00002");
//		for(Own_AuthorityVO own_AuthorityVO3 :list ) {
//			System.out.print(own_AuthorityVO3.getAd_no()+ ": ");
//			System.out.println(own_AuthorityVO3.getAuth_no());
//		}
		
		//查全部
//		List<Own_AuthorityVO> list1 = oadao.getAll();
//		for(Own_AuthorityVO own_AuthorityVO3 :list1 ) {
//			System.out.print(own_AuthorityVO3.getAd_no()+ ": ");
//			System.out.println(own_AuthorityVO3.getAuth_no());
//		}
		
		
		//刪除
//		oadao.delete("AD00004","AU01");
//		System.out.println("刪除成功!");
		
		
	}	
	
}
