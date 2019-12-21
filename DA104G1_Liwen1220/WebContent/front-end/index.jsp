<%@page import="com.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.getSession().setAttribute("URI", request.getRequestURI());
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
        <link rel="icon" href="<%=request.getContextPath()%>/images/高麗菜.png" type="image/gif" sizes="72x72">
        <meta name="author" content="Eat Share teams">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
        <title>分享食刻 Eare</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">
        <script src="https://kit.fontawesome.com/43de8a2881.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar-header navbar navbar-expand-lg navbar-light bg-light fixed-top">
            <a class="navbar-brand" href="<%=request.getContextPath()%>/front-end/index.jsp">
                <h1>分饗食刻</h1>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse d-xs-flex justify-content-end mr-5" id="navbarSupportedContent">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="#"><span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item mr-3">
                        <a class="nav-link" href="#"><i class="fas fa-seedling"></i><span>食譜</span></a>
                    </li>
                    <li class="nav-item mr-3">
                        <a class="nav-link" href="shopping.html"><i class="fas fa-store-alt"></i><span>購物市集</span></a>
                    </li>
                    <li class="nav-item mr-3">
                        <a class="nav-link" href="#"><i class="fas fa-cocktail"></i><span>找廚師</span></a>
                    </li>
                    <li class="nav-item mr-3">
                        <a class="nav-link" href="#"><i class="fas fa-users"></i><span>揪團</span></a></li>
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
            <!-- header開始  輪播圖片 -->
            <header>
                <div class="carousel-header">
                    <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                            <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <div class="pic d-block w-100 bg-cover"
                                style="background-image: url('<%=request.getContextPath()%>/images/montherandchild.jpg');"></div>
                                <div class="carousel-caption d-none d-md-block">
                                    <h5>分饗食刻 Eare</h5>
                                    <p>Eare
                                        是提供一個公開的食譜交流平台，您不但能在網站上找到喜歡的食譜，將食材搖身一變，變成美味菜餚，也能分享自己的食譜。您不但能參考站上多樣的食譜，還能找到喜歡的課程，跟著專業廚師學習，踏上自己的料理之路。
                                    </p>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="pic d-block w-100 bg-cover" style="background-image: url('<%=request.getContextPath()%>/images/vegetables.jpg');">
                                </div>
                                <div class="carousel-caption d-none d-md-block">
                                    <h5>生鮮健康購物</h5>
                                    <p>在這裡，您可以買到當令的蔬果、健康的食材，配合本站食譜，烹煮出屬於自己風格的料理。</p>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="pic d-block w-100 bg-cover" style="background-image: url('<%=request.getContextPath()%>/images/steak.jpg');">
                                </div>
                                <div class="carousel-caption d-none d-md-block">
                                    <h5>專業廚師課程</h5>
                                    <p>您可以在Eare找到專業的廚師，學習自己有興趣的課程，一步步成為料理達人。</p>
                                </div>
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </header>
            <!-- header結束  輪播圖片 -->
            <!-- section開始 網頁簡介 -->
            <section class="top-info bg-info text-center pt-5">
                <div class="container text-white">
                    <div class="row">
                        <div class="col-md-4 col-12">
                            <div class="title-icon"><i class="fas fa-utensils fa-5x"></i></div>
                            <div>
                                <h3>食譜交流</h3>
                                <P>Eare
                                    是提供一個公開的食譜交流平台，您不但能在網站上找到喜歡的食譜，將食材搖身一變，變成美味菜餚，也能分享自己的食譜。您不但能參考站上多樣的食譜，還能找到喜歡的課程，跟著專業廚師學習，踏上自己的料理之路。
                                </P>
                            </div>
                        </div>
                        <div class="col-md-4 col-12">
                            <div class="title-icon"><i class="fas fa-bread-slice fa-5x"></i></div>
                            <div>
                                <h3>揪團服務</h3>
                                <P>一個人做菜讓您覺得孤單嗎? 沒關係! Eare提供您一個社交管道，您可以在此找到喜歡的料理揪團，或是創建屬於自己的揪團，供大家參與。</P>
                            </div>
                        </div>
                        <div class="col-md-4 col-12">
                            <div class="title-icon"><i class="fas fa-carrot fa-5x"></i></div>
                            <div>
                                <h3>鮮食購物</h3>
                                <P>在Eare您不只可以找到喜歡的食譜，您也可以在我們的購物市集，挑選當令生鮮食材，嘗試自己做做看，烹調出屬於你自己的 Style!</P>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- section結束 網頁簡介 -->
            <!-- info start -->
            <section class="info-section container">
                <div class="info mt-5">
                    <h3 class="text-center py-5 text-info"><i class="far fa-star"></i><b
                    style="text-decoration:underline">精選食譜</b><i class="far fa-star"></i></h3>
                    <div class="row align-items-center">
                        <div class="col-lg-4 col-md-6 col-12 menu-col">
                            <a href="#">
                                <div class="card" style="width: 18rem;">
                                    <img class="img-fluid" src="<%=request.getContextPath()%>/images/umeAndmeat.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5>梅干扣肉</h5>
                                        <p class="card-text">經典客家料理，簡單純樸，香氣撲鼻...</p>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-4 col-md-6 col-12 menu-col">
                            <a href="#">
                                <div class="card" style="width: 18rem;">
                                    <img class="img-fluid" src="<%=request.getContextPath()%>/images/noodle.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5>台式海鮮拉麵佐昆布</h5>
                                        <p class="card-text">活跳跳的蝦子，濃郁的湯頭，食用時，彷彿蝦子在舌尖上跳動...</p>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-4 col-md-6 col-12 menu-col">
                            <a href="#">
                                <div class="card" style="width: 18rem;">
                                    <img class="img-fluid" src="<%=request.getContextPath()%>/images/syutofu.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5>酥炸臭豆腐</h5>
                                        <p class="card-text">家喻戶曉的台式料理，料理簡單，食用方便，令人齒頰留香...</p>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="info mt-5">
                    <h3 class="text-center py-5 text-info"><i class="far fa-star"></i><b
                    style="text-decoration:underline">精選廚師</b><i class="far fa-star"></i></h3>
                    <div class="row align-items-center">
                        <div class="col-lg-4 col-md-6 col-12 menu-col">
                            <a href="#">
                                <div class="card" style="width: 18rem;">
                                    <img class="img-fluid" src="<%=request.getContextPath()%>/images/agi.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5>阿雞師</h5>
                                        <p class="card-text">台灣料理界的翹楚，中餐界的霸主，每個男人都會燴飯的錯，一不小心就滑進去...</p>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-4 col-md-6 col-12 menu-col">
                            <a href="#">
                                <div class="card" style="width: 18rem;">
                                    <img class="img-fluid" src="<%=request.getContextPath()%>/images/james.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5>詹姆士</h5>
                                        <p class="card-text">兩個默契絕佳來自不同背景搭檔，對料理的熟稔程度，不亞於專業職人...</p>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-4 col-md-6 col-12 menu-col">
                            <a href="#">
                                <div class="card" style="width: 18rem;">
                                    <img class="img-fluid" src="<%=request.getContextPath()%>/images/goodgoodgod.jpeg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5>阿統師</h5>
                                        <p class="card-text">懂吃、懂玩、懂娛樂，只要有心人人都是食神，一個人可以料理<del>十個人</del>痾..不是，是十道菜...</p>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="info mt-5">
                    <h3 class="text-center py-5 text-info"><i class="far fa-star"></i><b
                    style="text-decoration:underline">精選課程</b><i class="far fa-star"></i></h3>
                    <div class="row align-items-center">
                        <div class="col-lg-4 col-md-6 col-12 menu-col">
                            <a href="#">
                                <div class="card" style="width: 18rem;">
                                    <img class="img-fluid" src="<%=request.getContextPath()%>/images/japancourse.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5>日式料理</h5>
                                        <p class="card-text">誰でも簡単に作る料理 任何人都可以學會的料理</p>
                                        <div class="chef-icon bg-cover" style="background-image:url('<%=request.getContextPath()%>/images/japchef.jpg')">
                                        </div>
                                        <h6 class="text-right chef-name">森上梅友乾</h6>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-4 col-md-6 col-12 menu-col">
                            <a href="#">
                                <div class="card" style="width: 18rem;">
                                    <img class="img-fluid" src="<%=request.getContextPath()%>/images/dumpling.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5>緊緻水餃料理</h5>
                                        <p class="card-text">教你從水餃內餡的製作以及包裹，打造不會破皮的水餃...</p>
                                        <div class="chef-icon bg-cover" style="background-image:url('<%=request.getContextPath()%>/images/chen.jpg')"></div>
                                        <h6 class="text-right chef-name">阿霖師</h6>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-4 col-md-6 col-12 menu-col">
                            <a href="#">
                                <div class="card" style="width: 18rem;">
                                    <img class="img-fluid" src="<%=request.getContextPath()%>/images/fish.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5>蒲燒鯛</h5>
                                        <p class="card-text">ポケモンゲットだぜ炙燒的極致，手把手教學，教您掌控最佳的火候，完美呈現這道料理</p>
                                        <div class="chef-icon bg-cover" style="background-image:url('<%=request.getContextPath()%>/images/wang.jpg')"></div>
                                        <h6 class="text-right chef-name">神奇寶貝大師</h6>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="info mt-5">
                    <h3 class="text-center py-5 text-info"><i class="far fa-star"></i><b
                    style="text-decoration:underline">精選食材</b><i class="far fa-star"></i></h3>
                    <div class="row align-items-center">
                        <div class="col-lg-4 col-md-6 col-12 menu-col">
                            <a href="#">
                                <div class="card" style="width: 18rem;">
                                    <img class="img-fluid" src="<%=request.getContextPath()%>/images/pork.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5>松阪豬</h5>
                                        <p class="card-text">
                                            油脂鮮甜細膩，肉質柔韌帶有脆度，肉腥味淡薄，並帶有獨特的嚼感，可以品嚐到豬肉原始的肉質和甜味。油脂鮮甜細膩，肉質柔韌帶有脆度，肉腥味淡薄，並帶有獨特的嚼感，可以品嚐到豬肉原始的肉質和甜味。油脂鮮甜細膩，肉質柔韌帶有脆度，肉腥味淡薄，並帶有獨特的嚼感，可以品嚐到豬肉原始的肉質和甜味。
                                        </p>
                                        <div class="text-right">售價:<i class="fas fa-dollar-sign ml-2"><span>800</span></i></div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-4 col-md-6 col-12 menu-col">
                            <a href="#">
                                <div class="card " style="width: 18rem;">
                                    <img class="img-fluid" src="<%=request.getContextPath()%>/images/orange.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5>砂糖橘</h5>
                                        <p class="card-text">風味清甜鮮美，含糖量即高、酸度不多，外觀非常討喜，吃過的人都難以忘懷它那甜美的滋味喔!</p>
                                        <div class="text-right">售價:<i class="fas fa-dollar-sign ml-2"><span>100</span></i></div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-4 col-md-6 col-12 menu-col">
                            <a href="#">
                                <div class="card" style="width: 18rem;">
                                    <img class="img-fluid" src="<%=request.getContextPath()%>/images/4seasonbean.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5>四季豆</h5>
                                        <p class="card-text">口感清甜，富含營養且低熱量，是一款健康的豆屬蔬菜；若想替蔬食料理增添一些口感，或是葉菜類蔬菜價格高漲時，四季豆會是很棒的選擇。</p>
                                        <div class="text-right">售價:<i class="fas fa-dollar-sign ml-2"><span>80</span></i></div>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </section>
            <!-- info end -->
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
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
            <script src="sweetalert2.all.min.js"></script>
<!-- <!-- Optional: include a polyfill for ES6 Promises for IE11 --> -->
<!--  <script src="sweetalert2.all.min.js"></script> -->
<!--  <script src="https://cdn.jsdelivr.net/npm/promise-polyfill"></script> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>           -->
<!-- <scrpit> -->
<%-- <c:if test="${not empty alert.success}"> --%>
<!--  swal.fire({ -->
<!--    icon:'success', -->
<!--    title:'修改成功', -->
<!--    text:"修改完成!!" -->
<!--  }); -->
<%--  <% request.removeAttribute("alert"); %> --%>
<%-- </c:if> --%>
<!-- </scrpit> -->           
        </body>
    </html>