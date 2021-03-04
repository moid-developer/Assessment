<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Book</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<c:choose>
<c:when test="${bookList ne null && not empty bookList }">
<div class="header" align="center"></div>
<p style="color:navy;text-align:center">All books</p> <p style="text-align:right"> </p>
<div align="center">
<table style="color:Navy;" align="center" class="table table-responsive">
<thead>
	<tr>
	<th> </th>
	<th> Name</th>
	<th>Author</th>
	<th>Price</th>
	<th>Status</th>
	</tr>
	</thead>
<c:forEach var="model" items="${bookList}" >
	<tr><td><img  src="image/${model.getImgName()}">
	<td><a href="bookdetail?bid=${model.getBid()}">${model.getBookName()}</a></td>
	<td>${model.getAuthorName()}</td>
	<td>${model.getPrice()}</td>
	<td>${model.getAvbStatus()}</td>
	<td><a href="addtocart?bid=${model.getBid()}">add to cart</a></td>
</tr>
</c:forEach>
</table>
</div>
</c:when>
<c:otherwise>
	<h3>books not found</h3>
</c:otherwise>
</c:choose>
<c:if test="${ msg ne null}"></c:if>
<a href="home">Home</a>


</body>
</html>