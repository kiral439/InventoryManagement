<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<title>Add Product</title>
	<link rel="stylesheet" href="dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="CSS/addNewPurchase.css">
</head>
<script>
	
</script>
<body>
	<s:set value="#request.currentProd" var="current" />
	<h1 class="addNewH3 text-uppercase">New Record:</h1>
	<s:form action="addNewProductSold" method="post" enctype="multipart/form-data">
		<tr>
			<td>Product ID:</td>
			<td>
				<select name="productOutBean.prod_id">
					<s:iterator id="productList" value="#request.prod_list">
						<s:if test="%{#current.prod_id==#productList.prod_id}">
							<option selected value="<s:property value="#productList.prod_id"/>">
								<s:property value="#productList.prod_id"/>
							</option>
						</s:if>
						<s:else>
							<option value="<s:property value="#productList.prod_id"/>">
								<s:property value="#productList.prod_id"/>
							</option>
						</s:else>
					</s:iterator>
				</select>
				<button type="submit" formaction="checkQuantity.action" class="btn btn-warning">Check</button>

			</td>
		</tr>
		<tr>
			<td>Buyer:</td>
			<td>
				<input type="text" name="productOutBean.buyer" value="" />
			</td>
		</tr>
		<tr>
			<td>Quantity:</td>
			<td>
				<textarea name="productOutBean.quantity"></textarea>
				Available stock: <s:property value="#current.in_stock" />
			</td>
		</tr>

	<table class="wwFormTable">
		<tr>
			<td>Selling Price:</td>
			<td>
				<textarea name="productOutBean.selling_price" value=""></textarea>
			</td>
		</tr>
		<tr>
			<td>Status:</td>
			<td>
				<select name="productOutBean.status">
					<option value="On shipping">On shipping</option>
					<option value="Delivered">Delivered</option>
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