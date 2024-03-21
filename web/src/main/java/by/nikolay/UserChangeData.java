package by.nikolay;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/userChangeData")
public class UserChangeData extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newName = req.getParameter("name");

        String newAge = req.getParameter("age");

        String oldEmail = req.getParameter("emailOLd");

        String newEmail = req.getParameter("email");

        char[] passwordOld = req.getParameter("passwordOld").toCharArray();

        char[] password = req.getParameter("password").toCharArray();


        req.getParameterMap().forEach((x, y)->System.out.println(x+ Arrays.toString(y)));


    }
}
