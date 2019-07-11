package com.markettb.dao;

import com.markettb.model.OrderBill;
import com.markettb.repository.OrderBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public class OrderBillDAOImpl implements OrderBillDAO {

    private OrderBillRepository orderBillRepository;

    @Autowired
    public void setOrderBillRepository(OrderBillRepository orderBillRepository){
        this.orderBillRepository = orderBillRepository;
    }

    // SAVE a new OrderBill
    @Override
    public void saveOrderBill(OrderBill orderBill) {
        orderBillRepository.save(orderBill);
    }

    /* SAVE & RETURN a OrderBill*/
    @Override
    public int saveGetIdOrderBill(OrderBill orderBill) {
        OrderBill orderBill1 = orderBillRepository.saveAndFlush(orderBill);
        orderBillRepository.flush();
        return orderBill1.getId();
    }

    // UPDATE a particular OrderBill
    @Override
    public void updateOrderBill(OrderBill orderBill) {
        OrderBill updateOrderBill = orderBillRepository.getOne(orderBill.getId());
        updateOrderBill.setName(orderBill.getName());
        updateOrderBill.setTotal(orderBill.getTotal());
        this.orderBillRepository.save(updateOrderBill);
    }

    /* DELETE a OrderBill By Id   */
    @Override
    public void deleteOrderBill(int id) {
        orderBillRepository.deleteById(id);
    }

    /*  GET a OrderBill by Id   */
    @Override
    public OrderBill getOrderBillById(int id) {
        return orderBillRepository.findById(id);
    }

    /*   GET all OrderBills */
    @Override
    public List<OrderBill> getAllOrderBills() {
        return orderBillRepository.findAll();
    }
}
