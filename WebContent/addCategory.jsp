<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<title>Add Product</title>
</head>
<body bgcolor="#D9DFAA">
	<s:form action="addCategory" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td colspan="2">Add Category:</td>
		</tr>
		<tr>
			<td>Category Code:</td>
			<td>
				<input type="text" name="categoryBean.code" value=""/>
			</td>
		</tr>
		<tr>
			<td>Category Name:</td>
			<td>
				<input type="text" name="categoryBean.name" value="" />
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="Add"/></td>
		</tr>
	</table>
	</s:form>
</body>
</html>