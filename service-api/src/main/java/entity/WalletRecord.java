package entity;

import java.io.Serializable;
import java.util.Date;

public class WalletRecord implements Serializable {
    private Integer id;
    private Integer walletId;
    private String transfer;
    private String receiver;
    private Double value;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "WalletRecord{" +
                "id=" + id +
                ", walletId=" + walletId +
                ", transfer='" + transfer + '\'' +
                ", receiver='" + receiver + '\'' +
                ", value=" + value +
                ", createTime=" + createTime +
                '}';
    }
}
