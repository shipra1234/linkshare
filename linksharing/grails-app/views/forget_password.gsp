<%--
  Created by IntelliJ IDEA.
  User: shipra
  Date: 10/3/15
  Time: 4:25 PM
--%>

<%@ page import="linksharing.User" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <%
        String name=session.getAttribute("user")
        User user=User.findByUsername(name)
    %>
    <g:if test="${user.role=="admin"}">
        <meta name="layout" content="dashboard_layout">
    </g:if>
    <g:else >
        <meta name="layout" content="user_layout">

    </g:else>
</head>

<body>
<g:if test="${flash.message}">
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        ${flash.message}
    </div>
</g:if>
<g:form name="forgetPassword" controller="user" action="changePassword" method="Post">
      <label>New Password</label>
      <g:passwordField name="newPassword"/><br/>
      <label>ReType Password</label>
      <g:passwordField name="retypePassword"/><br/>
     <g:hiddenField name="username" value="${params.username}"/>
    <g:submitButton name="change" value="Change"/>

    </g:form>
  <g:hasErrors bean="${errors}" field="password">
      <g:renderErrors bean="${errors}" as="list"/>
</g:hasErrors>


</body>
</html>