<%@ taglib prefix="formBlock" uri="blocktag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aleksandr_Dzyachenka
  Date: 5/30/2022
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="residentBean" type="edu.bsu.session.web_07.dao.ResidentDaoBean" scope="session" beanName="residentBean"/>
<jsp:include page="residentsHeader.jsp"/>
<div class="wrapper">
    <div class="container">
        <form action="<c:url value="process.jsp"/>" method="post">
            <formBlock:formBlockTag name="first-name" type="text" valueName="">
                First name
            </formBlock:formBlockTag>
            <formBlock:formBlockTag name="last-name" type="text" valueName="">
                Last name
            </formBlock:formBlockTag>
            <div class="button-block">
                <input type="submit" value="Delete" name="submit">
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

    .button-block {
        width: 100%;
        display: flex;
        flex-direction: row;
        justify-content: center;
    }
    .button-block input {
        background-color: #1c8ef9;
        padding: 5px 5px 5px 5px;
        color: white;
    }
</style>
</body>
</html>
