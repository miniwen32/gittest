<%@page import="com.authority.model.AuthorityVO"%>
<%@page import="com.authority.model.AuthorityService"%>
<%@page import="com.administrator.model.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	AuthorityService authSvc = new AuthorityService();
	List<AuthorityVO> list = authSvc.getAll();
	pageContext.setAttribute("list", list);
	String nowInAd_name = (String) session.getAttribute("nowInAd_name"); %>
<html>
<head>
<title>分饗食刻Eare</title>
    <!-- Required meta tags -->
<%@include file="/back-end/csslink.file"%>
<style>
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
	text-align: center;
}


</style>
</head>
<body>
<!-- navbar -->
<%@include file="/back-end/navbar.file"%>

	<h4>所有權限: listAllAdministrator.jsp</h4>

	<%--warning --%>
	<c:if test="${not empty errorMsgs}">
		<p style="color: red">Warning</p>
		<ul>
			<c:forEach var="massege" items="${errorMsgs}">
				<li style="color: red">${massege}</li>
			</c:forEach>
		</ul>
	</c:if>

	<table>
		<tr>
			<th>權限編號</th>
			<th>權限名稱</th>
			<th>權限內容</th>
			<th>修改</th>
		</tr>

		<%@include file="/back-end/page1.file"%>

		<c:forEach var="authVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">
			
			<tr>
				<td>${authVO.auth_no}</td>
				<td>${authVO.auth_name}</td>
				<td>${authVO.auth_note}</td>
				<td>
					<form method="post"
						action="<%=request.getContextPath()%>/authority/authority.do">
						<input type="submit" value="修改">
						<input type="hidden" name="action" value="get_One_For_Update">
						<input type="hidden" name="auth_no" value="${authVO.auth_no}">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@include file="/back-end/page2.file"%>
<!------------------------------ footer ------------------------------>
<!--- footer --->
<%@include file="/back-end/footer.file"%>
</body>
</html>