<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Từ điển Anh - Việt Đơn Giản</title>
  <style>
    body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; margin: 0; padding: 0; background-color: #f4f7f6; display: flex; justify-content: center; align-items: center; min-height: 90vh; }
    .container { width: 500px; background-color: #fff; padding: 30px 40px; border-radius: 10px; box-shadow: 0 5px 15px rgba(0,0,0,0.1); }
    h2 { text-align: center; color: #333; margin-bottom: 25px; }
    label { display: block; margin-bottom: 8px; font-weight: 600; color: #555; }
    input[type="text"] { width: calc(100% - 24px); padding: 10px; margin-bottom: 20px; border: 1px solid #ddd; border-radius: 5px; font-size: 1em; transition: border-color 0.3s; }
    input[type="text"]:focus { border-color: #007bff; outline: none; }
    input[type="submit"] { display: block; width: 100%; background-color: #007bff; color: white; padding: 12px 20px; border: none; border-radius: 5px; cursor: pointer; font-size: 1.1em; transition: background-color 0.3s; }
    input[type="submit"]:hover { background-color: #0056b3; }
    .result-box { margin-top: 25px; padding: 15px 20px; background-color: #e9ecef; border: 1px solid #ced4da; border-radius: 5px; }
    .result-box p { margin: 10px 0; line-height: 1.6; }
    .not-found { color: #dc3545; font-weight: bold; }
    .meaning { color: #28a745; font-weight: bold; font-size: 1.2em; }
    .searched-word { font-style: italic; color: #495057; }
  </style>
</head>
<body>
<div class="container">
  <h2>Tra cứu từ Anh - Việt</h2>

  <form method="POST" action="${pageContext.request.contextPath}/dictionary">
    <div>
      <label for="searchWordInput">Nhập từ tiếng Anh:</label>
      <%-- Hiển thị lại từ đã tìm kiếm trước đó nếu có --%>
      <input type="text" id="searchWordInput" name="searchWord" value="<c:out value='${searchWord}'/>" required autofocus>
    </div>
    <div>
      <input type="submit" value="Tra cứu">
    </div>
  </form>

  <%-- Chỉ hiển thị kết quả nếu đã có từ được tra (searchWord được gửi từ controller) --%>
  <c:if test="${not empty searchWord}">
    <div class="result-box">
      <p>Từ đã tra: <strong class="searched-word"><c:out value="${searchWord}"/></strong></p>
      <c:choose>
        <c:when test="${not empty vietnameseMeaning}">
          <p>Nghĩa tiếng Việt: <span class="meaning"><c:out value="${vietnameseMeaning}"/></span></p>
        </c:when>
        <c:when test="${not empty notFoundMessage}">
          <p class="not-found"><c:out value="${notFoundMessage}"/></p>
        </c:when>
      </c:choose>
    </div>
  </c:if>
</div>
</body>
</html>