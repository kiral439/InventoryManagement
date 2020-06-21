<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>Product List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center text-uppercase">Product Lists</h1>
	<hr />
	<div>
		<a href="categoriesList.action" class="btn btn-primary ml-5">Add Product</a>
	</div>
	<div class="p-5">
		<table class="table table-bordered table-striped">
			<thead class="bg-warning">
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Category</th>
				<th>In Stock</th>
				<th>Description</th>
				<th>Image</th>
				<th>Edit</th>
			</thead>
			<tbody>
				<s:iterator value="#request.prod_list" var="product">
					<tr>
						<td align="center"><s:property value="#product.prod_id" /></td>
						<td align="center"><s:property value="#product.prod_name" /></td>
						<td align="center"><s:property value="#product.category" /></td>
						<td align="center"><s:property value="#product.stock" /></td>
						<td align="center"><s:property value="#product.description" /></td>
						<td align="center"><img src="getImage.action?productBean.id=<s:property value="#product.id"/>" width="150"></td>
						<td><a href="#" class="btn btn-primary">Edit</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>

	<!-- SCRIPTS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>