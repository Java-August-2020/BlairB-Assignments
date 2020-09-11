<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<body>
	<form:form action="/songs/new" method="post" modelAttribute="song">
		<p>
	        <form:label path="title">Title</form:label>
	        <form:errors path="title"/>
	        <form:input path="title"/>
	    </p>
		<p>
	        <form:label path="artist">Artist</form:label>
	        <form:errors path="artist"/>
	        <form:input path="artist"/>
	    </p>
	    <p>
	        <form:label path="rating">rating</form:label>
	        <form:errors path="rating"/>
	        <form:input path="rating"/>
	    </p>
	    <input type="submit" value="Add Song"/>
	</form:form>
</body>
</html>