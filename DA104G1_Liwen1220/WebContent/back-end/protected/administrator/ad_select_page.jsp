<%@page import="com.administrator.model.AdministratorVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="Big5"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<%

AdministratorVO adVO = (AdministratorVO)session.getAttribute("adVO");
String nowInAd_name = (String) session.getAttribute("nowInAd_name");

%>
<html>
<head>
<title>���W����Eare</title>
    <!-- css.file -->
<%@include file="/back-end/csslink.file"%>
</head>
<body>
<!-- navbar -->
<%@include file="/back-end/navbar.file"%>
<table id="table-1">
		<tr>
			<td>
				<h3>�m  Administrator-�޲z���t��  �n</h3>
			</td>
		</tr>
	</table>
<br><br>
<%--���~�C�� --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">���~�T��</font>
	<ul>
	<c:forEach var="message" items="${errorMsgs}"> 
		<li style="color:red">${errorMsgs}</li>

	</c:forEach>
	</ul>
</c:if>
<ul>
<li>
<a href="<%=request.getContextPath()%>/back-end/protected/administrator/listAllAdministrator.jsp">
List
</a>
�޲z��
<br>
</li>
<li>
<form methond="post" action="<%=request.getContextPath()%>/administrator/administrator.do">
<b>��J���u�s��(AD00001)</b>
<input type="text" name="ad_no">
<input type="hidden" name="action" value="getOne_For_Display">
<input type="submit" value="�M��">
</form>
</li>
<br>
<%---�U�Ԧ���� --%>
<jsp:useBean id="adSvc" scope="page"
	class="com.administrator.model.AdministratorService" />
<li>
<form method="post"
action="<%=request.getContextPath()%>/administrator/administrator.do">
<b>�п�ܭ��u�m�W</b>
<select size="1" name="ad_no">
<c:forEach var="adVO" items="${adSvc.all}">
	<option value="${adVO.ad_no}">${adVO.ad_name}
</c:forEach>
</select>
<input type="hidden" name="action" value="getOne_For_Display">
<input type="submit" value="�e�X">
</form>
</li>
</ul>
<br>

<ul>
<li><a href="<%= request.getContextPath()%>/back-end/protected/administrator/addAdministrator.jsp">Add</a>
a new Administrator</li></ul>
<!--- footer --->
<%@include file="/back-end/footer.file"%>
</body>
</html>