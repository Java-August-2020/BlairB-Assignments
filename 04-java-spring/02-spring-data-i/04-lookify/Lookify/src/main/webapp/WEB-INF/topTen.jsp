<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<body>
	<div class="row">
		<span>Top Ten Songs</span>
		<a href="/dashboard">Dashboard</a>
	</div>
	<br/><br/>
	<c:forEach items="${songs}" var="song">
        <div class="row">
        	<span><c:out value="${song.rating}"/> - </span>
            <a href="/songs/${song.id}"><c:out value="${song.title}"/></a>
            <span><c:out value="${song.artist}"/></span>
        </div>
	</c:forEach>
</body>
</html>