<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Property</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/app/add-property" method="post">
		Property Name :: <input type="text" name="property-name">
		Location :: 	 <input type="text" name="location">
		City :: 		 <input type="text" name="city">
		Country :: 		 <input type="text" name="country">
		Owner :: 		 <input type="text" name="owner">
						 <input type="submit" value="submit">
	</form>
</body>
</html>