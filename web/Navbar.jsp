<%@page import="kz.bitlab.techorda.db.Users" %>
<%
    Users currentUser = (Users) session.getAttribute("currentUser");
%>
<div>
  <nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid mt-2">
      <b class="navbar-brand mx-3 ">BITLAB SHOP</b>
      <div class="collapse navbar-collapse mx-5 ">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Top Sales</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">By Category</a>
          </li>
            <%
                if(currentUser!=null){
            %>
            <li class="nav-item">
                <a class="nav-link" href="/userProfile"><%=currentUser.getFullName()%></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/userLogout">Logout</a>
            </li>

            <%
                }
                else {
            %>
          <li class="nav-item">
            <a class="nav-link" href="/addUser">Register</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/userSingIn">Sing in</a>
          </li>
            <%
                }
            %>
        </ul>
      </div>
    </div>
  </nav>
  <hr>
</div>