<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<center>
		<table width="100%" height="150">
			<tr>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Hobby</th>
			</tr>
			<tr>
				<td>${ myPerson.firstName }</td>
				<td>${ myPerson.lastName }</td>
				<td>${ myPerson.hobby }</td>
			</tr>
		</table>
	</center>

</body>
</html>