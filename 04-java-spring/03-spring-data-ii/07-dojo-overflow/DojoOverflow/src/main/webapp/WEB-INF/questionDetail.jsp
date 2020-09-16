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
	<h1><c:out value="${question.question}"/></h1>
	<span>Tags: </span>
	<c:forEach items="${question.tags}" var="tag">
		<span><c:out value="${tag.subject}"/></span>
	</c:forEach>
	<table>
	    <thead>
	        <tr>
	            <th>Answers</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${question.answers}" var="answer">
		        <tr>
		            <td><c:out value="${answer.answer}"/></td>
		        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<br/><br/>
	<form action="/questions/${question.id}" method="post">
		<label>Answer: <textarea name="answer"></textarea></label>
		<br/><button>Answer it!</button>
	</form>
</body>
</html>