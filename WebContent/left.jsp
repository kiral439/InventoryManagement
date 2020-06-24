<%@ page language="java" pageEncoding="UTF-8"%> <%@ taglib prefix="s"
uri="/struts-tags"%>
<html>
  <head>
    <title>Inventory Management System</title>
    <link rel="stylesheet" href="dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="CSS/left.css" />
  </head>

<!--   <body class="p-3">
    <a href="right.jsp" target="right" class="homeText"
      ><h4 class="my-3">HOME</h4>
     </a>
    <h5>Product Inventory</h5>
    <p class="ml-4">
      <a href="getAllProduct.action" target="right">Product List</a>
    </p>
    <p class="ml-4">
      <a href="getAllProductIn.action" target="right">Purchased Product</a>
    </p>
    <p class="ml-4">
      <a href="getAllProductOut.action" target="right">Product Sold</a>
    </p> -->

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
	

  <script
    src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
    integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
    crossorigin="anonymous"
  ></script>
  <script
    src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
    integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
    crossorigin="anonymous"
  ></script>
  <script
    src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
    integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
    crossorigin="anonymous"
  ></script>
</html>
