<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
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
			<td>Category:</td>
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
			<td>
				<a href="addCategory.jsp" class="btn btn-primary">Add Category</a>
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
				<textarea name="productInBean.quantity" value=""></textarea>
			</td>
		</tr>
		<tr>
			<td>Buying Price:</td>
			<td>
				<textarea name="productInBean.buying_price" value=""></textarea>
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
			<td>Date:</td>
			<td>
				<textarea name="productInBean.date" value=""></textarea>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="Add"/></td>
		</tr>
	</table>
	</s:form>
</body>
</html>