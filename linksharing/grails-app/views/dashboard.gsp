<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 25/2/15
  Time: 6:39 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
  <g:if test="${session.getAttribute("user")}">
      Welcome ${session.user}
  </g:if>

</body>
</html>