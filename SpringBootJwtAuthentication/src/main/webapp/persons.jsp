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
					<a class="navbar-brand text-danger" href="/view/persons">Demo Spring Boot and JSP
					</a>
				</div>
				<div class="col-md-6">
					<nav class="navbar navbar-expand-md navbar-dark">
						<ul class="navbar-nav ml-auto">
							<li class="nav-item active"><a class="nav-link" href="/">List
									Persons</a></li>
							<li class="nav-item"><a class="nav-link" href="/listCareers">List Careers
							</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
		<div class="container my-3">
			<h2>List Person</h2>
			<div class="row">
				<div class="col-md-8">
					<div class="my-3">
						<a href="/view/addPerson" class="btn btn-info" role="button">Add new</a>
					</div>
				</div>
				<div class="col-md-4">
					<div class="input-group my-3">
						<input type="text" class="form-control" placeholder="Search"
							id="search">
					</div>
				</div>
			</div>
			<div class="row">
				<table class="table">
					<thead>
						<tr>
							<th>No</th>
							<th>ID</th>
							<th>Name</th>
							<th>User name</th>
							<th>Birthday</th>
							<th>Phone</th>
							<th>Address</th>
							<th>Email</th>
							<th>Role</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody class="tbody-data">
					</tbody>
				</table>
			</div>
			<div class="row">
				<div class="col-md-12 form-inline">
					<div class="form-group">
						<input type="number" name="text_size" class="form-control"
							id="text_size" placeholder="Enter size" min="5">
					</div>
					<div class="ml-4 form-group">
						<nav aria-label="Page navigation" class="float-right">
							<ul class="pagination show-navigation"></ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="${contextPath}/resources/js/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/person.js"></script>
</body>
</html>