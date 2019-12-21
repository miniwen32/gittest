<%@page import="com.administrator.model.AdministratorVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
AdministratorVO adVO = (AdministratorVO) session.getAttribute("adVO");
String nowInAd_name = (String) session.getAttribute("nowInAd_name");
%>

<!DOCTYPE html>
<html>
<head>
<title>���W����Eare</title>
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
				<h3>Back:mem_select_page.jsp</h3>
				<h4>0201</h4>
			</td>
		</tr>
	</table>
<h2>�|���޲z</h2>
	<h3>��Ƭd��</h3>

	<%--���~��C--%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">���~�T��</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs} ">
				<li style="color: red">${errorMsgs}"</li>
			</c:forEach>
		</ul>
	</c:if>

	<ul>
		<li><a href="<%=request.getContextPath()%>/back-end/protected/member/listAllMember.jsp">List</a>all Members.<br> <br></li>

		<li>
			<form method="post"
				action="<%=request.getContextPath()%>/member/memberback.do">
				<b>��J�|���s��(�p: M00001)</b> <input type="text" name="mem_no"> <input
					type="hidden" name="action" value="getOne_For_Display"> <input
					type="submit" value="�M��">
			</form>
		</li>

		<%--�U�Ԧ�����--%>
		<jsp:useBean id="memSvc" scope="page"
			class="com.member.model.MemberService" />

		<li>
			<form method="post"
				action="<%=request.getContextPath()%>/member/memberback.do">
				<b>�п�ܷ|���s��:</b>
				<select size="1" name="mem_no">
					<c:forEach var="memberVO" items="${memSvc.all}">
						<option value="${memberVO.mem_no}">${memberVO.mem_name}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="�e�X">
			</form>
		</li>
	</ul>
<!--- footer --->
<%@include file="/back-end/footer.file"%>
</body>
</html>