//add
$(document).ready(function() {
	load_all_carees();
	$("#submit_add_new").click(function(){
		var submit = confirm('Are you sure?');
		if (submit) {
			post_person();
		    }
	});
});


function load_all_carees(){
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/api/careers",
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {
			var listCareer = data.content;
			$.each(listCareer,function(index){
				$("#career_check").append("<div class='form-check-inline'><label class='form-check-label'> <input type='checkbox' class='form-check-input' value='"+listCareer[index].idCareer+"' name='"+listCareer[index].nameCareer+"'>"+listCareer[index].nameCareer+"</label></div>");
			});
		},
		error : function(e) {
			console.log(exception);
		}
	});
}

function post_person() {
	var first_name = $("#first_name").val();
	var last_name = $("#last_name").val();
	var phone = $("#phone").val();
	var birthday = $("#birthday").val();
	var sex = $("#sex").val();
	var address = $("#address").val();

	var career_check = [];
	$('#career_check :checkbox:checked').each(function(i) {
		career_check[i] = {"idCareer": $(this).val(),"nameCareer": $(this).attr("name")};
	});
	
	var dataJson = JSON.stringify({firstName : first_name,lastName : last_name,phone : phone,birthday : birthday,sex : sex,address : address,careers:career_check});
	
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/api/persons",
		data : dataJson,
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {
			alert("Add success");
			$(location).attr('href',"/");
		},
		error : function(e) {
			var fail_first_name = "";
			var fail_last_name = "";
			var fail_phone ="";
			var fail_birthday = "";
			var fail_sex = "";
			var fail_address = "";
			exception = e.responseJSON;
			console.log(exception);
			$.each(exception,function(i,item){
				if(item.key == "firstName") fail_first_name+= "<div class='w-100'>- "+item.message+"</div>";
				if(item.key == "lastName") fail_last_name+= "<div class='w-100'>- "+item.message+"</div>";
				if(item.key == "phone") fail_phone+= "<div class='w-100'>- "+item.message+"</div>";
				if(item.key == "address") fail_adress+= "<div class='w-100'>- "+item.message+"</div>";
				if(item.key == "birthday") fail_birthday+= "<div class='w-100'>- "+item.message+"</div>";
				if(item.key == "sex") fail_sex+= "<div class='w-100'>- "+item.message+"</div>";
			})
			$("#fail_first_name").html(fail_first_name);
			$("#fail_last_name").html(fail_last_name);
			$("#fail_phone").html(fail_phone);
			$("#fail_address").html(fail_address);
			$("#fail_birthday").html(fail_birthday);
			$("#fail_sex").html(fail_sex);
		}
	});
}
