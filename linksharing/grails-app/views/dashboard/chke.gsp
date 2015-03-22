<%--
  Created by IntelliJ IDEA.
  User: shipra
  Date: 19/3/15
  Time: 1:03 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
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
<g:hasErrors bean="${errors}">
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <g:renderErrors bean="${errors}" as="list"/>
    </div>
</g:hasErrors>
<g:if test="${flash.message}">
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        ${flash.message}
    </div>
</g:if>
<div class="alert alert-warning alert-dismissible" role="alert" id="bl">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h5 id="shipra"></h5>
</div>
<div class="inbox" style="float: right; " >
    <div class="border">
        <div id="n" style="margin-right:40px;">

            <g:form class="navbar-form navbar-right" role="search" id="myForm" name="myForm">
                <div class="form-group">
                    <g:textField  class="form-control" placeholder="Search" name="resource"/>
                </div>
                <input type="button" name="search" class="btn btn-default" value="search" id="s"/>
            </g:form>
        </div>
        <h3>Inbox</h3>
    </div>
    <g:each in="${resources}" var="res">
        <div class="under">
            <div>
                <div id="data" style="float:right">
                    <ls:recentShare resource="${res}"></ls:recentShare>
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


<div id="user">

    <img src="${resource(dir:'images',file:'index.jpeg')}" class="m"/>
    <h7 style="margin-left:100px;"> </h7>
    <div style="margin-left:300px;">
        <label>Subscription</label>
        <label>Topic</label>
    </div>

</div>
<div class="s" style="margin-top:30px;">
    <div class="bo">
        <h3>Subscription</h3>
    </div>
    <div class="under">
        <div>
            <h3 style="float:right;margin-right:350px;"></h3>
            <img src="${resource(dir:'images',file:'index.jpeg')}" class="m"/>
            <h7 style="margin-left:100px;"> </h7>
        </div>

    </div>
    <h3 style="float:right;margin-right:350px;"></h3>
    <img src="${resource(dir:'images',file:'index.jpeg')}" class="m"/>
    <h7 style="margin-left:100px;"> </h7>
</div>
<div style="margin-left:50%; margin-top:80px;">
    <nav>
        <ul class="pagination">
            <li>
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li><g:paginate total="${count}" action="index" controller="dashboard"/></li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
<g:javascript src="jquery-2.1.3.min.js"></g:javascript>
<g:javascript src="bootstrap.min.js"></g:javascript>
<script type="text/javascript">

    jQuery(document).on('click', '#s', function() {
        var url="${createLink(controller:'dashboard',action:'searchResource')}";
        $.ajax({
            url:url,
            data:jQuery("#myForm").serialize(),
            type:'POST',
            success:function(data){
                console.log(data)
                if(data.status==true)
                {
                    $.each(data.resources,function(index,resource){
                        $('#data').html(resource.user.class)
                        $('#data').html(resource.description)

                    })
                }
                else{
                    $("#bl").show();
                    $("#shipra").html(data.mess)

                }

            }
        });
    });
    $(document).ready(function(){
        $("#bl").hide();
    });

</script>

</body>
</html>