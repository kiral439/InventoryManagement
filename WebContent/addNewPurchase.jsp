<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<title>Add Product</title>
	<link rel="stylesheet" href="dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="CSS/addNewPurchase.css">
</head>
<body bgcolor="#D9DFAA">
	<s:set value="#request.currentProd" var="current" />
	<s:set value="#request.originalProdId" var="orgProdId" />
	<h1 class="addNewH3 text-uppercase">New Purchase:</h1>
	<s:form action="addNewPurchase" method="post" enctype="multipart/form-data">
	
		<tr>
			<td>Product ID:</td>
			<td>
				<s:if test="%{#current!=null}">
					<input type="text" name="productInBean.prod_id" value="<s:property value="#current.prod_id" />"/>
				</s:if>
				<s:else>
					<input type="text" name="productInBean.prod_id" value="<s:property value="#orgProdId.prod_id" />"/>
				</s:else>
				<button type="submit" formaction="checkExistingProductId.action" class="btn btn-warning">Check</button>
			</td>
		</tr>
		<tr>
			<td>Name:</td>
			<td>
				<s:if test="%{#current!=null}">
					<input type="text" name="productBean.prod_name" value="<s:property value="#current.prod_name" />" readonly/>
				</s:if>
				<s:else>
					<input type="text" name="productBean.prod_name" value="" />
				</s:else>
			</td>
		</tr>
		<tr>
			<td>Category:</td>
			<td>
				<s:if test="%{#current!=null}">
					<select name="productBean.category" disabled>
				</s:if>
				<s:else>
					<select name="productBean.category" >
				</s:else>
					<s:iterator id="category" value="#request.categories">
						<s:if test="%{#current.category==#category.name}">
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
			<td></td>
			<td>
				<a href="addCategory.jsp" class="btn btn-primary addCategoryBtn">Add Category</a>
			</td>
		</tr>
		<tr>
			<td>Product Image:</td>
			<td>
				<s:if test="%{#current!=null}">
					<img src="getImage.action?productBean.id=<s:property value="#current.id"/>" width="150">
				</s:if>
				<s:else>
					<input type="file" name="photoFile"/>
				</s:else>
			</td>
		</tr>
		<tr>
			<td>Description:</td>
			<td>
				<s:if test="%{#current!=null}">
					<textarea rows="4" cols="30" name="productBean.description" readonly><s:property value="#current.description" /></textarea>
				</s:if>
				<s:else>
					<textarea rows="4" cols="30" name="productBean.description" value=""><s:property value="" /></textarea>
				</s:else>
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