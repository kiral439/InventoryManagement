<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Inventory Management System</title>
    <link rel="stylesheet" href="dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="CSS/left.css" />
</head>

<body class="p-3">
		<a href="getAllProductSession.action" target="right" class="homeText">
		<h4 class="homeText mt-5">HOME</h4></a>
		<h5>Product Inventory</h5>
		<p class="ml-4">
			<a href="getAllProduct.action" target="right">Product List</a>
		</p>
		<p class="ml-4">
			<a href="getAllProductIn.action" target="right">Purchased Product</a>
		</p>
		<p class="ml-4">
			<a href="getAllProductOut.action" target="right">Product Sold</a>
		</p>
	
	<s:form action="logout" method="post" theme="simple" class="anchored" target="_parent" >
		<s:submit value="Log out" class="btn btn-danger"/>
	</s:form>
	
<!-- SCRIPTS HERE -->
<script src="dist/jquery.min.js"></script>
<script src="dist/js/bootstrap.min.js"></script>
</body>

</html>
