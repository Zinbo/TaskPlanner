<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<table border="1">
	<tr>
		<th>Name</th>
		<th>Description</th>
		<th>Due Date</th>
	</tr>
	<c:forEach var="task" items="${tasks}">  
		<tr id="${task.id}" >
			<td><c:out value="${task.name}" /> </td>
			<td><c:out value="${task.description}" /> </td>
			<td><c:out value="${task.dueDate}" /> </td>
			<td><c:out value="${task.status}" /> </td>
			<c:if test="${task.status == 'IN_PROGRESS'}">
				<td><button onclick="taskButtonPressed(${task.id}, 'completeTask')">Complete Task</button>
				<td><button onclick="taskButtonPressed(${task.id}, 'changeProgressStatusOfTask')">Change Status to Not In Progress</button>
			</c:if>
			<c:if test="${task.status == 'NOT_IN_PROGRESS'}">
				<td><button onclick="taskButtonPressed(${task.id}, 'completeTask')">Complete Task</button>
				<td><button onclick="taskButtonPressed(${task.id}, 'changeProgressStatusOfTask')">Change Status to In Progress</button>	
			</c:if>
			<c:if test="${task.status == 'COMPLETE'}">
				<td><button onclick="taskButtonPressed(${task.id}, 'changeProgressStatusOfTask')">Change Status to In Progress</button>	
			</c:if>
			<td><button onclick="taskButtonPressed(${task.id}, 'deleteTask')">Delete Task</button>
		</tr>
	 </c:forEach> 
</table>