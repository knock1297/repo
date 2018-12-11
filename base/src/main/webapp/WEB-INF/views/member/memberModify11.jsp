
<%
	response.setCharacterEncoding("utf-8");
%>
<META http-equiv="Content-Type" content="text/html; charset=UTF8">
<c:forEach items="${List[0]}" var="memberInfo">
	<div class="col-md-12">
		<div class="row">
			<div class="col-md-12">
				<h2>회원정보 수정</h2>
			</div>
		</div>
	</div>
	<div class="col-md-12">
		<div class="row">
			<div class="col-md-12">
				<h2>${memberInfo.mbName}</h2>
			</div>
		</div>
	</div>
	
</c:forEach>

