<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>What is your question?</h1>
	<form action="/questions/new" method="post">
		<label>Question: <textarea name="question"></textarea></label>
		<label>Tags: <input name="tags"/></label>
	    <input type="submit" value="Submit"/>
	</form>
</body>
</html>