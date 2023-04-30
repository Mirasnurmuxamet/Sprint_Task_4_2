<%@ page import="kz.bitlab.techorda.db.Users" %><%--
  Created by IntelliJ IDEA.
  User: Miras
  Date: 30.04.2023
  Time: 7:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="Head.jsp"%>
</head>
<body>
<%@include file="Navbar.jsp"%>
<div class="mt-5">
    <%
        if(currentUser!=null){
    %>
    <div class="text-center my-4 h-50">
        <h1>Welcome <%=currentUser.getFullName()%></h1>
        <p class="text-capitalize text-secondary">This is your profile page</p>
    </div>
    <%
        }
    %>

    <nav class="navbar ">
        <li class="container">
            <div class="row flex-sm-column-reverse  ms-auto mt-0">
                <button  class="btn btn-danger   small mx-0" data-bs-toggle="modal" data-bs-target="#delete">
                    Delete profile
                </button>
            </div>
            <div class="modal fade" id="delete"
                 data-bs-backdrop="static"
                 data-bs-keyboard="false"
                 tabindex="-1"
                 aria-labelledby="staticBackdropLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="/userDelete" method="post">
                            <input type="hidden" name="userId" value="<%=currentUser.getId()%>">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="staticBackdropLabel">Warning</h1>
                                <button type="button"
                                        class="btn-close"
                                        data-bs-dismiss="modal"
                                        aria-label="Close">
                                </button>
                            </div>
                            <h4 class="modal-body">
                                Are you sure?
                            </h4>
                            <div class="modal-footer">
                                <button class="btn btn-danger">YES</button>
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">NO</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </li>
    </nav>
</div>
</body>
</html>
