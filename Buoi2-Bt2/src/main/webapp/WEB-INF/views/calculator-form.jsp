<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Simple Calculator</title>
</head>
<body>
<h2>Calculator</h2> <%-- Sửa lại lỗi chính tả thành Calculator --%>

<form action="${pageContext.request.contextPath}/calculate" method="post">
  <input type="number" name="firstOperand" step="any" value="<c:out value='${firstOperand}'/>" placeholder="Number 1" required>
  <input type="number" name="secondOperand" step="any" value="<c:out value='${secondOperand}'/>" placeholder="Number 2" required>
  <br><br>
  <input type="submit" name="operator" value="Addition(+)">
  <input type="submit" name="operator" value="Subtraction(-)">
  <input type="submit" name="operator" value="Multiplication(X)">
  <input type="submit" name="operator" value="Division(/)">
</form>

<c:if test="${not empty result || not empty errorMessage}">
  <hr>
  <h3>Result:</h3>
  <c:if test="${not empty result}">
    <p><c:out value="${firstOperand}"/>
      <c:forEach var="opSymbol" items="${selectedOperator.split('')}">
        <c:if test="${opSymbol == '+'}">+</c:if>
        <c:if test="${opSymbol == '-'}">-</c:if>
        <c:if test="${opSymbol == 'X'}">*</c:if>
        <c:if test="${opSymbol == '/'}">/</c:if>
      </c:forEach>
      <c:out value="${secondOperand}"/> = <strong><c:out value="${result}"/></strong>
    </p>
  </c:if>
  <c:if test="${not empty errorMessage}">
    <p style="color:red;"><c:out value="${errorMessage}"/></p>
  </c:if>
</c:if>

</body>
</html>