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

@WebServlet(value = "/addUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("AddUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email  = request.getParameter("userEmail");
        String password  = request.getParameter("userPassword");
        String repeatPassword  = request.getParameter("userPasswordRepeat");
        String fulName  = request.getParameter("userFullName");
        Users user = DBConnection.getUser(email);
        if(user==null){
            if(password.equals(repeatPassword)) {
                Users currentUser = new Users();
                currentUser.setEmail(email);
                currentUser.setPassword(password);
                currentUser.setFullName(fulName);
                DBConnection.addUser(currentUser);
                response.sendRedirect("/addUser?success");
            }
            else {
                response.sendRedirect("/addUser?errorPassword");
            }
        }
        else {
            response.sendRedirect("/addUser?errorEmail");
        }
    }
}
