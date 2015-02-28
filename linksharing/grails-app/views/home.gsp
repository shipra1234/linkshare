<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 24/2/15
  Time: 9:06 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title></title>
    <link href="${resource(dir: 'css',file: 'bootstrap.min.css')}" rel="stylesheet"/>
    <link href="${resource(dir: 'css',file: 'style.css')}" rel="stylesheet"/>
    <g:javascript src="bootstrap.min.js"/>
 </head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <h1>Link Sharing</h1>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->

        <form class="navbar-form navbar-right" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
</nav>

<div id="block">
    <div>
        <div style="border:solid 2px">
            <h5>Recent Shares</h5>
        </div>
    <img id="image" src="<g:createLink controller="user" action="viewImage"
                            params="[image:'/home/intelligrape/linkshare/linksharing/upload_image/index.jpeg']"/>"/>
        <g:render template="/user/showdetails"/>
    </div>
   <div style="margin-top:30px;">
       <img id="image" src="<g:createLink controller="user" action="viewImage"
                               params="[image:'/home/intelligrape/linkshare/linksharing/upload_image/index.jpeg']"/>"/>
       <g:render template="/user/showdetails"/>
   </div>

</div>
<div class="right">
<div class="form-group" >
   <g:form controller="user" action="register" method="POST" enctype="multipart/form-data">
       <label>FirstName</label>
       <g:textField name="firstName"/><br/>
       <label>LastName</label>
       <g:textField name="lastName"/><br/>
       <label>Email</label>
       <g:textField name="email"/><br/>
       <label>UserName</label>
       <g:textField name="username"/><br/>
       <label>Password</label>
       <g:passwordField name="password"/><br/>
       <label>Confirm Password</label>
       <g:passwordField name="confirmPassword"/><br/>
       Photo<input type="file"  name="photo" />
       <g:submitButton name="register" value="Register"/>
   </g:form>
    </div>
</div>
<div class="form-group" id="b">

    <g:form action= "login" controller="user">
        <label>UserName</label>
        <g:textField name="username"/><br/>
        <label>Password</label>
        <g:passwordField name="password"/><br/>
        <g:submitButton name="login" value="Login"/>
        <g:link>ForgetPassword</g:link>
        <h4>${flash.message}</h4>

    </g:form>
    </div>

<div id="bl">
    <div>
        <div style="border:solid 2px">
            <h5>Recent Post</h5>
        </div>
        <img  id="image" src="<g:createLink controller="user" action="viewImage"
                                params="[image:'/home/intelligrape/linkshare/linksharing/upload_image/index.jpeg']"/>"/>
        <g:render template="/user/showdetails"/>
    </div>
</div>


</body>
</html>