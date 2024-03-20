package by.nikolay;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.xml.validation.Validator;
import java.io.IOException;

@WebServlet("/userinfo")
public class UserServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String email = req.getParameter("email");
       char[] password = req.getParameter("password").toCharArray();

       if(Validators.isValidEmail(email)&&Validators.isValidPassword(password)){


           req.setAttribute("email", email);
           req.setAttribute("password", password);

           getServletContext().getRequestDispatcher("/UserInfo.jsp").forward(req, resp);

       }



    }
}