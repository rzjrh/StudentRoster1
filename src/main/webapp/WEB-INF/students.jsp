<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<style>
table{text-align:right}
th{
	min-width:100px;
	}
td{	
	padding-left:50px;
}
</style>
</head>
<body>
<a href="/students">Students</a>
<a href="/students/new">Students/new</a>
<a href="/contact/new">Contact/new</a>
<h1>Students (Dashboard)</h1>
<table>
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Age</th>
            <th>Address</th>
            <th>City</th>
            <th>State</th>
        </tr>
    </thead>
<tbody>
<c:forEach var="student" items="${students}">
<tr>
	<td>${student.id}</td>
	<td>${student.getFirstName() } ${student.getLastName() }</td>
	<td>${student.getAge() }</td>
	<td>${student.getContactInfo().getAddress() }</td>
	<td>${student.getContactInfo().getCity() }</td>
	<td>${student.getContactInfo().getState() }</td>
</tr>
</c:forEach>

</tbody>
</table>
<br>	 
</body>
</html> 