<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/WEB-INF/views/script/domFile.jsp" flush="false" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		$(document).ready(function() {
			var dataSet = {
				id : "knock12",
				pw : "password"
			}
			var url = "admin/dashBoard"
			var aa = utilCommonPage(url,dataSet,false);
			alert(aa)
		});
		function utilCommonPage( /* $contents, */ url, postData, async) {
			/* $contents : 데이터 뿌려줄 컨텐츠 */
			/* url : 요청 URL */
			/* postData : json 형식 데이터 */
			/* async : 동기화 여부(true/false) */
			// 		var progressSpeed = 1000;
			var result = null;
			$.ajax({
				method : "POST",
				contentType : 'application/json;charset=UTF-8',
				async : async,
				url : url,
				data : JSON.stringify(postData),
				timeout : 100000,
	
				success : function(data) {
					result = data;
				},
				beforeSend : function() {
					// 				$contents.fadeOut(0);
					// 				$.blockUI({
					// 					message : $("#msgWait div").animate({width:"100%"},progressSpeed)
					// 				});
				},
				error : function(request, status, error) {
					alert(request + " : " + status + " : " + error);
				},
				done : function(e) {
					console.log("DONE");
				},
				complete : function() { // 정상이든 비정상인든 실행이 완료될 경우 실행될 함수
					// 				var menu = $('.js-item-menu');
					// 			    var sub_menu_is_showed = -1;
					// 				for (var i = 0; i < menu.length; i++) {
					// 		            $(menu[i]).removeClass("show-dropdown");
					// 		          }
					// 		          $(this).toggleClass('show-dropdown');
					// 		        sub_menu_is_showed = jQuery.inArray(this, menu);
					// 				/* 블록UI 해제 */
					// 				setTimeout(function() {
					// 					$.unblockUI();
					// 					$contents.fadeIn(progressSpeed);
					// 				}, progressSpeed*2);
				}
				
			});
			return result;
		}
	</script>
</body>
</html>