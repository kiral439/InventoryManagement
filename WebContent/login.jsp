<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<title>Inventory Management System</title>
	
	<link rel="stylesheet" href="CSS/login.css">
</head>
<body>
	<div class="overlay">
	</div>
	
	<s:form action="login" method="post">
		<table>
			<tr>
				<s:textfield name="login.username" label="Username" size="22"></s:textfield>
			</tr>
			<tr>
				<s:password name="login.password" label="Password" size="22"></s:password>
			</tr>
			<tr>
				<td><input type="reset" value="reset" /></td>
				<td align="left"><input type="submit" value="Login" /></td>
				
			</tr>
		</table>
	</s:form>
	
</body>
</html>
