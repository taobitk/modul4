<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="${pageContext.request.contextPath}/saveCondiments" method="post">
    <input type="checkbox" name="condiment" value="Lettuce"> Lettuce
    <input type="checkbox" name="condiment" value="Tomato"> Tomato
    <input type="checkbox" name="condiment" value="Mustard"> Mustard
    <input type="checkbox" name="condiment" value="Sprouts"> Sprouts
    <hr/>
    <input type="submit" value="Save">
</form>
</body>
</html>