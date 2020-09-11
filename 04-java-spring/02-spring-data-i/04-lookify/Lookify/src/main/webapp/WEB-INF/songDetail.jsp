<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
	<a href="/dashboard">Dashboard</a>
	<br/><br/>
	<span>Title</span>
	<span>${song.title}</span><br/>
	<span>Artist</span>
	<span>${song.artist}</span><br/>
	<span>Rating</span>
	<span>${song.rating}</span><br/>
	<form:form action="/songs/${song.id}" method="post">
     	<input type="hidden" name="_method" value="delete"/>
     	<input type="submit" value="delete"/>
    </form:form>
</body>
</html>