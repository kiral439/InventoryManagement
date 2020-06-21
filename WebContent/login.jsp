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
	<s:form action="login" method="post" class="p-5">
		<table>
			<tr>
				<s:textfield name="login.username" label="Username" size="22"></s:textfield>
			</tr>
			<tr>
				<s:password name="login.password" label="Password" size="22"></s:password>
			</tr>
			<tr>
				<td class="tdBtn">
					<input type="reset" value="Reset" class="btn btn-danger"/>
					<input type="submit" value="Login" class="btn btn-success"/>
				</td>
				
				<!-- <td class="tdBtn"></td> -->
			</tr>
		</table>
	</s:form>
</body>
</html>
