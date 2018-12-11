<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<jsp:include page="/WEB-INF/include/css.jsp" flush="true" />
<jsp:include page="/WEB-INF/include/tagLib.jsp" flush="true" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<%
	response.setHeader("Content-Type", "application/xml");
	response.setContentType("text/xml;charset=UTF-8");
	response.setCharacterEncoding("utf-8");
	String mbId = (String)session.getAttribute("memberId") == null ? "" : (String)session.getAttribute("memberId");
	out.println(mbId);
	if( mbId == ""){
		%>
		<script>
			location.href = "/";
		</script>
		<%
	}
%>
<head>

<!-- <meta charset="utf-8"> -->
<META http-equiv="Content-Type" content="text/html; charset= UTF8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Pentacrid Home</title>

</head>

<body class="">
    <div class="page-wrapper">
        <!-- HEADER MOBILE-->
        <header class="header-mobile d-block d-lg-none">
            <div class="header-mobile__bar">
                <div class="container-fluid">
                    <div class="header-mobile-inner">
                        <a class="logo" href="/">
                            <img src="/resources/images/icon/logo.png" alt="CoolAdmin" />
                        </a>
                        <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                        </button>
                    </div>
                </div>
            </div>
            <nav class="navbar-mobile">
                <div class="container-fluid">
                    <ul class="navbar-mobile__list list-unstyled">
  	                    <c:forEach items="${menu}" var ="menu">
	                    	<li class="active has-sub">
	                            <a class="js-arrow" href="#">
	                                <i class="${menu.menuIcon}"></i>${menu.menuLabel}
	                            	<input type="hidden" id="menuHref" value="${menu.menuHref}"/>   
	                            </a>
	                            <c:if test = "${!empty subMenu}">
	                            	<ul class="list-unstyled navbar__sub-list js-sub-list">
			                            <c:forEach items="${subMenu}" var ="subMenu">
				                            <c:if test="${subMenu.menuId==menu.menuId}">
			                            		<li> 
				                                    <a href="#">${subMenu.menuLabel}
				                                    	<input type="hidden" id="menuHref" value="${subMenu.menuHref}"/>
				                                    </a>
				                                </li>
		                            		</c:if>
			                            </c:forEach>
		                            </ul>
	                            </c:if> 
	                        </li>
	                    </c:forEach>
                    </ul>
                </div>
            </nav>
        </header>
        <!-- END HEADER MOBILE-->

        <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar d-none d-lg-block">
            <div class="logo">
                <a href="#">
                    <img src="/resources/images/icon/logo.png" alt="Cool Admin" />
                </a>
            </div>
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
	                    <c:forEach items="${menu}" var ="menu">
	                    	<li class="active has-sub">
	                            <a class="js-arrow" href="#">
	                                <i class="${menu.menuIcon}"></i>${menu.menuLabel}
	                            	<input type="hidden" id="menuHref" value="${menu.menuHref}"/>   
	                            </a>
	                            <c:if test = "${!empty subMenu }">
	                            	<ul class="list-unstyled navbar__sub-list js-sub-list">
			                            <c:forEach items="${subMenu}" var ="subMenu">
				                            <c:if test="${subMenu.menuId==menu.menuId}">
			                            		<li> 
				                                    <a href="#">${subMenu.menuLabel}</a>
				                                    <input type="hidden" id="menuHref" value="${subMenu.menuHref}"/>   
				                                </li>
		                            		</c:if>
			                            </c:forEach>
		                            </ul>
	                            </c:if> 
	                        </li>
	                    </c:forEach>
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->

        <!-- PAGE CONTAINER-->
        <div class="page-container">
            <!-- HEADER DESKTOP-->
            <header class="header-desktop">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="header-wrap">
                            <form class="form-header" action="" method="POST">
                                <input class="au-input au-input--xl" type="text" name="search" placeholder="Search for datas &amp; reports..." />
                                <button class="au-btn--submit" type="submit">
                                    <i class="zmdi zmdi-search"></i>
                                </button>
                            </form>
                            <div class="header-button">
                                <div class="noti-wrap">
								</div>
                                <div class="account-wrap">
                                    <div class="account-item clearfix js-item-menu">
                                        <div class="content">
                                            <a class="js-acc-btn" href="#">${memberInfo.mbName}님</a>
                                        </div>
                                        <div class="account-dropdown js-dropdown">
                                            <div class="account-dropdown__body">
                                                <div class="account-dropdown__item">
                                                    <a href="#" id="memberModify">
                                                        <i class="zmdi zmdi-account"></i>정보수정</a>
                                                </div>
                                            </div>
                                            <div class="account-dropdown__footer">
                                                <a href="#" id ="logout">
                                                    <i class="zmdi zmdi-power"></i>Logout</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            <!-- HEADER DESKTOP-->

            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="overview-wrap" id="overview-wrap">
                                    <h2 class="title-1">overview</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>
		<input type="hidden" id ="mbId" value="${memberInfo.mbId}">
		<input type="hidden" id ="mbName" value="${memberInfo.mbName}">
    </div>
    <div class="progress mb-2" id ="msgWait" style="display:none">
		<div class="progress-bar bg-info progress-bar-striped progress-bar-animated" role="progressbar" style="width: 0%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100">Now Loding</div>
	</div>
	<script src="/resources/vendor/animsition/animsition.min.js"></script>
    <script src="/resources/js/main.js?ver=1.1"></script>
    <script src="/resources/js/attr.js"></script>
	<script>
		/*인물정보 수정*/
		$("#memberModify").click(function(){
			var progressSpeed = 1000;
			var dataSet = {
				memberId : $("#mbId").val(),
			};
			utilCommonPage($("#overview-wrap"),"/member/memberModify", dataSet, false);
		});
		function utilCommonPage($contents,url,postData,async){
			/* $contents : 데이터 뿌려줄 컨텐츠 */
			/* url : 요청 URL */
			/* postData : json 형식 데이터 */
			/* async : 동기화 여부(true/false) */
			var progressSpeed = 1000;
			var result = null;
			$.ajax({
				method : "POST",
				contentType : 'application/json;charset=UTF-8',
				async: false,
				url : url,
				data : JSON.stringify(postData),
				timeout : 100000,
				
				success : function(data) {
					$contents.html(data);
				},
				beforeSend:function(){
					$contents.fadeOut(0);
					$.blockUI({
						message : $("#msgWait div").animate({width:"100%"},progressSpeed)
					});
				},
				error:function(request,status,error){
					alert(request+" : "+status+" : "+error);
				},
				done : function(e) {
					console.log("DONE");
				},
				complete : function() { // 정상이든 비정상인든 실행이 완료될 경우 실행될 함수
					var menu = $('.js-item-menu');
				    var sub_menu_is_showed = -1;
					for (var i = 0; i < menu.length; i++) {
			            $(menu[i]).removeClass("show-dropdown");
			          }
			          $(this).toggleClass('show-dropdown');
			        sub_menu_is_showed = jQuery.inArray(this, menu);
					/* 블록UI 해제 */
					setTimeout(function() {
						$.unblockUI();
						$contents.fadeIn(progressSpeed);
					}, progressSpeed*2);
				}
			});
		};

	</script>
</body>
</html>


