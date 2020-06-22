<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Register</title>
    
    <s:head />
  </head>
  <body>
    <h3>Register for a prize by completing this form.</h3>

    <s:form action="register" method="post" class="p-5">
		<table>
			<tr>
				<s:textfield name="personBean.username" label="Username" size="22"></s:textfield>
			</tr>
			<tr>
				<s:password name="personBean.password" label="Password" size="22"></s:password>
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