package by.nikolay;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/userinform")
public class UserInfo extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        UserEntity user = UserService.getInstance().getUsersDatabase().getUserByEmail(email).get();

        resp.getWriter().write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>JSP Application</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>Email: " + user.getEmail() + "</p>\n" +
                "<p>Имя: " + user.getName() + "</p>\n" +
                "<p>Возраст:  " + user.getAge() + "</p>\n" +
                "<p>Роль: " + user.getRole().toString() + "</p>\n" +

                " <name=\"emailOLd\" value=" + user.getEmail() + " />" +
                "<a  href=\"UserChangeInfo?oldEmail=" + user.getEmail() + "\">Изменить данные</a>" +

                "</body>\n" +
                "</html>");
    }
}
