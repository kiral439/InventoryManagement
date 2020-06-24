<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>Product List</title>
<link rel="stylesheet" href="dist/css/bootstrap.min.css">
</head>
<body>
	<h1 class="pt-3 m-0 text-center text-uppercase">Product List</h1>
	<hr />
	<div class="px-5 py-3">
		<table class="table table-bordered table-striped">
			<thead class="bg-warning">
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Category</th>
				<th>In Stock</th>
				<th>Pending Stock</th>
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
						<td align="center"><s:property value="#product.in_stock" /></td>
						<td align="center"><s:property value="#product.pending_stock" /></td>
						<td align="center" style="overflow-wrap: anywhere" ><s:property value="#product.description" /></td>
						<td align="center"><img src="getImage.action?productBean.id=<s:property value="#product.id"/>" width="150"></td>
						<td><a href="ProductEdit.action?prodIn.prod_id=<s:property value="#product.prod_id" />" class="btn btn-primary">Edit</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>

<!-- SCRIPTS HERE -->
<script src="dist/jquery.min.js"></script>
<script src="dist/js/bootstrap.min.js"></script>
</body>
</html>