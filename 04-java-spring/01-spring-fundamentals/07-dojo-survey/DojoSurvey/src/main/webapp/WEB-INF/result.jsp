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
	<h2>Submitted Info</h2>
	<span>Your Name:</span>
	<span>${name}</span><br/>
	<span>Dojo Location:</span>
	<span>${location}</span><br/>
	<span>Favorite Language:</span>
	<span>${language}</span><br/>
	<span>Comment:</span>
	<span>${comment}</span>
</body>
</html>