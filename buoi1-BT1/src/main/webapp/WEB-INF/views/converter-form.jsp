<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- Khai báo JSTL --%>
<html>
<head>
    <title>USD to VND Converter</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        .container {
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"], input[type="number"] {
            width: calc(100% - 12px);
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 3px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .result {
            margin-top: 20px;
            padding: 10px;
            background-color: #f0f0f0;
            border: 1px solid #e0e0e0;
            border-radius: 3px;
        }

        .error {
            color: red;
            font-weight: bold;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>USD to VND Converter</h2>

    <form method="POST" action="${pageContext.request.contextPath}/convert">
        <div>
            <label for="exchangeRate">Tỉ giá (1 USD = ? VND):</label>
            <input type="number" id="exchangeRate" name="exchangeRate" step="any" value="${exchangeRate}" required>
        </div>
        <div>
            <label for="usdAmount">Số lượng USD muốn đổi:</label>
            <input type="number" id="usdAmount" name="usdAmount" step="any" value="${usdAmount}" required>
        </div>
        <div>
            <input type="submit" value="Chuyển đổi">
        </div>
    </form>

    <c:if test="${not empty error}">
        <p class="error"><c:out value="${error}"/></p>
    </c:if>

    <c:if test="${not empty vndAmount}">
        <div class="result">
            <p><strong>Thông tin chuyển đổi:</strong></p>
            <p>Số lượng USD: <c:out value="${usdAmount}"/> USD</p>
            <p>Tỉ giá: 1 USD = <c:out value="${exchangeRate}"/> VND</p>
            <p><strong>Số tiền VNĐ nhận được: <c:out value="${vndAmount}"/> VND</strong></p>
        </div>
    </c:if>
</div>
</body>
</html>