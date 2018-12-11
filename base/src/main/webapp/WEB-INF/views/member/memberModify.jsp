<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
// 	response.setHeader("Content-Type", "application/xml");
// 	response.setContentType("text/xml;charset=UTF-8");
	response.setCharacterEncoding("utf-8");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <h2>${rtMap[0]}</h2> --%>
<!-- <h2>list</h2> -->
<c:set var="memberInfo" value="${rtMap[0]}"/>
	<div class="card">
		<div class="card-header">
			<strong>Basic Info</strong> Elements
		</div>
		<div class="card-body card-block">
			<form action="" method="post" enctype="multipart/form-data"
				class="form-horizontal">
				<div class="row form-group">
					<div class="col col-md-4">
						<label class=" form-control-label">Employee number</label>
					</div>
					<div class="col-12 col-md-8">
						<p class="form-control-static"id="input-comno">${memberInfo.mbNo}</p>
					</div>
				</div>
				<div class="row form-group">
					<div class="col col-md-4">
						<label class=" form-control-label">ID</label>
					</div>
					<div class="col-12 col-md-8">
						<p class="form-control-static" id="input-id">${memberInfo.mbId}</p>
					</div>
				</div>
				<div class="row form-group">
					<div class="col col-md-4">
						<label class=" form-control-label">Name</label>
					</div>
					<div class="col-12 col-md-8">
						<p class="form-control-static" id="input-name">${memberInfo.mbName}</p>
					</div>
				</div>
				<div class="row form-group">
					<div class="col col-md-4">
						<label class=" form-control-label">Resident Registration
							Number</label>
					</div>
					<div class="col-12 col-md-8">
						<input type="text" readonly style="width:30%" id="input-jumin" value="${memberInfo.mbJumin}">-
						<input type="text" readonly style="width:30%" id="input-gender" value=${memberInfo.mbGender == "M"? "1******" : "2******"}>
					</div>
				</div>
				<div class="row form-group">
					<div class="col col-md-4">
						<label for="email-input" class=" form-control-label">Telephone Number</label>
					</div>
					<div class="col-12 col-md-8">
						<input type="email" id="input-ponn"
							placeholder="Telephone Number" class="form-control" value="${memberInfo.mbPonn}">
					</div>
				</div>
				<div class="row form-group">
					<div class="col col-md-4">
						<label for="email-input" class=" form-control-label">Email</label>
					</div>
					<div class="col-12 col-md-8">
						<input type="email" id="email" name="email"
							placeholder="Enter Email" class="form-control" value="${memberInfo.mbEmail}">
					</div>
				</div>
				<div class="row form-group">
					<div class="col col-md-4">
						<label for="password-input" class=" form-control-label">Password</label>
					</div>
					<div class="col-12 col-md-4">
						<input type="password" id="password-input" name="password-input"
							placeholder="Password" class="form-control"> 
					</div>
					<div class="col-12 col-md-4">
						<input type="password" id="password-confirm"
							placeholder="Password Confirm" class="form-control"> 
					</div>
				</div>
				<div class="row form-group">
					<div class="col col-md-4">
						<label for="password-input" class=" form-control-label">Password Confirm</label>
					</div>
					<div class="col-12 col-md-8">
						<input type="text" readonly id="input-adress" value="${memberInfo.mbAdress}"
						style="width:100%">
					</div>
				</div>
			</form>
		</div>
		<div class="card-footer">
			<button type="submit" class="btn btn-primary btn-sm">
				<i class="fa fa-dot-circle-o"></i> Submit
			</button>
			<button type="reset" class="btn btn-danger btn-sm">
				<i class="fa fa-ban"></i> Reset
			</button>
		</div>
	</div>
