<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Quantity Error</title>
	<link rel="stylesheet" href="dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="CSS/categoryCheckError.css">
</head>
<body>
	<!-- Category Name or Code already exists!
	<a href="addCategory.jsp" class="btn btn-primary">Add Category</a> -->
	<div class="container">
		<div class="box">
			<h1>Oops..</h1>
			<!-- <h3>Category Name or Code already exists!</h3> -->
			<p class="para-box">Quantity exceeds the Maximum Amount!</p>
			<span class="homepage-box">
				<a href="getAllProd_id.action">Return</a>
			</span>
		</div>
	</div>
</body>
</html>