<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<title>Inventory Management System</title>
	
	<link rel="stylesheet" href="dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="CSS/login.css">
</head>
<body>
	<div class="overlay">
	</div>
	<h1>INVENTORY MANAGEMENT SYSTEM</h1>
	<s:form action="login" method="post" class="p-5">
		<table>
			<tr>
				<s:textfield name="login.username" label="Username" size="22"></s:textfield>
			</tr>
			<tr>
				<s:password name="login.password" label="Password" size="22"></s:password>
			</tr>
			<tr>
				<p><a href="register.jsp">Please register</a> for our prize drawing.</p>
			</tr>
			<tr>
				<td class="tdBtn">
					<input type="reset" value="Reset" class="btn btn-danger"/>
					<input type="submit" value="Login" class="btn btn-success"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>
