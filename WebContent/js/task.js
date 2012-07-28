$(document).ready(function() {
	attachDialog("addTask", "Add Task", "addTask", "addTaskDialog");
	
	$.ajaxSetup ({  
	    cache: false  
	});
	getTasks();
});

function persistTask() {  
	// get the form values  
	var name = $('#name').val();
	var description = $('#description').val();
	var dueDate = $('#dueDate').val();
  
	$.ajax({  
		type: "POST",  
	    url: contexPath + "/addTask.htm",  
	    data: "name=" + name + "&description=" + description + "&dueDate=" + dueDate,
	    success: function(){
	    	getTasks();
	    }
	});
	$('#addTaskDialog').dialog('close');
	$('#name').val("");
	$('#description').val("");
	$('#dueDate').val("");
}

function getTasks() {
	$.get(contexPath + "/loadTasks.htm", function(data){
		console.log("data: " + data);
		$('#taskSummary').html(data);
	});
}

function taskButtonPressed(id, url){
	$.ajax({
		type: "POST",
		url: contexPath + "/" + url + ".htm",
		data: "id=" + id,
		success: function(){
	    	getTasks();
	    }
	});
}
