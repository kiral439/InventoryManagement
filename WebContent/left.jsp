<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	
	<style>
		body {
			background-color: #D9DBF1;
		}	
		
		.indent a {
			text-decoration: none;
		}
			
		.anchored {
			position: fixed;
			left: 0;
			bottom: 10;
			width: 100%;
			color: red;
			text-align: center;
		}
	</style>
</head>

<body class="p-3">
	<!--  <a href="StudentInfo.action" target="right">Products Inventory</a><p> // Change the action name convention -->
	<details>
		<summary>Product Inventory</summary>
		<p class="ml-4">
			<a href="StudentInfo.action" target="right">Products Inventory A</a>
		</p>
		<p class="ml-4">
			<a href="StudentInfo.action" target="right">Products Inventory B</a>
		</p>
		<p class="ml-4">
			<a href="StudentInfo.action" target="right">Products Inventory C</a>
		</p>
	</details>
	
	<details>
		<summary>Product Inventory</summary>
		<p class="ml-4">
			<a href="StudentInfo.action" target="right">Products Inventory A</a>
		</p>
		<p class="ml-4">
			<a href="StudentInfo.action" target="right">Products Inventory B</a>
		</p>
		<p class="ml-4">
			<a href="StudentInfo.action" target="right">Products Inventory C</a>
		</p>
	</details>
	
	<details>
		<summary>Product Inventory</summary>
		<p class="ml-4">
			<a href="StudentInfo.action" target="right">Products Inventory A</a>
		</p>
		<p class="ml-4">
			<a href="StudentInfo.action" target="right">Products Inventory B</a>
		</p>
		<p class="ml-4">
			<a href="StudentInfo.action" target="right">Products Inventory C</a>
		</p>
	</details>
	
	<!-- <a action="logout" target="right" class="anchored">Log Out</a> -->
	
	<s:form action="logout" method="post" theme="simple" class="anchored" target="_parent">
		<s:submit value="Log out"/>
	</s:form>
	

</body>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</html>
