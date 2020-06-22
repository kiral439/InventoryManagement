<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<title>Add Product</title>
	<link rel="stylesheet" href="dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="CSS/addCategory.css">
</head>
<body>
	<div class="overlay"></div>
	<s:form action="addCategory" method="post" enctype="multipart/form-data">
		<tr>
			<td colspan="2"><h1>Add Category:</h1></td>
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
			<td></td>
			<td class="addCategory-btn">
				<a href="categoriesList.action" class="btn btn-secondary">Return</a>
				<input type="submit" value="Add" class="btn btn-primary"/>
			</td>
		</tr>
	</s:form>
</body>
</html>