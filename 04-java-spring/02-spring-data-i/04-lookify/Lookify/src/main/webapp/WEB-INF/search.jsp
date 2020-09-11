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
		<span>Songs by artist: ${artistName}</span>
		<form action="/dashboard" method="post" class="row">
			<input name="artistSearched"/>
			<button type="submit">New Search</button>
		</form>
		<a href="/dashboard">Dashboard</a>
	</div><br/><br/>
	<table>
	    <thead>
	        <tr>
	            <th>Name</th>
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
</body>
</html>