<%@page import="com.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta name="description" content="分饗食刻 Eare 食譜網站">
<meta name="keywords" content="EatShare 分饗食刻 食譜 找廚師">
<link rel="icon" href="<%=request.getContextPath()%>/images/高麗菜.png"
	type="image/gif" sizes="72x72">
<meta name="author" content="Eat Share teams">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
<title>分享食刻 Eare</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">
<script src="https://kit.fontawesome.com/43de8a2881.js"
	crossorigin="anonymous"></script>
<style type="text/css">
body {
	background-image: url('<%=request.getContextPath()%>/gif/ki11.jpg');
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	background-attachment: fixed;
}

.logging {
	margin-top: 10%;
}

:root { -
	-input-padding-x: 1.5rem; -
	-input-padding-y: .75rem;
}

.card-signin {
	border: 0;
	border-radius: 1rem;
	box-shadow: 0 0.5rem 1rem 0 rgba(0, 0, 0, 0.1);
}

.card-signin .card-title {
	margin-bottom: 2rem;
	font-weight: 300;
	font-size: 1.5rem;
}

.card-signin .card-body {
	width: 100%;
	padding: 2rem;
}

.card-signin {
	margin-left: 37%;
}

.form-signin {
	width: 100%;
}

.forgotpw .btn {
	font-size: 80%;
	border-radius: 5rem;
	letter-spacing: .1rem;
	font-weight: bold;
	padding: 1rem;
	transition: all 0.2s;
}

.forgotpw input {
	border-radius: 20px;
}

.btn-info {
	margin-top: 10px;
}

.tellfill {
	text-align: center;
}

.form-signin input {
	border-radius: 20px;
}

.sex {
	text-align: center;
}

#showphoto {
	height: 250px;
	border: 3px dashed lightblue;
	margin: 5% 5%;
}

.warn {
	line-height: 40px;
	font-size: 20px;
}
.my-style-selector select {
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	border-color: #6ec3f5;
	border-width: 2px;
	border-radius: 10em;
	color: #1390e8;
	margin-right: 10px;
	outline: none;
	padding: .3em 1.25em;
}
</style>
</head>
<body>
	<nav
		class="navbar-header navbar navbar-expand-lg navbar-light bg-light fixed-top">
		<a class="navbar-brand"
			href="<%=request.getContextPath()%>/front-end/index.jsp">
			<h1>分饗食刻</h1>
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div
			class="collapse navbar-collapse d-xs-flex justify-content-end mr-5"
			id="navbarSupportedContent">
			<ul class="navbar-nav">
				<!-- <li class="nav-item">
                        <a class="nav-link" href="#"><span class="sr-only">(current)</span></a>
                      </li> -->
				<li class="nav-item mr-3"><a class="nav-link" href="#"><i
						class="fas fa-seedling"></i><span>食譜</span></a></li>
				<li class="nav-item mr-3"><a class="nav-link"
					href="shopping.html"><i class="fas fa-store-alt"></i><span>購物市集</span></a>
				</li>
				<li class="nav-item mr-3"><a class="nav-link" href="#"><i
						class="fas fa-cocktail"></i><span>找廚師</span></a></li>
				<li class="nav-item mr-3"><a class="nav-link" href="#"><i
						class="fas fa-users"></i><span>揪團</span></a></li>
