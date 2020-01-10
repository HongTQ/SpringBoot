function load_pagination(page, size, token) {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/api/persons/page/" + page + "/size/" + size + "",
		dataType : 'json',
		data : '',
		beforeSend : function(xhr) {
			xhr.setRequestHeader('Authorization', 'Bearer ' + token + '');
		},
		success : function(data) {
			console.log(data);
			totalPages = data.totalPages;
			totalElements = data.totalElements;
			number = data.number;
			var string_data = "";
			var no = 1;
			var content_data = data.content;
			$.each(content_data, function(index) {
				  content_role = content_data[index].user['roles'];
				  var str_role = '';
				  $.each(content_role, function(i){
					  str_role += content_role[i].name + ' '; 
				  });
				  console.log(str_role);
				  string_data += "<tr><td>"+no+"</td><td>"+content_data[index].id+"</td><td>"+content_data[index].name+"</td><td>"+content_data[index].user['username']+"</td><td>"+content_data[index].birthday+"</td><td>"+content_data[index].phone+"</td><td>"+content_data[index].address+"</td><td>"+content_data[index].email+"</td><td>"+str_role+"</td><td><a href='/view/editPerson?id="+content_data[index].id+"' class='btn btn-warning'>Edit</a></td><td><div data-id="+content_data[index].id+" class='btn btn-danger'>Delete</div></td></tr>";
				  no++;
			});
			$(".tbody-data").html(string_data);
		},
		error : function(e) {
			$(location).attr('href', "/view/login");
			console.log(e);
		}
	});
}

function check_token(page, size, token) {
	if (token == null) {
		$(location).attr('href', "/view/login");
	} else {
		load_pagination(page, size, token);
	}
}
$(document).ready(function() {
	var page = 0;
	var size = 5;
	var token = localStorage.getItem("usertoken");
	check_token(page, size, token);
});