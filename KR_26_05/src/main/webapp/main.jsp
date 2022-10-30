<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty sessionScope.locale}">
    <fmt:setLocale value="${sessionScope.locale}"/>
</c:if>
<fmt:setBundle basename="locale"/>
<fmt:message key="table.sum" var="sum"/>
<fmt:message key="table.payer" var="payer"/>
<fmt:message key="table.type" var="type"/>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<jsp:useBean id="now" class="java.util.Date"/>
<b>
    <fmt:formatDate type="time" value="${now}" pattern="dd.MM.yyyy HH:mm:ss"/>
    Aleksandr Dzyachenka
</b>

<p class="stat">Max tax payment: ${requestScope.max_payment}</p>
<p class="stat">Count of tax payments: ${requestScope.count_tax_payments}</p>
<table class="payments">
    <tr>
        <th>Id</th>
        <th>${type}</th>
        <th>${payer}</th>
        <th>${sum}</th>
    </tr>
    <c:forEach items="${requestScope.payments}" var="payment" varStatus="status">
        <tr>
            <td>${payment.id}</td>
            <td>${payment.type}</td>
            <td>${payment.payer}</td>
            <td>${payment.sum}</td>
        </tr>
    </c:forEach>
</table>
<form id="localeForm" action="${pageContext.request.contextPath}/" method="post">
    <button form="localeForm" type="submit" name="locale" value="en">
        EN
    </button>
    |
    <button form="localeForm" type="submit" name="locale" value="ru">
        RU
    </button>
</form>
<style>
    #customers {
        font-family: Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    .payments td, #customers th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    .payments tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    .payments tr:hover {
        background-color: #ddd;
    }

    .payments th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: green;
        color: white;
    }

    .stat {
        color: blue;
    }
</style>
</body>
</html>