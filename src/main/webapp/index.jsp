<%--
  Created by IntelliJ IDEA.
  User: asia
  Date: 08/02/18
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Chuck Norris Page</title>
  </head>
  <body>
  <header>
  <img src="/content/images/main.jpg", style="width: 100%"; height="47%" align="center"/>


  </header>
  <div style="float:right; width:20%">
    <%--dyrektywa--%>
    <%@include file="header.jsp"%>
  </div>

  <div style="float:left; width:20%">
    <%--dyrektywa--%>
    <%@include file="menu.jsp"%>
  </div>

  <div style="width: 90%">

  <h2> To get the jokes you have to log in. </h2>
  </div>
  </body>
</html>
