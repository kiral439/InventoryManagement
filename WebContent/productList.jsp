<%@ page language="java" pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="/struts-tags" prefix="s" %> --%>
<html>
<head>
	<title>Course Management System</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center text-uppercase">Product Lists</h1>
<hr/>
<div><a href="addProduct.jsp" class="btn btn-primary">Add Product<span class="glyphicon glyphicon-refresh"></span></a></div>
<div class="p-5">
    <table class="table table-bordered table-striped">
        <thead class="bg-warning">
            <th>Restore</th>
            <th>Products</th>
            <th>Price</th>
            <th>Category</th>
            <th>Sold</th>
        </thead>
        <tbody>

                <tr>
                    <td>
                        <a href="#" class="btn btn-primary">Restore<span class="glyphicon glyphicon-refresh"></span></a>
                    </td>
                    <td>title</td>
                    <td>price</td>
                    <td>Final</td>
                    <td>0</td>
                </tr>
        </tbody>
    </table>
</div>

<!-- SCRIPTS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>