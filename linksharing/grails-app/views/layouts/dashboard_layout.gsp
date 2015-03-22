<%--
  Created by IntelliJ IDEA.
  User: shipra
  Date: 5/3/15
  Time: 2:18 PM
--%>



<%@ page import="linksharing.Topic; linksharing.User" contentType="text/html;charset=UTF-8" %>
<html>
<head>
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
                <li><a href="#">Profile</a></li>
                <li class="divider"></li>
                <li><a href="${createLink(action:'userList',controller:'user')}">User</a></li>
                <li class="divider"></li>
                <li><a href="${createLink(action:'showTopic',controller:'topic')}">Topic</a></li>
                <li class="divider"></li>
                <li><a href="${createLink(action:'showPost',controller:'post')}">Post</a></li>
                <li class="divider"></li>
                <li><a href="#">Logout</a></li>
            </ul>
        </li>
    </ul>

    <div>
        <img src="${resource(dir:'images',file:'index.jpeg')}" class="message"/>
    </div>
    <div style="margin-right:50px">
        <g:actionSubmitImage class="message" value="message" src="${resource(dir:'images',file:'link.jpeg')}" id="link"/>
        <g:actionSubmitImage class="message" value="message" src="${resource(dir:'images',file:'message.jpeg')}" id="document"/>
        <g:actionSubmitImage class="message" value="message" src="${resource(dir:'images',file:'topic.jpeg')}" id="topic"/>
        <g:actionSubmitImage class="message" value="message" src="${resource(dir:'images',file:'subscribe.jpeg')}" id="subscribe"/>

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
<div id="subscribeTopic" title="Basic dialog" style="display: none;border:none; margin-left:500px">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4>Create Topic</h4>
            </div>
            <g:form action="saveTopic" controller="topic" name="topic" id="topic1">
                <div class="modal-body">
                    <label>Name:*</label>
                    <g:textField name="name" style="margin-left:20px;"/><br/>
                    <label>Visibility:*</label>
                    <g:select name="visibility" from="${Topic.Visibility}" noSelection="['visibility':'selectoption']"/>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <g:submitButton name="Save" class="btn btn-default"/>
                </div>
            </g:form>

        </div>
    </div>
</div>
<div id="dialog" title="Basic dialog" style="display: none;border:none; margin-left:500px;position:fixed" tabindex="-1" >
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4>Create Topic</h4>
                </div>
                <g:form action="saveTopic" controller="topic" name="topic" id="topic1">
                <div class="modal-body">
                    <label>TopicName:*</label>
                    <g:textField name="topicName" style="margin-left:20px;"/><br/>
                    <label>Visibility:*</label>
                    <g:select name="visibility" from="${Topic.Visibility}" noSelection="['visibility':'selectoption']"/>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <g:submitButton name="Save" class="btn btn-default"/>
                </div>
                    </g:form>

            </div>
        </div>
    </div>
<div id="sharedocument" title="Basic dialog" style="display: none;position:fixed;border:none; margin-left:500px">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4>Share Document</h4>
            </div>
            <g:form action="createDocument" controller="resource" enctype="multipart/form-data">
                <div class="modal-body">
                    <label>Title:*</label>
                    <g:textField name="title"/>
                    <label>Document:*</label>
                    <input type="file" name="document"><br/>
                    <label>Description:*</label>
                    <g:textArea name="description" rows="3" cols="8"/><br/>
                    <label>Topic</label>
                    <g:select name="topic" from="${linksharing.Topic.list()}" noSelection="['Select':'select topic']"/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <g:submitButton name="Save" class="btn btn-default"/>
                </div>
            </g:form>

        </div>
    </div>
</div>
<div id="sharelink" title="Basic dialog" style="display: none;position:fixed;border:none; margin-left:500px">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4>Share Link</h4>
            </div>
            <g:form action="createLink" controller="resource">
                <div class="modal-body">
                    <label>Title</label>
                    <g:textField name="title" style="margin-left:20px;"/><br/>
                    <label>Link:*</label>
                    <g:textField name="link" style="margin-left:20px;"/><br/>
                    <label>Description:*</label>
                    <g:textArea name="description" rows="3" cols="8"/><br/>
                    <label>Topic:*</label>
                   <g:select from="${Topic.list()}" name="topic" noSelection="['Select':'SelectanOption']"/>
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
<script>
    $(document).ready(function () {
        $('#topic').click(function(){
            $('#dialog').modal({
                backdrop:false,
                show:true
            })
        });
        $('#document').click(function(){
            $('#sharedocument').modal({
                backdrop:false,
                show:true
            })
        });
        $('#link').click(function(){
            $('#sharelink').modal({
                backdrop:false,
                show:true
            })
        })
        $('#topic1').validate({

            rules:{
              username:{
                  required:true
              }
            },
            messages:{
                username:{
                    required:"Enter user name"
                }
            }
        })
    });
</script>
<g:layoutBody/>
</body>
</html>

