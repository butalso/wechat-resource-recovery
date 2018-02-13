package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 企业实体
 */
@JsonIgnoreProperties(value = {"id", "password", "areaId"})
public class Company extends User {
    private final int userKind = 2;
    private String areaId;
    private String addrDetail;

    public Company() {
    }

    public Company(String name, String password,
                   String phone, String areaId, String addrDetail) {
        super(name, password, phone);
        this.areaId = areaId;
        this.addrDetail = addrDetail;
    }

    public int getUserKind() {
        return userKind;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAddrDetail() {
        return addrDetail;
    }

    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail;
    }

    @Override
    public String toString() {
        return "Company{" +
                super.toString() +
                "userKind=" + userKind +
                ", areaId='" + areaId + '\'' +
                ", addrDetail='" + addrDetail + '\'' +
                '}';
    }
}
