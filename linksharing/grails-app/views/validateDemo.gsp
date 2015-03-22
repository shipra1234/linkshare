<%--
  Created by IntelliJ IDEA.
  User: shipra
  Date: 7/3/15
  Time: 10:45 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <link href="${resource(dir: 'css',file: 'style.css')}" rel="stylesheet"/>
    <link href="${resource(dir: 'css',file: 'bootstrap.min.css')}" rel="stylesheet"/>
</head>

<body>
<g:form name="myForm" id="myForm">
    <label>UserName</label>
    <g:textField name="name" id="name"/><br/>
    <label>Age</label>
    <g:textField name="age" id="age"/><br/>
    <label>ContactNo</label>
    <g:textField name="contact" id="contact"/><br/>
    <g:submitButton name="save" value="Save"/>
</g:form>
<g:javascript src="jquery-2.1.3.min.js"/>
<g:javascript src="bootstrap.min.js"/>
<g:javascript src="jquery.validate.min.js"/>
<script type="text/javascript">
    $(document).ready(function(){
        $('#myForm').validate({
            rules:{
                name:{
                    required:true
                },
                age: {
                    required: true
                },
                contact:{
                    required:true,
                    minlength:10,
                    maxlength:10,
                    number:true
                }
            },
            messages: {
                name: {
                    required: "please enter name"
                },
                age: {
                    required: "enter age"
                },
                contact: {
                    required: "enter mobile no",
                    number: "please enter only digits"
                }
            }


        });

    });

</script>

</body>
</html>