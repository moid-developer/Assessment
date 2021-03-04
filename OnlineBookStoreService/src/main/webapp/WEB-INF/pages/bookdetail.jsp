<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book details</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<span class="header" align="center">
<h2 style="color:aqua;text-align:center">Book Detail</h2>
</span>
<div class="body " align="center">
<table>
<tr><td>Book name:</td>
<td>${detail.bookName}</td>
<td><img src="image/${detail.imgName}"/></td></tr>
<tr><td>Author Name:</td>
<td>${detail.authorName}</td></tr>
<tr><td>Description:</td></tr>
<tr><td colspan="5"><p>${detail.description}</p></td></tr>
<tr><td>Price:</td>
<td>${detail.price}</td></tr>
</table>
</div>
</body>
</html>