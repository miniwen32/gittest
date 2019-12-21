<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<html>
<head>
<title>mem_detail.second</title>
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
<style type="text/css">

body {
	background-image: url('<%=request.getContextPath()%>/gif/desk.jpg');
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	background-attachment: fixed;
}
         #memdetail {
            margin-top: 10%;
        }
        .card{
                    text-align: center;
                }
                .moveicone{
                    margin-top: 10%;
                }
        .main {
            font-weight: bold;
        }
      /*icone動態統一設定*/
        svg {
                        text-align: center;
                        margin: auto;
                        width: 100px;
                        height: 100px;
                }
                /* 會員資料icone*/
#icon-finger-print #path1, #icon-finger-print #path2, #icon-finger-print #path3, #icon-finger-print #path4, #icon-finger-print #path5 {
  fill: none;
  stroke: #282828;
  stroke-dashoffset: 0;
  stroke-width: 1.5;
  -webkit-transition: all 300ms ease;
  transition: all 300ms ease;
  -webkit-animation: fingerprint 6s forwards infinite;
          animation: fingerprint 6s forwards infinite;
}

#icon-finger-print #path1 {
  stroke-dasharray: 12.15426254272461;
}

#icon-finger-print #path2 {
  stroke-dasharray: 19.79115867614746;
}

#icon-finger-print #path3 {
  stroke-dasharray: 53.00725173950195;
}

#icon-finger-print #path4 {
  stroke-dasharray: 23.70177841186523;
}

#icon-finger-print #path5 {
  stroke-dasharray: 8.837481498718262;
}

@-webkit-keyframes fingerprint {
  20% {
    stroke-dashoffset: 40;
  }
  40% {
    stroke-dashoffset: 0;
  }
  100% {
    stroke-dashoffset: 0;
  }
}

@keyframes fingerprint {
  20% {
    stroke-dashoffset: 40;
  }
  40% {
    stroke-dashoffset: 0;
  }
  100% {
    stroke-dashoffset: 0;
  }
}

/* 收藏icone*/
                #icon-hearbeat {
                        -webkit-animation-name: heartbeat2;
                        animation-name: heartbeat2;
                        -webkit-animation-duration: 1s;
                        animation-duration: 1s;
                        -webkit-animation-timing-function: ease-in-out;
                        animation-timing-function: ease-in-out;
                        -webkit-animation-iteration-count: infinite;
                        animation-iteration-count: infinite;
                        -webkit-transform-origin: center center;
                        transform-origin: center center;
                }

                @-webkit-keyframes heartbeat2 {
                        from {
                                -webkit-transform: scale(1);
                                transform: scale(1);
                                -webkit-transform-origin: center center;
                                transform-origin: center center;
                                -webkit-animation-timing-function: ease-out;
                                animation-timing-function: ease-out;
                        }

                        10% {
                                -webkit-transform: scale(0.91);
                                transform: scale(0.91);
                                -webkit-animation-timing-function: ease-in;
                                animation-timing-function: ease-in;
                        }

                        17% {
                                -webkit-transform: scale(0.98);
                                transform: scale(0.98);
                                -webkit-animation-timing-function: ease-out;
                                animation-timing-function: ease-out;
                        }

                        33% {
                                -webkit-transform: scale(0.87);
                                transform: scale(0.87);
                                -webkit-animation-timing-function: ease-in;
                                animation-timing-function: ease-in;
                        }

                        45% {
                                -webkit-transform: scale(1);
                                transform: scale(1);
                                -webkit-animation-timing-function: ease-out;
                                animation-timing-function: ease-out;
                        }
                }

                @keyframes heartbeat2 {
                        from {
                                -webkit-transform: scale(1);
                                transform: scale(1);
                                -webkit-transform-origin: center center;
                                transform-origin: center center;
                                -webkit-animation-timing-function: ease-out;
                                animation-timing-function: ease-out;
                        }

                        10% {
                                -webkit-transform: scale(0.91);
                                transform: scale(0.91);
                                -webkit-animation-timing-function: ease-in;
                                animation-timing-function: ease-in;
                        }

                        17% {
                                -webkit-transform: scale(0.98);
                                transform: scale(0.98);
                                -webkit-animation-timing-function: ease-out;
                                animation-timing-function: ease-out;
                        }

                        33% {
                                -webkit-transform: scale(0.87);
                                transform: scale(0.87);
                                -webkit-animation-timing-function: ease-in;
                                animation-timing-function: ease-in;
                        }

                        45% {
                                -webkit-transform: scale(1);
                                transform: scale(1);
                                -webkit-animation-timing-function: ease-out;
                                animation-timing-function: ease-out;
                        }
                }

