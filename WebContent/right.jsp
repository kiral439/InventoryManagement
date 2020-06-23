<%@ page language="java" pageEncoding="UTF-8" import="org.model.Login, org.model.Product"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<link rel="stylesheet" href="dist/css/bootstrap.min.css">
	
	<style>
		body {
			display: flex;
			flex-wrap: wrap;
		}
		
		.card{
			margin: 20px;
		}
	</style>
	
</head>
<body>

<%-- <p>Hi, 
<%  Login user = (Login) session.getAttribute("user");
	String usr = user.getUsername();
	
	//Product products = (Product) session.getAttribute("products");
%> 

<%=usr%>

<p>
<a href="addCategory.jsp" class="btn btn-primary">Add Category</a> --%>

<s:iterator id="product" value="#session.products" var="product">
<div class="card" style="width: 18rem;">
	
	<img src="getImage.action?productBean.id=<s:property value="#product.id"/>" width="150">
  <div class="card-body">
    <h5 class="card-title"><s:property value="#product.prod_name" /></h5>
    <%-- <p class="card-text"><s:property value="#product.description" /></p> --%>
		<p class="card-text"><s:property value="#product.description.substring(0,60)" />...</p>
    <a href="ProductEdit.action?prodIn.prod_id=<s:property value="#product.prod_id" />" class="btn btn-primary">Edit</a>
  </div>
</div>
</s:iterator>




	<!-- SCRIPTS HERE -->
<script src="dist/jquery.min.js"></script>
<script src="dist/js/bootstrap.min.js"></script>
</body>
</html>
