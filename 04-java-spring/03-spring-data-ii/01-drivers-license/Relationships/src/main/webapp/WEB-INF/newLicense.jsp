<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<body>
	<form:form action="/licenses/new" method="post" modelAttribute="license">
		<p>
			<form:label path="person">Person: </form:label>
	        <form:errors path="person"/>
	        <form:select path="person">
	        	<c:forEach items="${persons}" var="person">
	        		<form:option value="${person.id}">${person.firstName} ${person.lastName}</form:option>
	        	</c:forEach>
	        </form:select>
		</p>
		<p>
	        <form:label path="state">State: </form:label>
	        <form:errors path="state"/>
	        <form:input path="state"/>
	    </p>
		<p>
	        <form:label path="expiration_date">Expiration Date: </form:label>
	        <form:errors path="expiration_date"/>
	        <form:input type="date" path="expiration_date"/>
	    </p>
	    <input type="submit" value="Add License"/>
	</form:form>
</body>
</html>