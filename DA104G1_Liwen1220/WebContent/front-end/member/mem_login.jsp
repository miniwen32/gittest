<%@page import="com.member.model.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");
	String account = (String) request.getAttribute("account");
%>
<html>
<meta charset="UTF-8">
<title>mem_logging</title>
<head>
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
	
<style>
body {
	background-image: url('<%=request.getContextPath()%>/gif/ki11.jpg');
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	background-attachment: fixed;
}

.logging {
	margin-top: 200px;
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
	padding: 2rem;
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

.btn-info {
	margin-top: 10px;
}

.tellfill {
	text-align: center;
}

.form-signin input {
	border-radius: 20px;
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
				<li class="nav-item mr-3"><a class="nav-link"
					href=<%=request.getRequestURI()%>> <img width="35" height="35"
						src='<%= (memberVO == null)?
                        		request.getContextPath()+"/images/signup.png": request.getContextPath()+"/member/MemberPicShow.do?mem_no="+memberVO.getMem_no()%>'
                            style="border-radius:30px">
						
						<span><%=(memberVO == null) ? "會員" : memberVO.getMem_name()%></span></a>
				</li>
				<li class="nav-item mr-3"><a class="nav-link"
					href="<%=request.getContextPath()%>/member/loginHandlerMem.do"> <i
						class="fas fa-user-circle"> </i><span><%=(memberVO == null) ? "登入" : "登出"%></span></a></li>

				<!-- ---------以上----------- -->
			</ul>
		</div>
	</nav>

	<!--登入-->
	<div class="container logging">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">
						<h5 class="card-title text-center">會員登入</h5>
						<div class="forgotpw">
							<form class="form-signin" method="post"
								action="<%=request.getContextPath()%>/member/loginHandlerMem.do">
								<label for="inputaccount">帳號</label>
								<p>
									<input type="text" name="account" id="inputaccount"
										class="form-control" placeholder="Account" required autofocus
										value="${(account == null) ? '': account}">
								</p>
								<label for="inputPassword">密碼</label>
								<p>
									<input type="password" name="password" id="inputPassword"
										class="form-control" placeholder="Password" required>
								</p>
								                        <div class="custom-control custom-checkbox mb-3" align="center">
								                            <input type="checkbox" class="custom-control-input" id="customCheck1">
								                            <label class="custom-control-label" for="customCheck1">忘記密碼</label>
								                        </div>
								<div style="height: 150px">
									<c:if test="${not empty errorMsgs}">
										<ul>
											<c:forEach var="message" items="${errorMsgs}">
												<li style="color: red">${message}</li>
											</c:forEach>
										</ul>
									</c:if>
								</div>
								<p align="center">
									我也想當大廚, 有請食神帶入坑 <a class="tellfill"
										href="<%=request.getContextPath()%>/front-end/member/addMember.jsp">
										《註冊》</a>
								</p>
								<hr class="my-4">
								<input type="hidden" name="action" value="login">
								<button id="loggingbtn"
									class="btn btn-lg btn-primary btn-block text-uppercase"
									type="submit">登入</button>
							</form>

							<button class="btn btn-lg btn-info btn-block text-uppercase"
								id="sendpw">忘記密碼</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
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
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.15.0/umd/popper.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
	<script src="<%=request.getContextPath()%>/js/poper.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/main.js"></script>

</body>
</html>