<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<title>Inventory Management System</title>
	
	<link rel="stylesheet" href="CSS/login.css">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div class="overlay">
	</div>
	<h1>INVENTORY MANAGEMENT SYSTEM</h1>
	<s:form action="login" method="post">
		<table class="p-4">
			<tr>
				<s:textfield name="login.username" label="Username" size="22"></s:textfield>
			</tr>
			<tr>
				<s:password name="login.password" label="Password" size="22"></s:password>
			</tr>
			<tr>
				<td><input type="reset" value="reset" class="btn btn-danger"/></td>
				<td><input type="submit" value="Login" class="btn btn-success"/></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
