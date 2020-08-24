<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<c:out value="${error}" />
	<form method="POST" action="/check">
	<label>What is the code?</label>
	<input type="text" name="code"/>
	<button>Try Code</button>
	</form>
	
</body>
</html>