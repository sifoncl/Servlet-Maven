package by.nikolay;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet("/userChangeData")
public class UserChangeData extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newName = req.getParameter("name");
        String newAge = req.getParameter("age");
        String oldEmail = req.getParameter("oldEmail");
        String newEmail = req.getParameter("email");
        char[] passwordOld = req.getParameter("passwordOld").toCharArray();
        char[] password = req.getParameter("password").toCharArray();


        if (UserService.getInstance().getUsersDatabase().getDatabase().containsKey(oldEmail)) {

            UserEntity oldUserData = UserService.getInstance().getUsersDatabase().getDatabase().get(oldEmail);

            if (Arrays.equals(passwordOld, oldUserData.getPassword())) {

                if (!newName.isBlank()) {
                    oldUserData.setName(newName);
                }
                if (!newAge.isBlank()) {
                    oldUserData.setAge(Integer.parseInt(newAge));
                }
                if (!newEmail.isBlank() &&
                        !(UserService.getInstance().getUsersDatabase().getDatabase().containsKey(newEmail))) {
                    oldUserData.setEmail(newEmail);
                }
                if (!req.getParameter("password").isBlank()) {
                    oldUserData.setPassword(password);
                }

                UserService.getInstance().getUsersDatabase().getDatabase().remove(oldEmail);

                UserService.getInstance().getUsersDatabase().getDatabase().put(oldUserData.getEmail(), oldUserData);

                req.setAttribute("email", oldUserData.getEmail());

                UserDbManager.saveDatabase(UserService.getInstance().getUsersDatabase());

                getServletContext().getRequestDispatcher("/userinform").forward(req, resp);
            } else {
                System.out.println("неверная пара логин пароль " + oldEmail);

                resp.getWriter().write("<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>Title</title>\n" +
                        "    <h3>Не верная пара логин пароль</h3>\n" +
                        "    <form action=\"UserChangeInfo\"\" method=\"get\">\n" +
                        "<input type=\"hidden\" value=" + oldEmail + " name=\"oldEmail\">\n" +
                        "        <input type=\"submit\" value=\"Изменить параметры\">\n" +
                        "    </form>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "\n" +
                        "</body>\n" +
                        "</html>");
            }
        }
    }
}
