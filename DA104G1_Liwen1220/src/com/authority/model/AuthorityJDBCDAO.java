package com.authority.model;

import java.sql.*;
import java.util.*;

public class AuthorityJDBCDAO implements AuthorityDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "DA104G1";
	String passwd = "DA104G1";

	private static final String INSERT_STMT = "INSERT INTO AUTHORITY(AUTH_NO,AUTH_NAME,AUTH_NOTE)VALUES (?,?,?)";
	private static final String GET_ALL_STMT = "SELECT AUTH_NO,AUTH_NAME,AUTH_NOTE FROM AUTHORITY ORDER BY AUTH_NO ASC";
//	private static final String GET_ALL_STMT = "SELECT * FROM AUTHORITY ORDER BY AUTH_NO ASC";
	private static final String GET_ONE_STMT = "SELECT AUTH_NO,AUTH_NAME,AUTH_NOTE FROM AUTHORITY WHERE AUTH_NO=?";
	private static final String UPDATE = "UPDATE AUTHORITY SET AUTH_NAME=?, AUTH_NOTE=? WHERE AUTH_NO =?";

	@Override
	public void insert(AuthorityVO authorityVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, authorityVO.getAuth_no());
			pstmt.setString(2, authorityVO.getAuth_name());
			pstmt.setString(3, authorityVO.getAuth_note());
			pstmt.executeQuery();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Could't load database driver" + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());
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
	public void update(AuthorityVO authorityVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, authorityVO.getAuth_name());
			pstmt.setString(2, authorityVO.getAuth_note());
			pstmt.setString(3, authorityVO.getAuth_no());
			pstmt.executeQuery();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Could't load database driver" + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());
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
	public AuthorityVO findByPrimaryKey(String auth_no) {
		AuthorityVO authorityVO = new AuthorityVO();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setString(1, auth_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				authorityVO.setAuth_no(rs.getString("auth_no"));
				authorityVO.setAuth_name(rs.getString("auth_name"));
				authorityVO.setAuth_note(rs.getString("auth_note"));
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
		return authorityVO;
	}

	@Override
	public List<AuthorityVO> getAll() {
		List<AuthorityVO> list = new ArrayList<AuthorityVO>();
		AuthorityVO authorityVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				authorityVO = new AuthorityVO();
				authorityVO.setAuth_no(rs.getString("auth_no"));
				authorityVO.setAuth_name(rs.getString("auth_name"));
				authorityVO.setAuth_note(rs.getString("auth_note"));
				list.add(authorityVO);
			}
		} catch (ClassNotFoundException e) {
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

	public static void main(String[] args) {
		AuthorityJDBCDAO audao = new AuthorityJDBCDAO();
//		AuthorityVO authorityVO = new AuthorityVO();

		// 穝糤
//		authorityVO.setAuth_no("AU10");
//		authorityVO.setAuth_name("代刚");
//		authorityVO.setAuth_note("虏瓃");
//		audao.insert(authorityVO);
//		System.out.println("穝糤Θ!");

		// 穝
//		authorityVO.setAuth_name("穝代刚");
//		authorityVO.setAuth_note("穝虏瓃");
//		authorityVO.setAuth_no("AU10");
//		audao.update(authorityVO);
//		System.out.println("穝Θ!");

		// 琩高1
//		AuthorityVO authorityVO1 = audao.findByPrimaryKey("AU01");
//		System.out.println(authorityVO1.getAuth_no() +",");
//		System.out.println(authorityVO1.getAuth_name() +",");
//		System.out.println(authorityVO1.getAuth_note() +",");
//		System.out.println();

		// 琩高场
		List<AuthorityVO> list = audao.getAll();
		for (AuthorityVO authorityVO2 : list) {
			System.out.println(authorityVO2.getAuth_no() + ",");
			System.out.println(authorityVO2.getAuth_name() + ",");
			System.out.println(authorityVO2.getAuth_note() + ",");
			System.out.println();
		}

	}

}
