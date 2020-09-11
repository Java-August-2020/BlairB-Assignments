<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
	<div class="container">
		<div class="row">
			<a href="/songs/new">Add New</a>
			<a href="/search/topTen">Top Songs</a>
			<form action="/dashboard" method="post" class="row">
				<input name="artistSearched"/>
				<button type="submit">Search Artists</button>
			</form>
		</div>
		<br/><br/>
		<table>
	    <thead>
	        <tr>
	            <th>Title</th>
	            <th>Rating</th>
	            <th>actions</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${songs}" var="song">
	        <tr>
	            <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
	            <td><c:out value="${song.rating}"/></td>
	            <td>
	            	<form:form action="/songs/${song.id}" method="post">
	            		<input type="hidden" name="_method" value="delete"/>
	            		<input type="submit" value="delete"/>
	            	</form:form>
	            </td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	</div>
</body>
</html>