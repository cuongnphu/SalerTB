package com.markettb.service;

import com.markettb.model.Bill;

import java.util.List;

public interface BillService {
    public void saveBill(Bill bill);
    public void updateBill(Bill bill);
    public void deleteBill(int id);
    public Bill getBillById(int id);
    public List<Bill> getAllBills();
    public List<Bill> getAllBillsByOrderId(int order_id);
}
