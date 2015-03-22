<%--
  Created by IntelliJ IDEA.
  User: shipra
  Date: 9/3/15
  Time: 2:17 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="dashboard_layout">
    <title></title>
    <link href="${resource(dir: 'css',file: 'bootstrap.min.css')}" rel="stylesheet"/>
</head>

<body>
  <div>
      <div style="border: solid 2px;height:50px" >
          <div style="float:right">
          <select>
              <option>Users</option>
              <option>AllUsers</option>
          </select>
          </div>
          <div style="float:right;margin-right:20px;">

              <form class="navbar-form navbar-right" role="search" id="search">
                  <div class="form-group">
                      <input type="text" class="form-control" placeholder="Search">

                  <button type="submit" class="btn btn-default">Submit</button>
                  </div>
              </form>
          </div>
          <h4>Users</h4>


      </div>
      <table border="solid 2px" align="center" class="table">
          <th>
          <td>Username</td>
          <td>Email</td>
          <td>FirstName</td>
          <td>LastName</td>
          <td>Active</td>
          <td>Manage</td>
          </th>
          <g:each in="${users}" var="p">
              <tr>
                  <td>${p.id}</td>
                  <td>${p.username}</td>
                  <td>${p.email}</td>
                  <td>${p.firstName}</td>
                  <td>${p.lastName}</td>
                  <td>${p.active}</td>
                  <td><select>
                      <option>Activate</option>
                      <option>Deactivate</option>
                  </select></td>

              </tr>
          </g:each>

      </table>
      </div>
</body>
</html>