<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Customer Information</title>
</head>
<body>
<h1>Customer information</h1>
<c:if test="${customer != null}">
  <form method="post" action="${pageContext.request.contextPath}/customers"> <%-- Action trỏ về /customers (sẽ được @PostMapping trong controller xử lý) --%>
    <input type="hidden" name="id" value="${customer.id}">
    <table>
      <tr>
        <td>Name:</td>
        <td><input type="text" name="name" value="${customer.name}"></td>
      </tr>
      <tr>
        <td>Email:</td>
        <td><input type="text" name="email" value="${customer.email}"></td>
      </tr>
      <tr>
        <td>Address:</td>
        <td><input type="text" name="address" value="${customer.address}"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Update customer"></td>
      </tr>
    </table>
  </form>
</c:if>
<c:if test="${customer == null}">
  <p>Customer not found!</p>
</c:if>
<p>
  <a href="${pageContext.request.contextPath}/customers">Back to list</a>
</p>
</body>
</html>