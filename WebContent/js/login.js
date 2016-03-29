//Code for consuming the login rest call
function test(){
	
	var username= $("#username").val();
	var password = $("#password").val();
	
	alert("Username"+username+" "+"Password"+password);
	$.ajax({
		type:"GET",
		url:"http://localhost:9080/StudentCourseRegistrationSystem/rest/login/dologin?username="+username+"&password="+password,
		dataType:"json",		
		success:function(response){
			sessionStorage.studentid=response.studentid;
			alert("hello"+sessionStorage.studentid);
			/*sessionStorage.setItem("sid",response.studentid);
			$("#label").html(sessionStorage.getItem("sid"));
			alert("Sid is getting displayed");
		alert("Sid is:"+"sid");*/
			if(response.status == true ){
			window.location.href="index.html";
			}
			else{
				alert("Invalid Credentials");
				window.location.href="Login.html";	
			}
		},
		error:function(error){
			
			console.log(error);
		}
	});	
}




