<%--
  Created by IntelliJ IDEA.
  User: Aleksandr_Dzyachenka
  Date: 5/29/2022
  Time: 11:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="wrapper">
    <div class="container">
        <h2>Error!</h2>
        <p>Problem is: <%= exception%></p>
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
        display: flex;
        flex-direction: column;
        justify-content: center;
        background-color: white;
        border-radius: 50px;
    }
</style>
</body>
</html>
