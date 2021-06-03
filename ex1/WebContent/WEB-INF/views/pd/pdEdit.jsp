<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdEdit.jsp</title>
</head>
<body>
<h1>상품수정</h1>
	<form action="<c:url value='/pd/pdEdit.do'/>" 
	name="frmEdit" method="post">
		<!-- 수정처리시 no가 필요, hidden필드에 넣어서 전달-사용자에게 안보임 -->
		<input type="hidden" name="no" value="${param.no }">
		<label for="pdName">상품명</label>
		<input type="text" name="pdName" id="pdName" 
			value="${pdDto.pdName }"><br>
		<label for="price">가격</label>
		<input type="text" name="price" id="price"
			value="${pdDto.price }"><br><br>
		<input type="submit" value="수정">
	
	</form>
	<hr>
	<a href="<c:url value='/pd/pdList.do'/>">상품 목록</a>
</body>
</html>