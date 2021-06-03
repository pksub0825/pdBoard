<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
	<h1>상품등록</h1>
	<form action='<c:url value="/pd/pdWrite.do" />'
		name="frmWrite" method="post">
		
		<label for="pdName">상품명</label>
		<input type="text" name="pdName" id="pdName"><br>
		<label for="price">상품가격</label>
		<input type="text" name="price" id="price"><br>
		
		<input type="submit" value="전송"><br>
			
	</form>
	<hr>
	<a href='<c:url value="/pd/pdList.do"/>'>상품목록</a>
</body>
</html>