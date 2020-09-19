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
	<h1>Welcome <c:out value="${user.firstName}"/></h1>
	<h4>Events in your state</h4>
	<table>
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>Date</th>
	            <th>Location</th>
	            <th>Host</th>
	            <th>Action/Status</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${localEvents}" var="localEvent">
	        <tr>
	            <td><a href="/events/${localEvent.id}"><c:out value="${localEvent.name}"/></a></td>
	            <td><c:out value="${localEvent.date}"/></td>
	            <td><c:out value="${localEvent.location}"/></td>
	            <td><c:out value="${localEvent.host.firstName}"/></td>
	            <td>
	            	<form:form action="/events/${localEvent.id}" method="post">
		            	<c:choose>
						    <c:when test="${user == localEvent.host}">
						        <a href="/events/${localEvent.id}/edit">Edit</a>
						        <input type="hidden" name="_method" value="delete"/>
		            			<input type="submit" value="delete"/>
						    </c:when>    
						    <c:otherwise>
				    			<c:choose>
							        <c:when test="${localEvent.attendees.contains(user)}"> 
							            <span>Joining</span>
							            <input type="hidden" name="_method" value="put"/>
	            						<input type="submit" value="Cancel"/>
							        </c:when> 
							        <c:otherwise> 
							        	<input type="submit" value="Join"/>
							        </c:otherwise>
							    </c:choose>
						    </c:otherwise>
						</c:choose>
	            	</form:form>
	            </td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	
	<h4>Other Events</h4>
	<table>
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>Date</th>
	            <th>Location</th>
	            <th>State</th>
	            <th>Host</th>
	            <th>Action</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${otherEvents}" var="otherEvent">
	        <tr>
	            <td><a href="/events/${otherEvent.id}"><c:out value="${otherEvent.name}"/></a></td>
	            <td><c:out value="${otherEvent.date}"/></td>
	            <td><c:out value="${otherEvent.location}"/></td>
	            <td><c:out value="${otherEvent.state}"/></td>
	            <td><c:out value="${otherEvent.host.firstName}"/></td>
	            <td>
	            	<form:form action="/events/${otherEvent.id}" method="post">
		    			<c:choose>
					        <c:when test="${otherEvent.attendees.contains(user)}"> 
					            <span>Joining</span>
					            <input type="hidden" name="_method" value="put"/>
           						<input type="submit" value="Cancel"/>
					        </c:when> 
					        <c:otherwise> 
					        	<input type="submit" value="Join"/>
					        </c:otherwise>
					    </c:choose>
	            	</form:form>
	            </td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	
	<h1>Create an Event</h1>
	<p><form:errors path="event.*"/></p>
	<form:form method="POST" action="/events" modelAttribute="event">
		<p>
            <form:label path="name">Name:</form:label>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="date">Date:</form:label>
            <form:input type="date" path="date"/>
        </p>
        <p>
            <form:label path="location">Location:</form:label>
            <form:input path="location"/>
        </p>
        <p>
            <form:label path="state">State:</form:label>
            <form:input path="state"/>
        </p>
        <input type="submit" value="Create Event"/>
    </form:form>
</body>
</html>