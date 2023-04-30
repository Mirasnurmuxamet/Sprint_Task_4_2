package kz.bitlab.techorda.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.Users;

import java.io.IOException;

@WebServlet(value = "/userSingIn")
public class UserSingInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("UserSingIn.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email  = request.getParameter("userEmail");
        String password  = request.getParameter("userPassword");
        Users user = DBConnection.getUser(email);
        if(user!=null && password.equals(user.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user);
            response.sendRedirect("/userProfile");
        }
        else {
            response.sendRedirect("/userSingIn?error");
        }
    }
}
