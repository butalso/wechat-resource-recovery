package dto;

import java.io.Serializable;

/**
 * 省市区生活小区四级地址实体
 */
public class Address implements Serializable {
    private String province;
    private String city;
    private String area;
    private String housingEstate;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getHousingEstate() {
        return housingEstate;
    }

    public void setHousingEstate(String housingEstate) {
        this.housingEstate = housingEstate;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", housingEstate='" + housingEstate + '\'' +
                '}';
    }
}
