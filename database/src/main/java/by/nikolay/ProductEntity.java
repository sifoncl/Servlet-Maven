package by.nikolay;

import java.util.Objects;

public class ProductEntity {

    private String name;
    private int price;

    public ProductEntity(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductEntity that)) return false;
        return price == that.price && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }


    @Override
    public String toString() {
        return "ProductEntity{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
