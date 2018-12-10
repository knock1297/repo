<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/WEB-INF/views/script/domFile.jsp" flush="false" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
<script>
// 	$(document).ready(function() {
// 		alert();
// 	});
	$(function(){
		$("#submit1").click(function(){
			$("#test").submit();
		})
	});
</script>
</head>
<body>index입니다.
<form id="test" method="POST" action="admin/adminTest">
	<input type="text" value="aa" name="t1" id="t1">
	<input type="button" id="submit1" value="test">
</form>
</body>
</html>