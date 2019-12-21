<%@page import="com.authority.model.AuthorityVO"%>
<%@page import="com.administrator.model.AdministratorVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
AuthorityVO authVO = (AuthorityVO) request.getAttribute("authVO");
String nowInAd_name = (String) session.getAttribute("nowInAd_name");
%>

<!DOCTYPE html>
<html>
<head>
<title>���W����Eare</title>
    <!-- css.file -->
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
}
</style>
</head>
<body>
<!-- navbar -->
<%@include file="/back-end/navbar.file"%>
	<br>
	<h4>�ק�updateAuthority.jsp</h4><br>
	<%--���~�C�� --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red" size='3'>Warning</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>	

	<form method="post" action="<%=request.getContextPath()%>/authority/authority.do">
	<table>
	<tr>
	<td>�v���s��:</td>
	<td>${authVO.auth_no}
	<input type="hidden" name="auth_no" value="${authVO.auth_no}">
	
	</td>
	
	</tr>
	<tr>
	<td>�v���W��:</td>
	<td><input type="text" name="auth_name" value="<%= (authVO==null)? "" : authVO.getAuth_name() %>"></td>
	</tr>
	<tr>
	<td>�v��²�z:</td>
	<td><input type="text" name="auth_note" value="<%= (authVO==null)? "" : authVO.getAuth_note() %>"></td>
	</tr>
</table>	
	<br>
	<input type="submit" value="�ק粒��">
	<input type="hidden" name="action" value="update">
	</form>
	
<!--- footer --->
<%@include file="/back-end/footer.file"%>
</body>
</html>