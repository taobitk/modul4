<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Selected Condiments</title>
</head>
<body>
<h1>Selected Sandwich Condiments</h1>

<c:choose>
    <c:when test="${not empty selectedCondiments}">
        <p>You have selected:</p>
        <ul>
            <c:forEach var="item" items="${selectedCondiments}">
                <li><c:out value="${item}"/></li>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        <p style="color: red;">${message}</p> <%-- Hiển thị thông báo nếu không chọn gì --%>
    </c:otherwise>
</c:choose>

<p><a href="${pageContext.request.contextPath}/">Choose again</a></p>
</body>
</html>