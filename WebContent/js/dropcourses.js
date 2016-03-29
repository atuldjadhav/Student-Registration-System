/**
 * js file for StudentDropCourse.html
 * Please use modern web browser as this file will not attempt to be
 * compatible with older browsers. Use Chrome and open javascript console
 * or Firefox with developer console.
 * 
 * jquery is required
 */
$(document).ready(function() {
	//console.log("ready");
	
	var $dropcourses = $('#drop_courses');
	
	/**
	 * This is for the Submit button
	 * It will trigger a ajax GET call to: /StudentCourseRegistrationSystem/rest/studentrest/status/dropcourses
	 * This will delete a item entry to our student database
	 */
	$('#submit').click(function(e) {
		//console.log("submit button has been clicked");
		e.preventDefault(); //cancel form submit
		
		var jsObj = $dropcourses.serializeObject();
			var ajaxObj = {};
		
		//console.log(jsObj);
		
		ajaxObj = {  
			type: "GET",
			url: "http://localhost:8080/StudentCourseRegistrationSystem/rest/studentrest/status/dropcourses", 
			data: JSON.stringify(jsObj), 
			contentType:"application/json",
			error: function(jqXHR, textStatus, errorThrown) {
				console.log("Error " + jqXHR.getAllResponseHeaders() + " " + errorThrown);
			},
			success: function(data) { 
				//console.log(data);
				if(data[0].HTTP_CODE == 200) {
					$('#div_ajaxResponse').text( data[0].MSG );
				}
			},
			complete: function(XMLHttpRequest) {
				//console.log( XMLHttpRequest.getAllResponseHeaders() );
			}, 
			dataType: "json" //request JSON
		};
		
		$.ajax(ajaxObj);
	});
	
	
			
		
		
});