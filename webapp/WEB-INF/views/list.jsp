<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호부</h1>
	<h2>리스트</h2>
	
	<c:forEach items="${pList}" var="pList">
		<table border='1'>
			<tr>
				<td>이름(name)</td>
				<td>${pList.name}</td>
			<tr>
			<tr>
				<td>핸드폰(hp)</td>
				<td>${pList.hp }</td>
			<tr>
			<tr>
				<td>회사(company)</td>
				<td>${pList.company }</td>
			<tr>
			<tr>
				<td><a href="/phonebook3/updateForm?personId=${pList.personId}">[수정폼]</a></td>
				<td><a href="/phonebook3/delete?personId=${pList.personId}">삭제</a></td>
			<tr>
		</table>
	</c:forEach>
</body>
</html>