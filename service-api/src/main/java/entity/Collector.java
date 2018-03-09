package entity;

import dto.Address;

/**
 * 回收员实体
 */
public class Collector extends User {
    private final Integer userKind = 1;
    private String companyName;
    private String IDCardNo;
    private String gender;
    private Integer credit;
    private Integer point;
    private Integer experience;

    public Collector() {
    }

    public Collector(String name) {
        super(name);
    }

    public Collector(String name, String password, String phone,
                     String companyName, String IDCardNo,
                     String gender, Address address) {
        super(name, password, phone, address);
        this.companyName = companyName;
        this.IDCardNo = IDCardNo;
        this.gender = gender;
    }

    @Override
    public Integer getUserKind() {
        return userKind;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIDCardNo() {
        return IDCardNo;
    }

    public void setIDCardNo(String IDCardNo) {
        this.IDCardNo = IDCardNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Collector{" +
                "userKind=" + userKind +
                ", companyName='" + companyName + '\'' +
                ", IDCardNo='" + IDCardNo + '\'' +
                ", gender='" + gender + '\'' +
                ", credit=" + credit +
                ", point=" + point +
                ", experience=" + experience +
                '}';
    }
}
