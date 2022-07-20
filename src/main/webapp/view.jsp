<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="2px">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Std</th>
			<th>School</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${std}" var="student">
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.std}</td>
				<td>${student.school}</td>
				<td><a href="delete?id=${student.id}">delete</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>