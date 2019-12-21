<%@page import="java.util.List"%>
<%@page import="com.administrator.model.*"%>
<%@page import="com.member.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	AdministratorVO adVO = (AdministratorVO) session.getAttribute("adVO");
	String nowInAd_name = (String) session.getAttribute("nowInAd_name");
	MemberService memSvc = new MemberService();
	List<MemberVO> list = memSvc.getAll();
	pageContext.setAttribute("list", list);
	 %>
<html>
<head>
<title>���W����Eare</title>
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
}

#right {
	margin-left: 5%;
}
</style>
</head>
<body>
<!-- navbar -->
<%@include file="/back-end/navbar.file"%>
						<h4>�Ҧ��|�������-listAllMember.jsp</h4>
						<%--���~�C�� --%>
						<c:if test="${not empty errorMsgs}">
							<font style="color: pink">�`�N�ݳo��!</font>
							<br>
							<ul>
								<c:forEach var="message" items="${errorMsgs}">
									<li style="color: red">${message}</li>
								</c:forEach>
							</ul>
						</c:if>
						<table>
							<tr>
								<th>�s��</th>
								<th>�b��</th>
								<th>�m�W</th>
								<th>�a�}</th>
								<th>�q��</th>
								<th>���U��</th>
								<th>�H�c</th>
								<th>�I��</th>
								<th>�Q���|����</th>
								<th>���A</th>
								<th>�ͤ�</th>
								<th>�ʧO</th>
								<th>�j�Y��</th>
								<th>�ק�</th>
								<th>�R��</th>

							</tr>
							<%@include file="/back-end/page1.file"%>
							<c:forEach var="memberVO" items="${list}" begin="<%=pageIndex%>"
								end="<%=pageIndex+rowsPerPage-1%>">
								<tr>
									<td>${memberVO.mem_no}</td>
									<td>${memberVO.mem_account}</td>
									<td>${memberVO.mem_name}</td>
									<td>${memberVO.mem_addr}</td>
									<td>${memberVO.mem_mobi}</td>
									<td>${memberVO.sign_up_date}</td>
									<td>${memberVO.mem_email}</td>
									<td>${memberVO.point_count}</td>
									<td>${memberVO.mre_count}</td>
									<td><c:choose>
											<c:when test="${memberVO.mem_status eq'0'}">
				������
				</c:when>
											<c:when test="${memberVO.mem_status eq'1'}">
				�w����
				</c:when>
											<c:when test="${memberVO.mem_status eq'2'}">
				���v
				</c:when>
										</c:choose></td>
									<td>${memberVO.birth}</td>

									<td>${(memberVO.gender eq'0')? '�k��':'�k��'}</td>
									<td><img
										src="<%=request.getContextPath()%>/member/MemberPicShow.do?mem_no=${memberVO.mem_no}&ask=mem_pic"
										width="100px"></td>

									<td>
										<form method="post"
											action="<%=request.getContextPath()%>/member/memberback.do"
											style="margin-bottom: 0px">
											<input type="submit" value="�ק�"> <input type="hidden"
												name="mem_no" value="${memberVO.mem_no}"> <input
												type="hidden" name="action" value="get_One_For_Update">
										</form>
									</td>

									<td>
										<form method="post"
											action="<%=request.getContextPath()%>/member/memberback.do"
											style="margin-bottom: 0px">
											<input type="submit" img src="images/veg" value="�R��">
											<input type="hidden" name="mem_no" value="${memberVO.mem_no}">
											<input type="hidden" name="action" value="delete">
										</form>
									</td>
								</tr>
							</c:forEach>
						</table>
						<%@ include file="/back-end/page2.file"%>
<!--- footer --->
<%@include file="/back-end/footer.file"%>
</body>
</html>	
				