/* 廚房icone*/

                #icon-page .page-outline {
                        -webkit-animation-name: line1;
                        animation-name: line1;
                        -webkit-animation-duration: 2s;
                        animation-duration: 2s;
                        stroke-dashoffset: 1000;
                        stroke-dasharray: 1000;
                        -webkit-animation-iteration-count: infinite;
                        animation-iteration-count: infinite;
                        -webkit-animation-timing-function: ease-in-out;
                        animation-timing-function: ease-in-out;
                }

                #icon-page .page-line {
                        -webkit-animation-name: line1;
                        animation-name: line1;
                        -webkit-animation-duration: 2s;
                        animation-duration: 2s;
                        stroke-dashoffset: 1000;
                        stroke-dasharray: 1000;
                        -webkit-animation-delay: 1s;
                        animation-delay: 1s;
                        -webkit-animation-iteration-count: infinite;
                        animation-iteration-count: infinite;
                        -webkit-animation-timing-function: ease-in-out;
                        animation-timing-function: ease-in-out;
                }

                @-webkit-keyframes line1 {
                        to {
                                stroke-dashoffset: 0;
                        }
                }

                @keyframes line1 {
                        to {
                                stroke-dashoffset: 0;
                        }
                }
/* 點數icone*/  
#icon-save-money .dollar {
                        animation: dollar linear 2s infinite;
                        transform-origin:bottom center;
                        
                  }
                  @keyframes dollar{
                    0% {
    -webkit-transform: rotateY(-360deg);
            transform: rotateY(-360deg);
    opacity: 0;
  }
  100% {
    -webkit-transform: rotateY(0deg);
            transform: rotateY(0deg);
    opacity: 1;
  }
}

/* 外派icone*/ 
    #icon-cycling {
      -webkit-transform-origin: center;
      transform-origin: center;
      -webkit-animation: slide-right 2s linear 0.5s infinite;
      animation: slide-right 2s linear 0.5s infinite;
      margin-left: -70px;
    }

    @-webkit-keyframes slide-right {
      0% {
        -webkit-transform: translateX(-100);
        transform: translateX(-100);
      }

      100% {
        -webkit-transform: translateX(100px);
        transform: translateX(100px);
      }
    }

    @keyframes slide-right {
      0% {
        -webkit-transform: translateX(-100);
        transform: translateX(-100);
      }

      100% {
        -webkit-transform: translateX(100px);
        transform: translateX(100px);
      }
    }
/* 揪團icone*/
    #icon-footsteps .foot1 {
      -webkit-animation-name: foot1;
      animation-name: foot1;
      -webkit-animation-duration: 2s;
      animation-duration: 2s;
      -webkit-animation-timing-function: ease;
      animation-timing-function: ease;
      -webkit-animation-iteration-count: infinite;
      animation-iteration-count: infinite;
      -webkit-transform-origin: center center;
      transform-origin: center center;
      margin-top: -10px;
    }

    #icon-footsteps .foot2 {
      -webkit-animation-name: foot2;
      animation-name: foot2;
      -webkit-animation-duration: 2s;
      animation-duration: 2s;
      -webkit-animation-timing-function: ease;
      animation-timing-function: ease;
      -webkit-animation-iteration-count: infinite;
      animation-iteration-count: infinite;
      -webkit-transform-origin: center center;
      transform-origin: center center;
    }

    @-webkit-keyframes foot1 {

      from,
      50%,
      to {
        opacity: 1;
      }

      25%,
      75% {
        opacity: 0;
      }
    }

    @keyframes foot1 {

      from,
      50%,
      to {
        opacity: 1;
      }

      25%,
      75% {
        opacity: 0;
      }
    }

    @-webkit-keyframes foot2 {

      25%,
      75% {
        opacity: 1;
      }

      from,
      50%,
      to {
        opacity: 0;
      }
    }

    @keyframes foot2 {

      25%,
      75% {
        opacity: 1;
      }

      from,
      50%,
      to {
        opacity: 0;
      }
    }  
