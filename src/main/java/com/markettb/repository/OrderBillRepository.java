package com.markettb.repository;

import com.markettb.model.OrderBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBillRepository extends JpaRepository<OrderBill,Integer> {
    OrderBill findById(int id);
}
