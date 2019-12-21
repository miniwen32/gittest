<%@page import="com.administrator.model.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	AdministratorVO adVO = (AdministratorVO) session.getAttribute("adVO");
	String nowInAd_name = (String) session.getAttribute("nowInAd_name");
	AdministratorService adSvc = new AdministratorService();
	List<AdministratorVO> list = adSvc.getAll();
	pageContext.setAttribute("list", list);
%>

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
	text-align: center;
}
#right{
margin-left :15%;
}
</style>
</head>
<body>
<!-- navbar -->
<%@include file="/back-end/navbar.file"%>
						<h4>�Ҧ��޲z��: listAdministrator.jsp</h4>

						<%--���~�C�� --%>
						<c:if test="${not empty errorMsgs}">
							<font style="color: red">Warning:</font>
							<ul>
								<c:forEach var="massege" items="${errorMsgs}">
									<li style="color: red">${massege}</li>
								</c:forEach>
							</ul>
						</c:if>

						<table>
							<tr>
								<th>�s��</th>
								<th>�b��</th>
								<th>�K�X</th>
								<th>�m�W</th>
								<th>�a�}</th>
								<th>�q��</th>
								<th>��¾��</th>
								<th>�q�l�H�c</th>
								<th>���A</th>
								<th>�ק�</th>
							</tr>

							<%@include file="/back-end/page1.file"%>

							<c:forEach var="adVO" items="${list}" begin="<%=pageIndex%>"
								end="<%=pageIndex+rowsPerPage-1%>">

								<tr>
									<td>${adVO.ad_no}</td>
									<td>${adVO.ad_account}</td>
									<td>${adVO.ad_password}</td>
									<td>${adVO.ad_name}</td>
									<td>${adVO.ad_addr}</td>
									<td>${adVO.ad_mobi}</td>
									<td>${adVO.ad_wdate}</td>
									<td>${adVO.ad_email}</td>
									<td><c:choose>
											<c:when test="${adVO.ad_status eq '0'}">
��¾
</c:when>
											<c:when test="${adVO.ad_status eq '1'}">
�b¾
</c:when>
										</c:choose></td>


									<td>
										<form method="post"
											action="<%=request.getContextPath()%>/administrator/administrator.do">
											<input type="submit" value="�ק�" style="margin-bottom: 0px">
											<input type="hidden" name="ad_no" value="${adVO.ad_no}">
											<input type="hidden" name="action" value="get_One_For_Update">
										</form>
									</td>
								</tr>
							</c:forEach>
						</table>
						<%@include file="/back-end/page2.file"%>
<!--- footer --->
<%@include file="/back-end/footer.file"%>
</body>
</html>