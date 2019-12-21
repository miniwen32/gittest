<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String nowInAd_name = (String) session.getAttribute("nowInAd_name"); %>

<html>
<head>
<title>分饗食刻Eare</title>
<!-- css.file -->
<%@include file="/back-end/csslink.file"%>

<style>
table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
	border: 3px ridge Gray;
	height: 80px;
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
</style>
</head>
<body>
<!-- navbar -->
<%@include file="/back-end/navbar.file"%>

	<table id="table-1">
		<tr>
			<td>
				<h3>Back:auth_select_page.jsp</h3>
			</td>
		</tr>
	</table>
	
<h3>資料查詢</h3>

<%--錯誤列表--%>
	<c:if test="${not empty errorMsgs}">
	<p><font style="color:red">Warning</font></p>
	<ul>
	<c:forEach var="message" items="${errorMsgs}">
	<li style="color:red">${message}</li>
	</c:forEach>
	</ul>
	
	</c:if>
<ul>
<li>
<a href="<%=request.getContextPath()%>/back-end/protected/authority/listAllAuthority.jsp">
List</a>顯示所有權限	
<form method="post" action="<%= request.getContextPath()%>/authority/authority.do">
<b>輸入權限編號</b>
<input type="text" name="auth_no">
<input type="hidden" name="action" value="getOne_For_Display">
<input type="submit" value="尋找">
</form>
</li>

<%----下拉式選單 --%>
<jsp:useBean id="authSvc" scope="page" class="com.authority.model.AuthorityService" />
<li>
<form method="post" action="<%= request.getContextPath()%>/authority/authority.do">
<b>請選擇權限</b>
<select size:"1" name="auth_no">
<c:forEach var="authVO" items="${authSvc.all}">
	<option value="${authVO.auth_no}">${authVO.auth_name}
</c:forEach>
</select>
<input type="hidden" name="action" value="getOne_For_Display">
<input type="submit" value="送出">
</form>
</li>
</ul>

<h3>權限管理</h3>
<ul><li>
<a href="<%= request.getContextPath()%>/back-end/protected/authority/addAuthority.jsp">Add</a> a new authority</li></ul>

<!--- footer --->
<%@include file="/back-end/footer.file"%>

</body>
</html>