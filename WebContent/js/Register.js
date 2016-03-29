
	
function test(){
	alert(sessionStorage.studentid);
	var course= $("#Coursename").val();
	var pricepage= $("#Price").val();
	var locationpage= $("#Time").val();
	var timepage= $("#Location").val();
	if(course!=""&&pricepage==""&&locationpage==""&&timepage==""){
	
	alert(course);
	alert(pricepage);
$.ajax({
	type:"GET",
	url:"http://localhost:9080/StudentCourseRegistrationSystem/rest/studentrest/status/findcourses?coursename="+course,
	dataType:"json",
	
	success:function(response){
		
		var len=response.length;
for(i=0;i<response.length;i++){
	

	var inp1="<button type='button'  onclick='register(this)'>Register</button>";
	//<button type="button" class="use-address" onclick="test(this);">Use</button>
	$("#resultid").append("<tr><td>"+response[i].CourseName+"</td>"+
	"<td>"+response[i].CourseCode+"</td>"+
	"<td>"+response[i].Credits+"</td>"+
	"<td>"+response[i].SectionID+"</td>"+
	"<td>"+response[i].Location+"</td>"+
	"<td>"+response[i].Price+"</td>"+
	"<td>"+response[i].StartTime+"</td>"+
	"<td>"+inp1+"</td></tr>");
	$("#studentTable").css("visibility","visible");
}		
		
		
		
	},
	error:function(data){
		
		alert("Error"+data);		
	}
});
	}
	if(course==""&&pricepage!=""&&locationpage==""&&timepage=="")
	alert(pricepage);
	{$.ajax({
		
		type:"GET",
		url:"http://localhost:9080/StudentCourseRegistrationSystem/rest/studentrest/status/findprice?price="+pricepage,
		dataType:"json",
		
		success:function(response){
			
			var len=response.length;
	for(i=0;i<response.length;i++){
		

		var inp1="<button type='button'  onclick='register(this)'>Register</button>";
		//<button type="button" class="use-address" onclick="test(this);">Use</button>
		$("#resultid").append("<tr><td>"+response[i].CourseName+"</td>"+
		"<td>"+response[i].CourseCode+"</td>"+
		"<td>"+response[i].Credits+"</td>"+
		"<td>"+response[i].SectionID+"</td>"+
		"<td>"+response[i].Location+"</td>"+
		"<td>"+response[i].Price+"</td>"+
		"<td>"+response[i].StartTime+"</td>"+
		"<td>"+inp1+"</td></tr>");
		$("#studentTable").css("visibility","visible");
	}		
			
			
			
		},
		error:function(data){
			
			alert("Error"+data);		
		}
	});
		
		
		
		
		
		
		
		
	}
};

function register(x){
	var StudentId=sessionStorage.studentid;
	var Term="Fall 2015";
var coursename = $(x).closest("tr").find('td:eq(0)').text();
var coursecode = $(x).closest("tr").find('td:eq(1)').text();
var credits = $(x).closest("tr").find('td:eq(2)').text();
var sectionid = $(x).closest("tr").find('td:eq(3)').text();
var location = $(x).closest("tr").find('td:eq(4)').text();
var price=$(x).closest("tr").find('td:eq(5)').text();
var starttime=$(x).closest("tr").find('td:eq(6)').text();

alert("Hello");
	var testJson = {
			studentid:StudentId,
			sectionid:sectionid,
			coursecode:coursecode,
			term:Term,
			grade:"NA"
				
	};
	var str=JSON.stringify(testJson);
	alert(str);
	alert(testJson.sectionid);
	ajaxObj = {  
			type: "POST",
			url: "http://localhost:9080/StudentCourseRegistrationSystem/rest/studentrest/status", 
			data: JSON.stringify(testJson),
			dataType:'text',
			contentType:"application/json",
			success: function(data) { 
	alert("You have successfully registered for the course. please check your mail for payment details");
	window.location.href="http://localhost:9080/StudentCourseRegistrationSystem/VCOURSE.html";
	alert("Removing Row");
	 $(x).closest('tr').remove();
	},
	error:function(data){
		alert("You have already registered for this course");
	}
	}
	$.ajax(ajaxObj);
	
}



