package kz.bitlab.techorda.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kz.bitlab.techorda.db.Users;

import java.io.IOException;

@WebServlet(value = "/userProfile")
public class UserProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users currentUser = (Users) request.getSession().getAttribute("currentUser");
        if(currentUser!=null) {
            request.setAttribute("user", currentUser);
            request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("/userSingIn");
        }

    }
}
