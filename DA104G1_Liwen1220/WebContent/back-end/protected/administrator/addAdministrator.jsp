<%@page import="com.administrator.model.AdministratorVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	AdministratorVO adVOnotyet = (AdministratorVO) request.getAttribute("adVOnotyet");
	String nowInAd_name = (String) session.getAttribute("nowInAd_name");
%>
<html>
<head>
<title>分饗食刻Eare</title>
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
	font-size: 15px;
}

th, td {
	padding: 5px;
}

#send {
	text-align: center;
}
#right {
	margin-left: 30%;
}
</style>
</head>

<body>
<!-- navbar -->
<%@include file="/back-end/navbar.file"%>
					<h4>新增管理員: addAdministrator</h4>
					<br>
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

					<%--填寫資料 --%>
					<form method="post"
						action="<%=request.getContextPath()%>/administrator/administrator.do"
						name="form1">
						<table>
							<tr>
								<td>帳號:</td>
								<td><input type="text" name="ad_account" id="ad_account"
									value="<%=(adVOnotyet == null) ? "" : adVOnotyet.getAd_account()%>">
								<font id="showthesame"></font>
								</td>
							</tr>

							<tr>
								<td>姓名:</td>
								<td><input type="text" name="ad_name"
									value="<%=(adVOnotyet == null) ? "" : adVOnotyet.getAd_name()%>"></td>	
							</tr>


<!-- ---------------------------------------- -->
<tr>
<td>地址:</td>
<td>
<select id="city" name="city" style="width: 114px; height: 22px">
</select>
<select style="width: 114px; height: 22px" id="district" name="district"></select><br>
<input type="text" name="ad_addr" value="<%=(adVOnotyet == null) ? "" : adVOnotyet.getAd_addr()%>">
</td>
</tr>
<!-- ------------------------------------------- -->
							<tr>
								<td>手機:</td>
								<td><input type="text" name="ad_mobi"
									value="<%=(adVOnotyet == null) ? "" : adVOnotyet.getAd_mobi()%>"></td>
							</tr>

							<tr>
								<td>電子信箱:</td>
								<td><input type="text" name="ad_email"
									value="<%=(adVOnotyet == null) ? "" : adVOnotyet.getAd_email()%>"></td>
								
							</tr>

						</table>
						<br> <input type="hidden" name="action" value="insert">
						<input type="submit" value="送出" id="send">
					</form>
<!--- footer --->
<%@include file="/back-end/footer.file"%>
	<script>
	$(document).ready(function(){
		
		$("#ad_account").keyup(function(){
			
			$.ajax({
				url:"<%=request.getContextPath()%>/administrator/administrator.do",
				type:"POST",
				data:{
					action:"ckaccount",
					account:$("#ad_account").val()
				},
				success:function(data){
					$("#showthesame").html(data);
				}
	
			})	
		})		
	})
	
	
	var addr1 =addr;
		$(document).ready(function() {
			
			let city = $('#city');
			let str = '<option selected disabled>----選擇縣市----</option>';
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
							str += "<option>"+ addr[i].district[j]+"</option>";
						}
						district.html(str);
					}
				}
			}
		})
	</script>
</body>
</html>