package entity;

/**
 * 系统的使用者，Customer和Collector的父类
 */
public class User {
    private int id;
    private String name;
    private String password;
    private String gender;
    private String phone;
    private int credit;
    private int housingEstateId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getHousingEstateId() {
        return housingEstateId;
    }

    public void setHousingEstateId(int housingEstateId) {
        this.housingEstateId = housingEstateId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", credit=" + credit +
                ", housingEstateId=" + housingEstateId +
                '}';
    }
}
