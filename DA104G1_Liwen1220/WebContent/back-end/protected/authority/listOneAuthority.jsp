<%@page import="com.authority.model.AuthorityVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String nowInAd_name = (String) session.getAttribute("nowInAd_name");
AuthorityVO authVO = (AuthorityVO) request.getAttribute("authVO");
%>
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
							
							<h4>ListOneAuthority.jsp</h4>
							<br>
							<%--錯誤列表 --%>
							<c:if test="${not empty errorMsgs}">
								<font style="color: red" size='3'>Warning</font>
								<ul>
									<c:forEach var="message" items="${errorMsgs}">
										<li style="color: red">${message}</li>
									</c:forEach>
								</ul>
							</c:if>

							<form method="post"
								action="<%=request.getContextPath()%>/authority/authority.do">
								<table>
									<tr>
										<td>權限編號:</td>
										<td>${authVO.auth_no}<input type="hidden" name="auth_no"
											value="${authVO.auth_no}"></td>
									</tr>
									<tr>
										<td>權限名稱:</td>
										<td>${authVO.auth_name}<input type="hidden"
											name="auth_name" value="${authVO.auth_name}"></td>
									</tr>
									<tr>
										<td>權限簡述:</td>
										<td>${authVO.auth_note}<input type="hidden" name="auth_note"
											value="${authVO.auth_note}">
										</td>
									</tr>
								</table>
								<br> <input type="submit" value="修改"> <input
									type="hidden" name="action" value="get_One_For_Update">

							</form>
<a href="<%=request.getContextPath()%>/back-end/protected/authority/listAllAuthority.jsp">
List</a>顯示所有權限

<!--- footer --->
<%@include file="/back-end/footer.file"%>
</body>
</html>