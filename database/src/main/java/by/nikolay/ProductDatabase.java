package by.nikolay;

import java.util.HashMap;
import java.util.Optional;

public class ProductDatabase {

    static final String DEFAULT_PATH = "src/main/resources/ProductDatabase.json";

    private HashMap<Integer, ProductEntity> database;

    private String path = DEFAULT_PATH;

    public ProductDatabase() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String paths) {
        this.path = paths;
    }

    public void addProductToDatabase(ProductEntity product) {
        this.database.put(product.getId(), product);
    }

    public Optional<ProductEntity> getProductById(int id) {
        return Optional.ofNullable(this.database.get(id));
    }
}
