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
	<h1><c:out value="${category.name}"/></h1>
	<h2>Products: </h2>
	<c:forEach items="${productsForCategory}" var="prod">
		<p><c:out value="${prod.name}"/></p>
	</c:forEach>
	
	<form action="/categories/${category.id}" method="post">
			<select name="product">
				<c:forEach items="${products}" var="product">
	        		<option value="${product.id}">${product.name}</option>
	        	</c:forEach>
			</select>
	    <input type="submit" value="Add"/>
	</form>
</body>
</html>