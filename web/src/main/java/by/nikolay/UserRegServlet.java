package by.nikolay;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/userReg")
public class UserRegServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newUserEmail = req.getParameter("email");
        char[] newUserPassword = req.getParameter("password").toCharArray();
        String newUserName = req.getParameter("name");
        int newUserAge = Integer.parseInt(req.getParameter("age"));

        if (Validators.isValidEmail(newUserEmail) && Validators.isValidPassword(newUserPassword) &&
                !(UserService.getInstance().getUsersDatabase().getDatabase().containsKey(newUserEmail))) {
            UserEntity newUser = new UserEntity(newUserName, newUserAge, newUserEmail,
                    newUserPassword, new ArrayList<ProductEntity>(), UserEntity.Roles.user);

            UserService.getInstance().getUsersDatabase().addUserToDatabase(newUser);

            UserDbManager.saveDatabase(UserService.getInstance().getUsersDatabase());

            req.setAttribute("email", newUserEmail);

            getServletContext().getRequestDispatcher("/userinform").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/NotAllowedRegistration.html").forward(req, resp);
        }

    }

}
