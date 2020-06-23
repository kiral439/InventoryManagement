<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<title>Add Product</title>
</head>
<body bgcolor="#D9DFAA">
<s:set value="#request.prod_list" var="productBean"/>
<s:set value="#request.prodOut_list" var="productOutBean"/>
	<s:form action="UpdateProductOutInfo" method="post" enctype="multipart/form-data">
	
	<table>
		<tr>
			<td colspan="2">Edit Product Sold:</td>
		</tr>
		<tr>
			<td>Product ID:</td>
			<td>
				<input type="hidden" name="productOutBean.id" value="<s:property value="#productOutBean.id"/>" readonly/>
				<input type="text" name="productBean.prod_id" value="<s:property value="#productBean.prod_id"/>" readonly/>
			</td>
		</tr>
		<tr>
			<td>Name:</td>
			<td>
				<input type="text" name="productBean.prod_name" value="<s:property value="#productBean.prod_name"/>" readonly/>
			</td>
		</tr>
		<tr>
			<td>Category:</td>
			<td>
				<input type="text" name="productBean.category" value="<s:property value="#productBean.category"/>" readonly/>
			</td>
		</tr>
		<tr>
			<td>Product Image:</td>
			<td>
				<img src="getImage.action?productBean.id=<s:property value="#productBean.id"/>" width="150">
			</td>
		</tr>
		<tr>
			<td>Description:</td>
			<td>
				<textarea name="productBean.description" readonly><s:property value="#productBean.description"/></textarea>
			</td>
		</tr>
		<tr>
			<td>Buyer:</td>
			<td>
				<textarea name="productOutBean.buyer"><s:property value="#productOutBean.buyer"/></textarea>
			</td>
		</tr>
		<tr>
			<td>Quantity:</td>
			<td>
				<s:if test="%{#productOutBean.status=='Delivered'}">
					<textarea name="productOutBean.quantity" readonly><s:property value="#productOutBean.quantity"/></textarea>
				</s:if>
				<s:else>
					<textarea name="productOutBean.quantity"><s:property value="#productOutBean.quantity"/></textarea>
				</s:else>
			</td>
			<td>Maximum quantity: 
					<s:property value="%{(#productBean.in_stock)+(#productOutBean.quantity)}"/>
			</td>
		</tr>
		<tr>
			<td>Selling Price:</td>
			<td>
				<s:if test="%{#productOutBean.status=='Delivered'}">
					<textarea name="productOutBean.selling_price" readonly><s:property value="#productOutBean.selling_price"/></textarea>
				</s:if>
				<s:else>
					<textarea name="productOutBean.selling_price"><s:property value="#productOutBean.selling_price"/></textarea>
				</s:else>
			</td>
		</tr>
		<tr>
			<td>Status:</td>
			<td>
				<select name="productOutBean.status">
					<s:if test="%{#productOutBean.status=='On shipping'}">
						<option selected value="On shipping">On shipping</option>
						<option value="Delivered">Delivered</option>
					</s:if>
					<s:else>
						<option value="On shipping">On shipping</option>
						<option selected value="Delivered">Delivered</option>
					</s:else>
				</select>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="Save Changes"/></td>
		</tr>
	</table>
	</s:form>
</body>
</html>