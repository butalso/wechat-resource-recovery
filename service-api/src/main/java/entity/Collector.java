package entity;

/**
 * 回收员实体
 */
public class Collector extends User {
    private String IDCardNo;

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
                "IDCardNo='" + IDCardNo + '\'' +
                '}';
    }
}
