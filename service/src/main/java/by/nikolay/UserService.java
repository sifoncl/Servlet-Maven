package by.nikolay;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Optional;

public class UserService {

    private static UserService instance;

    private UsersDatabase usersDatabase = initUserDatabase(UsersDatabase.DEFAULTP_PATH);



    public Optional<UserDao> getUserByEmail(String userEmail) {
        return usersDatabase.getUserByEmail(userEmail).map(x -> new UserDao(
                x.getName(),
                x.getAge(),
                x.getEmail(),
                x.getPassword(),
                x.getCart(),
                x.getRole()
        ));
    }

    private UserService() {
    }

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }


    private static UsersDatabase initUserDatabase(String path) {
        UsersDatabase usersDatabase = new UsersDatabase();
        try {
            usersDatabase = UserDbManager.loadDatabase(path);
        } catch (IOException e) {
            try {
                UserDbManager.saveDatabase(usersDatabase);
            } catch (IOException b) {
                System.out.println(LocalTime.now().toString() + " Не удалось сохранить бд юзеров");
            }
        }
        return usersDatabase;
    }



}
