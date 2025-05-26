<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Customer List</title>
  <style>
    table, th, td { border: 1px solid black; border-collapse: collapse; padding: 5px;}
  </style>
</head>
<body>
<h1>Customers</h1>
<p>
  <%-- <a href="/customers/create">Create new customer</a> --%> <%-- Link tạo mới sẽ cần controller riêng --%>
</p>
<table>
  <tr>
    <th>Name</th>
    <th>Email</th>
    <th>Address</th>
  </tr>
  <c:forEach items="${customers}" var="c">
    <tr>
      <td><a href="${pageContext.request.contextPath}/customers/${c.id}"><c:out value="${c.name}"/></a></td>
      <td><c:out value="${c.email}"/></td>
      <td><c:out value="${c.address}"/></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>