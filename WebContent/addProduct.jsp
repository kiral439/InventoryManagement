<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<title>Add Product</title>
</head>
<body bgcolor="#D9DFAA">
	<s:form action="addProduct" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td colspan="2">Add Product:</td>
		</tr>
		<tr>
			<td>Product ID:</td>
			<td>
				<input type="text" name="product.sid" value="<s:property value="#product.sid"/>" readOnly/>
			</td>
		</tr>
		<tr>
			<td>Name:</td>
			<td>
				<input type="text" name="product.name" value="<s:property value="#product.name"/>" />
			</td>
		</tr>
		<tr>
			<td>category:</td>
			<td>
				<select name="category.id">
					<s:iterator id="category" value="#request.categories">
						<option value="<s:property value="#category.id"/>">
							<s:property value="#category.name"/>
						</option>
					</s:iterator>
				</select>
			</td>
		</tr>
		<tr>
			<td>Product Image:</td>
			<td>
				<input type="file" name="photoFile"/>
			</td>
		</tr>
		<tr>
			<td>Stock:</td>
			<td>
				<input type="text" name="product.birthday" value="<s:property value="#product.birthday"/>"/>
			</td>
		</tr>
		<tr>
			<td>Description:</td>
			<td>
				<textarea name="product.remarks" value="<s:property value="#product.remarks"/>"></textarea>
			</td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Add"/></td>
		</tr>
	</table>
	</s:form>
</body>
</html>