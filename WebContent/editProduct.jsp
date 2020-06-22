<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<title>Add Product</title>
	<link rel="stylesheet" href="dist/css/bootstrap.min.css">
</head>
<body bgcolor="#D9DFAA">
<s:set value="#request.prod_list" var="productBean"/>
<s:set value="#request.prodIn_list" var="productInBean"/>
	<s:form action="UpdateProductInfo" method="post" enctype="multipart/form-data">
	
	<table>
		<tr>
			<td colspan="2">Edit Product:</td>
		</tr>
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
			<td>
				<a href="addCategory.jsp" class="btn btn-primary">Add Category</a>
			</td>
		</tr>
		<tr>
			<td>Product Image:</td>
			<td>
				<img src="getImage.action?productBean.id=<s:property value="#productBean.id"/>" width="150">
				<input type="file" name="photoFile"/>
			</td>
		</tr>
		<tr>
			<td>Description:</td>
			<td>
				<textarea name="productBean.description"><s:property value="#productBean.description"/></textarea>
			</td>
		</tr>
		<tr>
			<td>Supplier:</td>
			<td>
				<textarea name="productInBean.supplier"><s:property value="#productInBean.supplier"/></textarea>
			</td>
		</tr>
		<tr>
			<td>Quantity:</td>
			<td>
				<textarea name="productInBean.quantity"><s:property value="#productInBean.quantity"/></textarea>
			</td>
		</tr>
		<tr>
			<td>Buying Price:</td>
			<td>
				<textarea name="productInBean.buying_price"><s:property value="#productInBean.buying_price"/></textarea>
			</td>
		</tr>
		<tr>
			<td>Status:</td>
			<td>
				<select name="productInBean.status">
					<s:if test="%{#productInBean.status=='Arrived'}">
						<option value="On shipping">On shipping</option>
						<option selected value="Arrived">Arrived</option>
					</s:if>
					<s:else>
						<option selected value="On shipping">On shipping</option>
						<option value="Arrived">Arrived</option>
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