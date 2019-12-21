<%@page import="com.administrator.model.AdministratorVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	AdministratorVO adVO = (AdministratorVO) session.getAttribute("adVO");
	String account = (String) request.getAttribute("account");
	String nowInAd_name = (String) session.getAttribute("nowInAd_name");
%>
<html>
<head>
<title>分饗食刻Eare</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" href="<%=request.getContextPath()%>/images/高麗菜.png"
	type="image/gif" sizes="72x72">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/manage.css">
<link
	href="https://fonts.googleapis.com/css?family=Noto+Serif+TC:700&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/43de8a2881.js"
	crossorigin="anonymous"></script>
<style type="text/css">
body {
	background-image: url("<%=request.getContextPath()%>/images/bg.jpg");
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	background-attachment: fixed;
}

#bgimg {
	background: rgb(255, 255, 255, 0.2);
}

.logging {
	margin-top: 100px;
}

:root { -
	-input-padding-x: 1.5rem; -
	-input-padding-y: .75rem;
}

.card-signin {
	border: 0;
	border-radius: 1rem;
	box-shadow: 0 0.5rem 1rem 0 rgba(0, 0, 0, 0.2);
}

.card-signin .card-title {
	margin-bottom: 2rem;
	font-weight: 300;
	font-size: 2rem;
}

.card-signin .card-body {
	padding: 2rem;
}

.form-signin {
	width: 100%;
	font-size: 1.3rem;
}

.forgotpw .btn {
	font-size: 1.5rem;
	border-radius: 5rem;
	letter-spacing: 1rem;
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
	<div id="bgimg">
		<nav id="navheight"
			class="navbar navbar-expand-sm navbar-light bg-light fixed-top justify-content-between">
			<a class="navbar-brand"
				href="<%=request.getContextPath()%>/back-end/manage.jsp"><img
				src="<%=request.getContextPath()%>/images/logo.svg" alt=""></a>
			<div class="navbar-nav">
				<a class="nav-item nav-link mr-3 h4"
					href="<%=request.getContextPath()%>/back-end/administrator/administrator_login.jsp">
					<i class="fas fa-user-tie"></i>管理員登入</a>


					
			</div>
		</nav>
		<div class="main">

			<!--管理員登入-->
			<div class="container logging">
				<div class="row">
					<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
						<div class="card card-signin my-5">
							<div class="card-body">
								<h5 class="card-title text-center">管理員登入</h5>
								
								<div class="forgotpw">
									<form class="form-signin" method="post"
										action="<%=request.getContextPath()%>/administrator/loginHandlerAd.do">
										<label for="inputaccount">帳號</label>


										<p>
											<input type="text" name="account" id="inputaccount"
												class="form-control" placeholder="Account" required
												autofocus value="${(account == null) ? '': account}">
										</p>
										<label for="inputPassword">密碼</label>
										<p>
											<input type="password" name="password" id="inputPassword"
												class="form-control" placeholder="Password" required>
										</p>


										<div class="custom-control custom-checkbox mb-3"
											align="center">
											<input type="checkbox" class="custom-control-input"
												id="customCheck1"> <label
												class="custom-control-label" for="customCheck1">記住密碼</label>
										</div>


										<div style="height: 100px">
											
											<c:if test="${not empty errorMsgs}">
												<ul>
													<c:forEach var="message" items="${errorMsgs}">
														<li style="color: red">${message}</li>
													</c:forEach>
												</ul>
											</c:if>

										</div>
										<hr class="my-4">
										<button
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
		</div>
		<footer class="text-center text-secondary">
			&copy;分饗食刻Eare<span id="year"></span>
		</footer>
		<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
		<script src="<%=request.getContextPath()%>/js/poper.js"></script>
		<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/manager.js"></script>
	</div>
</body>
</html>