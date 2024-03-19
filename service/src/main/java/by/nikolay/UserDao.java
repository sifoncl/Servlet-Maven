package by.nikolay;

import java.util.ArrayList;

public class UserDao {


    String name;
    int age;

    String email;

    char[] password;

    ArrayList<ProductEntity> cart;

    UserEntity.Roles role;

    public UserDao(String name, int age, String email,
                   char[] password, ArrayList<ProductEntity> cart, UserEntity.Roles role) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.cart = cart;
        this.role = role;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public ArrayList<ProductEntity> getCart() {
        return cart;
    }

    public void setCart(ArrayList<ProductEntity> cart) {
        this.cart = cart;
    }

    public UserEntity.Roles getRole() {
        return role;
    }

    public void setRole(UserEntity.Roles role) {
        this.role = role;
    }

}
