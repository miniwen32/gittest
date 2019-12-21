<%@page import="java.util.List"%>
<%@page import="com.member.model.MemberVO"%>
<%@page import="com.member.model.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");

response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

%>
<html>
<head>
<title>mem_detail</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta name="description" content="分饗食刻 Eare 食譜網站">
<meta name="keywords" content="EatShare 分饗食刻 食譜 找廚師">
<link rel="icon" href="<%=request.getContextPath()%>/images/高麗菜.png"
	type="image/gif" sizes="72x72">
<meta name="author" content="Eat Share teams">
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css"> -->
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

#memdetail {
	margin-top: 10%;
}

.card {
	text-align: center;
}

.moveicone {
	margin-top: 10%;
}

.main {
	font-weight: bold;
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
	<!--會員資料修改-->
	<div id="memdetail">
		<div class="main">
			<div class="container">
				<div class="row">
					<div class="col-md-4">
						<div class="card">
							<div class="card-header bg-danger text-white">我的基本資料</div>
							<!--資料修改動圖-->
							<img src="<%=request.getContextPath()%>/gif/mem.gif"
								class="img-fluid">
							<div class="card-body">


<!-- --------------------資料修改按鈕-------------------- -->
								<form method="post"
									action="<%=request.getContextPath()%>/member/member.do">
									<input type="submit" value="資料修改" class="btn btn-outline-primary btn-sm" role="button">
									<input type="hidden" name="mem_no" value="${memberVO.mem_no}">
									<input type="hidden" name="action" value="get_One_For_Update">
								</form>
<!-- ------------------資料修改按鈕end------------------ -->
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="card">

							<div class="card-header bg-warning text-white">我的收藏</div>
							<!--收藏動圖-->
							<div class="love">
								<img src="<%=request.getContextPath()%>/gif/heart.gif"
									class="img-fluid">
							</div>
							<div class="card-body">
								<a name="" id="" class="btn btn-outline-primary btn-sm" href="#"
									role="button">收藏廚師</a> <a name="" id=""
									class="btn btn-outline-primary btn-sm" href="#" role="button">收藏食譜</a>
								<a name="" id="" class="btn btn-outline-primary btn-sm" href="#"
									role="button">收藏商品</a>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="card">
							<div class="card-header bg-dark text-white">我的廚房</div>
							<!--廚房動圖-->

							<div class="food">
								<img src="<%=request.getContextPath()%>/gif/re.gif"
									class="img-fluid">
							</div>
							<div class="card-body">
								<a name="" id="" class="btn btn-outline-primary btn-sm" href="#"
									role="button">新增食譜</a> <a name="" id=""
									class="btn btn-outline-primary btn-sm" href="#" role="button">修改食譜</a>
								<a name="" id="" class="btn btn-outline-primary btn-sm" href="#"
									role="button">刪除食譜</a>
							</div>
						</div>
					</div>
				</div>
				<div class="row mt-5">
					<div class="col-md-4">
						<div class="card">
							<div class="card-header bg-info text-white">我的點數</div>
							<!--點數icone-->
							<div class="money">
								<img src="<%=request.getContextPath()%>/gif/point.gif"
									class="img-fluid">
							</div>

							<div class="card-body">
								<a name="" id="" class="btn btn-outline-primary btn-sm" href="#"
									role="button">儲值點數</a> <a name="" id=""
									class="btn btn-outline-primary btn-sm" href="#" role="button">交易紀錄</a>
								<a name="" id="" class="btn btn-outline-primary btn-sm" href="#"
									role="button">點數兌現</a>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="card">
							<div class="card-header bg-secondary text-white">我的外派廚師</div>

							<!--廚師icon-->
							<div class="food">
								<img src="<%=request.getContextPath()%>/gif/chef.gif"
									class="img-fluid">
							</div>
							<div class="card-body">
								<a name="" id="" class="btn btn-outline-primary btn-sm" href="#"
									role="button">在線課程資訊</a> <a name="" id=""
									class="btn btn-outline-primary btn-sm" href="#" role="button">歷史訂單</a>
								<a name="" id="" class="btn btn-outline-primary btn-sm" href="#"
									role="button">申請成為廚師</a>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="card">
							<div class="card-header bg-success text-white">我的揪團</div>
							<!--揪團icone-->
							<div class="food">
								<img src="<%=request.getContextPath()%>/gif/walk.gif"
									class="img-fluid">
							</div>

							<div class="card-body">
								<a name="" id="" class="btn btn-outline-primary btn-sm" href="#"
									role="button">成團通知</a> <a name="" id=""
									class="btn btn-outline-primary btn-sm" href="#" role="button">參團資訊</a>
								<a name="" id="" class="btn btn-outline-primary btn-sm" href="#"
									role="button">歷史紀錄</a> <a name="" id=""
									class="btn btn-outline-primary btn-sm" href="#" role="button">開團管理</a>
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
</body>
</html>