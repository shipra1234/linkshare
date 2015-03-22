<%--
  Created by IntelliJ IDEA.
  User: shipra
  Date: 16/3/15
  Time: 12:51 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <link href="${resource(dir: 'css',file: 'style.css')}" rel="stylesheet"/>
    <link href="${resource(dir: 'css',file: 'bootstrap.min.css')}" rel="stylesheet"/>

</head>

<body>


<nav>
    <ul class="pagination">
        <li>
            <a href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li>
            <div id="showdata" style="width:500px;height: 500px;background-color:#007fff">

            </div>
        </li>
        <li><util:remotePaginate id="pagination" action="show" controller="paginate" total="${count}"  update="listUpdate"/></li>
        <li>
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>

    </ul>
</nav>

</body>
</html>