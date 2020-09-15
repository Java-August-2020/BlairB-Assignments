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
	<h1><c:out value="${product.name}"/></h1>
	<h2>Categories: </h2>
	<c:forEach items="${categoriesForProduct}" var="cat">
		<p><c:out value="${cat}"/></p>
	</c:forEach>
	
	<form action="/products/${product.id}" method="post">
			<select name="category">
				<c:forEach items="${categories}" var="category">
	        		<option value="${category.id}">${category.name}</option>
	        	</c:forEach>
			</select>
	    <input type="submit" value="Add"/>
	</form>
</body>
</html>