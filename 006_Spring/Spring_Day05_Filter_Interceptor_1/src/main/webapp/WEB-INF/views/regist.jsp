<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>��� ������</h2>
	<c:if test="${not empty userId }">
		<span>${userId }��, �ݰ����ϴ�.</span>
		<a href="/logout">�α׾ƿ�</a>
	</c:if>
</body>
</html>