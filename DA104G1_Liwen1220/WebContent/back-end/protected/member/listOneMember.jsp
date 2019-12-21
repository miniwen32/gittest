<%@page import="com.administrator.model.AdministratorVO"%>
<%@page import="com.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String nowInAd_name = (String) session.getAttribute("nowInAd_name");
	AdministratorVO adVO = (AdministratorVO) session.getAttribute("adVO");
	MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");
	pageContext.setAttribute("memberVO", memberVO);
%>

<html>
<head>
<title>分饗食刻Eare</title>
    <!-- css.file -->
<%@include file="/back-end/csslink.file"%>
<style>
le#table-1 {
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
</style>
</head>
<body>
<!-- navbar -->
<%@include file="/back-end/navbar.file"%>
						<table id="table-1">
							<tr>
								<td>
									<h4>
										<a
											href="<%=request.getContextPath()%>/back-end/protected/member/mem_select_page.jsp"><img
											src="<%=request.getContextPath()%>/images/logo.png"
											title="回首頁" width="200"></a>
									</h4>
									<h3>會員的資料-listOneMember.jsp</h3>
								</td>
							</tr>
						</table>

						<%--錯誤列表 --%>
						<c:if test="${not empty errorMsgs}">
							<font style="color: deeppink">後端錯誤看這裡</font>
							<ul>
								<c:forEach var="message" items="${errorMsgs}">
									<li style="color: red">${message}</li>
								</c:forEach>
							</ul>
						</c:if>

						<table>
							<tr>
								<th>編號</th>
								<td>${memberVO.mem_no}</td>
							</tr>
							<tr>
								<th>帳號</th>
								<td>${memberVO.mem_account}</td>
							</tr>
							<tr>
								<th>密碼</th>
								<td>${memberVO.mem_password}</td>
							</tr>
							<tr>
								<th>姓名</th>
								<td>${memberVO.mem_name}</td>
							</tr>
							<tr>
								<th>地址</th>
								<td>${memberVO.mem_addr}</td>
							</tr>
							<tr>
								<th>電話</th>
								<td>${memberVO.mem_mobi}</td>
							</tr>
							<tr>
								<th>註冊日</th>
								<td>${memberVO.getSign_up_date()}</td>
							</tr>
							<tr>
								<th>信箱</th>
								<td>${memberVO.mem_email}</td>
							</tr>
							<tr>
								<th>點數</th>
								<td>${memberVO.point_count}</td>
							</tr>
							<tr>
								<th>被檢舉次數</th>
								<td>${memberVO.mre_count}</td>
							</tr>
							<tr>
								<th>狀態</th>
								<td>${memberVO.mem_status}</td>
							</tr>
							<tr>
								<th>生日</th>
								<td>${memberVO.birth}</td>
							</tr>
							<tr>
								<th>性別</th>
								<td>${memberVO.gender}</td>
							</tr>
							<tr>
								<th>大頭照</th>
								<td><img
									src="<%=request.getContextPath()%>/member/MemberPicShow.do?mem_no=${memberVO.mem_no}&ask=mem_pic"
									width="150px"></td>
							</tr>
						</table>


						<form method="post"
							action="<%=request.getContextPath()%>/member/memberback.do"
							style="margin-bottom: 0px">
							<input type="submit" value="修改"> <input type="hidden"
								name="mem_no" value="${memberVO.mem_no}"> <input
								type="hidden" name="action" value="get_One_For_Update">
						</form>
						&nbsp;&nbsp; <a
							href="<%=request.getContextPath()%>/back-end/protected/member/listAllMember.jsp">List</a>all
						Members.
<!--- footer --->
<%@include file="/back-end/footer.file"%>
</body>
</html>