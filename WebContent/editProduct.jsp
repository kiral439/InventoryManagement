<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<title>Edit Product</title>
	<link rel="stylesheet" href="dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="CSS/editProduct.css">
</head>
<body>
<h1 class="addNewH3 text-uppercase">Edit Product:</h1>
<s:set value="#request.prod_list" var="productBean"/>
<s:set value="#request.prodIn_list" var="productInBean"/>
	<s:form action="UpdateProductInfo" method="post" enctype="multipart/form-data">
	
		<tr>
			<td>Product ID:</td>
			<td>
				<input type="hidden" name="productInBean.id" value="<s:property value="#productInBean.id"/>" readonly/>
				<input type="text" name="productBean.prod_id" value="<s:property value="#productBean.prod_id"/>" readonly/>
			</td>
		</tr>
		<tr>
			<td>Name:</td>
			<td>
				<input type="text" name="productBean.prod_name" value="<s:property value="#productBean.prod_name"/>" />
			</td>
		</tr>
		<tr>
			<td>Category:</td>
			<td>
				<select name="productBean.category">
					<s:iterator id="category" value="#request.categories" var="category">
						<s:if test="%{#category.name==#productBean.category}">
							<option selected value="<s:property value="#category.name"/>">
								<s:property value="#category.name"/>
							</option>
						</s:if>
						<s:else>
							<option value="<s:property value="#category.name"/>">
								<s:property value="#category.name"/>
							</option>
						</s:else>
					</s:iterator>
				</select>
			</td>
		</tr>
		<tr>
			<td>Product Image:</td>
			<td>
				<img src="getImage.action?productBean.id=<s:property value="#productBean.id"/>" width="150">
				<input type="file" name="photoFile"/>
			</td>
		</tr>
		<table class="wwFormTable ">
		<tr>
			<td>Description:</td>
			<td>
				<textarea name="productBean.description"><s:property value="#productBean.description"/></textarea>
			</td>
		</tr>
		<tr>
			<td>In stock:</td>
			<td>
				<input type="text" name="productBean.in_stock" value="<s:property value="#productBean.in_stock"/>" readonly/>
			</td>
		</tr>
		<tr>
			<td>Pending stock:</td>
			<td>
				<input type="text" name="productBean.pending_stock" value="<s:property value="#productBean.pending_stock"/>" readonly/>
			</td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Save Changes" class="btn btn-primary addBtn"/></td>
		</tr>
	</table>
	
	</s:form>
</body>
</html>