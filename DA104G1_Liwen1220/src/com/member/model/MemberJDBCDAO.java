package com.member.model;

import java.io.*;
import java.sql.*;
import java.util.*;

public class MemberJDBCDAO implements MemberDAO_interface {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "DA104G1";
	String passwd = "DA104G1";

	private static final String INSERT_STMT = "INSERT INTO MEMBER(MEM_NO, MEM_ACCOUNT, MEM_PASSWORD, MEM_NAME, MEM_ADDR, MEM_MOBI, SIGN_UP_DATE, MEM_EMAIL, POINT_COUNT, MRE_COUNT, MEM_STATUS, BIRTH, GENDER,MEM_PIC,MEM_PHO,MEM_INFO)VALUES (('M'||LPAD(SEQ_MEM_NO.NEXTVAL,5,'0')),?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE MEMBER SET  MEM_ACCOUNT =?, MEM_PASSWORD=?, MEM_NAME=?, MEM_ADDR=?, MEM_MOBI=?, MEM_EMAIL=?, POINT_COUNT=?, MRE_COUNT=?, MEM_STATUS=?, BIRTH=?, GENDER=?,MEM_PIC=?,MEM_PHO=?,MEM_INFO=? WHERE MEM_NO = ?";
	private static final String GET_ALL_STMT = "SELECT MEM_NO, MEM_ACCOUNT, MEM_PASSWORD, MEM_NAME, MEM_ADDR, MEM_MOBI, SIGN_UP_DATE, MEM_EMAIL, POINT_COUNT, MRE_COUNT, MEM_STATUS, BIRTH, GENDER,MEM_PIC,MEM_PHO,MEM_INFO FROM MEMBER ORDER BY MEM_NO";
	private static final String GET_ONE_STMT = "SELECT MEM_NO, MEM_ACCOUNT, MEM_PASSWORD, MEM_NAME, MEM_ADDR, MEM_MOBI, to_char(SIGN_UP_DATE,'yyyy-mm-dd')SIGN_UP_DATE, MEM_EMAIL, POINT_COUNT, MRE_COUNT, MEM_STATUS, to_char(BIRTH,'yyyy-mm-dd')BIRTH, GENDER,MEM_PIC,MEM_PHO,MEM_INFO FROM MEMBER WHERE MEM_NO =?";
	private static final String GET_ONE_STMT_BY_ACCOUNT = "SELECT MEM_NO, MEM_ACCOUNT, MEM_PASSWORD, MEM_NAME, MEM_ADDR, MEM_MOBI, to_char(SIGN_UP_DATE,'yyyy-mm-dd')SIGN_UP_DATE, MEM_EMAIL, POINT_COUNT, MRE_COUNT, MEM_STATUS, to_char(BIRTH,'yyyy-mm-dd')BIRTH, GENDER,MEM_PIC,MEM_PHO,MEM_INFO FROM MEMBER WHERE MEM_ACCOUNT =?";
	private static final String DELETE = "DELETE FROM MEMBER WHERE MEM_NO =?";
	private static final String CHECK_ACCOUNT = "SELECT MEM_ACCOUNT FROM MEMBER WHERE MEM_ACCOUNT=?";

