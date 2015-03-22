<%--
  Created by IntelliJ IDEA.
  User: shipra
  Date: 6/3/15
  Time: 10:33 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <link href="${resource(dir: 'css',file: 'bootstrap.min.css')}" rel="stylesheet"/>
    <link href="${resource(dir:'css',file:'bootstrap-theme.min.css')}" rel="stylesheet"/>
    <link href="${resource(dir: 'css',file: 'style.css')}" rel="stylesheet"/>

</head>

<body>
<h2>Example of using methods of Modal Plugin</h2>
<g:submitButton class="btn btn-primary btn-lg" id="click" name="Click Me">
    Launch demo modal
</g:submitButton>
<form action="" controller="">
 <div id="dialog" title="Basic dialog" style="display: none;border:none; margin-left:500px">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4>Create Topic</h4>
            </div>
            <div class="modal-body">
                <label>Name:*</label>
                <g:textField name="username" style="margin-left:20px;"/><br/>
                <label>Visibility:*</label>
               <select>
                   <option>Public</option>
                   <option>Private</option>
               </select>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <g:submitButton name="Save" class="btn btn-default"/>
            </div>

            </div>
        </div>
   </div>
  </form>
<g:javascript src="jquery-2.1.3.min.js"></g:javascript>
<g:javascript src="bootstrap.min.js"></g:javascript>
<script>
    $(document).ready(function () {
    $('#click').click(function(){
        $('#dialog').modal('show')
    })
    });
</script>
</body>
</html>