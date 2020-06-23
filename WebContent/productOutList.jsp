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
	
	<h1 class="pt-3 m-0 text-center text-uppercase">Product Sold</h1>
	<hr />
	<div class="d-flex mx-5">
		<a href="getAllProd_id.action" class="btn btn-primary mr-auto">Add Record</a>
		<a href="getAllOnShippingProductOut.action" class="btn btn-primary">Show On Shipping Product Only</a>
		<a href="getAllProductOut.action" class="btn btn-primary ml-3">Show All Product Sold</a>
	</div>
	<div class="p-5">
		<table class="table table-bordered table-striped">
			<thead class="bg-warning">
				<th>Product ID</th>
				<th>Buyer</th>
				<th>Quantity</th>
				<th>Status</th>
				<th>Selling Price</th>
				<th>Edit</th>
				<th>Return</th>
				<th>Date</th>
			</thead>
			<tbody>
				<s:iterator value="#request.prodOut_list" var="prodOut">
					<tr>
						<td align="center"><s:property value="#prodOut.prod_id" /></td>
						<td align="center"><s:property value="#prodOut.buyer" /></td>
						<td align="center"><s:property value="#prodOut.quantity" /></td>
						<td align="center">
							<s:if test="%{#prodOut.status=='On shipping'}">
								<a href="productOutUpdate.action?prodOut.id=<s:property value="#prodOut.id"/>&prodOut.prod_id=<s:property value="#prodOut.prod_id" />" class="btn btn-warning"><s:property value="#prodOut.status"/></a></td>
							</s:if>
							<s:else>
							    <a href="productOutUpdate.action?prodOut.id=<s:property value="#prodOut.id"/>&prodOut.prod_id=<s:property value="#prodOut.prod_id" />" class="btn btn-success"><s:property value="#prodOut.status"/></a></td>
							</s:else>
						</td>
						<td align="center"><s:property value="#prodOut.selling_price" /></td>
						<%-- <td align="center"><img src="getImage.action?product.id=<s:property value="#product.id"/>" width="150"></td> --%>
						<td><a href="ProductOutEdit.action?prodOut.id=<s:property value="#prodOut.id" />&prodOut.prod_id=<s:property value="#prodOut.prod_id" />" class="btn btn-primary">Edit</a></td>
						<td><a href="ProductOutReturn.action?productOutBean.id=<s:property value="#prodOut.id" />&productBean.prod_id=<s:property value="#prodOut.prod_id" />" class="btn btn-danger">Return</a></td>
						<td align="center"><s:property value="#prodOut.date" /></td>
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