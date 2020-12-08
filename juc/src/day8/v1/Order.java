package day8.v1;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer orderId;
    private String payer;
    private String payee;
    private BigDecimal tranAmt;
    private Date tranTime;

    public Order(Integer orderId, String payer, String payee, BigDecimal tranAmt, Date tranTime) {
        this.orderId = orderId;
        this.payer = payer;
        this.payee = payee;
        this.tranAmt = tranAmt;
        this.tranTime = tranTime;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public Date getTranTime() {
        return tranTime;
    }

    public void setTranTime(Date tranTime) {
        this.tranTime = tranTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", payer='" + payer + '\'' +
                ", payee='" + payee + '\'' +
                ", tranAmt=" + tranAmt +
                ", tranTime=" + tranTime +
                '}';
    }
}
