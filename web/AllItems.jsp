<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.techorda.db.Items" %><%--
  Created by IntelliJ IDEA.
  User: Miras
  Date: 26.04.2023
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AllItems</title>
    <%@include file="Head.jsp"%>
</head>
<body>
<%@include file="Navbar.jsp"%>
<%
    ArrayList<Items> items =  (ArrayList<Items>) request.getAttribute("allItems");
%>
<div class="mx-5 mb-5">
    <div class="text-center my-4">
        <h1>Welcome to  BITLAB SHOP</h1>
        <p class="text-capitalize text-secondary">Electronic devices with high quality and  service</p>
    </div>
    <div>
        <div class="row row-cols-1 row-cols-md-3 g-4">
            <%
                if(items!=null){
                    for(Items i : items){
            %>
            <div class="col">
                <div class="card text-center shadow-lg h-100">
                    <h4 class="card-header">
                        <%=i.getName()%>
                    </h4>
                    <div class="card-body">
                        <h4 class="card-title text-success">$<%=i.getPrice()%></h4>
                        <p class="card-text h-25" ><%=i.getDescription()%></p>
                        <a href="#" class="btn btn-success btn-group-lg mt-3">BY NOW</a>
                    </div>
                </div>
            </div>
            <%
                    }
                }
            %>
        </div>
    </div>
</div>
</body>
</html>
