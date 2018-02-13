package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import enums.UserKind;

/**
 * 业主实体（卖废品的用户）
 */
@JsonIgnoreProperties(value = {"id", "password", "userKind", "housingEstateId"})
public class Customer extends User {
    private final int userKind = 0;
    private String nickName;
    private String gender;
    private int credit;
    private int housingEstateId;

    public Customer() {
    }

    public Customer(String name, String password, String phone,
                    String nickName, String gender, int housingEstateId) {
        super(name, password, phone);
        this.nickName = nickName;
        this.gender = gender;
        this.housingEstateId = housingEstateId;
    }

    public int getUserKind() {
        return userKind;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
                "userKind=" + UserKind.getKindInfo(userKind) +
                ", gender='" + gender + '\'' +
                ", credit=" + credit +
                ", housingEstateId=" + housingEstateId +
                '}';
    }
}
