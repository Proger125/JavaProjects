<%@ page import="edu.bsu.session.web_07.dto.ResidentDto" %>
<%@ page import="edu.bsu.session.web_07.ResidentsServlet" %>
<%@ page import="java.util.Objects" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aleksandr_Dzyachenka
  Date: 5/30/2022
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="residentBean" type="edu.bsu.session.web_07.dao.ResidentDaoBean" scope="session"/>
    <c:if test="<%=Objects.equals(request.getParameter(ResidentsServlet.SUBMIT), ResidentsServlet.ADD)%>">
        <jsp:setProperty name="residentBean" property="residentDto" value="<%=new ResidentDto(request.getParameter(ResidentDto.FIRST_NAME), request.getParameter(ResidentDto.LAST_NAME), request.getParameter(ResidentDto.CITY), request.getParameter(ResidentDto.STREET), Integer.parseInt(request.getParameter(ResidentDto.HOUSE_NUMBER)))%>"/>
    </c:if>
    <c:if test="<%=Objects.equals(request.getParameter(ResidentsServlet.SUBMIT), ResidentsServlet.DELETE)%>">
        <jsp:setProperty name="residentBean" property="residentDto" value="<%=new ResidentDto(request.getParameter(ResidentDto.FIRST_NAME), request.getParameter(ResidentDto.LAST_NAME))%>"/>
    </c:if>
<jsp:forward page="residents.jsp" />
</body>
</html>
