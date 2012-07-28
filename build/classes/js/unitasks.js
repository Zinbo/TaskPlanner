$(document).ready(function() {
	attachDialog("addUniTask", "Add University Task", "addUniTask", "addUniversityTaskDialog");
});

function persistUniTask() {  
	// get the form values  
	var name = $('#name').val();
	var description = $('#description').val();
	var dueDate = $('#dueDate').val();
	var module = $('#module').val();
  
	$.ajax({  
		type: "POST",  
	    url: contexPath + "/addUniTask.htm",  
	    data: "name=" + name + "&description=" + description + "&dueDate=" + dueDate + "&module=" + module
	});
	$('#addUniversityTaskDialog').dialog('close');
	$('#addTaskDialog').dialog('close');
	$('#name').val("");
	$('#module').val("");
	$('#dueDate').val("");
	$('#description').val("");
}

function getUniTasks() {
	$.get(contexPath + "/loadUniTasks.htm", function(data){
		console.log("data: " + data);
		$('#tasksBox').html(data);
	});
}