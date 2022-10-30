<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aleksandr_Dzyachenka
  Date: 5/30/2022
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <header class="custom-header">
      <div class="menu-item">
          <a href="<c:url value="residents.jsp"/> ">Home</a>
      </div>
      <div class="menu-item">
          <a href="<c:url value="addResident.jsp"/>">Add resident</a>
      </div>
      <div class="menu-item">
          <a href="<c:url value="delete.jsp"/>">Delete resident</a>
      </div>
  </header>
  <style>
      .custom-header {
          width: 100%;
          height: 50px;
          display: flex;
          flex-direction: row;
          justify-content: space-around;
          background-color: white;
          border-bottom: 1px solid #dddddd;
      }

      .menu-item {
          display: flex;
          flex-direction: column;
          justify-content: center;
          background-color: #f2f2f2;
          margin: 10px 30px 10px 30px;
          padding: 5px 5px 5px 5px;
      }
      .menu-item a {
          text-decoration: none;
          color: black;
      }
  </style>
</body>
</html>
