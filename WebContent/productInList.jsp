<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product In List</title>
<link rel="stylesheet" href="dist/css/bootstrap.min.css">
</head>
<body>
	<h1 class="pt-3 m-0 text-center text-uppercase">Purchased Product</h1>
	<hr />
	<div class="d-flex mx-5">
		<a href="categoriesList.action" class="btn btn-primary mr-auto">New Purchase</a>
		<a href="getAllOnShippingProductIn.action" class="btn btn-primary">Show On Shipping Product Only</a>
		<a href="getAllProductIn.action" class="btn btn-primary ml-3">Show All Purchased Product</a>
	</div>
	<div class="p-5">
		<table class="table table-bordered table-striped">
			<thead class="bg-warning">
				<th>Product ID</th>
				<th>Supplier</th>
				<th>Quantity</th>
				<th>Status</th>
				<th>Buying Price</th>
				<th>Edit</th>
				<th>Date</th>
			</thead>
			<tbody>
				<s:iterator value="#request.prodIn_list" var="prodIn">
					<tr>
						<td align="center"><s:property value="#prodIn.prod_id" /></td>
						<td align="center"><s:property value="#prodIn.supplier" /></td>
						<td align="center"><s:property value="#prodIn.quantity" /></td>
						<td>
						
						<s:if test="%{#prodIn.status=='On shipping'}">
							<a href="productInUpdate.action?prodIn.prod_id=<s:property value="#prodIn.prod_id"/>&prodIn.id=<s:property value="#prodIn.id"/>" class="btn btn-warning"><s:property value="#prodIn.status"/></a></td>
						</s:if>
						<s:else>
						    <a href="productInUpdate.action?prodIn.prod_id=<s:property value="#prodIn.prod_id"/>&prodIn.id=<s:property value="#prodIn.id"/>" class="btn btn-success"><s:property value="#prodIn.status"/></a></td>
						</s:else>

						</td>
						<td align="center"><s:property value="#prodIn.buying_price" /></td>
						<td><a href="ProductInEdit.action?prodIn.id=<s:property value="#prodIn.id" />&prodIn.prod_id=<s:property value="#prodIn.prod_id" />" class="btn btn-primary">Edit</a></td>
						<td align="center"><s:property value="#prodIn.date" /></td>
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