<!-- ---------會員登入後，變更----------- -->
                    <li class="nav-item mr-3">
                        <a class="nav-link" href=<%= (memberVO == null)? request.getContextPath()+"/front-end/member/mem_login.jsp" : request.getContextPath()+"/front-end/protected/member/mem_detail.jsp"%>>
                        <img width="35" height="35"
                        src='
                        <%= (memberVO == null)?
                        		request.getContextPath()+"/images/signup.png": request.getContextPath()+"/member/MemberPicShow.do?mem_no="+memberVO.getMem_no()%>'
                            style="border-radius:30px"><span><%=(memberVO == null)? "會員": " "+memberVO.getMem_name()%></span></a>
                        </li>
                    <li class="nav-item mr-3">
                        <a class="nav-link" href="<%=request.getContextPath()%>/member/loginHandlerMem.do"><i class="fas fa-user-circle"></i><span><%= (memberVO == null)? "登入":"登出"%></span></a>
                    </li>
 <!-- ---------以上----------- -->  
			</ul>
		</div>
	</nav>
	<!--修改-->
	<div class="container logging">
		<div class="row">
			<div class="col-sm-9 col-md-9 col-lg-9 mx-9">
				<div class="card card-signin my-8">
					<div class="card-body">
						<h5 class="card-title text-center">《 我的基本資料 》</h5>
						<%----錯誤處理 --%>
						<c:if test="${not empty errorMsgs}">
							<font style="color: red">請檢查以下</font>
							<ul>
								<c:forEach var="message" items="${errorMsgs}">
									<li style="color: red">${message}</li>
								</c:forEach>
							</ul>
						</c:if>
						<div class="forgotpw" class="container">
							<form class="form-signin" method="post"
								action="<%=request.getContextPath()%>/member/member.do"
								name="form1" enctype="multipart/form-data">
								<div class="row">
									<div class="col-6">

										<font id="mem_account" size="4">帳號 : &nbsp; </font> <input
											type="hidden" name="mem_account" id="mem_account"
											value="<%=memberVO.getMem_account()%>" style='dispaly:none'>
										<font color="green" size="6"><%=memberVO.getMem_account()%></font><br>
										<br>
										<p class="sex">
											<label for="female">
											<input type="radio" id="female"
												name="gender" value="1"
												
												<%=(memberVO == null || memberVO.getGender().equals("1")) ? "checked" : ""%>>女生
												<img src="<%=request.getContextPath()%>/images/woman.jpg">
												</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label for="male">
											<input type="radio" id="male"
												name="gender" value="0" <%=(memberVO.getGender().equals("0")) ? "checked" : ""%>>男生 
												<img
												src="<%=request.getContextPath()%>/images/man.jpg"></label>
										</p>

										<label for="pw">更改密碼</label>
										<p>
											<input type="Password" id="pw" name="mem_password" class="form-control"
												placeholder="New Password"
												value="<%=memberVO.getMem_password()%>">
										</p>
										<label for="ckpw">確認新密碼</label>
										<span id="showError"></span>
										<p>
											<input type="password" id="ckpw" name="ck_password"
												value="<%=memberVO.getMem_password()%>" class="form-control"
												placeholder="Confirm Password">
										</p>
										
									</div>

									<div class="col-6">
										<div id="showphoto">
											<img
												src="<%=request.getContextPath()%>/member/MemberPicShow.do?mem_no=${memberVO.mem_no}"
												width='100%' height='100%'>
										</div>
										<input type="file" name="mem_pic" class="uploadfile"
											id="mem_pic" value="<%=memberVO.getMem_pic()%>"
											style="border-radius: 0px">
									</div>

								</div>
								<div class="row">
									<div class="col-12">
										<hr class="my-4">

										<label for="inputname">姓名</label>
										<p>
											<input type="text" name="mem_name" id="inputaccount"
												class="form-control" placeholder="Name" required autofocus
												value="<%=memberVO.getMem_name()%>">
										</p>
										<label for="inputDate">生日</label>
										<p>
											<input type="text" name="birth" id="birth"
												class="form-control" required autofocus
												value="<%=memberVO.getBirth()%>">
										</p>
										<label for="cellphone">手機</label>
										<p>
											<input type="number" name="mem_mobi" id="cellphone"
												class="form-control" required autofocus placeholder="Phone"
												value="<%=memberVO.getMem_mobi()%>">
										</p>
										<label for="email">電子信箱</label>
										<p>
											<input type="email" name="mem_email" id="email"
												class="form-control" required autofocus placeholder="E-mail"
												value="<%=memberVO.getMem_email()%>">
										</p>
										<div class="my-style-selector">
										<label for="Address">地址</label>
										<select id="city" name="city" style="width: 140px; height: 38px"></select>
									<select style="width: 140px; height: 38px" id="district" name="district"></select></P>
										
										
										<p>
											<input type="text" name="mem_addr" id="address"
												class="form-control" required autofocus
												placeholder="Address" value="<%=memberVO.getMem_addr()%>">
										</p>
