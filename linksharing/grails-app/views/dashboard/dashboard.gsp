<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 25/2/15
  Time: 6:39 PM
--%>

<%@ page import="linksharing.User" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
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
<div class="inbox"  style="float: right;">
    <div class="clearfix">
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
                <div style="margin-left:300px;margin-top:20px;">
                   <I> <ls:marked resource="${res}"></ls:marked></I>
                    <I style="margin-left:100px;">
                    <ls:document resource="${res}"></ls:document>
                    </I>
                    </div>
        </div>
        </div>
    </g:each>
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
<div style="float:right; margin-top:700px;" id="filterList">
    <div class="clearfix">
        <nav>
            <ul class="pagination">

                <util:remotePaginate id="pagination" action="resourcePaginate" controller="dashboard" total="${count}"  update="listUpdate"/>

            </ul>
        </nav>
    </div>
</div>

<div class="s" style="margin-top:60px;">
    <div class="clearfix">
    <div class="bo">
        <h3>Subscription</h3>
    </div>

    <g:each in="${topics}" var="t">
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
                            <g:textField name="topic" id="invitetopic" value="${t.name}"></g:textField>

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
                        params:[topic:"${t.id}"])}">${t.name}</a></h4>

            </div>
            <div style="float:right;margin-right:250px;">
                <h5>${t.user.username}</h5>
                <h5>@ ${t.user.firstName }</h5>
            </div>
            <div>
                <img src="${resource(dir:'images',file:'index.jpeg')}" class="m"/>
            </div>
                <div style="margin-left:200px;float:left">
                    <ls:isEditable resources="${resources}" topic="${t.name}" visibility="${t.visibility}"></ls:isEditable>
                    </div>
                    <div style="float: right">
                        <g:form name="formData" id="formData">
                                <g:select from="${linksharing.Subscription.Seriousness.values()}"
                                          name="seriousness" id="edit"/>

                                <g:hiddenField name="topic" value="${t.name}"></g:hiddenField>

                            </g:form>
                        </div>
                        <div>
                        <g:actionSubmitImage class="im" value="message" id="msg" src="${resource(dir:'images',file:'msg.jpeg')}" />
                        </div>


        </div>

        </g:each>
</div>
    </div>
<script type="text/javascript">
    $(document).ready(function(){
        $("#bl").hide();
        $('.showBlock').hide();
        $('#msg').click(function(){
            $('.invitation').modal({
                backdrop:false,
                show:true

            })
        });
    });
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
    jQuery(document).on('change','#editVisible',function(){
        var url="${createLink(controller:'dashboard',action:'editVisibility')}";
        $.ajax({
            url:url,
            data:jQuery("#formvisibility").serialize(),
            type:'POST',
            success:function(data){
                $("#bl").show();
                $("#shipra").html(data.mess)
            }
        })
    });

</script>
</body>
</html>