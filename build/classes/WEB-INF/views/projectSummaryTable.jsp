<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script>
	$(function() {
		$( "#tabs" ).tabs();
	});
</script>
<div id="tabs">
	<ul>
		<li><a href="#tabs-1">Projects</a></li>
		<li><a href="#tabs-2">Project Ideas</a></li>
	</ul>
	<div id="tabs-1">
		<table border="1">
			<tr>
				<th>Name</th>
				<th>Programming Language</th>
				<th>Description</th>
				<th>Status</th>
			</tr>
			<c:forEach var="project" items="${projects}">  
				<tr id="${project.id}" >
					<td><c:out value="${project.name}" /> </td>
					<td><c:out value="${project.programmingLanguage}" /> </td>
					<td><c:out value="${project.description}" /> </td>
					<td><c:out value="${project.status}" /> </td>
					<c:if test="${project.status == 'IN_PROGRESS'}">
						<td><button onclick="projectButtonPressed(${project.id}, 'completeProject')">Complete Project</button>
						<td><button onclick="projectButtonPressed(${project.id}, 'changeProgressStatusOfProject')">Change Status to Not In Progress</button>
					</c:if>
					<c:if test="${project.status == 'NOT_IN_PROGRESS'}">
						<td><button onclick="projectButtonPressed(${project.id}, 'completeProject')">Complete Project</button>
						<td><button onclick="projectButtonPressed(${project.id}, 'changeProgressStatusOfProject')">Change Status to In Progress</button>	
					</c:if>
					<c:if test="${project.status == 'COMPLETE'}">
						<td><button onclick="projectButtonPressed(${project.id}, 'changeProgressStatusOfProject')">Change Status to In Progress</button>	
					</c:if>
					<td><button onclick="projectButtonPressed(${project.id}, 'deleteProject')">Delete Project</button>
				</tr>
			 </c:forEach> 
		</table>
	</div>
	<div id="tabs-2">
		<table border="1">
			<tr>
				<th>Name</th>
				<th>Programming Language</th>
				<th>Description</th>
			</tr>
			<c:forEach var="projectIdea" items="${projectIdeas}">  
				<tr id="${projectIdea.id}" >
					<td><c:out value="${projectIdea.name}" /> </td>
					<td><c:out value="${projectIdea.programmingLanguage}" /> </td>
					<td><c:out value="${projectIdea.description}" /> </td>
					<td><button onclick="projectButtonPressed(${projectIdea.id}, 'deleteProjectIdea')">Delete Project Idea</button>
					<td><button onclick="projectButtonPressed(${projectIdea.id}, 'convertToProject')">Convert Idea to Project</button>
				</tr>
			 </c:forEach> 
		</table>
	</div>
</div>