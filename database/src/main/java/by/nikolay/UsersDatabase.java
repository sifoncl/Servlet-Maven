package by.nikolay;

import java.util.HashMap;
import java.util.Optional;

public class UsersDatabase {

    static final String DEFAULTP_PATH = "G:/Tom_Cat/UsersDatabase.json";

    private HashMap<String, UserEntity> database = new HashMap<>();

    private String path = DEFAULTP_PATH;

    public String getPath() {
        return path;
    }

    public void setPath(String paths) {
        this.path = paths;
    }

    public UsersDatabase() {
    }

    public void addUserToDatabase(UserEntity user) throws RuntimeException {
        if (this.database.containsKey(user.getEmail())) {
            throw new RuntimeException("user allready exist");
        } else {
            this.database.put(user.getEmail(), user);
        }
    }

    public HashMap<String, UserEntity> getDatabase() {
        return database;
    }

    public Optional<UserEntity> getUserByEmail(String email) {
        return Optional.ofNullable(this.database.get(email));
    }

}
