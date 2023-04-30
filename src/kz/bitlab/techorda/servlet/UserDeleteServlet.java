package kz.bitlab.techorda.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.Users;

import java.io.IOException;

@WebServlet(value = "/userDelete")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Users user = (Users) request.getSession().getAttribute("currentUser");
        if(user!=null){
            int id = Integer.parseInt(request.getParameter("userId"));
            DBConnection.deleteUser(id);
            response.sendRedirect("/userLogout");
        }else {
            response.sendRedirect("/userSingIn");
        }

    }
}
