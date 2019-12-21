<%@page import="com.administrator.model.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	AdministratorVO adVO = (AdministratorVO) session.getAttribute("adVO");
	AdministratorVO adVOupdate = (AdministratorVO) request.getAttribute("adVOupdate");

	AdministratorVO adVOforOne = (AdministratorVO) request.getAttribute("adVOforOne");
	String nowInAd_name = (String) session.getAttribute("nowInAd_name");
	AdministratorService adSvc = new AdministratorService();
	List<AdministratorVO> list = adSvc.getAll();
	pageContext.setAttribute("list", list);
%>

<html>
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
	text-align: center;
}
#right{
margin-left :30%;
}
#test{
height:82PX;
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
										href="<%=request.getContextPath()%>/back-end/protected/administrator/ad_select_page.jsp"><img
										src="<%=request.getContextPath()%>/images/logo.png"
										title="回首頁" width="200"></a>
								</h4>
								<h3>員工資料-listOneAdministrator.jsp</h3>
							</td>
						</tr>
					</table>
					<c:if test="${not empty errorMsgs}">
						<font style="color: red">Warning</font>
						<ul>
							<c:forEach var="message" items="${errorMsgs}">
								<li style="color: red">${message}</li>
							</c:forEach>
						</ul>
					</c:if>

					<table>

						<tr>
							<th>編號</th>
							<td>${adVOupdate.ad_no}
							${adVOforOne.ad_no}
							<input type="hidden" name="ad_no" value="${(adVOupdate == null)? adVOforOne.ad_no : adVOupdate.ad_no}">
							</td>
						</tr>
						<tr>
							<th>帳號</th>
							<td>${adVOupdate.ad_account}
							${adVOforOne.ad_account}
							<input type="hidden" name="ad_account" value="${(adVOupdate == null)? adVOforOne.ad_account : adVOupdate.ad_account}">
							</td>
						</tr>
						<tr>
							<th>姓名</th>
							<td>${adVOupdate.ad_name}
							${adVOforOne.ad_name}
							<input type="hidden" name="ad_name" value="${(adVOupdate == null)? adVOforOne.ad_name : adVOupdate.ad_name}">
							</td>
						</tr>
						<tr>
							<th>地址</th>
							<td>${adVOupdate.ad_addr}
							${adVOforOne.ad_addr}
							<input type="hidden" name="ad_addr" value="${(adVOupdate == null)? adVOforOne.ad_addr:adVOupdate.ad_addr}">
							</td>
						</tr>
						<tr>
							<th>電話</th>
							<td>${adVOupdate.ad_mobi}
							${adVOforOne.ad_mobi}
							<input type="hidden" name="ad_mobi" value="${(adVOupdate == null)? adVOforOne.ad_mobi :adVOupdate.ad_mobi}">
							</td>
						</tr>
						<tr>
							<th>到職日</th>
							<td>${adVOupdate.ad_wdate}
							${adVOforOne.ad_wdate}
							<input type="hidden" name="ad_wdate" value="${(adVOupdate == null)? adVOforOne.ad_wdate : dVOupdate.ad_wdate}">
						</td>
						</tr>
						<tr>
							<th>電子信箱</th>
							<td>${adVOupdate.ad_email}
							${adVOforOne.ad_email}
							<input type="hidden" name="ad_email" value="${(adVOupdate == null)? adVOforOne.ad_email:adVOupdate.ad_email}">
						</td>
						</tr>
						<tr>
							<th>狀態</th>
							<td>${adVOupdate.ad_status}
							${adVOforOne.ad_status}
							<input type="hidden" name="ad_status" value="${(adVOupdate == null)? adVOforOne.ad_status:adVOupdate.ad_status}">
						</td>
						</tr>
					</table>
	<form method="post"
	action="<%= request.getContextPath()%>/administrator/administrator.do"
	style="margin-bottom: 0px">
	<input type="submit" value="修改">
	<input type="hidden" name="ad_no" value="<%=(adVOupdate == null)? adVOforOne.getAd_no() :adVOupdate.getAd_no()%>">
	<input type="hidden" name="action" value="get_One_For_Update">
	</form>
	
	<li>
<a href="<%=request.getContextPath()%>/back-end/protected/administrator/listAllAdministrator.jsp">
List
</a>
管理員
<br>
</li>
<!--- footer --->
<%@include file="/back-end/footer.file"%>
</body>
</html>