	@Override
	public void insert(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, memberVO.getMem_account());
			pstmt.setString(2, memberVO.getMem_password());
			pstmt.setString(3, memberVO.getMem_name());
			pstmt.setString(4, memberVO.getMem_addr());
			pstmt.setString(5, memberVO.getMem_mobi());
			pstmt.setString(6, memberVO.getMem_email());
			pstmt.setInt(7, memberVO.getPoint_count());
			pstmt.setInt(8, memberVO.getMre_count());
			pstmt.setString(9, memberVO.getMem_status());
			pstmt.setDate(10, memberVO.getBirth());
			pstmt.setString(11, memberVO.getGender());
			pstmt.setBytes(12, memberVO.getMem_pic());
			pstmt.setBytes(13, memberVO.getMem_pho());
			pstmt.setString(14, memberVO.getMem_info());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());
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
	public void update(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, memberVO.getMem_account());
			pstmt.setString(2, memberVO.getMem_password());
			pstmt.setString(3, memberVO.getMem_name());
			pstmt.setString(4, memberVO.getMem_addr());
			pstmt.setString(5, memberVO.getMem_mobi());
			pstmt.setString(6, memberVO.getMem_email());
			pstmt.setInt(7, memberVO.getPoint_count());
			pstmt.setInt(8, memberVO.getMre_count());
			pstmt.setString(9, memberVO.getMem_status());
			pstmt.setDate(10, memberVO.getBirth());
			pstmt.setString(11, memberVO.getGender());
			pstmt.setBytes(12, memberVO.getMem_pic());
			pstmt.setBytes(13, memberVO.getMem_pho());
			pstmt.setString(14, memberVO.getMem_info());
			pstmt.setString(15, memberVO.getMem_no());
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Coudn't load database driver" + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());
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
	public void delete(String mem_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, mem_no);

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver" + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured" + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
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
	public MemberVO findByPrimaryKey(String mem_no) {
		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setString(1, mem_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMem_no(rs.getString("mem_no"));
				memberVO.setMem_account(rs.getString("mem_account"));
				memberVO.setMem_password(rs.getString("mem_password"));
				memberVO.setMem_name(rs.getString("mem_name"));
				memberVO.setMem_addr(rs.getString("mem_addr"));
				memberVO.setMem_mobi(rs.getString("mem_mobi"));
				memberVO.setSign_up_date(rs.getDate("sign_up_date"));
				memberVO.setMem_email(rs.getString("mem_email"));
				memberVO.setPoint_count(rs.getInt("Point_count"));
				memberVO.setMre_count(rs.getInt("mre_count"));
				memberVO.setMem_status(rs.getString("mem_status"));
				memberVO.setBirth(rs.getDate("birth"));
				memberVO.setGender(rs.getString("gender"));
				memberVO.setMem_pic(rs.getBytes("mem_pic"));
				memberVO.setMem_pho(rs.getBytes("mem_pho"));
				memberVO.setMem_info(rs.getString("mem_info"));
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
		return memberVO;
	}

	@Override
	public MemberVO findByAccount(String mem_account) {
		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT_BY_ACCOUNT);
			pstmt.setString(1, mem_account);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMem_no(rs.getString("mem_no"));
				memberVO.setMem_account(rs.getString("mem_account"));
				memberVO.setMem_password(rs.getString("mem_password"));
				memberVO.setMem_name(rs.getString("mem_name"));
				memberVO.setMem_addr(rs.getString("mem_addr"));
				memberVO.setMem_mobi(rs.getString("mem_mobi"));
				memberVO.setSign_up_date(rs.getDate("sign_up_date"));
				memberVO.setMem_email(rs.getString("mem_email"));
				memberVO.setPoint_count(rs.getInt("Point_count"));
				memberVO.setMre_count(rs.getInt("mre_count"));
				memberVO.setMem_status(rs.getString("mem_status"));
				memberVO.setBirth(rs.getDate("birth"));
				memberVO.setGender(rs.getString("gender"));
				memberVO.setMem_pic(rs.getBytes("mem_pic"));
				memberVO.setMem_pho(rs.getBytes("mem_pho"));
				memberVO.setMem_info(rs.getString("mem_info"));
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
		return memberVO;
	}

	@Override
	public List<MemberVO> getAll() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO memberVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMem_no(rs.getString("mem_no"));
				memberVO.setMem_account(rs.getString("mem_account"));
				memberVO.setMem_password(rs.getString("mem_password"));
				memberVO.setMem_name(rs.getString("mem_name"));
				memberVO.setMem_addr(rs.getString("mem_addr"));
				memberVO.setMem_mobi(rs.getString("mem_mobi"));
				memberVO.setSign_up_date(rs.getDate("sign_up_date"));
				memberVO.setMem_email(rs.getString("mem_email"));
				memberVO.setPoint_count(rs.getInt("Point_count"));
				memberVO.setMre_count(rs.getInt("mre_count"));
				memberVO.setMem_status(rs.getString("mem_status"));
				memberVO.setBirth(rs.getDate("birth"));
				memberVO.setGender(rs.getString("gender"));
				memberVO.setMem_pic(rs.getBytes("mem_pic"));
				memberVO.setMem_pho(rs.getBytes("mem_pho"));
				memberVO.setMem_info(rs.getString("mem_info"));
				list.add(memberVO);
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

	public boolean isMemExist(String mem_account) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isMemExit = false;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(CHECK_ACCOUNT);

			pstmt.setString(1, mem_account);
			ResultSet rs = pstmt.executeQuery();
			isMemExit = rs.next();
			return isMemExit;

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
		MemberJDBCDAO memdao = new MemberJDBCDAO();

		// 新增
//		MemberVO memberVO1 = new MemberVO();;
//		memberVO1.setMem_account("aaaa123");
//		memberVO1.setMem_password("pppp123");
//		memberVO1.setMem_name("Eason");
//		memberVO1.setMem_addr("Taipei");
//		memberVO1.setMem_mobi("0933333333");
//		memberVO1.setMem_email("eason@gmail");
//		memberVO1.setPoint_count(1000);
//		memberVO1.setMre_count(0);
//		memberVO1.setMem_status("1");
//		memberVO1.setBirth(java.sql.Date.valueOf("1985-10-24"));
//		memberVO1.setGender("0");
//		byte[] pic1 = getPic("C:/liwen/5.jpg");
//		memberVO1.setMem_pic(pic1);
//		byte[] pic2 = getPic("C:/liwen/6.jpg");
//		memberVO1.setMem_pho(pic2);
//		memberVO1.setMem_info("這是我的廚房介紹");	
//		memdao.insert(memberVO1);
//		System.out.println("新增成功!");

		// 修改
