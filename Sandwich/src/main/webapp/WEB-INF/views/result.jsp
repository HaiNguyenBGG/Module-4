<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Kết quả lựa chọn</title>
</head>
<body>
<h2>Bạn đã chọn các gia vị sau:</h2>
<ul>
    <c:forEach var="item" items="${selectedCondiments}">
        <li>${item}</li>
    </c:forEach>
</ul>
<a href="/">Chọn lại</a>
</body>
</html>