<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<title>Add Product</title>
</head>
<body bgcolor="#D9DFAA">
	<s:form action="addNewPurchase" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td colspan="2">Add Product:</td>
		</tr>
		<tr>
			<td>Product ID:</td>
			<td>
				<input type="text" name="productInBean.prod_id" value=""/>
			</td>
		</tr>
		<tr>
			<td>Name:</td>
			<td>
				<input type="text" name="productBean.prod_name" value="" />
			</td>
		</tr>
		<tr>
			<td>category:</td>
			<td>
				<select name="productBean.category">
					<s:iterator id="category" value="#request.categories">
						<option value="<s:property value="#category.name"/>">
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
			<td>Description:</td>
			<td>
				<textarea name="productBean.description" value=""></textarea>
			</td>
		</tr>
		<tr>
			<td>Supplier:</td>
			<td>
				<textarea name="productInBean.supplier" value=""></textarea>
			</td>
		</tr>
		<tr>
			<td>Quantity:</td>
			<td>
				<textarea name="productInBean.pending_stock" value=""></textarea>
			</td>
		</tr>
		<tr>
			<td>Buying Price:</td>
			<td>
				<textarea name="productInBean.supplier" value=""></textarea>
			</td>
		</tr>
		<tr>
			<td>Status:</td>
			<td>
				<select name="productInBean.status">
					<option value="On shipping">On shipping</option>
					<option value="Arrived">Arrived</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="Add"/></td>
		</tr>
	</table>
	</s:form>
</body>
</html>