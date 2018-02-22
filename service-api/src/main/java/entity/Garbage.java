package entity;

import java.io.Serializable;

public class Garbage implements Serializable {

    private int id;
    private String typeName;
    private String name;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Garbage{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
