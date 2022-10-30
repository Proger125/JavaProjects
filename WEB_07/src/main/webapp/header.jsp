<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aleksandr_Dzyachenka
  Date: 5/30/2022
  Time: 12:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header class="custom-header">
    <c:if test="${sessionScope.step == 1}">
        <div class="step-block green">
            <div class="step-inner-block">1</div>
        </div>
        <div class="step-block">
            <div class="step-inner-block">2</div>
        </div>
        <div class="step-block">
            <div class="step-inner-block">3</div>
        </div>
        <div class="step-block">
            <div class="step-inner-block">4</div>
        </div>
    </c:if>
    <c:if test="${sessionScope.step == 2}">
        <div class="step-block">
            <div class="step-inner-block">1</div>
        </div>
        <div class="step-block green">
            <div class="step-inner-block">2</div>
        </div>
        <div class="step-block">
            <div class="step-inner-block">3</div>
        </div>
        <div class="step-block">
            <div class="step-inner-block">4</div>
        </div>
    </c:if>
    <c:if test="${sessionScope.step == 3}">
        <div class="step-block">
            <div class="step-inner-block">1</div>
        </div>
        <div class="step-block">
            <div class="step-inner-block">2</div>
        </div>
        <div class="step-block green">
            <div class="step-inner-block">3</div>
        </div>
        <div class="step-block">
            <div class="step-inner-block">4</div>
        </div>
    </c:if>
    <c:if test="${sessionScope.step == 4}">
        <div class="step-block">
            <div class="step-inner-block">1</div>
        </div>
        <div class="step-block ">
            <div class="step-inner-block">2</div>
        </div>
        <div class="step-block">
            <div class="step-inner-block">3</div>
        </div>
        <div class="step-block green">
            <div class="step-inner-block">4</div>
        </div>
    </c:if>
</header>
<style>
    .custom-header {
        width: 100%;
        height: 50px;
        display: flex;
        flex-direction: row;
        justify-content: center;
        background-color: white;
    }
    .step-block {
        width: 40px;
        height: 40px;
        margin: auto;
        display: flex;
        flex-direction: column;
        justify-content: center;
        border: 1px solid #1c8ef9;
        border-radius: 50px;
    }

    .step-inner-block{
        width: 100%;
        display: flex;
        flex-direction: row;
        justify-content: center;
    }

    .green {
        background-color: #1c8ef9;
    }
</style>
</body>
</html>
