<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center" style="azimuth: left-side;color: blue;" >All Users</h1>
<table align="center" border="2" background="red">
<tr><td>ID</td><td>USERNAME</td><td>PASSWORD</td></tr>
<c:forEach var="user" items="${userlogins}">
<tr><td>${user.id }</td>
<td>${user.name}</td>
<td>${user.password}</td></tr>
</c:forEach>
</table>

</body>
</html>