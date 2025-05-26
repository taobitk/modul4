<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="yaa.b1bth22.model.Customer" %>
<html>
<head>
  <title>Customer List</title>
</head>
<body>
<%
  List<Customer> customers = (List<Customer>) request.getAttribute("customers");
%>

<div class="page-title">CustomerList</div>

<p>There are <%= (customers != null) ? customers.size() : 0 %> customer(s) in list.</p>

<table>
  <thead>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Email</th>
    <th>Address</th>
  </tr>
  </thead>
  <tbody>
  <% if (customers != null && !customers.isEmpty()) { %>
  <% for (Customer customer : customers) { %>
  <tr>
    <td><%= customer.getId() %></td>
    <td>
      <a href="${pageContext.request.contextPath}/customer-info?id=<%= customer.getId() %>">
        <%= customer.getName() %>
      </a>
    </td>
    <td><%= customer.getEmail() %></td>
    <td><%= customer.getAddress() %></td>
  </tr>
  <% } %>
  <% } else { %>
  <tr>
    <td colspan="4" class="no-data">No customers found.</td>
  </tr>
  <% } %>
  </tbody>
</table>
</body>
</html>