package com.markettb.service;

import com.markettb.dao.BillDAO;
import com.markettb.model.Bill;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BillServiceImpl implements BillService {

    private Logger log = Logger.getLogger(BillServiceImpl.class);
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
        if(id > 0){
            log.info("Delete a Bill by Id = " + id);
            this.billDAO.deleteBill(id);
        }else
            log.info("======================== WARNING: CANNOT Delete Bill by Id incorrect");
    }

    @Override
    public Bill getBillById(int id) {
        if(id > 0)
            return this.billDAO.getBillById(id);
        else
            return null;
    }

    @Override
    public List<Bill> getAllBills() {
        return this.billDAO.getAllBills();
    }

    @Override
    public List<Bill> getAllBillsByOrderId(int order_id) {
        if(order_id > 0)
            return this.billDAO.getAllBillsByOrderId(order_id);
        else {
            log.info("===================== WARNING: Get All Bills with OrderId not Exist ========================");
            return null;
        }
    }
}
