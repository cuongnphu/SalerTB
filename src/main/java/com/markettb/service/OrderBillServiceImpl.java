package com.markettb.service;

import com.markettb.dao.OrderBillDAO;
import com.markettb.model.OrderBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class OrderBillServiceImpl implements OrderBillService {

    private OrderBillDAO orderBillDAO;

    @Autowired
    public void setOrderBillDAO(OrderBillDAO orderBillDAO){
        this.orderBillDAO = orderBillDAO;
    }

    @Override
    public void saveOrderBill(OrderBill orderBill) {
        if(orderBill.getName()!=""){
            orderBill.setTotal(0);
            orderBill.setDate(new Date());
            this.orderBillDAO.saveOrderBill(orderBill);
        }
    }

    @Override
    public int saveGetIdOrderBill(OrderBill orderBill) {
        if(orderBill.getName()!=""){
            orderBill.setTotal(0);
            orderBill.setDate(new Date());
            return this.orderBillDAO.saveGetIdOrderBill(orderBill);
        }else
            return 0;
    }

    @Override
    public void updateOrderBill(OrderBill orderBill) {
        if(orderBill.getName()!="")
            this.orderBillDAO.updateOrderBill(orderBill);

    }

    @Override
    public void deleteOrderBill(int id) {
        this.orderBillDAO.deleteOrderBill(id);
    }

    @Override
    public OrderBill getOrderBillById(int id) {
        return this.orderBillDAO.getOrderBillById(id);
    }

    @Override
    public List<OrderBill> getAllOrderBills() {
        return this.orderBillDAO.getAllOrderBills();
    }

    @Override
    public List<OrderBill> getLast5OrderBills() {
        return this.orderBillDAO.getLast5OrderBills();
    }

    @Override
    public List<OrderBill> getAllOrderBillByDateBetween(Date fromDate, Date toDate) {
        return this.orderBillDAO.getAllOrderBillByDateBetween(fromDate,toDate);
    }
}
