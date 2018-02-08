package entity;

/**
 * 业主实体（卖废品的用户）
 */
public class Customer extends User {
    private final int userKind = 0;
    private String gender;
    private int credit;
    private int housingEstateId;

    public Customer() {
    }

    public Customer(String name, String password, String phone,
                    String gender, int housingEstateId) {
        super(name, password, phone);
        this.gender = gender;
        this.housingEstateId = housingEstateId;
    }

    public int getUserKind() {
        return userKind;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        return "Customer{" +
                super.toString() +
                "userKind=" + userKind +
                ", gender='" + gender + '\'' +
                ", credit=" + credit +
                ", housingEstateId=" + housingEstateId +
                '}';
    }
}
