<%@page import="com.administrator.model.AdministratorVO"%>
<%@page import="com.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");
String nowInAd_name = (String) session.getAttribute("nowInAd_name");
	AdministratorVO adVO = (AdministratorVO) session.getAttribute("adVO");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<html lang="en">
<head>
<title>分饗食刻Eare</title>
    <!-- css.file -->
<%@include file="/back-end/csslink.file"%>
<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}

table {
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
}

#right {
	margin-left: 30%;
}
/* 替換適合地址的 css 樣式 */
.my-style-selector select {
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	border-color: #6ec3f5;
	border-width: 2px;
	border-radius: 10em;
	color: #1390e8;
	margin-right: 10px;
	outline: none;
	padding: .3em 1.25em;
}
</style>
<body>
<!-- navbar -->
<%@include file="/back-end/navbar.file"%>
						<table id="table-1">
							<tr>
								<td>
									<h4>
										<a
											href="<%=request.getContextPath()%>/back-end/protected/administrator/ad_select_page.jsp"><img
											src="<%=request.getContextPath()%>/images/logo.png"
											title="回首頁" width="200"></a>
									</h4>
									<h3>修改會員的資料-update_member_input.jsp</h3>
								</td>
							</tr>
						</table>

						<c:if test="${not empty errorMsgs}">
							<font style="color: red">請檢查以下</font>
							<ul>
								<c:forEach var="message" items="${errorMsgs}">
									<li style="color: red">${message}</li>
								</c:forEach>
							</ul>
						</c:if>


						<form class="form-signin" method="post"
							action="<%=request.getContextPath()%>/member/memberback.do"
							name="form1" enctype="multipart/form-data">

							<table>
								<tr>
									<td>編號:</td>
									<td><input type="hidden" name="mem_no"
										value="${memberVO.mem_no}" display='none'>
										${memberVO.mem_no}</td>
								</tr>
								<tr>
									<td>帳號:</td>
									<td><input type="hidden" name="mem_account"
										value="${memberVO.mem_account}" display='none'>
										${memberVO.mem_account}</td>
								</tr>

								<tr>
									<td>性別:</td>
									<td><input type="hidden" name="gender"
										value="${memberVO.gender}">
										${(memberVO.gender eq'0')? '男生':'女生'}</td>
								</tr>
								<tr>
									<td>姓名:</td>
									<td><input type="hidden" name="mem_name"
										value="${memberVO.mem_name}" display='none'>
										${memberVO.mem_name}</td>
								</tr>
								<tr>
									<td>手機:</td>
									<td><input type="hidden" name="mem_mobi"
										value="${memberVO.mem_mobi}" display='none'>
										${memberVO.mem_mobi}</td>
								</tr>
								<tr>
									<td>電子信箱:</td>
									<td><input type="hidden" name="mem_email"
										value="${memberVO.mem_email}" display='none'>
										${memberVO.mem_email}</td>
								</tr>

								<tr>
									<td>會員狀態:</td>
									<td><select size="1" name="mem_status">
											<option name="mem_status" value="0"
												${memberVO.mem_status eq '0' ?'selected':''}>未驗證
											<option name="mem_status" value="1"
												${memberVO.mem_status eq '1' ?'selected':''}>已驗證
											<option name="mem_status" value="2"
												${memberVO.mem_status eq '2' ?'selected':''}>停權</option>
									</select></td>
								</tr>

								<tr>
									<td>生日:</td>
									<td><input type="hidden" name="birth"
										value="${memberVO.birth}">
										${memberVO.birth}</td>
								</tr>

								<tr>
									<td>地址:</td>
									<td><input type="hidden" name="mem_addr"
										value="${memberVO.mem_addr}">
										${memberVO.mem_addr}</td>
								</tr>

								<tr>
									<td>註冊日:</td>
									<td><input type="hidden" name="sign_up_date"
										value="${memberVO.sign_up_date}">
										${memberVO.sign_up_date}</td>
								</tr>

								<tr>
									<td>點數:</td>
									<td><input type="hidden" name="point_count"
										value="${memberVO.point_count}">
										${memberVO.point_count}</td>
								</tr>

								<tr>
									<td>檢舉次數:</td>
									<td><input type="hidden" name="mre_count"
										value="${memberVO.mre_count}">
										${memberVO.mre_count}</td>
								</tr>

								<tr>
									<td>大頭照</td>
									<td>
										<div id="showphoto">
											<img
												src="<%=request.getContextPath()%>/member/MemberPicShow.do?mem_no=${memberVO.mem_no}"
												width='100%' height='100%'>
										</div>
									</td>
								</tr>

							</table>
							<input type="hidden" name="mem_password"
								value="${memberVO.mem_password}"> <input
								type="hidden" name="action" value="update"> <input
								type="submit" value="修改完成">
						</form>

					</div>
				</div>
			</div>
		</div>
<!--- footer --->
<%@include file="/back-end/footer.file"%>
</body>
</html>