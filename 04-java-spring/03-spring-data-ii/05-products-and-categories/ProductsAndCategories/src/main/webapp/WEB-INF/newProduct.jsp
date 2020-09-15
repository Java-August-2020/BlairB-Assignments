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
	<h1>New Product</h1>
	<form:form action="/products/new" method="post" modelAttribute="product">
		<p>
	        <form:label path="name">Name: </form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
		<p>
	        <form:label path="description">description: </form:label>
	        <form:errors path="description"/>
	        <form:input path="description"/>
	    </p>
	    <p>
	        <form:label path="price">price</form:label>
	        <form:errors path="price"/>
	        <form:input path="price"/>
	    </p>
	    <input type="submit" value="Create"/>
	</form:form>
</body>
</html>