//		MemberVO memberVO2 = new MemberVO();
//		memberVO2.setMem_account("change123");
//		memberVO2.setMem_password("change123");
//		memberVO2.setMem_name("changeEason");
//		memberVO2.setMem_addr("changeTaipei");
//		memberVO2.setMem_mobi("0933333333");
//		memberVO2.setMem_email("changeeason@gmail");
//		memberVO2.setPoint_count(2000);
//		memberVO2.setMre_count(0);
//		memberVO2.setMem_status("1");
//		memberVO2.setBirth(java.sql.Date.valueOf("1985-10-24"));
//		memberVO2.setGender("0");
//		byte[] pic1 = getPic("C:/liwen/6.jpg");
//		memberVO2.setMem_pic(pic1);
//		byte[] pic2 = getPic("C:/liwen/6.jpg");
//		memberVO2.setMem_pho(pic2);
//		memberVO2.setMem_info("這是我的廚房介紹");
//		memberVO2.setMem_no("M00012");
//
//		memdao.update(memberVO2);
//		System.out.println("更新成功");

		// 查詢單一
		MemberVO memberVO4 = memdao.findByPrimaryKey("M00001");
		System.out.println(memberVO4.getMem_no()  +",");
		System.out.println(memberVO4.getMem_account()  +",");
		System.out.println(memberVO4.getMem_password()  +",");
		System.out.println(memberVO4.getMem_name()  +",");
		System.out.println(memberVO4.getMem_addr()  +",");
		System.out.println(memberVO4.getMem_mobi()  +",");
		System.out.println(memberVO4.getSign_up_date()  +",");
		System.out.println(memberVO4.getMem_email()  +",");
		System.out.println(memberVO4.getPoint_count()  +",");
		System.out.println(memberVO4.getMre_count()  +",");
		System.out.println(memberVO4.getMem_status()  +",");
		System.out.println(memberVO4.getBirth()  +",");
		System.out.println(memberVO4.getGender()  +",");
		System.out.println(memberVO4.getMem_pic()  +",");
		System.out.println(memberVO4.getMem_pho()  +",");
		System.out.println(memberVO4.getMem_info());
		System.out.println();

		// 帳號查詢單一
//		MemberVO memberVO4 = memdao.findByAccount("text123");
//		System.out.println(memberVO4.getMem_no() + ",");
//		System.out.println(memberVO4.getMem_account() + ",");
//		System.out.println(memberVO4.getMem_password() + ",");
//		System.out.println(memberVO4.getMem_name() + ",");
//		System.out.println(memberVO4.getMem_addr() + ",");
//		System.out.println(memberVO4.getMem_mobi() + ",");
//		System.out.println(memberVO4.getSign_up_date() + ",");
//		System.out.println(memberVO4.getMem_email() + ",");
//		System.out.println(memberVO4.getPoint_count() + ",");
//		System.out.println(memberVO4.getMre_count() + ",");
//		System.out.println(memberVO4.getMem_status() + ",");
//		System.out.println(memberVO4.getBirth() + ",");
//		System.out.println(memberVO4.getGender() + ",");
//		System.out.println(memberVO4.getMem_pic() + ",");
//		System.out.println(memberVO4.getMem_pho() + ",");
//		System.out.println(memberVO4.getMem_info());
//		System.out.println();

		// 查詢全部
		List<MemberVO> list = memdao.getAll();
		for(MemberVO memberVO3 : list) {
			System.out.print(memberVO3.getMem_no()  +",");
			System.out.print(memberVO3.getMem_account()  +",");
			System.out.print(memberVO3.getMem_password()  +",");
			System.out.print(memberVO3.getMem_name()  +",");
			System.out.print(memberVO3.getMem_addr()  +",");
			System.out.print(memberVO3.getMem_mobi()  +",");
			System.out.print(memberVO3.getSign_up_date()  +",");
			System.out.print(memberVO3.getMem_email()  +",");
			System.out.print(memberVO3.getPoint_count()  +",");
			System.out.print(memberVO3.getMre_count()  +",");
			System.out.print(memberVO3.getMem_status()  +",");
			System.out.print(memberVO3.getBirth()  +",");
			System.out.print(memberVO3.getGender()  +",");
			System.out.print(memberVO3.getMem_pic()  +",");
			System.out.print(memberVO3.getMem_pho()  +",");
			System.out.print(memberVO3.getMem_info());
			System.out.println();
		}

		// 刪除
//		memdao.delete("M00012");
//		System.out.println("刪除成功");
	}

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
