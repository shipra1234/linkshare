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
<g:if test="${flash.message}">
<div class="alert alert-warning alert-dismissible" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    ${flash.message}
</div>
    </g:if>
<div style="float:right;">
<div class="inbox">
    <div class="clearfix">
        <div class="border">
            <h3>Recent Share</h3>
        </div>
            <g:each in="${resources}" var="res">
                <div class="under" style="height:120px;" >
                    <div style="float:right">
                        <h4>  <a href="${createLink(action:'renderTopic',controller:'topic',
                                params:[topic:"${res.topic.id}"])}">${res.topic.name}</a></h4>

                    </div>
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
    <div class="inbox" style="float:right;margin-top:30px;">
        <div class="clearfix">
            <div style="border:solid 2px">
                <h5>Recent Post</h5>
            </div>
            <g:each in="${resourceList}" var="list">
                <div class="under" style="height:120px;" >
                    <div style="float:right">
                        <h4>  <a href="${createLink(action:'renderTopic',controller:'topic',
                                params:[topic:"${list.topic.id}"])}">${list.topic.name}</a></h4>

                    </div>
                    <div>
                        <div>
                            <ls:showInbox resources="${list}"></ls:showInbox>
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
<div class="right">
<div class="form-group" >
   <g:form controller="login" action="register" method="POST" enctype="multipart/form-data" id="form" name="form">
       <label>FirstName*</label>
       <input name="firstName" id="firstName" value="" type="text" style="margin-left:80px;"><br>
       <label>LastName*</label>
       <input name="lastName" value="" id="lastName" type="text" style="margin-left:80px;"><br>
       <label>Email*</label>
       <input name="email" value="" id="email" type="text"style="margin-left:110px;"><br>
       <label>UserName*</label>
       <input name="username" value="" id="username" type="text" style="margin-left:80px;"><br>
       <label>Password*</label>
       <input name="password" value="" id="password" type="password" style="margin-left:80px;"><br>
       <label>Confirm Password*</label>
       <input name="confirmPassword" value="" id="confirmPassword" type="password" style="margin-left:20px"><br>
       Photo<input name="photo" type="file">
       <input name="register" value="Register" id="register" type="submit">
   </g:form>
    </div>
</div>
<div class="form-group" id="b">

    <g:form action= "login" controller="login">
        <label>UserName*</label>
        <g:textField name="username" /><br/>
        <label>Password*</label>
        <g:passwordField name="password"/><br/>
        <g:submitButton name="login" value="Login"/>
        <input type="button" name="forget" value="ForgetPassword" id="forget"/>
    </g:form>
    </div>
<div id="dialog" title="Basic dialog" style="display: none;border:none;margin-left:100px;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4>Forget Password</h4>
            </div>
            <g:form action="forgetPassword" controller="user" method="post">
                <div class="modal-body">
                    <label>UserName:*</label>
                    <g:textField name="username" style="margin-left:20px;"/><br/>
                    <label>Remember Password</label>
                    <g:textField name="password"/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <g:submitButton name="Save" class="btn btn-default"/>
                </div>
            </g:form>

        </div>
    </div>
</div>


<g:javascript src="jquery-2.1.3.min.js"></g:javascript>
<g:javascript src="bootstrap.min.js"></g:javascript>
<g:javascript src="jquery.validate.min.js"></g:javascript>


<script type="text/javascript">
    $('document').ready(function(){
        $('#form').validate({
            rules:{
                firstName:{
                    required:true
                },
                lastName:{
                    required:true
                },
                email:{
                    required:true,
                    email:true
                },
                username:{
                    required:true
                },
                password:{
                  required:true,
                    minlength:6,
                    maxlength:10
                },
                confirmPassword:{
                    required:true,
                    minlength:6,
                    maxlength:10
                }
            },
            messages:{
                firstName:{
                    required:"Please enter your firstName"
                },
                lastName:{
                    required:"Please enter lastName"
                },
                email:{
                    required:"email field is empty"
                },
                username:{
                    required:"please enter username"
                },
                password:{
                    required:"enter password"

                },
                confirmPassword:{
                    required:"enter confirmPassword"
                }
            }
        })
        $('#forget').click(function(){
            $('#dialog').modal('show')
        });
    });
</script>
</body>
</html>