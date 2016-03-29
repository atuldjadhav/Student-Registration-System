var ids=sessionStorage.studentid;
alert("ids is "+ids);

alert("hello");
$(document).ready(function()
			{
		
	$.ajax({
		type:"GET",
		url:"http://localhost:9080/StudentCourseRegistrationSystem/rest/studentrest/status/checkcourses?studentid="+ids,
		dataType:"json",
		
		success:function(response){
			
			
			var len=response.length;
	for(i=0;i<response.length;i++){
		

		//var inp = "<input id='sno' type='button' name='id' value='delete'>"+delete+"</input>";
		var inp1="<button type='button'  onclick='test(this)'>Delete</button>";
		//<button type="button" class="use-address" onclick="test(this);">Use</button>
		$("#resultid").append("<tr><td>"+response[i].StudentID+"</td>"+
		"<td>"+response[i].SectionID+"</td>"+
		"<td>"+response[i].CourseCode+"</td>"+
		"<td>"+response[i].Term+"</td>"+
		"<td>"+response[i].grade+"</td>"
		
		);
		//$("#resultTable").append("<tr><td>Last Name:</td><td>"+response[i].lastName+"</td></tr>");
	}		
			
			
			
		},
		error:function(data){
			
			alert("error"+data);
			
			
		}

	});

			});





