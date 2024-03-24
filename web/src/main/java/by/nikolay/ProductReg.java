package by.nikolay;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/ProductReg")
public class ProductReg extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int pricre = Integer.parseInt(req.getParameter("price"));

        if (ProductService.getInstance().getProductDatabase().getDatabase().containsKey(name)) {
            resp.getWriter().write("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "    <h3>Товар с таким именем уже есть в базе</h3>\n" +
                    "    <a href=\"newProductRegistration.html\">Попробовать еще раз</a>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>");
        } else {
            ProductService.getInstance().getProductDatabase().getDatabase().put(name, new ProductEntity(name, pricre));
            ProductDbManager.saveDatabase(ProductService.getInstance().getProductDatabase());
        }
    }
}
