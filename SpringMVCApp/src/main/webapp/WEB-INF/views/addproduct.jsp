<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">register form</h2>
<s:form action="addproduct" method="post"  commandName="product">
pid:<input type="text" name="id"/>
pname<input type="text" name="name"/>
desc<input type="text" name="desc"/>
price<input type="text" name="price"> 
<input type="submit" value="add product"> 

</s:form>
</body>
</html>