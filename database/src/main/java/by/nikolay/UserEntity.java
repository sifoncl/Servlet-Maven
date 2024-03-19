package by.nikolay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class UserEntity {

    enum Roles {
        admin,
        user,
        manager,

    }

    String name;
    int age;

    String email;

    char[] password;

    ArrayList<ProductEntity> cart;

    Roles role;


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

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public UserEntity(int id, String name, int age, String email, char[] password, ArrayList<ProductEntity> cart, Roles role) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.cart = cart;
        this.role = role;
    }

    public UserEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity that)) return false;
        return age == that.age && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Arrays.equals(password, that.password) && Objects.equals(cart, that.cart) && role == that.role;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, age, email, cart, role);
        result = 31 * result + Arrays.hashCode(password);
        return result;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password=" + Arrays.toString(password) +
                ", cart=" + cart +
                ", role=" + role +
                '}';
    }
}