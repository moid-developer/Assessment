<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books in cart</title>
</head>
<body>

<c:choose>
<c:when test="${books ne null}">
<div class="header" align="center"></div>
<h2 style="color:navy;text-align:center"> Book in cart </h2>
<div align="center">
<table style="color:Navy;" align="center" class="table table-responsive">
<c:forEach var="md" items="${books}" begin="1">
	<tr><td><img src="image/${md.getImgName()}"></td>
	<td>${md.getbookName()}</td>
	<td>${md.getAuthorName()}</td>
	<td>${md.getPrice()}</td>
	<td>${md.getAvbStatus()}</td>
	
</tr>
</c:forEach>
</table>
</div>
</c:when>
<c:otherwise>
	<h3>Cart is empty</h3>
</c:otherwise>
</c:choose>
<a href="home">Home</a>
</body>
</html>