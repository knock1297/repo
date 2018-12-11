<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/include/css.jsp" flush="true" />
<jsp:include page="/WEB-INF/include/tagLib.jsp" flush="true" />
<!DOCTYPE html>
<html>
<%String mbId = (String)session.getAttribute("memberId") == null ? "" : (String)session.getAttribute("memberId");
	out.println(mbId);
	if( mbId != ""){
		%>
		<script>
			location.href = "main/index";
		</script>
		<%
	}
%>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Pentacrid Login</title>

</head>

<body>
	<section class="login-block" style="height: 100%">
		<div class="container">
			<div class="row">
				<div class="col-md-6 login-sec">회사로고</div>
				<div class="col-md-6 login-sec">
					<h2 class="text-center">login</h2>
					<form id="loginForm" method="POST">
						<div class="form-group">
							<input type="text" class="form-control" value="${loginId}"
								placeholder="E-mail" name="loginId" id="loginId">

						</div>
						<div class="form-group">
							<input type="password" class="form-control"
								placeholder="Password" name="password" id="password">
						</div>


						<div class="form-check">
<!-- 							<label class="form-check-label"> <input type="checkbox" -->
<!-- 								name="rememberChk" id="rememberChk" class="form-check-input"> -->
<!-- 								&nbsp; -->
<!-- 								<small>&nbsp; Remember Me</small> -->
<!-- 							</label> -->
							<button type="button" class="btn btn-login float-right"
								onClick="login()">Login</button>
						</div>

					</form>
					<div class="copy-text">
						contract <i class="fa fa-heart"></i> by <a href="#">knock1297@gmail.com</a>

					</div>

				</div>
			</div>
		</div>
	</section>
</body>
<script>

	function login() {
		$.ajax({
			url : "/login/loginChk",
			type : "POST",
			data : $("#loginForm").serialize(),
			beforeSend : function() { // ajax 요청하기전에 실행되는 함수
				/* 블록UI */
				$.blockUI({
					message : "로그인중입니다."
				});
			},
			success : function(memberInfo) {
				/* 콜백 */
				setTimeout(function() {
					if (memberInfo.mbName != null) {
						$.blockUI({
							message : memberInfo.mbName + "님 환영 합니다."
						});
						location.href = "/main/index";
					} else {
						$.blockUI({
							message : "로그인에 실패했습니다."
						});
					}
				}, 500);
			},
			complete : function(memberInfo) { // 정상이든 비정상인든 실행이 완료될 경우 실행될 함수
				/* 블록UI 해제 */
				setTimeout(function() {
					$.unblockUI();
				}, 500);
			}
		});
	}
	$(function(){
		$("#password").keyup(function(e){
			if(e.keyCode == '13'){
				login();
			}
		});
	});
</script>

</html>


