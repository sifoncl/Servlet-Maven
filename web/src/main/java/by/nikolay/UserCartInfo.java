package by.nikolay;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/cartInfo")
public class UserCartInfo extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userEmail = req.getParameter("email");
        ArrayList<ProductEntity> userCart = UserService.getInstance().getUserByEmail(userEmail).get().getCart();
        int totalPrice = 0;

        resp.getWriter().write("<!DOCTYPE html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>\n");

        for (ProductEntity pE : userCart) {
            resp.getWriter().write(
                    "<h3>Название: " + pE.getName() + ". Цена: " + pE.getPrice() + " </h3>" +
                            "<br>");
            totalPrice += pE.getPrice();
        }


        resp.getWriter().write(
                "<h3>Итоговая цена: " + totalPrice + " </h3>" +
                        "</div>\n" +
                        "</body>\n" +
                        "</html>");
    }
}
