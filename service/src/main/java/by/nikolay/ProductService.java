package by.nikolay;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

public class ProductService {


    private static ProductService instance;


    private ProductDatabase productDatabase = initProductDatabase(ProductDatabase.DEFAULT_PATH);


    public Optional<ProductDao> getProductByName(String name) {
        return productDatabase.getProductByName(name).map(x -> new ProductDao(x.getName(), x.getPrice()));
    }


    private ProductService() {
    }

    public static synchronized ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    private static ProductDatabase initProductDatabase(String path) {

        ProductDatabase productDatabase = new ProductDatabase();
        try {
            productDatabase = ProductDbManager.loadDatabase(path);
        } catch (IOException e) {
            try {
                ProductDbManager.saveDatabase(productDatabase);
            } catch (IOException b) {
                System.out.println(LocalTime.now().toString() + " Не удалось сохранить бд продуктов");
            }
        }
        return productDatabase;
    }

    public ProductDatabase getProductDatabase() {
        return productDatabase;
    }
}
