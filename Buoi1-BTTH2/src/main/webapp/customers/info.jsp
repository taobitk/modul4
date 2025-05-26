
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="yaa.b1bth22.model.Customer" %>
<html>
<head>
  <title>Customer Information</title>
  <style>
    .info-container {
      border: 1px solid gray;
      padding: 15px;
      width: 300px;
    }
    .info-container label {
      display: inline-block;
      width: 80px;
      margin-bottom: 10px;
    }
    .info-container input[type="text"] {
      width: 200px;
      margin-bottom: 10px;
    }
    .info-container input[type="submit"], .info-container a {
      margin-top: 10px;
    }
  </style>
</head>
<body>
<% Customer customer = (Customer) request.getAttribute("customer"); %>

<% if (customer != null) { %>
<div class="info-container">
  <h2 style="margin-top:0; margin-bottom: 15px; text-align: center;">Customer Information</h2>
  <div>
    <label for="id">Id</label>
    <input type="text" id="id" name="id" value="<%= customer.getId() %>" readonly>
  </div>
  <div>
    <label for="name">Name</label>
    <input type="text" id="name" name="name" value="<%= customer.getName() %>" readonly>
  </div>
  <div>
    <label for="email">Email</label>
    <input type="text" id="email" name="email" value="<%= customer.getEmail() %>" readonly>
  </div>
  <div>
    <label for="address">Address</label>
    <input type="text" id="address" name="address" value="<%= customer.getAddress() %>" readonly>
  </div>
  <form action="#" method="post">
    <input type="hidden" name="id" value="<%= customer.getId() %>">
    <input type="submit" value="Update">
  </form>
</div>
<% } else { %>
<p>Customer information not available.</p>
<% } %>

<p><a href="/customers">Back to list</a></p>

</body>
</html>