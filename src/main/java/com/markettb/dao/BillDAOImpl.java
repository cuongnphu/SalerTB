package com.markettb.dao;

import com.markettb.model.Bill;
import com.markettb.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BillDAOImpl implements BillDAO {
    private BillRepository billRepository;

    @Autowired
    public void setBillRepository(BillRepository billRepository){
        this.billRepository = billRepository;
    }

    /* SAVE a new Bill */
    @Override
    public void saveBill(Bill bill) {
        this.billRepository.save(bill);
    }

    /*   UPDATE a particular Bill */
    @Override
    public void updateBill(Bill bill) {
        Bill updateBill = this.billRepository.getOne(bill.getId());
        updateBill.setOrderId(bill.getOrderId());
        updateBill.setPrice(bill.getPrice());
        updateBill.setQuantity(bill.getQuantity());
        updateBill.setTotal(bill.getTotal());
        this.billRepository.save(updateBill);
    }

    /* DELETE a BILL by Id*/
    @Override
    public void deleteBill(int id) {
        this.billRepository.deleteById(id);
    }

    /*    GET a particular Bill by Id  */
    @Override
    public Bill getBillById(int id) {
        return this.billRepository.findById(id);
    }

    /* GET all Bills */
    @Override
    public List<Bill> getAllBills() {
        return this.billRepository.findAll();
    }

    /* GET all Bills by Order_Id*/
    @Override
    public List<Bill> getAllBillsByOrderId(int order_id) {
        return this.billRepository.findByOrderId(order_id);
    }
}
