<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <s:head> --%>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="CSS/register.css">
<s:head/>
</head>
<body>
	<div class="container">
		<h1>Register</h1>
	    <p>Please fill in this form to create an account.</p>
		<s:form action="register" method="post" class="p-5">
			<tr>
				<s:textfield name="register.username" label="Username" size="22"></s:textfield>
			</tr>
			<tr>
				<s:password name="register.password" label="Password" size="22"></s:password>
			</tr>
			<tr>
				<td></td>
				<td class="tdBtn">
					<a href="login.jsp" class="btn btn-secondary">Return</a>
					<input type="submit" value="Register" class="btn btn-success"/>
				</td>
			</tr>
		</s:form>
	</div>
</body>
</html>