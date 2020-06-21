<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product In List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center text-uppercase">Purchased Product</h1>
	<hr />
	<div>
		<a href="categoriesList.action" class="btn btn-primary ml-5">New Purchase</a>
		<a href="getAllOnShippingProduct.action" class="btn btn-primary">Show On Shipping Product Only</a>
		<a href="getAllProductIn.action" class="btn btn-primary">Show All Purchased Product</a>
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
						
						<%-- <td align="center">
						<s:form action="arrived.action?productIn.id=<s:property value="#prodIn.id"/>" method="post" theme="simple" class="anchored" target="_parent" >
							<s:submit value="On shipping" class="btn btn-success"/>
						</s:form> --%>
						<td>
						
						<s:if test="%{#prodIn.status=='On shipping'}">
							<a href="productInUpdate.action?prodIn.id=<s:property value="#prodIn.id"/>" class="btn btn-danger"><s:property value="#prodIn.status"/></a></td>
						</s:if>
						<s:else>
						    <a href="productInUpdate.action?prodIn.id=<s:property value="#prodIn.id"/>" class="btn btn-success"><s:property value="#prodIn.status"/></a></td>
						</s:else>
						
						<%-- <a href="productInUpdate.action?prodIn.id=<s:property value="#prodIn.id"/>" class="btn btn-success"><s:property value="#prodIn.status"/></a></td> --%>
						</td>
						
						<%-- <td align="center"><s:property value="#prodIn.status" /></td> --%>
						<td align="center"><s:property value="#prodIn.buying_price" /></td>
						<%-- <td align="center"><img src="getImage.action?product.id=<s:property value="#product.id"/>" width="150"></td> --%>
						<td><a href="productInEdit.action?prodIn.id=<s:property value="#prodIn.id" />" class="btn btn-primary">Edit</a></td>
						<td align="center"><s:property value="#prodIn.date" /></td>
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