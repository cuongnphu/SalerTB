package com.markettb.dao;

import com.markettb.model.OrderBill;

import java.util.Date;
import java.util.List;

public interface OrderBillDAO {
    public void saveOrderBill(OrderBill orderBill);
    public int saveGetIdOrderBill(OrderBill orderBill);
    public void updateOrderBill(OrderBill orderBill);
    public void deleteOrderBill(int id);
    public OrderBill getOrderBillById(int id);
    public List<OrderBill> getAllOrderBills();
    public List<OrderBill> getLast5OrderBills();
    public List<OrderBill> getAllOrderBillByDateBetween(Date fromDate, Date toDate);
}
