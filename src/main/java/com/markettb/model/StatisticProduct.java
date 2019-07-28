package com.markettb.model;


import java.util.List;

public class StatisticProduct {
    private List<Product> productList;
    private int statisticTotal;

    /*Implement Constructor*/
    public StatisticProduct() {
        this.statisticTotal = 0;
    }

    public StatisticProduct(List<Product> productList, int statisticTotal) {
        this.productList = productList;
        this.statisticTotal = statisticTotal;
    }

    /*Implement GETTER & SETTER*/
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getStatisticTotal() {
        return statisticTotal;
    }

    public void setStatisticTotal(int statisticTotal) {
        this.statisticTotal = statisticTotal;
    }
}