</div>

										<input type="hidden" name="sign_up_date"
											value="<%=memberVO.getSign_up_date()%>" display="none">
										<input type="hidden" name="point_count"
											value="<%=memberVO.getPoint_count()%>" display="none">
										<input type="hidden" name="mre_count"
											value="<%=memberVO.getMre_count()%>" display="none">
										<input type="hidden" name="mem_no"
											value="<%=memberVO.getMem_no()%>" display="none">


										<div style="height: 50px"></div>

										<hr class="my-4">
										<br> <input type="hidden" name="action" value="update">
										<button class="btn btn-lg btn-info btn-block text-uppercase"
											type="submit">修改完成</button>
									</div>
								</div>
							</form>
						</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<br>
	<br>
	<br>
	<!--footer start-->
	<footer class="text-white bg-warning text-center">
		&copy;Eare 分饗食刻<span id="year"></span>
	</footer>
	<!--footer end-->
	<!-- 線上客服 -->
	<div class="customer-service" title="線上客服"></div>

	<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
	<script src="<%=request.getContextPath()%>/js/poper.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/main.js"></script>
	<script src="<%=request.getContextPath()%>/js/addr.js"></script>
</body>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>

//<!-------------地址-------------------->

var addr1 =addr;
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
					str += "<option>"+ addr[i].district[j]+"</option>";
				}
				district.html(str);
			}
		}
	}
})
// <!-------------地址-------------------->

//前端預覽+照片格式驗證
	function ckpic(e) {
	let mem_pic = document.getElementById("mem_pic");
	let exAllowed = ["bmp","gif","png","jpg","ico"];
	let fileStr = e.target.value.toLowerCase();
	let fileName, fileExt;

	let dot = fileStr.lastIndexOf(".");
	fileExt = fileStr.substr(dot + 1);

	if (exAllowed.indexOf(fileExt) == -1){
		document.getElementById("showphoto").innerHTML = "<font class='warn' color='red'>非圖檔 ,格式不合!!<br>請再挑一張吧</font><br>";
	}else{
		let photo = URL.createObjectURL(mem_pic.files[0]);
			document.getElementById("showphoto").innerHTML = "<img src ="+ photo + " width='100%' height='100%'>";
	}
}
    	document.getElementById("mem_pic").onchange = ckpic;

//前端密碼和確認密碼CK
function ckthesame(e){
			let pw = document.getElementById("pw");
			let ckwp = document.getElementById("ckpw");
			let showError = document.getElementById("showError");

			if(pw.value === ckwp.value && ckwp != ""){
				showError.innerHTML ="<font style='color:green;font-weight:Bold;font-size:small'>確認OK!</font>";
			}else {
				showError.innerHTML ="<font style='color:red;font-weight:Bold;font-size:small'>密碼不一致</font>";
				ckwp.value = "";
			}
		}
		document.getElementById("ckpw").onchange = ckthesame;
		document.getElementById("pw").onchange = ckthesame;
</script>



<!-- 日期轉換 -->
<%
	java.sql.Date birth = null;
	try {
		birth = memberVO.getBirth();
	} catch (Exception e) {
		birth = new java.sql.Date(System.currentTimeMillis());
	}
%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>
<script>
$.datetimepicker.setLocale('zh');
$('#birth').datetimepicker({
   theme: '',              //theme: 'dark',
   timepicker:false,       //timepicker:true,
   step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
   format:'Y-m-d',         //format:'Y-m-d H:i:s',
   value: '<%=birth%>
	',
		maxDate : '+1970-01-01' // 去除今日(不含)之後
	});
</script>
</html>