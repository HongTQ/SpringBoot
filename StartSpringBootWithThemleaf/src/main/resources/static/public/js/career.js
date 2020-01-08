$(document).ready(function() {
	load_all_carees();
	click_action();
	click_save();
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
			var num = 0;
			var tbody_data = "";
			$.each(listCareer,function(index){
				num++;
				tbody_data+= "<tr><td>"+num+"</td><td>"+listCareer[index].idCareer+"</td><td>"+listCareer[index].nameCareer+"</td><td><div data-id="+listCareer[index].idCareer+" data-action='edit' data-name='"+listCareer[index].nameCareer+"' class='btn btn-warning'>Edit</div></td><td><div data-action='del' data-id="+listCareer[index].idCareer+" class='btn btn-danger'>Delete</div></td></tr>";
			});
			$(".tbody-data").html(tbody_data);
			click_action();
		},
		error : function(e) {
			console.log(exception);
		}
	});
}

function click_action(){
	$(".tbody-data tr td div").click(function(){
		var data_action = $(this).data("action");
		var id = $(this).data("id");
		if(data_action == "del"){
			del_career(id);
		}else if(data_action == "edit"){
			$("#id_career").val(id);
			$("#name_career").val($(this).data("name"));
		}else{
			alert("Fail");
		}
	});
}

function click_save(){
	$("#save_career").click(function(){
		var id_career = $("#id_career").val();
		var submit = confirm('Are you sure?');
		if(submit){
			if(id_career){
				edit_career(id_career);
				$("#id_career").val("");
			}else{
				add_career();
			}
		}
	});
}
function del_career(id) {
	var submit = confirm('Are you sure?');
	if (submit) {
		$.ajax({
			type : "DELETE",
			contentType : "application/json",
			url : "/careers/" + id + "",
			success : function() {
				alert("Deleted career information with id = " + id + "");
				load_all_carees();
			},
			error : function(e) {
				console.log(e);
			}
		});
	}
}

function edit_career(idCareer){
	var id_career = $("#id_career").val();
	var name_career = $("#name_career").val();
	var dataJson = JSON.stringify({idCareer: id_career, nameCareer : name_career});
	$.ajax({
		type : "PUT",
		contentType : "application/json",
		url : "/api/careers/"+idCareer+"",
		dataType : 'json',
		data: dataJson,
		success : function() {
			alert("Edit success");
			load_all_carees();
			$("#name_career").val("");
		},
		error : function(e) {
			var fail_name = "";
			exception = e.responseJSON;
			console.log(exception);
			$.each(exception,function(i,item){
				if(item.key == "nameCareer") fail_name+= "<div class='w-100'>- "+item.message+"</div>";
			})
			$("#fail_name").html(fail_name);
		}
	});
}

function add_career(){
	var name_career = $("#name_career").val();
	var dataJson = JSON.stringify({nameCareer : name_career});
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/api/careers",
		dataType : 'json',
		data: dataJson,
		success : function() {
			alert("Add success");
			load_all_carees();
			$("#name_career").val("");
		},
		error : function(e) {
			var fail_name = "";
			exception = e.responseJSON;
			console.log(exception);
			$.each(exception,function(i,item){
				if(item.key == "nameCareer") fail_name+= "<div class='w-100'>- "+item.message+"</div>";
			})
			$("#fail_name").html(fail_name);
		}
	});
}