<%@ page language="java" pageEncoding="UTF-8" import="org.model.Login"%>
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

<p>Hi, 
<%  Login user = (Login) session.getAttribute("user");
	String usr = user.getUsername();
%> 

<%=usr%>

<p>
<a href="addCategory.jsp" class="btn btn-primary">Add Category</a>

<s:iterator id="product" value="#request.prod_list" var="product">
<div class="card" style="width: 18rem;">
	<img src="getImage.action?prod_list.id=<s:property value="#product.id"/>" width="150">
  <div class="card-body">
    <h5 class="card-title"><s:property value="#product.prod_name" /></h5>
    <p class="card-text"><s:property value="#product.description" /></p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>
</s:iterator>
<div class="card" style="width: 18rem;">
  <img src="https://source.unsplash.com/600x300" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>
<div class="card" style="width: 18rem;">
  <img src="https://source.unsplash.com/600x300" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>
<div class="card" style="width: 18rem;">
  <img src="https://source.unsplash.com/600x300" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>




	<!-- SCRIPTS HERE -->
<script src="dist/jquery.min.js"></script>
<script src="dist/js/bootstrap.min.js"></script>
</body>
</html>
