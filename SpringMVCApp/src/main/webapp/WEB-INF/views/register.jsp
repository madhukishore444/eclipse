
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2 align="center">register form</h2>
<s:form action="registerprocess" method="post" commandName="register">
<table>
	<tr><td>UserName</td><td><s:input path="username" /></td><td><font color="red">
							<s:errors path="username"/></font></td></tr>
	<tr><td>FirstName</td><td><s:input path="firstName" /></td><td><font color="red"><s:errors path="firstName"/></font></td></tr>
	<tr><td>LastName</td><td><s:input path="lastName" /></td></tr> 
	<tr><td>email</td><td><s:input path="email" /></td></tr>
	<tr><td>city</td><td><s:select items="${cities }" path="city"></s:select></td></tr>
	<tr><td>state</td><td><s:select items="${states }" path="state"></s:select></td></tr>
	<tr><td></td><td><input type="submit" value="REGISTER" /></td></tr>
</table>


</s:form>

</body>
</html>