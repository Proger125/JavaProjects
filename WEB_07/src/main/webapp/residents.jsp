<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aleksandr_Dzyachenka
  Date: 5/30/2022
  Time: 11:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="residentsHeader.jsp"/>
<jsp:useBean id="residentBean" type="edu.bsu.session.web_07.dao.ResidentDaoBean" scope="session"/>
<table class="residents">
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>City</th>
        <th>Street</th>
        <th>House number</th>
    </tr>
    <c:forEach items="${residentBean.residents}" var="resident" varStatus="status">
        <tr>
            <td>${resident.firstName}</td>
            <td>${resident.lastName}</td>
            <td>${resident.address.city}</td>
            <td>${resident.address.street}</td>
            <td>${resident.address.houseNumber}</td>
        </tr>
    </c:forEach>
</table>
<table class="residents-in-cities">
    <tr>
        <th>City</th>
        <th>Count</th>
    </tr>
    <c:forEach items="${residentBean.residentsInCities}" var="residentInCity" varStatus="status">
        <tr>
            <td>${residentInCity.key}</td>
            <td>${residentInCity.value}</td>
        </tr>
    </c:forEach>
</table>
<style>
    .residents td, #customers th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    .residents tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    .residents tr:hover {
        background-color: #ddd;
    }

    .residents th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: green;
        color: white;
    }
    .residents-in-cities {
        border: 1px solid #dddddd;
        padding: 8px;
    }
    .residents-in-cities th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: green;
        color: white;
    }
    .residents-in-cities tr:nth-child(even) {
        background-color: #f2f2f2;
    }
</style>
</body>
</html>
