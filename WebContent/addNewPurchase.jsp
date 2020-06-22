<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<title>Add Product</title>
	<link rel="stylesheet" href="dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="CSS/addNewPurchase.css">
</head>
<body bgcolor="#D9DFAA">
	<h1 class="addNewH3 text-uppercase">New Purchase:</h1>
	<s:form action="addNewPurchase" method="post" enctype="multipart/form-data">
	
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
			<td></td>
			<td>
				<a href="addCategory.jsp" class="btn btn-primary addCategoryBtn">Add Category</a>
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
				<textarea rows="4" cols="30" name="productBean.description" value=""></textarea>
			</td>
		</tr>

	<table class="wwFormTable">
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
			<td></td>
			<td><input type="submit" value="CONFIRM"/ class="btn btn-primary addBtn"></td>
		</tr>
	</table>
	</s:form>
	
	<!-- SCRIPTS HERE -->
<script src="dist/jquery.min.js"></script>
<script src="dist/js/bootstrap.min.js"></script>
</body>
</html>