<%@ page language="java" pageEncoding="UTF-8" import="org.model.Login, org.model.Product"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<Title>Inventory Management System</Title>
	<link rel="stylesheet" href="dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="CSS/right.css">
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
<div class="card">
	
	<!-- getting the image url from the database -->
	<div id="image-css" style="background-image: url('getImage.action?productBean.id=<s:property value="#product.id"/>');" >
		
	</div>
	<!-- END of getting the image url from the database -->
	
	<%-- <img src="getImage.action?productBean.id=<s:property value="#product.id"/>" class="card-img-top editImage"> --%>
  <div class="card-body">
    <h5 class="card-title">
    	<s:if test="%{#product.prod_name.length()<15}">
    		<s:property value="#product.prod_name" />
    	</s:if>
    	<s:else>
			<p><s:property value="#product.prod_name.substring(0,15)" />...</p>
    	</s:else>
    <%-- <s:property value="#product.prod_name" /> --%>
    
    </h5>
    <%-- <p class="card-text"><s:property value="#product.description" /></p> --%>
    	<s:if test="%{#product.description.length()<50}">
    		<p class="card-text"><s:property value="#product.description" /></p>
    	</s:if>
    	<s:else>
    		<p class="card-text"><s:property value="#product.description.substring(0,50)" />...</p>
    	</s:else>
    <a href="ProductEdit.action?prodIn.prod_id=<s:property value="#product.prod_id" />" class="btn btn-primary editBtn">Edit</a>
  </div>
</div>
</s:iterator>

<!-- 
<div class="card" style="width: 18rem;">
  <img src="https://source.unsplash.com/600x300" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>

 -->


	<!-- SCRIPTS HERE -->
<script src="dist/jquery.min.js"></script>
<script src="dist/js/bootstrap.min.js"></script>
</body>
</html>
