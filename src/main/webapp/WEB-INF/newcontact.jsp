<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<a href="/students">Students</a>
<a href="/students/new">Students/new</a>
<a href="/contact/new">Contact/new</a>
<h1>New Contact</h1>
<form:form action="/contact/new" method="post" modelAttribute="contact">
		<form:label path="student">Student</form:label><br>
		<form:errors path="student"/>
		<form:select path="student">
			<c:forEach var="student" items="${students}">
				<form:option value ="${student}"> ${student.getFirstName()} ${student.getLastName()}</form:option>
			</c:forEach>
		</form:select>
		<br>
		<form:label path="address">Address</form:label>
	    <form:errors path="address"/><br>
	    <form:input path="address"/><br>
	    <form:label path="city">City</form:label>
	    <form:errors path="city"/><br>
	    <form:input path="city"/><br>
	    <form:label path="state">State</form:label>
	    <form:errors path="state"/><br>
	    <form:input path="state"/><br>
	    <form:button type="Submit"> Create </form:button>
</form:form>
</body>
</html>