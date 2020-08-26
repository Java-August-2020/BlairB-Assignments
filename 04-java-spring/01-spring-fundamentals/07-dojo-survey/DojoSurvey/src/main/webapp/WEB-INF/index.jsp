<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="/result">
		<label>Your Name:<input name="name"/></label>
		<label>Dojo Location:<input name="location"/></label>
		<label>Favorite Language:<input name="language"/></label>
		<label for="comment">Comment (optional)</label><br/>
		<textarea name="comment"/></textarea><br/>
		<button>Button</button>
	</form>
</body>
</html>