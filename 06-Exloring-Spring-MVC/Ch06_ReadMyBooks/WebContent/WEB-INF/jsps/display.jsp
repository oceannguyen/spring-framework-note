<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Book List</title>
</head>
<body>
	<center>
		<img alt="bookshelf" src="images/img1.png" height="180" width="350">
		<br />
	</center>

	<jstl:if test="${ not empty bookList }">
		<h1 align="center">
			<font color="green"> Book List of ${authorName } <font>
		</h1>
		<table align="center" border="1">
			<tr>
				<th>Book Name</th>
				<th>ISBN</th>
				<th>Publication</th>
				<th>Price</th>
				<th>Description</th>
			</tr>
			<jstl:forEach var="book" items="${bookList}" varStatus="st">
				<tr>
					<td>
						<jstl:out value="${ book.bookName }"></jstl:out>
					</td>
					<td>
						<jstl:out value="${ book.ISBN }"></jstl:out>
					</td>
					<td>
						<jstl:out value="${ book.publication }"></jstl:out>
					</td>
					<td>
						<jstl:out value="${ book.price }"></jstl:out>
					</td>
					<td>
						<jstl:out value="${ book.description }"></jstl:out>
					</td>
				</tr>
			</jstl:forEach>
		</table>
	</jstl:if>
	
	<jstl:if test="${ empty bookList }">
		<jstl:out value="No Book Found"></jstl:out>
	</jstl:if>


</body>
</html>