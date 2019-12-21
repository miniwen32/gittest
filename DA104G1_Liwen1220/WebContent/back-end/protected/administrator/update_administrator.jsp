<%@page import="com.administrator.model.AdministratorVO"%>
<%@page import="com.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	AdministratorVO adVO = (AdministratorVO) session.getAttribute("adVO");
	String nowInAd_name = (String) session.getAttribute("nowInAd_name");
%>
<html>
<head>s
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
}

#right {
	margin-left: 30%;
}
/* /* 替換適合地址的 css 樣式 */
*
/
/* .my-style-selector select { */
/* 	-webkit-appearance: none; */
/* 	-moz-appearance: none; */
/* 	appearance: none; */
/* 	border-color: #6ec3f5; */
/* 	border-width: 2px; */
/* 	border-radius: 10em; */
/* 	color: #1390e8; */
/* 	margin-right: 10px; */
/* 	outline: none; */
/* 	padding: .3em 1.25em; */
/* } */
</style>
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
									<h3>修改員工的資料-update_administratort.jsp</h3>
								</td>
							</tr>
						</table>

						<h3>資料修改</h3>
						<%----錯誤處理 --%>

						<c:if test="${not empty errorMsgs}">
							<font style="color: red">Warning</font>
							<ul>
								<c:forEach var="message" items="${errorMsgs}">
									<li style="color: red">${message}</li>
								</c:forEach>
							</ul>
						</c:if>

						<form method="post"
							action="<%=request.getContextPath()%>/administrator/administrator.do"
							name="form1">
							<table>
								<tr>
									<td>編號:</td>
									<td><input type="hidden" name="ad_no"
										value="${adVO.ad_no}"> ${adVO.ad_no}</td>
								</tr>

								<tr>
									<td>帳號:</td>
									<td><input type="hidden" name="ad_account"
										value="${adVO.ad_account}">${adVO.ad_account}</td>
								</tr>

								<tr>
									<td>姓名:</td>
									<td><input type="text" name="ad_name"
										value="${adVO.ad_name}"></td>
								</tr>

								<tr>
									<td>手機:</td>
									<td><input type="text" name="ad_mobi"
										value="${adVO.ad_mobi}"></td>
								</tr>

								<tr>
									<td>電子信箱:</td>
									<td><input type="text" name="ad_email"
										value="${adVO.ad_email}"></td>
								</tr>

								<tr>
									<div class="my-style-selector">
										<td>地址:</td>
										<td>
										<select id="city" name="city"
											style="width: 140px; height: 38px"></select>
											<select style="width: 140px; height: 38px" id="district"
											name="district"></select><br>
											<input type="text" name="ad_addr"
											value="${adVO.ad_addr}"></td>
									</div>
								</tr>

								<tr>
									<td>員工狀態:</td>
									<td><jsp:useBean id="adSvc" scope="page"
											class="com.administrator.model.AdministratorService" /> <select
										size="1" name="ad_status">
											<option value="0" ${adVO.ad_status eq '0' ?'selected':''}>離職
											
											<option value="1" ${adVO.ad_status eq '1' ?'selected':''}>在職
											</option>
									</select></td>
								</tr>
							</table>
							<br> <input type="hidden" name="action" value="update">
							<input type="hidden" name="ad_no" value="${adVO.ad_no}">
							<input type="submit" value="修改完成">
						</form>
<!--- footer --->
<%@include file="/back-end/footer.file"%>
<script>
	var addr1 = addr;
	$(document).ready(function() {

		let city = $('#city');
		let str = '<option selected disabled>選擇縣市</option>';
		for (let i = 0; i < addr.length; i++) {
			str += "<option>" + addr1[i].name + "</option>";

		}
		city.html(str);

		city.on('change', getData);

		let optionTxt;
		function getData(e) {
			let district = $('#district');
			optionTxt = $(this).find('option:selected').text();
			let str = '';
			let index = 0;
			for (let i = 0; i < addr.length; i++) {
				if (optionTxt === addr[i].name) {
					index = addr[i].district.length;
					for (let j = 0; j < index; j++) {
						str += "<option>" + addr[i].district[j] + "</option>";
					}
					district.html(str);
				}
			}
		}
	})
</script>