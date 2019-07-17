package com.markettb.model;


import java.util.List;


public class StatisticOrder {
    private List<OrderBill> orderBillList;
    private int statisticTotal;

    /*Implement constructor*/
    public StatisticOrder() {
        this.statisticTotal = 0;
    }

    public StatisticOrder(List<OrderBill> orderBillList, int statisticTotal) {
        this.orderBillList = orderBillList;
        this.statisticTotal = statisticTotal;
    }

    /*Implement GETTER & SETTER*/
    public List<OrderBill> getOrderBillList() {
        return orderBillList;
    }

    public void setOrderBillList(List<OrderBill> orderBillList) {
        this.orderBillList = orderBillList;
    }

    public int getStatisticTotal() {
        return statisticTotal;
    }

    public void setStatisticTotal(int statisticTotal) {
        this.statisticTotal = statisticTotal;
    }
}
