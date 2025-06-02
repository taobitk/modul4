<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Employee Information</title>
</head>
<body>
<h2>Submitted Employee Information</h2>
<table>
  <tr>
    <td>Name:</td>
    <td>${name}</td> <%-- Lấy giá trị từ model attribute "name" --%>
  </tr>
  <tr>
    <td>ID:</td>
    <td>${id}</td>
  </tr>
  <tr>
    <td>Contact Number:</td>
    <td>${contactNumber}</td>
  </tr>
</table>
<br/>
<%-- Link để quay lại form tạo nhân viên mới --%>
<a href="${pageContext.request.contextPath}/employee/showForm">Add Another Employee</a>
</body>
</html>
