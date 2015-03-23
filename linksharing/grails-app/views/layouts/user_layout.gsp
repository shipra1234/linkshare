<%--
  Created by IntelliJ IDEA.
  User: shipra
  Date: 10/3/15
  Time: 9:06 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <title></title>
    <link href="${resource(dir: 'css',file: 'style.css')}" rel="stylesheet"/>
    <link href="${resource(dir: 'css',file: 'bootstrap.min.css')}" rel="stylesheet"/>
    <g:layoutHead/>
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
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown" id="down">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${username} <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="${createLink(action:'editProfile',controller:'profile')}">Profile</a></li>
                     <li class="divider"></li>
                    <li><a href="${createLink(action:'signUp',controller:'login' )}">Logout</a></li>
                </ul>
            </li>
        </ul>

        <div>
            <img src="${resource(dir:'images',file:'index.jpeg')}" class="message"/>
        </div>
        <div style="margin-right:50px">
            <g:actionSubmitImage class="message" value="message" src="${resource(dir:'images',file:'link.jpeg')}" id="link"/>
            <g:actionSubmitImage class="message" value="message" src="${resource(dir:'images',file:'message.jpeg')}"/>
            <g:actionSubmitImage class="message" value="message" src="${resource(dir:'images',file:'topic.jpeg')}" id="topic"/>
        </div>
        <div id="n">

            <form class="navbar-form navbar-right" role="search" id="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </div>

</nav>

<g:javascript src="jquery-2.1.3.min.js"></g:javascript>
<g:javascript src="bootstrap.min.js"></g:javascript>
<g:layoutBody/>
</body>
</html>