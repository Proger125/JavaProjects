<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="formBlock" uri="blocktag" %>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<jsp:include page="header.jsp"/>
    <div class="wrapper">
        <div class="container">
            <form action="<c:url value="/"/>" method="post">
                <c:if test="${sessionScope.step == 1}">
                    <formBlock:formBlockTag name="first-name" type="text" valueName="${sessionScope.firstName}">
                        First name
                    </formBlock:formBlockTag>
                    <formBlock:formBlockTag name="last-name" type="text" valueName="${sessionScope.lastName}">
                        Last name
                    </formBlock:formBlockTag>
                </c:if>
                <c:if test="${sessionScope.step == 2}">
                    <formBlock:formBlockTag name="city" type="text" valueName="${sessionScope.city}">
                        City
                    </formBlock:formBlockTag>
                    <formBlock:formBlockTag name="street" type="text" valueName="${sessionScope.street}">
                        Street
                    </formBlock:formBlockTag>
                    <formBlock:formBlockTag name="house-number" type="text" valueName="${sessionScope.houseNumber}">
                        House number
                    </formBlock:formBlockTag>
                </c:if>
                <c:if test="${sessionScope.step == 3}">
                    <formBlock:formBlockTag name="email" type="email" valueName="${sessionScope.email}">
                        Email
                    </formBlock:formBlockTag>
                    <formBlock:formBlockTag name="phone-number" type="tel" valueName="${sessionScope.phoneNumber}">
                        Phone number
                    </formBlock:formBlockTag>
                </c:if>
                <c:if test="${sessionScope.step == 4}">
                    <div class="form-block final">
                        <label for="first-name">First name: ${sessionScope.firstName}</label>
                        <label for="last-name">Last name: ${sessionScope.lastName}</label>
                        <label for="city">City: ${sessionScope.city}</label>
                        <label for="street">Street: ${sessionScope.street}</label>
                        <label for="house-number">House number: ${sessionScope.houseNumber}</label>
                        <label for="email">Email: ${sessionScope.email}</label>
                        <label for="phone-number">Phone number: ${sessionScope.phoneNumber}</label>
                    </div>
                </c:if>
                <div class="form-button-block">
                    <c:if test="${sessionScope.step != 1}">
                        <input type="submit" value="Prev" name="direction" >
                    </c:if>
                    <c:if test="${sessionScope.step == 1}">
                        <input type="submit" value="Prev" name="direction" disabled>
                    </c:if>
                    <c:if test="${sessionScope.step != 3 && sessionScope.step != 4}">
                        <input type="submit" value="Next" name="direction">
                    </c:if>
                    <c:if test="${sessionScope.step == 3}" >
                        <input type="submit" value="Finish" name="direction">
                    </c:if>
                </div>
            </form>
        </div>
    </div>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        .wrapper {
            width: 100%;
            height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            background-color: #1c8ef9;
        }

        .container {
            width: 50%;
            height: 50%;
            margin: auto;
            background-color: white;
            border-radius: 50px;
        }

        .container form {
            height: 100%;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }

        .form-block{
            width: calc(100% - 100px);
            height: 70px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            margin-left: 50px;
        }

        .final {
            height: 150px;
        }

        .form-button-block{
            width: calc(100% - 100px);
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            margin-left: 50px;
        }

    </style>
</body>
</html>