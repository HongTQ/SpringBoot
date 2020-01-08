$(document).ready(function(){
	var isClick = true;
	$("#thead-first-name").click(function(){
		if(isClick == true){
			load_ajax_sort("/api/persons/sorts/phone");
			isClick = false;
		}else{
			load_ajax_sort("/api/persons");
			isClick = true;
		}
	});
	
	$("#search").change(function(){
		strSearch = $("#search").val();
		if(strSearch){
			load_ajax_search("/api/persons/search/"+strSearch+"");
		}else{
			load_ajax_sort("/api/persons");
		}
	});
	load_pagination(0,5);
});

function load_ajax_sort(strUrl){
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : strUrl,
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {
			var string_data = "";
			var no = 1;
			var content_data = data.content;
			$.each(content_data, function(index) {
				var career = "";
				if(content_data[index].careers.length != 0){
					career = "<tr><td colspan=11 id='seemore"+content_data[index].id+"' class='collapse bg-secondary text-white'><p><strong>Career:</strong> ";
					$.each(content_data[index].careers, function(index_career){
						career+= "<br>- "+content_data[index].careers[index_career].nameCareer+"";
						});
					career += "</p></tr></td>";
				}
				if(content_data[index].sex == true) sex = "Male"; else sex = "Female";
				string_data += "<tr><td>"+no+"</td><td>"+content_data[index].id+"</td><td>"+content_data[index].firstName+"</td><td>"+content_data[index].lastName+"</td><td>"+sex+"</td><td>"+content_data[index].birthday+"</td><td>"+content_data[index].phone+"</td><td>"+content_data[index].address+"</td><td><a href='#seemore"+content_data[index].id+"' class='btn btn-info' data-toggle='collapse'>See more</a></td><td><a href='/editPerson?id="+content_data[index].id+"' class='btn btn-warning'>Edit</a></td><td><div data-id="+content_data[index].id+" class='btn btn-danger'>Delete</div></td></tr>"+career+"";
					  no++;
			});
			$(".tbody-data").html(string_data);
		},
		error : function(e) {
			console.log(e);
		}
	});
}

function load_ajax_search(strSearchUrl){
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : strSearchUrl,
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {
			var string_data = "";
			var no = 1;
			$.each(data, function(index) {
				var career = "";
				if(data[index].careers.length != 0){
					career = "<tr><td colspan=11 id='seemore"+data[index].id+"' class='collapse bg-secondary text-white'><p><strong>Career:</strong> ";
					$.each(data[index].careers, function(index_career){
						career+= "<br>- "+data[index].careers[index_career].nameCareer+"";
						});
					career += "</p></tr></td>";
				}
				if(data[index].sex == true) sex = "Male"; else sex = "Female";
				 string_data += "<tr><td>"+no+"</td><td>"+data[index].id+"</td><td>"+data[index].firstName+"</td><td>"+data[index].lastName+"</td><td>"+sex+"</td><td>"+data[index].birthday+"</td><td>"+data[index].phone+"</td><td>"+data[index].address+"</td><td><a href='#seemore"+data[index].id+"' class='btn btn-info' data-toggle='collapse'>See more</a></td><td><a href='/editPerson?id="+data[index].id+"' class='btn btn-warning'>Edit</a></td><td><div data-id='"+data[index].id+"' class='btn btn-danger'>Delete</div></td></tr>"+career+"";
				  no++;
			});
			$(".tbody-data").html(string_data);
		},
		error : function(e) {
			console.log(e);
		}
	});
}

function load_pagination(page,size){
	var totalPages;
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/api/persons/page/"+page+"/size/"+size+"",
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {
			totalPages = data.totalPages;
			totalElements = data.totalElements;
			number = data.number;
			var string_data = "";
			var no = 1;
			var content_data = data.content;
			$.each(content_data, function(index) {
				var career = "";
				if(content_data[index].sex == true) sex = "Male"; else sex = "Female";
				if(content_data[index].careers.length != 0){
					career = "<tr><td colspan=11 id='seemore"+content_data[index].id+"' class='collapse bg-secondary text-white'><p><strong>Career:</strong> ";
					$.each(content_data[index].careers, function(index_career){
						career+= "<br>- "+content_data[index].careers[index_career].nameCareer+"";
						});
					career += "</p></tr></td>";
				}
					  string_data += "<tr><td>"+no+"</td><td>"+content_data[index].id+"</td><td>"+content_data[index].firstName+"</td><td>"+content_data[index].lastName+"</td><td>"+sex+"</td><td>"+content_data[index].birthday+"</td><td>"+content_data[index].phone+"</td><td>"+content_data[index].address+"</td><td><a href='#seemore"+content_data[index].id+"' class='btn btn-info' data-toggle='collapse'>See more</a></td><td><a href='/editPerson?id="+content_data[index].id+"' class='btn btn-warning'>Edit</a></td><td><div data-id="+content_data[index].id+" class='btn btn-danger'>Delete</div></td></tr>"+career+"";
					  no++;
			});
			$(".tbody-data").html(string_data);
			show_pagination(number,totalPages);
			click_del();
		},
		error : function(e) {
			console.log(e);
		}
	});
}

function show_pagination(currentPage,totalPage){
	$(".show-navigation").html("");
	if(totalPage > 1){
		for(var i = 0; i< totalPage; i++){
			if(currentPage == i){
				$(".show-navigation").append("<li class='page-item current'>"+(i+1)+"</li>");
			}else{
				$(".show-navigation").append("<li class='page-item'>"+(i+1)+"</li>");	
			}
		}
		$(".show-navigation li").click(function(){
			var num = parseInt($(this).text());
			num = num-1;
			var textSize = parseInt($("#text_size").val());
			if(textSize){
				if(textSize < 5){
					alert("Size must be greater than 5");
				}else{
					load_pagination(num,textSize);
				}
			}else{
				load_pagination(num,5);
			}
		})
	}
}

function click_del() {
	$(".tbody-data tr td div").click(function() {
		var submit = confirm('Are you sure?');
		if (submit) {
			id = $(this).data("id");
			del_person(id);
		}
	});
}
function del_person(id){
	$.ajax({
		type : "DELETE",
		contentType : "application/json",
		url : "/api/persons/"+id+"",
		cache : false,
		timeout : 600000,
		success : function(data) {
			alert("Deleted user information with id = "+id+"");
			load_pagination(0,5);
		},
		error : function(e) {
			console.log(e);
		}
	});
}