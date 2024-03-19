package by.nikolay;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProductDbManager {

    public static ProductDatabase loadDatabase(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] jsonData = Files.readAllBytes(Path.of(path));
        ProductDatabase database = new ProductDatabase();
        database.setPath(path);
        database = objectMapper.readValue(jsonData, ProductDatabase.class);
        return database;
    }

    public static void saveDatabase(ProductDatabase database) throws IOException {
        File file = new File(database.getPath());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(file, database);
    }


}
