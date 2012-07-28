$(document).ready(function() {
	attachDialog("addProject", "Add Project", "addProject", "addProjectDialog");
	attachDialog("addProjectIdea", "Add Project Idea", "addProjectIdea", "addProjectIdeaDialog");
	
	$.ajaxSetup ({  
	    cache: false  
	});
	getProjects();
});

function persistProject() {  
	// get the form values  
	var name = $('#projectName').val();
	var programmingLanguage = $('#projectProgrammingLanguage').val();
	var description = $('#projectDescription').val();
  
	$.ajax({  
		type: "POST",  
	    url: contexPath + "/addProject.htm",  
	    data: "name=" + name + "&programmingLanguage=" + programmingLanguage + "&description=" + description,
	    success: function(){
	    	getProjects();
	    }
	});
	$('#addProjectDialog').dialog('close');
	$('#projectName').val("");
	$('#projectDescription').val("");
	$('#projectProgrammingLanguage').val("");
}

function persistProjectIdea() {  
	// get the form values  
	var name = $('#projectIdeaName').val();
	var programmingLanguage = $('#projectIdeaProgrammingLanguage').val();
	var description = $('#projectIdeaDescription').val();
  
	$.ajax({  
		type: "POST",  
	    url: contexPath + "/addProjectIdea.htm",  
	    data: "name=" + name + "&programmingLanguage=" + programmingLanguage + "&description=" + description,
	    success: function(){
	    	getProjects();
	    }
	});
	$('#addProjectIdeaDialog').dialog('close');
	$('#projectIdeaName').val("");
	$('#projectIdeaDescription').val("");
	$('#projectIdeaProgrammingLanguage').val("");
}

function getProjects() {
	$.get(contexPath + "/loadProjects.htm", function(data){
		console.log("data: " + data);
		$('#projectSummary').html(data);
	});
}

function projectButtonPressed(id, url){
	$.ajax({
		type: "POST",
		url: contexPath + "/" + url + ".htm",
		data: "id=" + id,
		success: function(){
	    	getProjects();
	    }
	});
}
