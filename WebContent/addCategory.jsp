<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
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
				<input required type="text" name="categoryBean.code" value=""/>
			</td>
		</tr>
		<tr>
			<td>Category Name:</td>
			<td>
				<input required type="text" name="categoryBean.name" value="" />
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="Add"/></td>
		</tr>
		<tr>
			<td>
				<a href="categoriesList.action" class="btn btn-primary">Return</a>
			</td>
		</tr>
	</table>
	</s:form>
</body>
</html>