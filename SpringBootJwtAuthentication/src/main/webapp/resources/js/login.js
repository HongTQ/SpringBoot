$(document).ready(function() {
	$("#submit").click(function() {
		var username = $("#username").val();
		var password = $("#password").val();

		if (username == '') {
			$("#fail_username").html("User name not null or blank");
		} else {
			$("#fail_username").html("");
		}

		if (password == '') {
			$("#fail_password").html("Password not null or blank");
		} else {
			$("#fail_password").html("");
		}

		if (username != '' && password != '') {
			// login(username, password);
			var dataJson = JSON.stringify({
				username : username,
				password : password
			});
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "/api/auth/signin",
				dataType : 'json',
				data : dataJson,
				success : function(data) {
					localStorage.setItem("usertoken", data.accessToken);
					$(location).attr('href', "/view/persons");
				},
				error : function(e) {
					alert("Wrong account or password");
					console.log(e);
				}
			});
		} else {
			return false;
		}
	})
});

function login(username, password) {
	var dataJson = JSON.stringify({
		username : username,
		password : password
	});
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/api/auth/singin",
		dataType : 'json',
		data : dataJson,
		success : function(data) {
			console.log(data);
		},
		error : function(e) {
			console.log(e);
		}
	});
}