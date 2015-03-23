<%--
  Created by IntelliJ IDEA.
  User: shipra
  Date: 13/3/15
  Time: 12:13 PM
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
    <div class="alert alert-warning alert-dismissible" role="alert" id="bl">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h5 id="shipra"></h5>
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
            <h3>POST:${topic.name}</h3>
        </div>
        <div id="listUpdate">
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
                        <div style="margin-left:400px;margin-top:20px;">
                        </div>
                    </div>
                </div>
            </g:each>
        </div>
    </div>

</div>
<div class="s" style="height:210px;border-bottom:none;margin-left:40px;" >
    <div class="clearfix">
        <div class="bo">
            <h3>Topics:${topic.name}</h3>
        </div>
            <div class="invitation" title="Basic dialog" style="display: none;border:none; margin-left:500px;position:fixed" tabindex="-1" >
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4>Send Invitation</h4>
                        </div>
                        <g:form action="sendInvitation" controller="dashboard" name="topic" id="topic1">
                            <div class="modal-body">
                                <label>Email:*</label>
                                <g:textField name="email" style="margin-left:20px;"/><br/>
                                <label>Topic:*</label>
                                <g:textField name="topic" id="invitetopic" value="${topic.name}"></g:textField>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <g:submitButton name="Invite" class="btn btn-default"/>
                            </div>
                        </g:form>

                    </div>
                </div>
            </div>
            <div class="under">
                <div style="float:right">
                    <h4>  <a href="${createLink(action:'renderTopic',controller:'topic',
                            params:[topic:"${topic.id}"])}">${topic.name}</a></h4>
                        <h5>(${topic.visibility})</h5>

                </div>
                <div style="float:right;margin-right:250px;">
                    <h5>${topic.user.username}</h5>
                    <h5>@ ${topic.user.firstName }</h5>
                </div>
                <div>
                    <img src="${resource(dir:'images',file:'index.jpeg')}" class="m"/>
                </div>
                <div style="float: right">
                    <g:form name="formData" id="formData">
                        <g:select from="${linksharing.Subscription.Seriousness.values()}"
                                  name="seriousness" id="edit"/>

                        <g:hiddenField name="topic" value="${topic.name}"></g:hiddenField>

                    </g:form>
                </div>
                <div>
                    <g:actionSubmitImage class="im" value="message" id="msg" src="${resource(dir:'images',file:'msg.jpeg')}" />
                </div>

                <div>
                    <ls:subscribe topic="${topic}"></ls:subscribe>
                    </div>
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
</div>
<div style="float:right; margin-top:700px;" id="filterList">
    <div class="clearfix">
        <nav>
            <ul class="pagination">

                <util:remotePaginate id="pagination" action="topicPaginate" controller="topic"
                                     total="${count}"  update="listUpdate" params="[topic:topic.id]"/>

            </ul>
        </nav>
    </div>
</div>

<div class="clearfix">
    <div class="border" style="width:500px;margin-left:40px;margin-top:20px;">
        <h3>User:${topic.name}</h3>
    </div>
    <div>
<g:each in="${resources}" var="res">
<div id="user">
    <div style="float:right;margin-right:100px;">
            <h4 style="margin-right:150px;">${res.user.username}</h4>
            <h4>@${res.user.firstName}</h4>
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
    </g:each>
        </div>
</div>


<script type="text/javascript">
    $(document).ready(function(){
        $("#bl").hide();
        $('#msg').click(function(){
            $('.invitation').modal({
                backdrop:false,
                show:true

            })
        });
    });
    jQuery(document).on('change','#edit',function(){
        var url="${createLink(controller:'dashboard',action:'editData')}";
        $.ajax({
            url:url,
            data:jQuery("#formData").serialize(),
            type:'POST',
            success:function(data){
                $("#bl").show();
                $("#shipra").html(data.mess)
                $('#edit').val(data.seriousness1)
            }
        })
    });
    jQuery(document).on('click', '#postSearch', function() {
        var url="${createLink(controller:'topic',action:'searchTopic')}";
        $.ajax({
            url:url,
            data:jQuery("#postForm").serialize(),
            type:'POST',
            success:function(data){
                console.log(data)
                if(data.status==true)
                {
                    $('#listUpdate').html(data.updatedResourcesHtml)
                }
                else{

                    $("#bl").show();
                    $("#shipra").html(data.mess)
                    $('#serious').html(data.seriousness1)

                }

            }
        });
    });

</script>
</body>
</html>