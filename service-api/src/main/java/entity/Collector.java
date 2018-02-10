package entity;

/**
 * 回收员实体
 */
public class Collector extends User {
    private final int userKind = 1;
    private String nickName;
    private String companyName;
    private String IDCardNo;
    private String gender;
    private int credit;
    private int housingEstateId;

    public Collector() {
    }

    public Collector(String name, String password, String phone,
                     String nickName, String companyName, String IDCardNo,
                     String gender, int housingEstateId) {
        super(name, password, phone);
        this.nickName = nickName;
        this.companyName = companyName;
        this.IDCardNo = IDCardNo;
        this.gender = gender;
        this.housingEstateId = housingEstateId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
        return "Collector{" +
                super.toString() +
                "userKind=" + userKind +
                ", nickName='" + nickName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", IDCardNo='" + IDCardNo + '\'' +
                ", gender='" + gender + '\'' +
                ", credit=" + credit +
                ", housingEstateId=" + housingEstateId +
                '}';
    }
}
