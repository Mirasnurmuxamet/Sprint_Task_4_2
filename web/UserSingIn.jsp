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
        Login Page
    </div>
    <%
        String error = request.getParameter("error");
        if(error!=null){
    %>
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        Incorrect email or password!
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <%
        }
    %>
    <form class="px-4 my-3" action="/userSingIn" method="post">
        <div class="mb-3">
            <label class="form-label">Email address</label>
            <input type="email" class="form-control" name="userEmail">
        </div>
        <div class="mb-3"><label class="form-label">Password</label>
            <input type="password" class="form-control" name="userPassword">
        </div>
        <button type="submit" class="btn btn-success">SING IN</button>
    </form>
</div>
</body>
</html>
