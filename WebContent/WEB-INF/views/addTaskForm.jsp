<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
		$( "#dueDate" ).datepicker();
</script>
<title>Add Tasks</title>
</head>
<body>
<h1>Add Task</h1>
	<table>
		<tr><td>Name: </td><td> <input type="text" id="name"><br/></td></tr>
		<tr><td>Description: </td><td> <input type="text" id="description"><br/></td></tr>
		<tr><td>Due Date: </td><td> <input type="text" id="dueDate"><br/></td></tr>
		<tr><td colspan="2"><input type="button" value="Add Task" onclick="persistTask()"><br/></td></tr>
	</table>
</body>
</html>