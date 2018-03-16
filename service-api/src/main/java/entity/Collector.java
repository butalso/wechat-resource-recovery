package entity;

import dto.Address;

/**
 * 回收员实体
 */
public class Collector extends ECPUser {
    private final Integer userKind = 1;
    private String companyName;
    private String IDCardNo;

    public Collector() {
    }

    public Collector(Integer id, String name) {
        super(id, name);
    }

    public Collector(String name, String password) {
        super(name, password);
    }

    public Collector(String name, String password, String gender,
                     String phone, String companyName, String IDCardNo,
                     Address address) {
        super(name, password);
        this.setPhone(phone);
        this.companyName = companyName;
        this.IDCardNo = IDCardNo;
        this.setGender(gender);
        this.setAddress(address);
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

    @Override
    public String toString() {
        return "Collector{" +
                super.toString() +
                "userKind=" + userKind +
                ", companyName='" + companyName + '\'' +
                ", IDCardNo='" + IDCardNo + '\'' +
                '}';
    }
}
