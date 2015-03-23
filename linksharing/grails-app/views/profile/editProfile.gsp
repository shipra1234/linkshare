<%--
  Created by IntelliJ IDEA.
  User: shipra
  Date: 22/3/15
  Time: 7:27 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="topic_layout">
</head>

<body>
<g:if test="${flash.message}">
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        ${flash.message}
    </div>
</g:if>
<div style="float: right">
<div class="inbox">
    <div class="clearfix">
        <div class="border">
            <h3>Edit profile</h3>
        </div>
        <div class="under" style="height:200px;">
            <div class="form-group" style="margin-left:100px;margin-top:40px;">
                <g:form controller="profile" action="updateProfile" method="POST" enctype="multipart/form-data" id="form" name="form">
                    <label>FirstName*</label>
                    <input name="firstName" id="firstName" value="${user.firstName}" type="text" style="margin-left:80px;"/><br/>
                    <label>LastName*</label>
                    <input name="lastName"  id="lastName" value="${user.lastName}" type="text" style="margin-left:80px;"/><br/>
                    <label>UserName*</label>
                    <input name="username"  id="username" value="${user.username}" type="text" style="margin-left:80px;"/><br/>
                    Photo<input name="photo" type="file">
                    <input type="hidden" name="userId" value="${user.id}">
                    <g:submitButton name="update" value="Update" id="update"  style="margin-left:150px;margin-top:30px;"/>
                </g:form>
            </div>
        </div>
    </div>
    </div>
    <div class="inbox" style="margin-top:30px">
    <div class="clearfix">
        <div class="border">
            <h3>Change Password</h3>
        </div>
        <div class="under" style="height:150px;">
            <div class="form-group" style="margin-left:100px;margin-top:40px;">
                <g:form controller="profile" action="changePassword" method="POST" id="form1" name="form1">
                    <label>Password*</label>
                    <input name="password" id="password"  type="password" style="margin-left:80px;"/><br/>
                    <label>Confirm Password*</label>
                    <input name="confirmPassword"  id="confirmPassword"  type="password" style="margin-left:20px;"/><br/>
                    <input type="hidden" name="userId" value="${user.id}">
                    <g:submitButton name="update" value="Update" id="update"  style="margin-left:150px;margin-top:30px;"/>
                </g:form>
            </div>
        </div>
    </div>
</div>



</div>
<div id="user">
    <div class="clearfix">
        <div style="float:right;margin-right:100px;">
            <h4 style="margin-right:150px;">${user.username}</h4>
            <h4>@${user.firstName}</h4>
        </div>
        <img src="${resource(dir:'images',file:'index.jpeg')}" class="m"/>

        <div style="margin-left:300px;">
            <label>Subscription</label>
            <label>Topic</label>
            <div>
                <I style="margin-left:70px;font-size: large"><ls:showSubscription subscription="${subscription}"></ls:showSubscription></I>
                <I style="margin-left: 20px;font-size: large"><ls:showPost post="${post}" subscription="${subscription}"></ls:showPost></I>
            </div>
        </div>
    </div>
</div>
</body>
</html>