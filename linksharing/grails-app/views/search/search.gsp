<%--
  Created by IntelliJ IDEA.
  User: shipra
  Date: 23/3/15
  Time: 4:33 AM
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
<div class="inbox"  style="float: right;">
    <div class="clearfix">
        <div class="border">
            <div id="na" style="margin-right:40px;">

                <g:form class="navbar-form navbar-right" role="search" id="postForm" name="postForm">
                    <div class="form-group">
                        <g:textField  class="form-control" placeholder="Search" name="resource"/>
                    </div>
                    <input type="button" name="search" class="btn btn-default" value="search" id="postSearch"/>
                </g:form>
            </div>
            <h3>Search for test:</h3>
        </div>
        <div id="listUpdate">
            <g:each in="${resourceList}" var="res">
                <div class="under">
                    <div>
                        <div>
                            <ls:showInbox resources="${res}"></ls:showInbox>
                        </div>
                        <img src="${resource(dir:'images',file:'index.jpeg')}" class="m"/>
                        <div>
                            <g:actionSubmitImage  class="im" value="message" src="${resource(dir:'images',file:'facebook.jpeg')}"/>
                            <g:actionSubmitImage  class="im" value="message" src="${resource(dir:'images',file:'twitter.jpeg')}"/>
                            <g:actionSubmitImage class="im" value="message" src="${resource(dir:'images',file:'google.jpeg')}" />
                        </div>
                    </div>
                </div>
            </g:each>
        </div>
    </div>

</div>
<div class="inbox"  style="float: right;">
    <div class="clearfix">
        <div class="border">
            <div id="n" style="margin-right:40px;">

                <g:form class="navbar-form navbar-right" role="search" id="postForm" name="postForm">
                    <div class="form-group">
                        <g:textField  class="form-control" placeholder="Search" name="resource"/>
                    </div>
                    <input type="button" name="search" class="btn btn-default" value="search" id="postSearch"/>
                </g:form>
            </div>
            <h3>Top Post:</h3>
        </div>

            <g:each in="${resources}" var="res">
                <div class="under">
                    <div>
                        <div>
                            <ls:showInbox resources="${res}"></ls:showInbox>
                        </div>
                        <img src="${resource(dir:'images',file:'index.jpeg')}" class="m"/>
                        <div>
                            <g:actionSubmitImage  class="im" value="message" src="${resource(dir:'images',file:'facebook.jpeg')}"/>
                            <g:actionSubmitImage  class="im" value="message" src="${resource(dir:'images',file:'twitter.jpeg')}"/>
                            <g:actionSubmitImage class="im" value="message" src="${resource(dir:'images',file:'google.jpeg')}" />
                        </div>
                    </div>
                </div>
            </g:each>
        </div>
    </div>


</body>
</html>