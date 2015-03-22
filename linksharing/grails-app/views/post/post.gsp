<%--
  Created by IntelliJ IDEA.
  User: shipra
  Date: 15/3/15
  Time: 11:38 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="topic_layout">
</head>

<body>
<div id="data">
    <div class="inbox" style="float: right;">
        <div class="border">
            <h3>Trending Topics:<I id="post"></I></h3>

        </div>
        <div class="under">
            <img src="${resource(dir:'images',file:'index.jpeg')}" class="m"/>
            <div id="resource1">
            </div>
        </div>
        <img src="${resource(dir:'images',file:'index.jpeg')}" class="m"/>
        <div>

        </div>
    </div>
    <div class="p">
        <h3 style="float:right;margin-right:280px;">${username}</h3>
        <img src="${resource(dir:'images',file:'index.jpeg')}" class="m"/>
        <h7 style="margin-left:100px;"> @ ${firstName}</h7>
        <div>
        ${resource}
            </div>
    </div>

</div>

</body>
</html>