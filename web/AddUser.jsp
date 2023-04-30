<%--
  Created by IntelliJ IDEA.
  User: Miras
  Date: 29.04.2023
  Time: 15:50
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
<div class="card container shadow-lg w-50 mt-5">
    <div class="card-header px-4">
        Sing up page
    </div>
    <form class="px-4 my-3" action="/addUser" method="post">
        <%
            String error = request.getParameter("errorEmail");
            if(error!=null){
        %>
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            Email is busy!
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
        <%
            }
        %>
        <%
            String passwordError = request.getParameter("errorPassword");
            if(passwordError!=null){
        %>
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            Password are not same!
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
        <%
            }
        %>

        <%
            String success = request.getParameter("success");
            if(success!=null){
        %>
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            User created successfully!
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
        <%
            }
        %>
        <div class="mb-3">
            <label class="form-label">Email address</label>
            <input type="email" class="form-control" name="userEmail">
        </div>
        <div class="mb-3"><label class="form-label">Password</label>
            <input type="password" class="form-control" name="userPassword">
        </div>
        <div class="mb-3"><label class="form-label">Repeat password</label>
            <input type="password" class="form-control" name="userPasswordRepeat">
        </div>
        <div class="mb-3"><label class="form-label">Full name</label>
            <input type="text" class="form-control" name="userFullName">
        </div>
        <button type="submit" class="btn btn-success">SING UP</button>
    </form>
</div>
</body>
</html>
