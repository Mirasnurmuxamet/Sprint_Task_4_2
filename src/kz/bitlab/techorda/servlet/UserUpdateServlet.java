/*package kz.bitlab.techorda.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.Users;

import java.io.IOException;
import java.sql.PreparedStatement;

@WebServlet(value = "/userUpdate")
public class UserUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Users currentUser = (Users) request.getSession().getAttribute("currentUser");
        if (currentUser != null) {
            int id = Integer.parseInt(request.getParameter("userId"));
            String email = request.getParameter("userEmail");
            String password = request.getParameter("userPassword");
            String repeatPassword = request.getParameter("userPasswordRepeat");
            String fulName = request.getParameter("userFullName");
            Users user = DBConnection.getUser(email);
            if (user == null) {
                if (password.equals(repeatPassword)) {
                    Users updateUser = new Users();
                    updateUser.setId(id);
                    updateUser.setEmail(email);
                    updateUser.setPassword(password);
                    updateUser.setFullName(fulName);
                    DBConnection.updateUser(updateUser);
                    response.sendRedirect("/userProfile?success");
                } else {
                    response.sendRedirect("/userProfile?errorPassword");
                }
            }
            else {
                response.sendRedirect("/userProfile?errorEmail");
            }

        }

    }
}
    public static void updateUser(Users user){
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE users " +
                            "SET " +
                            "email = ? , " +
                            "password = ?, " +
                            "fullName = ?, " +
                            "WHERE id = ?"
            );
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }




<div class="row flex-sm-column-reverse  ms-auto mt-0">
<button  class="btn btn-primary   small mx-0" data-bs-toggle="modal" data-bs-target="#update">
        Update profile
</button>
</div>
<div class="modal fade" id="update"
        data-bs-backdrop="static"
        data-bs-keyboard="false"
        tabindex="-1"
        aria-labelledby="staticBackdropLabel"
        aria-hidden="true">
<div class="modal-dialog">
<div class="modal-content">
<form action="/userUpdate" method="post">
<input type="hidden" name="userId" value="<%=currentUser.getId()%>">
<div class="modal-header">
<h1 class="modal-title fs-5" id="staticBackdropLabel">Update profile</h1>
<button type="button"
class="btn-close"
        data-bs-dismiss="modal"
        aria-label="Close">
</button>
</div>
<div class="modal-body">
<div class="mb-3">
<input type="hidden" name="userId" value="<%=currentUser.getId()%>">
<label class="form-label">Email address</label>
<input type="email"
class="form-control"
        name="userEmail"
        value="<%=currentUser.getEmail()%>">
</div>
<div class="mb-3"><label class="form-label">Password</label>
<input type="password"
class="form-control"
        name="userPassword"
        value="<%=currentUser.getPassword()%>">
</div>
<div class="mb-3"><label class="form-label">Repeat password</label>
<input type="password"
class="form-control"
        name="userPasswordRepeat"
        value="<%=currentUser.getPassword()%>">
</div>
<div class="mb-3"><label class="form-label">Full name</label>
<input type="text"
class="form-control"
        name="userFullName"
        value="<%=currentUser.getFullName()%>">
</div>
</div>
<div class="modal-footer">
<button class="btn btn-danger">SAVE</button>
<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">CLOSE</button>
</div>
</form>
</div>
</div>
</div>
*/