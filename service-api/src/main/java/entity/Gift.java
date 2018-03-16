package entity;

import java.io.Serializable;

public class Gift implements Serializable {
    private Integer id;
    private String name;
    private Integer point;
    private Integer inventory;

    public Gift() {
    }

    public Gift(String name, Integer point, Integer inventory) {
        this.name = name;
        this.point = point;
        this.inventory = inventory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", point=" + point +
                ", inventory=" + inventory +
                '}';
    }
}
