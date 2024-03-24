package by.nikolay;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/userloger")
public class UserLoger extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        char[] password = req.getParameter("password").toCharArray();

        if (UserService.getInstance().getUsersDatabase().getDatabase().containsKey(email)) {
            if (Arrays.equals(UserService.getInstance().getUsersDatabase().getDatabase().get(email).getPassword(), password)) {
                getServletContext().getRequestDispatcher("/userinform").forward(req, resp);
            } else {
                System.out.println("Юзер не верный пытаюсь редирект");
                resp.sendRedirect(req.getContextPath() + "/UserNotFound.jsp");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/UserNotFound.jsp");
        }
    }
}