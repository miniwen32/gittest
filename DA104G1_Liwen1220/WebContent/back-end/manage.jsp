<%@page import="com.administrator.model.AdministratorVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

AdministratorVO adVO = (AdministratorVO)session.getAttribute("adVO");
String nowInAd_name = (String) session.getAttribute("nowInAd_name");
%>

<!DOCTYPE html>
<html>
<head>
<title>分饗食刻Eare</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="<%=request.getContextPath()%>/images/高麗菜.png" type="image/gif" sizes="72x72">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/manage.css">
    <link href="https://fonts.googleapis.com/css?family=Noto+Serif+TC:700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/43de8a2881.js" crossorigin="anonymous"></script>
            <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
            <script src="<%=request.getContextPath()%>/js/poper.js"></script>
            <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/manager.js"></script>
</head>
<style>

body{
background-image: url("<%=request.getContextPath()%>/images/bg.jpg");
background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    background-attachment: fixed;
}
#bgimg{
    background: rgba(255, 255, 255, 0.2);
}


</style>
<body>
<div id="bgimg">
        <nav id="navheight" class="navbar navbar-expand-sm navbar-light bg-light fixed-top justify-content-between">
            <a class="navbar-brand" href="#"><img src="<%=request.getContextPath()%>/images/logo.svg" alt=""></a>
            <div class="navbar-nav">
                <a class="nav-item nav-link mr-3 h4" href="<%=request.getContextPath()%>/back-end/administrator/administrator_login.jsp">
<!--                 <i class="fas fa-user-tie"></i>管理員登入</a> -->
                <i class="fas fa-user-tie"></i><%=(nowInAd_name == null)? "管理員登入": nowInAd_name +" 想登出"%></a>
            </div>
        </nav>
<!------------------------------ 以上表頭 ------------------------------>
        <div class="main" >
        
            <div class="row no-gutters">
<div class="col-md-3 list d-flex justify-content-end">
					<ul class="menu list-group text-center mt-4 ml-3 w-75">
                        <li class="list-group-item list-group-item-success d-block"><a class="h-100 d-block"
                                href="#">後台員工系統</a>
                                
                            <ul class="list-group text-center">
                                <li class="list-group-item list-group-item-success"><a class="" href="<%=request.getContextPath()%>/back-end/protected/administrator/ad_select_page.jsp">員工管理</a></li>
                                <li class="list-group-item list-group-item-success"><a class="" href="<%=request.getContextPath()%>/back-end/protected/authority/auth_select_page.jsp">權限管理</a></li>
                            </ul>
                        </li>
                        
                      <li class="list-group-item list-group-item-success d-block"><a class="h-100 d-block"
                                href="#">使用者訊息管理</a>
                            <ul class="list-group text-center">
                                <li class="list-group-item list-group-item-success"><a class="h-100 d-block"
                                        href="#">客服系統</a>
                                </li>
                            </ul>
                        </li>
                        

                        <li class="list-group-item list-group-item-success d-block"><a class="h-100 d-block"
                                href="#">檢舉管理</a>
                            <ul class="list-group text-center">
                                <li class="list-group-item list-group-item-success"><a class="h-100 d-block"
                                        href="#">揪團檢舉</a>
                                </li>
                                <li class="list-group-item list-group-item-success"><a class="h-100 d-block"
                                        href="#">食譜檢舉</a>
                                </li>
                                <li class="list-group-item list-group-item-success"><a class="h-100 d-block"
                                        href="#">廚師檢舉</a>
                                </li>
                            </ul>
                        </li>
                        <li class="list-group-item list-group-item-success d-block"><a class="h-100 d-block"
                                href="#">會員管理</a>
                            <ul class="list-group text-center">
                                <li class="list-group-item list-group-item-success"><a class="h-100 d-block"
                                        href="<%=request.getContextPath()%>/back-end/protected/member/mem_select_page.jsp">一般會員管理</a>
                                </li>
                                <li class="list-group-item list-group-item-success"><a class="h-100 d-block"
                                        href="#">廚師管理</a>
                                </li>
                            </ul>
                        </li>
                        <li class="list-group-item list-group-item-success d-block"><a class="h-100 d-block"
                                href="#">購物市集管理</a>
                            <ul class="list-group text-center">
                                <li class="list-group-item list-group-item-success"><a class="h-100 d-block"
                                        href="#">商品管理</a>
                                <li class="list-group-item list-group-item-success"><a class="h-100 d-block"
                                        href="#">訂單管理</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div class="col-md-9"></div>
            </div>
        </div>
<!------------------------------ footer ------------------------------>
        <footer class="text-center text-secondary">&copy;分饗食刻Eare<span id="year"></span></footer>

    </div>
</body>
</html>