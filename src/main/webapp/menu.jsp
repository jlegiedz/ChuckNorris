<%@ page import="javaModel.MenuElements" %><%--
  Created by IntelliJ IDEA.
  User: asia
  Date: 19/02/18
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<ul>

    <c:set var="enumValue" value="<%=MenuElements.values()%>"/>

    <c:forEach items="${enumValue}" var="value">
        <a href="${value.getUrl()}"> <li> ${value.getElementName()}</li></a>
    </c:forEach>

</ul>




</body>
</html>
