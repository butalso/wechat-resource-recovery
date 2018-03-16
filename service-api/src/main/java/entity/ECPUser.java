package entity;

/**
 * 拥有经验值、信誉值、积分值的用户，回收员和业主的父类
 */
public class ECPUser extends User {

    private String gender;
    private Integer credit;
    private Integer point;
    private Integer experience;
    private Wallet wallet;

    public ECPUser() {
    }

    public ECPUser(Integer id, String name) {
        super(id, name);
    }

    public ECPUser(String name, String password) {
        super(name, password);
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

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "ECPUser{" +
                super.toString() +
                "gender='" + gender + '\'' +
                ", credit=" + credit +
                ", point=" + point +
                ", experience=" + experience +
                ", wallet=" + wallet +
                '}';
    }
}
