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
<title>���W����Eare</title>
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
											title="�^����" width="200"></a>
									</h4>
									<h3>�|�������-listOneMember.jsp</h3>
								</td>
							</tr>
						</table>

						<%--���~�C�� --%>
						<c:if test="${not empty errorMsgs}">
							<font style="color: deeppink">��ݿ��~�ݳo��</font>
							<ul>
								<c:forEach var="message" items="${errorMsgs}">
									<li style="color: red">${message}</li>
								</c:forEach>
							</ul>
						</c:if>

						<table>
							<tr>
								<th>�s��</th>
								<td>${memberVO.mem_no}</td>
							</tr>
							<tr>
								<th>�b��</th>
								<td>${memberVO.mem_account}</td>
							</tr>
							<tr>
								<th>�K�X</th>
								<td>${memberVO.mem_password}</td>
							</tr>
							<tr>
								<th>�m�W</th>
								<td>${memberVO.mem_name}</td>
							</tr>
							<tr>
								<th>�a�}</th>
								<td>${memberVO.mem_addr}</td>
							</tr>
							<tr>
								<th>�q��</th>
								<td>${memberVO.mem_mobi}</td>
							</tr>
							<tr>
								<th>���U��</th>
								<td>${memberVO.getSign_up_date()}</td>
							</tr>
							<tr>
								<th>�H�c</th>
								<td>${memberVO.mem_email}</td>
							</tr>
							<tr>
								<th>�I��</th>
								<td>${memberVO.point_count}</td>
							</tr>
							<tr>
								<th>�Q���|����</th>
								<td>${memberVO.mre_count}</td>
							</tr>
							<tr>
								<th>���A</th>
								<td>${memberVO.mem_status}</td>
							</tr>
							<tr>
								<th>�ͤ�</th>
								<td>${memberVO.birth}</td>
							</tr>
							<tr>
								<th>�ʧO</th>
								<td>${memberVO.gender}</td>
							</tr>
							<tr>
								<th>�j�Y��</th>
								<td><img
									src="<%=request.getContextPath()%>/member/MemberPicShow.do?mem_no=${memberVO.mem_no}&ask=mem_pic"
									width="150px"></td>
							</tr>
						</table>


						<form method="post"
							action="<%=request.getContextPath()%>/member/memberback.do"
							style="margin-bottom: 0px">
							<input type="submit" value="�ק�"> <input type="hidden"
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