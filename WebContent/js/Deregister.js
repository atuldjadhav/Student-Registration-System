
$(document).ready(function()
		{
	
$.ajax({
	type:"GET",
	url:"http://localhost:9080/StudentCourseRegistrationSystem/rest/studentrest/status/checkcourses?studentid="+sessionStorage.studentid,
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
	"<td>"+response[i].grade+"</td>"+
	"<td>"+inp1+"</td></tr>"
	
	);
	
}		
		
		
		
	},
	error:function(data){
		alert("Please contact the Customer Care Service");
		console.log(error);
		
		
	}

});

		});
 function test(x){
	 
	//var x = $('input:radio[name=id]:checked').val();
	var id1 = $(x).closest("tr").find('td:eq(0)').text();
	var id2 = $(x).closest("tr").find('td:eq(2)').text();
	alert(sessionStorage.studentid);
	
	alert(id1);
	alert(id2);
	var url = "http://localhost:9080/StudentCourseRegistrationSystem/rest/studentrest/status/dropcourses?studentid="+id1+"&coursecode="+id2;
	
	$.ajax({
		type:"GET",
		url: url,
		dataType:"json",
		statusCode:{
			200:function(){
				
				window.location.href="http://localhost:9080/StudentCourseRegistrationSystem/DCOREG.html";
			}},
		

	
		})
} 






