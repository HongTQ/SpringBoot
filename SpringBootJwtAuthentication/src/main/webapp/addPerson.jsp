<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Log in with your account</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet"
	type="text/css">
</head>

<body>
	<div class="container-fluid">
		<div class="container">
			<div class="row bg-dark">
				<div class="col-md-6 align-self-center">
					<a class="navbar-brand text-danger" href="/">Demo Spring Boot
						and Thymeleaf </a>
				</div>
				<div class="col-md-6">
					<nav class="navbar navbar-expand-md navbar-dark">
						<ul class="navbar-nav ml-auto">
							<li class="nav-item active"><a class="nav-link" href="/">List
									Persons</a></li>
							<li class="nav-item"><a class="nav-link" href="/listCareers">List
									Careers </a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
		<div class="container my-3">
			<h2>Add person</h2>
			<form>
				<div class="form-group">
					<label for="last_name">Name:</label>
					<div id="fail_name" class="text-danger"></div>
					<input type="text" class="form-control"
						placeholder="Enter name" id="name" />
				</div>
				<div class="form-group">
					<label for="user_name">User name:</label>
					<div id="fail_user_name" class="text-danger"></div>
					<input type="text" class="form-control"
						placeholder="Enter user name" id="user_name"/>
				</div>
				<div class="form-group">
					<label for="birthday">Birthday</label>
					<div id="fail_birthday" class="text-danger"></div>
					<input type="date" class="form-control"
						placeholder="Enter birthday" id="birthday" />
				</div>
				<div class="form-group">
					<label for="phone">Phone</label>
					<div id="fail_phone" class="text-danger"></div>
					<input type="text" class="form-control" placeholder="Enter phone"
						id="phone" />
				</div>
				<div class="form-group">
					<label for="address">Address</label>
					<div id="fail_address" class="text-danger"></div>
					<input type="text" class="form-control" placeholder="Enter address"
						id="address" />
				</div>
				<div class="form-group">
					<label for="email">Email</label>
					<div id="fail_email" class="text-danger"></div>
					<input type="text" class="form-control" placeholder="Enter email"
						id="email"/>
				</div>
				<input type="button" class="btn btn-info" value="Update"
					id="submit_update" />
			</form>
		</div>
	</div>
	<script src="${contextPath}/resources/js/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/addPerson.js"></script>
</body>
</html>