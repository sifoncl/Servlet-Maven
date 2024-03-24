package by.nikolay;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/ProductMenu")
public class AllProductMenu extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userEmail = req.getParameter("email");
        HashMap<String, ProductEntity> prodDb = ProductService.getInstance().getProductDatabase().getDatabase();

        resp.getWriter().write("<!DOCTYPE html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>\n");

        for (Map.Entry<String, ProductEntity> pE : prodDb.entrySet()) {
            System.out.println(pE.getValue().toString());
            resp.getWriter().write(
                    "<h3>Название: " + pE.getValue().getName() + "Цена: " + pE.getValue().getPrice() + " </h3>" +
                            "<a  href=\"addToCart?email=" + userEmail + "&pr=" +
                            pE.getKey() + "\">Добавить в корзину</a>");
        }

        resp.getWriter().write(
                "</div>\n" +
                        "</body>\n" +
                        "</html>");

    }
}
