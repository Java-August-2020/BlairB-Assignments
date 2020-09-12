<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>New Dojo</h1>
	<form action="/dojos/new" method="post">
		<label>Name: <input name="name"/></label>
		<button>Create</button>
	</form>
</body>
</html>