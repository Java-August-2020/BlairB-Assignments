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
	<h1>Questions Dashboard</h1>
	<table>
	    <thead>
	        <tr>
	            <th>Question</th>
	            <th>Tags</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${questions}" var="question">
		        <tr>
		            <td><c:out value="${question.question}"/></td>
		            <td>
		            	<c:forEach items="${question.tags}" var="tag">
		            		<span><c:out value="${tag.subject}"/>,</span>
		            	</c:forEach>
		            </td>
		        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<a href="/questions/new">New Question</a>
</body>
</html>