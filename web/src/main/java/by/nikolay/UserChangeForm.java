package by.nikolay;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/UserChangeInfo")
public class UserChangeForm extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getParameterMap().forEach((x, y) -> System.out.println(x + Arrays.toString(y)));
        System.out.println(req.getParameter("oldEmail"));
        String oldEmail = req.getParameter("oldEmail");

        resp.getWriter().write("<!DOCTYPE html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>\n" +
                "    <form action=\"userChangeData\" method=\"get\">\n" +
                "        Email: <input type=\"text\" name=\"email\">\n" +
                "        <br>" +
                "        Пароль старый: <input type=\"text\" name=\"passwordOld\">\n" +
                "        Пароль: <input type=\"text\" name=\"password\">\n" +
                "        <br>" +
                "        Имя: <input type=\"text\" name=\"name\">\n" +
                "        <br>" +
                "        Возраст: <input type=\"text\" name=\"age\">\n" +
                "<input type=\"hidden\" value=" + oldEmail + " name=\"oldEmail\">\n" +
                "        <br>" +
                "        <input type=\"submit\" value=\"Изменить параметры\">\n" +
                "    </form>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
    }
}
