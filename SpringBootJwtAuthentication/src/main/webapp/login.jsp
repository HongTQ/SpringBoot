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
	<div class="container">
		<div class="col-md-12">
			<h1>Spring Security login</h1>
			<form action="" method="POST">
				<div class="form-group">
					<label>User name:</label>
					<label class="text-danger" id="fail_username"></label>
					<input type="text" class="form-control" placeholder="Enter username" id="username">
				</div>
				<div class="form-group">
					<label>Password:</label>
					<label class="text-danger" id="fail_password"></label>
					<input type="password" class="form-control" placeholder="Enter password" id="password">
				</div>
				<button type="button" class="btn btn-primary" id="submit">Login</button>
			</form>
		</div>
	</div>
	<script src="${contextPath}/resources/js/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/login.js"></script>
</body>
</html>