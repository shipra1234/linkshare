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
    <link href="${resource(dir:'css',file:'jRating.jquery.css')}" rel="stylesheet" media="screen"/>
</head>

<body>
<div class="alert alert-warning alert-dismissible" role="alert" id="bl">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h5 id="shipra"></h5>
</div>
<div style="float: right">
<div style="border:1px solid;margin-right:40px;width:500px;" >
    <div class="clearfix">
        <div class="bo">
            <h3>Trending Topics</h3>
        </div>
        <div>
        <g:each in="${topicList}" var="topic">
        <div class="under" style="border-right:1px solid">
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
            </div>
            <div style="margin-left:60px;margin-top:20px;">
                <label>Subscription</label>
                <label>Topic</label>

            </div>
            <div style="margin-left:20px;">
                <I style="margin-left:70px;font-size: large"><ls:showSubscription subscription="${subscription}"></ls:showSubscription></I>
                <I style="margin-left: 20px;font-size: large"><ls:showPost post="${post}" subscription="${subscription}"></ls:showPost></I>
            </div>
        </div>
            </g:each>
            </div>
    </div>
</div>
 </div>
    <div class="p">
        <div class="example" style="float: right;margin-top:20px;margin-right:20px;">

        <div class="basic" data-average="20" data-id="1" id="${resource.id}">
            <input type="hidden" value="${resource.id}" id="resourceId">
            <img src="${resource(dir:'images',file:'star.jpeg')}" height="20" width="50"/>
        </div>

    </div>
        <h3 style="float:right;margin-right:150px;">${resource.user.username}</h3>
        <img src="${resource(dir:'images',file:'index.jpeg')}" class="m"/>
        <h7 style="margin-left:100px;"> @ ${resource.user.firstName}</h7>
        <div>
        ${resource.description}
            </div>
    </div>

<g:javascript src="jquery-2.1.3.min.js"></g:javascript>
<g:javascript src="jRating.jquery.min.js"></g:javascript>
<script type="text/javascript">
    $(document).ready(function() {
        $("#bl").hide();
        var url = "${createLink(controller:'resourceRating',action:'rate')}";
        $('.basic').jRating({
            step: true,
            length: 20

        });
        $('.basic').jRating({
            onClick: function (element, rate) {
                var id=$('#resourceId').attr('value');
                $.ajax({
                    url:url,
                    data:{rate:rate,resource:id},
                    success:function(data){
                        if(data.status==true){
                            $("#bl").show();
                            $("#shipra").html(data.message);
                        }

                    }
                })
            }
        });



    });
</script>
</body>
</html>