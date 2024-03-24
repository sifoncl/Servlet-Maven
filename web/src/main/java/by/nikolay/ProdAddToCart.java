package by.nikolay;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addToCart")
public class ProdAddToCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userEmail = req.getParameter("email");
        System.out.println("Ищу " + userEmail);
        UserEntity user = UserService.getInstance().getUsersDatabase().getDatabase()
                .get(userEmail);

        String productName = req.getParameter("pr");

        ProductEntity product = ProductService.getInstance().getProductDatabase()
                .getDatabase().get(req.getParameter("pr"));

        user.addToCart(product);

        UserService.getInstance().getUsersDatabase().getDatabase().remove(userEmail);
        UserService.getInstance().getUsersDatabase().getDatabase().put(user.getEmail(), user);
        UserDbManager.saveDatabase(UserService.getInstance().getUsersDatabase());
    }
}
