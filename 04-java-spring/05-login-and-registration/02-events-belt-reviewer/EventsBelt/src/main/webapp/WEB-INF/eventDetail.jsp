<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><c:out value="${event.name}"/></h1>
	<p>Host: <c:out value="${event.host.firstName} ${event.host.lastName}"/></p>
	<p>Date: <c:out value="${event.date}"/></p>
	<p>Location: <c:out value="${event.location}"/></p>
	<p>People who are attending this event: <c:out value="${event.date}"/></p>
	
	<table>
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>Location</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${event.attendees}" var="attendee">
		        <tr>
		        	<td><c:out value="${attendee.firstName} ${attendee.lastName}"/></td>
		            <td><c:out value="${attendee.location}"/></td>
	            </tr>
            </c:forEach>
	    </tbody>
	</table>
	<br/><br/><br/>
	
	<h2>Message Wall</h2>
	<c:forEach items="${event.comments}" var="comment">
       	<p><c:out value="${comment.user.firstName} says: ${comment.comment}"/></p>
    </c:forEach>
    <hr/>
    <br/><br/>
    <form action="/events/${event.id}/newComment" method="post">
    	<span>Add Comment:</span><br/>
    	<textarea name="comment"></textarea>
    	<button>Submit</button>
    </form>
</body>
</html>