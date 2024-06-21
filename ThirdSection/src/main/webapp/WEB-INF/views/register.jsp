<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form:form modelAttribute="merch" action="save" method="post">
    <form:input path="name" type="text" placeholder="Enter name"/>
     <form:input path="email" type="text" placeholder="Enter email"/>
    <form:input path="gnumber" type="text" placeholder="Enter gstnumber"/>
    <form:input path="password" type="text" placeholder="Enter password"/>
    <form:input path="phone" type="text" placeholder="Enter phone"/>
    <form:button>Register</form:button>
    
   </form:form>
</body>
</html>