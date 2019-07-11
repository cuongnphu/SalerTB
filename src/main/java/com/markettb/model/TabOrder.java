package com.markettb.model;

import java.util.List;

public class TabOrder {

    private OrderBill orderBill;
    private List<Bill> billList;

    /* Implement Constructor*/
    public TabOrder() {
    }

    public TabOrder(OrderBill orderBill, List<Bill> billList) {
        this.orderBill = orderBill;
        this.billList = billList;
    }

    // Implement Getter & Setter
    public OrderBill getOrderBill() {
        return orderBill;
    }

    public void setOrderBill(OrderBill orderBill) {
        this.orderBill = orderBill;
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }
}