</style>
</head>
<body>

	<nav
		class="navbar-header navbar navbar-expand-lg navbar-light bg-light fixed-top">
		<a class="navbar-brand" href="<%=request.getContextPath()%>/font-end/index.jsp">
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
				<li class="nav-item mr-3"><a class="nav-link"
					href="<%=request.getContextPath()%>/font-end/member/mem_detail_second.jsp"><img width="22" height="22"
						src="<%=request.getContextPath()%>/images/signup.png" alt=""><span>會員</span></a>
				</li>
				<li class="nav-item mr-3"><a class="nav-link" href="<%=request.getContextPath()%>/font-end/member/mem_login.jsp"><i
						class="fas fa-user-circle"></i><span>登入</span></a></li>
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
							<div class="moveicone">
								<svg id="icon-finger-print" width="34px" height="34px"
									viewBox="0 0 34 34">
          <g transform="translate(7.000000, 6.000000)"
										stroke-linecap="round">
             <path id="path1"
										d="M3.14414922,1.97419264 C3.14414922,1.97419264 5.30885997,0.506351808 9.06036082,0.506351808 C12.8118617,0.506351808 14.781903,1.97419264 14.781903,1.97419264"></path>
             <path id="path2"
										d="M0.466210729,7.27628774 C0.466210729,7.27628774 3.19024811,2.75878123 9.09512428,2.96502806 C15.0000005,3.17127489 17.4745821,7.17202872 17.4745821,7.17202872"></path>
             <path id="path3"
										d="M2,16.4687762 C2,16.4687762 1.12580828,14.9305411 1.27082278,11.9727304 C1.45871447,8.14036841 5.19587478,5.30175361 9.05270871,5.30175361 C12.9095426,5.30175361 15.0000001,7.82879552 15.8975926,9.33195218 C16.5919575,10.4947729 17.7597991,14.4361492 14.6226101,15.0206592 C12.41268,15.4324056 11.5911303,13.4911155 11.5911303,12.9859143 C11.5911303,11.9727302 11.1054172,10.2336826 9.05270848,10.2336826 C6.99999978,10.2336826 6.11384543,11.8665663 6.4593664,13.7955614 C6.6532895,14.8782069 7.59887942,18.3701197 12.0173963,19.5605638"></path>
             <path id="path4"
										d="M7.0204614,19.6657197 C7.0204614,19.6657197 3.88328263,16.5690127 3.88328268,12.9603117 C3.88328274,9.35161068 6.59923746,7.80642537 9.0076008,7.80642554 C11.4159641,7.8064257 14.1798468,9.55747124 14.1798468,12.759562"></path>
             <path id="path5"
										d="M8.95538742,12.6694189 C8.95538742,12.6694189 9.04883608,18.1288401 15.069217,17.3610597"></path>
          </g>

       </svg>

							</div>
							<div class="card-body">
								<form method="post"
						action="<%=request.getContextPath()%>/member/member.do">
						
						<input type="hidden" name="mem_no" value="${memberVO.mem_no}">
						<input type="hidden" name="action" value="get_One_For_Update">
                        <input type="submit" value="資料修改"  id="" class="btn btn-outline-primary btn-sm" href="" role="button"></a>
					</form>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="card">

							<div class="card-header bg-warning text-white">我的收藏</div>
							<!--收藏動圖-->
							<div class="moveicone">
								<svg version="1.1" id="icon-hearbeat"
									xmlns="http://www.w3.org/2000/svg"
									xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
									width="510px" height="510px" viewBox="0 0 510 510"
									style="enable-background: new 0 0 510 510;"
									xml:space="preserve">
                        <path
										d="M369.75,21.675c-43.35,0-86.7,20.4-114.75,53.55c-28.05-33.15-71.4-53.55-114.75-53.55C61.2,21.675,0,82.875,0,161.925
                              c0,96.9,86.7,175.95,219.3,293.25l35.7,33.15l35.7-33.15c130.05-119.85,219.3-198.9,219.3-293.25
                              C510,82.875,448.8,21.675,369.75,21.675z M257.55,419.475H255l-2.55-2.55C130.05,307.274,51,235.875,51,161.925
                              c0-51,38.25-89.25,89.25-89.25c38.25,0,76.5,25.5,91.8,61.2h48.45c12.75-35.7,51-61.2,89.25-61.2c51,0,89.25,38.25,89.25,89.25
                              C459,235.875,379.95,307.274,257.55,419.475z" />
                </svg>


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

							<div class="moveicone">
								<svg id="icon-page" viewBox="0 0 178 211"
									xmlns="http://www.w3.org/2000/svg" clip-rule="evenodd"
									stroke-linejoin="round" stroke-miterlimit="1.5">
                        <path class="page-outline" fill="none"
										stroke="#000" stroke-width="15"
										d="M5.208 5.208h166.667v200H5.208z" />
                        <path class="page-line blink"
										d="M138.542 65.778a4.167 4.167 0 0 0-4.167-4.166H42.708a4.166 4.166 0 0 0-4.166 4.166v8.334a4.166 4.166 0 0 0 4.166 4.166h91.667a4.167 4.167 0 0 0 4.167-4.166v-8.334zM138.542 136.305a4.167 4.167 0 0 0-4.167-4.167H42.708a4.167 4.167 0 0 0-4.166 4.167v8.334a4.166 4.166 0 0 0 4.166 4.166h91.667a4.167 4.167 0 0 0 4.167-4.166v-8.334z"
										fill="#ff4776" />
                </svg>
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
							<div class="moveicone">
								<svg id="icon-save-money" viewBox="-29 0 487 487.719"
									xmlns="http://www.w3.org/2000/svg">
                  <g class="dollar">
                  <path fill="#ea3970"
										d="M220.867 266.176a7.616 7.616 0 0 0-2.742-.094c-9.16-1.066-16.07-8.816-16.086-18.035a8 8 0 0 0-16 0c.024 15.394 10.32 28.879 25.164 32.953v8a8 8 0 0 0 16 0v-7.516c17.133-3.586 28.777-19.543 26.977-36.953-1.805-17.41-16.473-30.64-33.977-30.644-10.031 0-18.164-8.133-18.164-18.164s8.133-18.164 18.164-18.164 18.164 8.132 18.164 18.164a8 8 0 0 0 16 0c-.023-16.164-11.347-30.106-27.164-33.442V155a8 8 0 0 0-16 0v7.77c-16.508 4.507-27.133 20.535-24.86 37.496s16.747 29.62 33.86 29.617c9.899 0 17.973 7.926 18.152 17.82.184 9.895-7.597 18.113-17.488 18.473zm0 0" />
                  <path fill="#ea3970"
										d="M104.195 222.5c0 64.07 51.938 116.008 116.008 116.008S336.211 286.57 336.211 222.5s-51.938-116.008-116.008-116.008c-64.039.07-115.933 51.969-116.008 116.008zm116.008-100.008c55.234 0 100.008 44.774 100.008 100.008s-44.774 100.008-100.008 100.008S120.195 277.734 120.195 222.5c.063-55.207 44.801-99.945 100.008-100.008zm0 0" />
              </g>
                  <path fill="#2a2a31"
										d="M375.648 358.23l-62.668 29.61a51.043 51.043 0 0 0-43.515-26.852l-57.852-1.59a61.1 61.1 0 0 1-26.293-6.789l-5.886-3.05a103.833 103.833 0 0 0-96.176.101l.367-13.336a8 8 0 0 0-7.777-8.219L12.41 326.36a7.997 7.997 0 0 0-8.215 7.778L.363 473.347a8 8 0 0 0 7.778 8.22l63.437 1.746h.219a8 8 0 0 0 8-7.782l.183-6.66 16.48-8.824a28.269 28.269 0 0 1 21.099-2.309l98.414 27.621c.172.051.343.09.52.13a105.348 105.348 0 0 0 21.628 2.23 106.739 106.739 0 0 0 44.59-9.73 7.43 7.43 0 0 0 .992-.548l142.692-92.296a8.004 8.004 0 0 0 2.62-10.657c-10.593-18.797-34.09-25.957-53.367-16.258zM16.578 465.793l3.39-123.219 47.442 1.305-3.39 123.223zm258.926-2.094a90.704 90.704 0 0 1-55.469 6.192l-98.148-27.551a44.236 44.236 0 0 0-32.977 3.605l-8.422 4.512 2.254-81.926a87.938 87.938 0 0 1 89.336-4.765l5.887 3.05a77.267 77.267 0 0 0 33.21 8.579l57.856 1.59c16.25.468 30.051 12.038 33.348 27.96l-86.176-2.379c-4.418-.12-8.094 3.364-8.219 7.778a8.003 8.003 0 0 0 7.778 8.219l95.101 2.617h.223a8 8 0 0 0 7.992-7.782 50.772 50.772 0 0 0-.773-10.378l64.277-30.372c.063-.027.125-.058.188-.09a24.443 24.443 0 0 1 27.64 3.872zm0 0" />
              </svg>
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
							<div class="moveicone">

								<svg id="icon-cycling" version="1"
									xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
      <path fill="#ea3970"
										d="M331 123c23 0 42-20 42-43s-19-43-42-43-43 20-43 43 19 43 43 43zM107 261a107 107 0 1 0 107 107c-1-59-49-107-107-107zm0 182c-42 0-75-33-75-75s33-75 75-75c41 0 74 33 74 75s-33 75-74 75z" />
      <path fill="#2a2a31"
										d="M404 239v-43c-32 0-58-11-78-31l-41-40c-7-8-17-13-29-13s-22 4-30 13l-59 58c-7 8-12 19-12 30s5 23 12 31l68 60v107h42V277l-47-47 51-51 16 16c26 28 64 44 107 44z" />
      <path fill="#ea3970"
										d="M405 261a107 107 0 1 0 107 107c0-59-48-107-107-107zm0 182c-41 0-74-33-74-75s33-75 74-75c42 0 75 33 75 75s-33 75-75 75z" />
    </svg>
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
							<div class="moveicone">
								<svg version="1.1" id="icon-footsteps"
									xmlns="http://www.w3.org/2000/svg"
									xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
									viewBox="0 0 512 512"
									style="enable-background: new 0 0 512 512;"
									xml:space="preserve">
      <g class="foot1">
        <path stroke=""
										d="M209.5,371.069H104.506c-4.49,38.638-6.83,109.404,23.999,133.063
                     c13.449,10.349,29.538,9.479,45.387,3.21c20.909-8.29,35.458-21.759,43.258-39.998C231.309,433.975,219.789,399.787,209.5,371.069z
                     M202.39,461.064c-6.06,14.199-17.639,24.779-34.438,31.428c-12.619,5-22.349,4.67-29.728-1
                     c-21.889-16.819-21.769-75.606-19.349-104.384h79.765c5.46,14.939,14.859,47.867,3.75,73.926V461.064z" />
        <path stroke="#2a2a31"
										d="M161.692,70.616c-10.189,5.38-80.395,17.619-84.715,134.422c-1.9,50.667,8,94.845,19.719,140.082
                     H211.39c19.999-65.526,46.157-190.579,6.63-246.136C196.62,68.906,163.252,70.996,161.692,70.616z M199.5,329.121h-90.695
                     c-6.45-24.139-17.739-74.226-15.899-123.483c2.42-64.646,26.279-104.644,70.916-118.933c17.999,0.92,31.498,8,41.158,21.549
                     C239.178,156.301,215.779,271.985,199.5,329.121L199.5,329.121z" />
      </g>
      <g class="foot2">
        <path stroke="#2a2a31"
										d="M407.419,300.413H302.424c-2.51,7-24.999,55.537-7.61,96.235
                     c7.8,18.279,22.349,31.748,43.258,39.998c15.849,6.27,31.938,7.14,45.387-3.21c15.529-11.939,24.359-37.078,26.249-74.746
                     C410.622,339.235,409.856,319.737,407.419,300.413z M393.739,357.98c-1.62,32.308-8.549,54.047-19.999,62.866
                     c-7.39,5.68-17.119,6-29.738,1c-16.799-6.65-28.378-17.229-34.438-31.428c-11.109-26.059-1.71-58.997,3.75-73.996h79.725
                     C394.134,330.246,394.368,344.126,393.739,357.98z" />
        <path stroke="#2a2a31"
										d="M435.007,134.382C430.427,11.869,352.052,1.57,350.242,0c-2.13,0.47-34.818-1.9-56.277,28.328
                     c-39.578,55.557-13.409,180.66,6.58,246.136h114.743C427.247,228.337,436.957,185.279,435.007,134.382z M403.129,258.465h-90.695
                     c-16.259-56.997-39.688-172.79-5.49-220.857c9.659-13.609,23.139-20.609,41.168-21.559c44.637,14.299,68.496,54.297,70.916,118.933
                     C420.868,184.24,409.578,234.327,403.129,258.465z" />
      </g>
    </svg>
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
	</div>
	</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
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