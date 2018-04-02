<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<center>
		<form:form modelAttribute="myPerson" method="POST"
			action="addPerson.htm">
			<h2>
				<center>Enter the Person Details</center>
			</h2>

			<table width="100%" height="150" align="center">
				<tr>
					<td width="50%" align="right">First Name of the Person</td>
					<td width="50%" align="left"><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td width="50%" align="right">Last Name of the Person</td>
					<td width="50%" align="left"><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td width="50%" align="right">Hobby Select</td>
					<td width="50%" align="left"><form:select path="hobby">
							<form:options items="${ hobbies }" itemLabel="hobbyName"
								itemValue="hobbyId" />
						</form:select></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Add Person"></td>
				</tr>
			</table>

		</form:form>
	</center>

</body>
</html>