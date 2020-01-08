//editPerson
$(document).ready(function() {
	var id = $("#id").val();
	load_all_carees();
	get_person(id);
	$("#submit_update").click(function(){
		var submit = confirm('Are you sure?');
		if (submit) {
			post_person();
		    }
	});
});
var id;
function get_person(id) {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/api/persons/" + id,
		data : "",
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {
			$("#first_name").val(data.firstName);
			$("#last_name").val(data.lastName);
			$("#phone").val(data.phone);
			$("#birthday").val(data.birthday);
			var career_checked = data.careers;
			if(career_checked){
				$('#career_check :checkbox').each(function(i) {
					var compare = $(this).val();
					var _seft = this;
					$.each(career_checked,function(index){
						if(career_checked[index].idCareer == compare){
							_seft.setAttribute("checked", "checked");
						}
					});
				});
				}
			
			$.each($("#sex option"), function() {
				 if(data.sex == true){
					 $("#sex").html("<option value='true' selected>Male</option><option value='false'>Female</option>");
				 }else{
					 $("#sex").html("<option value='true'>Male</option><option value='false' selected>Female</option>");
				 }
			});
			
			$("#address").val(data.address);
		},
		error : function(e) {
			console.log(e);
		}
	});
}

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
	var id = $("#id").val();
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
	
	var dataJson = JSON.stringify({id : id,firstName : first_name,lastName : last_name,phone : phone,birthday : birthday,sex : sex,address : address,careers:career_check});
	
	$.ajax({
		type : "PUT",
		contentType : "application/json",
		url : "/api/persons/" + id,
		data : dataJson,
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {
			alert("Update success");
			$(location).attr('href',"/");
		},
		error : function(e) {
			var fail_first_name = "";
			var fail_last_name = "";
			var fail_phone ="";
			var fail_birthday = "";
			var fail_sex = "";
			var fail_address = "";
			var fail_id = "";
			exception = e.responseJSON;
			console.log(exception);
			$.each(exception,function(i,item){
				if(item.key == "firstName") fail_first_name+= "<div class='w-100'>- "+item.message+"</div>";
				if(item.key == "lastName") fail_last_name+= "<div class='w-100'>- "+item.message+"</div>";
				if(item.key == "phone") fail_phone+= "<div class='w-100'>- "+item.message+"</div>";
				if(item.key == "address") fail_adress+= "<div class='w-100'>- "+item.message+"</div>";
				if(item.key == "birthday") fail_birthday+= "<div class='w-100'>- "+item.message+"</div>";
				if(item.key == "sex") fail_sex+= "<div class='w-100'>- "+item.message+"</div>";
				if(item.key == "id") fail_id+= item.message;
			})
			$("#fail_first_name").html(fail_first_name);
			$("#fail_last_name").html(fail_last_name);
			$("#fail_phone").html(fail_phone);
			$("#fail_address").html(fail_address);
			$("#fail_birthday").html(fail_birthday);
			$("#fail_sex").html(fail_sex);
			if(fail_id != ""){
				alert(fail_id);
			}
		}
	});
}
