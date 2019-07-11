package com.markettb.service;

import com.markettb.dao.BillDAO;
import com.markettb.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BillServiceImpl implements BillService {

    private BillDAO billDAO;

    @Autowired
    public void setBillDAO(BillDAO billDAO) {
        this.billDAO = billDAO;
    }

    @Override
    public void saveBill(Bill bill) {
        if (bill.getPrice() > 0 && bill.getQuantity() > 0) {
            /* Calculate total = price * quantity */
            int total = bill.getPrice() * bill.getQuantity();
            bill.setTotal(total);
            this.billDAO.saveBill(bill);
        }
    }

    @Override
    public void updateBill(Bill bill) {
        if (bill.getPrice() > 0 && bill.getQuantity() > 0) {
            /* Calculate total = price * quantity */
            int total = bill.getPrice() * bill.getQuantity();
            bill.setTotal(total);
            this.billDAO.updateBill(bill);
        }
    }

    @Override
    public void deleteBill(int id) {
        this.billDAO.deleteBill(id);
    }

    @Override
    public Bill getBillById(int id) {
        return this.billDAO.getBillById(id);
    }

    @Override
    public List<Bill> getAllBills() {
        return this.billDAO.getAllBills();
    }

    @Override
    public List<Bill> getAllBillsByOrderId(int order_id) {
        return this.billDAO.getAllBillsByOrderId(order_id);
    }
}
