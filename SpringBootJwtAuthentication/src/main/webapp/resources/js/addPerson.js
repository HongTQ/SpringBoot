function check_token(token) {
	if (token == null) {
		$(location).attr('href', "/view/login");
	}
}

function post_person(token) {
	var name = $("#name").val();
	var phone = $("#phone").val();
	var birthday = $("#birthday").val();
	var address = $("#address").val();
	var email = $("#email").val();
	
	var dataJson = JSON.stringify({name : name,phone : phone,birthday : birthday, address : address, email : email});
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/api/persons",
		data : dataJson,
		dataType : 'json',
		beforeSend : function(xhr) {
			xhr.setRequestHeader('Authorization', 'Bearer ' + token + '');
		},
		success : function(data) {
			alert("Add success");
			$(location).attr('href',"/view/persons");
		},
		error : function(e) {
			console.log(e);
		}
	});
}
function isEmail(email) {
	var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	return regex.test(email);
}

function isPhoneNumber(phoneNumber){
	var regex = /^0(1\d{9}|9\d{8})$/;
	return regex.test(phoneNumber);
}
$(document).ready(function() {
	var token = localStorage.getItem("usertoken");
	check_token(token);
	$("#submit_update").click(function(){
		var submit = confirm('Are you sure?');
		if (submit) {
			var name = $("#name").val();
			var phone = $("#phone").val();
			var birthday = $("#birthday").val();
			var address = $("#address").val();
			var email = $("#email").val();
			if(name == ''){
				$("#fail_name").html("<div class='w-100'>- Name not null </div>");
			}
			if(phone == ''){
				$("#fail_phone").html("<div class='w-100'>- Please enter phone </div>");
			}
			if(birthday == ''){
				$("#fail_birthday").html("<div class='w-100'>- Please enter birthday </div>");
			}
			if(address == ''){
				$("#fail_birthday").html("<div class='w-100'>- Please enter birthday </div>");				
			}
			if(!isEmail(email)){
				$("#fail_email").html("<div class='w-100'>- Please enter your email again </div>");
			}
			if(!isPhoneNumber(phone)){
				$("#fail_phone").html("<div class='w-100'>- Please enter your phone again </div>");	
			}
			if(name != '' && phone != '' && birthday != '' && email != '' && phone != ''){
				post_person(token);
			}
		}
	});
});