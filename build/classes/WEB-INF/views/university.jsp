<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shane's Life Planner: University</title>
<script type="text/javascript">
	var contexPath = "<%=request.getContextPath() %>";
</script>
<link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.1/themes/base/jquery-ui.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.1/jquery-ui.min.js"></script>
<script src="../js/commonMethods.js" type="text/javascript"></script>
<script src="../js/unitasks.js" type="text/javascript"></script>
<script>
	$(function() {
		$( "#tabs" ).tabs();
	});
</script>
</head>
<body>
	<h1>Tasks</h1>
	<div id="tabs">
		<ul>
			<c:forEach var="module" items="${listOfTasksByModule}" varStatus="status">
					<li><a href="#tabs-${status.count}">${module[0].module}</a></li>
			</c:forEach>
		</ul>
		<c:forEach var="module" items="${listOfTasksByModule}" varStatus="status">
			<div id="tabs-${status.count}">
				<table border="1">
					<tr>
						<th>Name</th>
						<th>Description</th>
						<th>Due Date</th>
					</tr>
					<c:forEach var="task" items="${module}">
						<tr id="${task.id}" >
							<td><c:out value="${task.name}" /> </td>
							<td><c:out value="${task.description}" /> </td>
							<td><c:out value="${task.dueDate}" /> </td>
							<td><button onclick="completeButtonPressed(${task.id}, 'completeUniTask')">Complete</button>
							<td><button onclick="removeButtonPressed(${task.id}, 'removeUniTask')">Remove</button>
						</tr>
					</c:forEach> 	
				</table>
				<br>
	   		</div>
	   	</c:forEach> 
   	</div>
   	<div id="addUniversityTaskDialog"></div>
   	<img id="addUniTask" src="../img/AddEvent.png"></img>
</body>
</html>